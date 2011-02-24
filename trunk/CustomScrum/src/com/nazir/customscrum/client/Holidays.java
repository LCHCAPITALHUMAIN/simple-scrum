
package com.nazir.customscrum.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 1, 2010
 * Time: 7:59:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Holidays extends VerticalPanel {

    FlexTable table;
    int currentRow = 0;
    List<Date> days;

    public Holidays() {
        addCriteria();
        table = new FlexTable();
        generateDays();
        generateHoliday("Nazir KHAN");
        generateHoliday("Imad ELALI");
        generateHoliday("Agata SOBIK");
        highlightWeekends();
        add(table);

    }

    private void highlightWeekends() {
        int row = table.getRowCount();
        for (int i = 0; i < row; i++) {
            for (int j =0;j < days.size();j++) {
                if (days.get(j).getDay() == 6 || days.get(j).getDay() == 5) {
                    table.getCellFormatter().getElement(i, j+1).setClassName("errorInActual");
                }
            }
        }

    }

    private void addCriteria() {
        HorizontalPanel panel = new HorizontalPanel();
        panel.add(new Label("User type") );
        ListBox dropDownUserTypes = new ListBox();
        dropDownUserTypes.addItem("IT");
        dropDownUserTypes.addItem("BA");
        dropDownUserTypes.addItem("Support");
        panel.add(dropDownUserTypes );
        add(panel);
    }


    public void generateDays() {
        int currentCol = 1;
        days = new ArrayList<Date>();
        Date date = new Date();
        date.setDate(1);

        do {
            days.add(new Date(date.getTime()));
            date.setDate(date.getDate() + 1) ;
        } while (date.getDate() != 1);
        
        DateTimeFormat fmt = DateTimeFormat.getFormat("EEE");
        for (Date day : days) {
            table.setWidget(currentRow, currentCol++, new Label(fmt.format(day)));

        }
        currentRow++;
    }
    public void generateHoliday(String userName) {
        int currentCol = 0;
        table.setWidget(currentRow, currentCol++, new Label(userName));
        for (Date day : days) {
            ListBox dayOff = new ListBox();
            dayOff.addItem("F");
            dayOff.addItem("M");
            dayOff.addItem("A");
            dayOff.addItem("T");
            dayOff.setStyleName("holiday");
            table.setWidget(currentRow, currentCol++, dayOff);
        }
        currentRow++;
    }

    private DatePicker createDatePicker() {
        // Create a basic date picker
        final DatePicker datePicker = new DatePicker();

        // Set the value in the text box when the user selects a date
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
          public void onValueChange(ValueChangeEvent<Date> event) {
            Date date = event.getValue();
              datePicker.addStyleToDates("holiday", event.getValue());
          }
        });

        // Set the default value
        datePicker.setValue(new Date(), true);
        return datePicker;
    }

}
