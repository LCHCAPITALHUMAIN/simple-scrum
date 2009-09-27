package com.gwt_ext.mypackage.client;

/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.GridCellListenerAdapter;
import com.gwt_ext.mypackage.client.model.SprintbacklogEntity;

import java.util.Date;

import java.util.List;


public class EditableGridSample implements EntryPoint {
    private final EditorGridPanel grid = new EditorGridPanel();


    public void onModuleLoad() {
        Panel panel = new Panel();
        panel.setBorder(false);
        panel.setPaddings(15);

        HttpProxy proxy = new HttpProxy("data/plants.xml", Connection.GET);

        final RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("common"),
                        new StringFieldDef("botanical"),
                        new StringFieldDef("light"),
                        new FloatFieldDef("price"),
                        new DateFieldDef("availDate", "availability", "m/d/Y"),
                        new BooleanFieldDef("indoor")
                }
        );

        XmlReader reader = new XmlReader("plant", recordDef);
        final Store store = new Store(proxy, reader);
        store.load();



        SimpleStore cbStore = new SimpleStore("lightTypes", new String[]{
                "Shade",
                "Mostly Shady",
                "Sun or Shade",
                "Mostly Sunny",
                "Sunny"
        });
        cbStore.load();

        final ComboBox cb = new ComboBox();
        cb.setDisplayField("lightTypes");
        cb.setStore(cbStore);

        ColumnConfig commonCol = new ColumnConfig("Common Name", "common", 220, true, null, "common");
        commonCol.setEditor(new GridEditor(new TextField()));

        ColumnConfig lightCol = new ColumnConfig("Light", "light", 130);
        lightCol.setEditor(new GridEditor(cb));


        ColumnConfig priceCol = new ColumnConfig("Price", "price", 70, true);
        priceCol.setAlign(TextAlign.RIGHT);
        priceCol.setRenderer(new Renderer() {
            public String render(Object value, CellMetadata cellMetadata, Record record,
                                 int rowIndex, int colNum, Store store) {
                return "$" + value;
            }
        });
        NumberField numberField = new NumberField();
        numberField.setAllowBlank(false);
        numberField.setAllowNegative(false);
        numberField.setMaxValue(1000);
        priceCol.setEditor(new GridEditor(numberField));

        ColumnConfig availableCol = new ColumnConfig("Available", "availDate", 95, true);

        DateField dateField = new DateField();
        dateField.setFormat("m/d/Y");
        dateField.setMinValue("01/01/06");
        dateField.setDisabledDays(new int[]{0, 6});
        dateField.setDisabledDaysText("Plants are not available on the weekend");
        availableCol.setEditor(new GridEditor(dateField));

        ColumnConfig indoorCol = new ColumnConfig("Indoor?", "indoor", 55);

        indoorCol.setRenderer(new Renderer() {
            public String render(Object value, CellMetadata cellMetadata, Record record,
                                 int rowIndex, int colNum, Store store) {
                boolean checked = ((Boolean) value).booleanValue();
                return "<img class=\"checkbox\" src=\"js/ext/resources/images/default/menu/" +
                        (checked ? "checked.gif" : "unchecked.gif") + "\"/>";
            }
        });

        ColumnConfig[] columnConfigs = {
                commonCol,
                lightCol,
                priceCol,
                availableCol,
                indoorCol
        };

        ColumnModel columnModel = new ColumnModel(columnConfigs);
        columnModel.setDefaultSortable(true);



        Toolbar toolbar = new Toolbar();
        ToolbarButton button = new ToolbarButton("Add Plant", new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {

                Record plant = recordDef.createRecord(new Object[]{
                        "New Plant1", "Anguinaria Canadensis", "Mostly Shady",
                        new Float(5), "", Boolean.FALSE});
                grid.stopEditing();
                store.insert(0, plant);
                grid.startEditing(0, 0);
            }
        });
        toolbar.addButton(button);

        grid.setStore(store);
        grid.setColumnModel(columnModel);
        grid.setWidth(500);
        grid.setHeight(300);
        grid.setAutoExpandColumn("common");
        grid.setTitle("Editor Grid Example");
        grid.setFrame(true);
        grid.setClicksToEdit(1);
        grid.setTopToolbar(toolbar);

        grid.addGridCellListener(new GridCellListenerAdapter() {
            public void onCellClick(GridPanel grid, int rowIndex, int colIndex, EventObject e) {
                if (grid.getColumnModel().getDataIndex(colIndex).equals("indoor") &&
                        e.getTarget(".checkbox", 1) != null) {
                    Record record = grid.getStore().getAt(rowIndex);
                    record.set("indoor", !record.getAsBoolean("indoor"));
                }
            }
        });

        store.load(new UrlParam[]{new UrlParam("rnd", new Date().getTime() + "")});
        panel.add(grid);

        RootPanel.get().add(panel);

        {
            final com.google.gwt.user.client.ui.Button button2 = new com.google.gwt.user.client.ui.Button("Click me");
            final Label label = new Label();

            button2.addClickListener(new ClickListener() {
                public void onClick(Widget sender) {
                    if (label.getText().equals("")) {
                        SprintBacklogService.App.getInstance().getBacklogItems("Sprint 22", 2, new MyBacklogItemAsyncCallback(label));
                    } else {
                        label.setText("");
                    }
                    label.setText("Grid content: "+grid.getStore().getCount()+" elts, first: "+display(grid.getStore().getAt(0)));
                }
            });

            // Assume that the host HTML has elements defined whose
            // IDs are "slot1", "slot2".  In a real app, you probably would not want
            // to hard-code IDs.  Instead, you could, for example, search for all
            // elements with a particular CSS class and replace them with widgets.
            //
            RootPanel.get("slot1").add(button2);
            RootPanel.get("slot2").add(label);
        }
    }

    private String display(Record at) {
        StringBuilder str = new StringBuilder();
        for (String field : at.getFields()) {
            str.append(field+":"+at.getAsString(field)+" ");
        }
        return str.toString();
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            DOM.setInnerHTML(label.getElement(), result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }

    private static class MyBacklogItemAsyncCallback implements AsyncCallback<List<SprintbacklogEntity>> {
        private Label label;

        public MyBacklogItemAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(List<SprintbacklogEntity> result) {
            //DOM.setInnerHTML(label.getElement(), "List of: "+result.size()+" elements. First: "+result.get(0));
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}