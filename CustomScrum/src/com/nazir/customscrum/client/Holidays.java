package com.nazir.customscrum.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 1, 2010
 * Time: 7:59:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Holidays extends VerticalPanel {
    public Holidays() {
        HorizontalPanel panel;
        panel = new HorizontalPanel();
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        add(panel);

        panel = new HorizontalPanel();
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        add(panel);

        panel = new HorizontalPanel();
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        panel.add(createDatePicker());
        add(panel);

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
