package Utils;

import models.Holiday;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/16/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateCompare implements Comparator<Holiday> {
    public int compare(Holiday one, Holiday two){
    return one.date.compareTo(two.date);
    }
}