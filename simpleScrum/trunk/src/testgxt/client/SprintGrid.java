package testgxt.client;


import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import testgxt.client.model.scrum.SprintBacklogEntity;
import testgxt.client.model.scrum.SprintBacklogHelper;

import java.util.ArrayList;
import java.util.List;

public class SprintGrid extends LayoutContainer {

  private FormBinding formBindings;

  @SuppressWarnings("unchecked")
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");

    ContentPanel cp = new ContentPanel();

    cp.setHeading("Form Bindings");
    cp.setFrame(true);
    cp.setSize(1200, 400);
    cp.setLayout(new RowLayout(Orientation.HORIZONTAL));

    final Grid<SprintBacklogEntity> grid = createGrid();
    grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    grid.getSelectionModel().addListener(Events.SelectionChange,
        new Listener<SelectionChangedEvent<SprintBacklogEntity>>() {
          public void handleEvent(SelectionChangedEvent<SprintBacklogEntity> be) {
            if (be.getSelection().size() > 0) {
              //formBindings.bind((ModelData) be.getSelection().get(0));
            } else {
              //formBindings.unbind();
            }
          }
        });
    cp.add(grid, new RowData(.6, 1));

    //FormPanel formPanel = createForm();
    //formBindings = new FormBinding(formPanel, true);
    //formBindings.setStore((Store) grid.getStore());

    //cp.add(formPanel, new RowData(.4, 1));

    cp.setButtonAlign(HorizontalAlignment.LEFT);
    cp.addButton(new Button("Reset", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        grid.getStore().rejectChanges();
      }
    }));
    cp.addButton(new Button("Commit", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        grid.getStore().commitChanges();
      }
    }));
    cp.addButton(new Button("Refresh", new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        SprintBacklogService.App.getInstance().getBacklogItems("Sprint #", 2, new SprintTasksToStoreAsyncCallback(grid.getStore()));
      }
    }));
    add(cp);
    System.out.println("grid rendered");      
  }

  private Grid<SprintBacklogEntity> createGrid() {
    /*ListStore<Stock> store = new ListStore<Stock>();
    store.setMonitorChanges(true);
    store.add(TestData.getStocks());*/
    final ListStore<SprintBacklogEntity> store = new ListStore<SprintBacklogEntity>();
    store.setMonitorChanges(true);
    store.addStoreListener(new StoreListener<SprintBacklogEntity>() {
      public void storeUpdate(StoreEvent<SprintBacklogEntity> se) {
        super.storeUpdate(se);
        if (Record.RecordUpdate.COMMIT.equals(se.getOperation())) {
          if (se.getRecord().getModel() instanceof SprintBacklogEntity) {
            SprintBacklogService.App.getInstance().setBacklogItems((SprintBacklogEntity) se.getRecord().getModel(), new NoOpSprintTasksAsyncCallback());
          } else {
            throw new UnsupportedOperationException("commit on data but data are not of expected type....");
          }
        }
      }
    });
    SprintBacklogService.App.getInstance().getBacklogItems("Sprint #", 2, new SprintTasksToStoreAsyncCallback(store));

    EditorGrid<SprintBacklogEntity> grid = new EditorGrid<SprintBacklogEntity>(store, SprintBacklogHelper.getGxtColumnModel());
    grid.getView().setEmptyText("sdfd");
    grid.setBorders(false);
    grid.setAutoExpandColumn("remarks");
    grid.setBorders(true);

    return grid;
  }

  private static class SprintTasksToStoreAsyncCallback implements AsyncCallback<List<SprintBacklogEntity>> {
    private ListStore<SprintBacklogEntity> store;

    public SprintTasksToStoreAsyncCallback(ListStore<SprintBacklogEntity> store) {
      this.store = store;
    }

    public void onSuccess(List<SprintBacklogEntity> result) {
      store.removeAll();
      store.add(result);
      //DOM.setInnerHTML(label.getElement(), "Elements: "+result.size()+". First is "+result.get(0));
    }

    public void onFailure(Throwable throwable) {
      //label.setText("Failed to receive answer from server!");
    }
  }

  private static class NoOpSprintTasksAsyncCallback implements AsyncCallback<List<SprintBacklogEntity>> {
    public NoOpSprintTasksAsyncCallback() {
    }

    public void onSuccess(List<SprintBacklogEntity> result) {
    }

    public void onFailure(Throwable throwable) {
    }
  }
}