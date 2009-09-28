package testgxt.client;


import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class MainPanel extends LayoutContainer {
  private ContentPanel contentPanel;
  private LayoutContainer firstContent;

  @SuppressWarnings("unchecked")
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    setStyleAttribute("margin", "10px");

    contentPanel = new ContentPanel();

    contentPanel.setHeading("CRDS Web Sprint Backlog");
    contentPanel.setFrame(true);
    contentPanel.setSize(1200, 400);
    contentPanel.setLayout(new RowLayout(Orientation.HORIZONTAL));
    contentPanel.add(firstContent);

    super.add(contentPanel);
  }

  public ContentPanel getContentPanel() {
    return contentPanel;
  }

  public void setFirstContent(LayoutContainer firstContent) {
    this.firstContent = firstContent;
  }
}