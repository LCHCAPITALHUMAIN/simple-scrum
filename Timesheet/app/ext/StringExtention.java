package ext;

import play.templates.JavaExtensions;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class StringExtention extends JavaExtensions {
    public static String htmlSpace(String str) {
        return str.replace(" ", "&nbsp;");
    }
}
