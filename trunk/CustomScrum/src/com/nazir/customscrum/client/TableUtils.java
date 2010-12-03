package com.nazir.customscrum.client;

import com.google.gwt.user.client.ui.FlexTable;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 1, 2010
 * Time: 11:15:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TableUtils {
    public static void highLightColumn(FlexTable tableSprintTask, int columnIndex) {
        highLightColumn(tableSprintTask, columnIndex, "errorInActual");
    }

    public static void highLightColumn(FlexTable tableSprintTask, int columnIndex, String cssClass) {
        if (tableSprintTask.getRowCount() < 1) {
            throw new RuntimeException("No rows to highlight");
        }
        if (columnIndex >= tableSprintTask.getCellCount(1)) {
            throw new RuntimeException("Table doesn't have column with index " + columnIndex);
        }
        for (int row = 0; row < tableSprintTask.getRowCount(); row++) {
            tableSprintTask.getCellFormatter().getElement(row, columnIndex).setClassName(cssClass);

        }

    }

    public static void highLightRow(FlexTable tableSprintTask, int rowIndex, String cssClass) {
        if (rowIndex >= tableSprintTask.getRowCount()) {
            throw new RuntimeException("Table doesn't have row with index " + rowIndex);
        }
        for (int col = 0; col < tableSprintTask.getCellCount(rowIndex); col++) {
            tableSprintTask.getCellFormatter().getElement(rowIndex, col).setClassName(cssClass);

        }

    }

}
