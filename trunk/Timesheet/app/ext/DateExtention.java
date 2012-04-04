package ext;

import play.templates.JavaExtensions;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class DateExtention extends JavaExtensions {
    public static String format(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
