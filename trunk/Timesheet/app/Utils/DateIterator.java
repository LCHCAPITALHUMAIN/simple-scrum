package Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/13/12
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateIterator implements Iterator<Date>, Iterable<Date> {
    private Calendar current = Calendar.getInstance();
    private Calendar end = Calendar.getInstance();

    public DateIterator(Date start, Date end) {
        this.current.setTime(start);
        this.current.add(Calendar.DATE, -1);
        this.end.setTime(end);
        this.end.add(Calendar.DATE, -1);
    }

    public Iterator<Date> iterator() {
        return this;
    }

    public boolean hasNext() {
        return !current.after(end);
    }

    public Date next() {
        this.current.add(Calendar.DATE, 1);
        return current.getTime();
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove a date");
    }
}
