package Utils;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/13/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeIgnoringComparator implements Comparator<Date> {
  public int compare(Date d1, Date d2) {
    if (d1.getYear() != d2.getYear())
        return d1.getYear() - d2.getYear();
    if (d1.getMonth() != d2.getMonth())
        return d1.getMonth() - d2.getMonth();
    return d1.getDate() - d2.getDate();
  }
}

