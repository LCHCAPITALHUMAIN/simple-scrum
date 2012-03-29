package ext;

import groovy.lang.Closure;
import play.templates.JavaExtensions;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class BooleanExtention extends JavaExtensions {
    public static String falseValue(Boolean aBoolean, String falseValue) {
        return aBoolean ? "" : falseValue;
    }
    public static String trueValue(Boolean aBoolean, String trueValue) {
        return aBoolean ? trueValue: "";
    }
}
