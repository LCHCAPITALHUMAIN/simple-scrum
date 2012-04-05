package ext;

import play.templates.JavaExtensions;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class FloatExtention extends JavaExtensions {
    public static String inDays(Float valueInHours) {
        valueInHours = valueInHours / 8;
        return valueInHours.toString();
    }
    //TODO: Right candidate to migrate as a macro in the template
    public static String color(Float valueInHours) {
        if (valueInHours == 8) {
            return "success";
        } else if (valueInHours == 0) {
            return "danger";
        }
        return "warning";
    }

    public static String inHours(Float valueInHours) {
        return valueInHours.toString() + (valueInHours<=1? " Hour":" Hour(s)");

    }
    public static String inPercentage(Float valueInHours) {
        if (valueInHours > 8) {
            throw new IllegalArgumentException("Invalid hours, a day contains only 8 working hours, whereas value is " + valueInHours);
        }
        Integer percentage = (int) (valueInHours * 12.5F);
        return percentage.toString();
    }
    public static String inDaysWithUnit(Float valueInHours) {
        return inDays(valueInHours) + (valueInHours > 8 ? " Days": " Day");
    }
}
