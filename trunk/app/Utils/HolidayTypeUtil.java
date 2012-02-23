package Utils;

import models.HolidayType;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/17/12
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class HolidayTypeUtil {
    private static HolidayType workingDay;
    private static HolidayType publicHoliday;
    private static HolidayType weekend;
    private static HolidayType morningAbsent;
    private static HolidayType afternoonAbsent;
    private static HolidayType fullDayAbsent;

    public static HolidayType getWorkingDay() {
        return workingDay;
    }

    public static HolidayType getPublicHoliday() {
        return publicHoliday;
    }

    public static HolidayType getWeekend() {
        return weekend;
    }

    public static HolidayType getMorningAbsent() {
        return morningAbsent;
    }

    public static HolidayType getAfternoonAbsent() {
        return afternoonAbsent;
    }

    public static HolidayType getFullDayAbsent() {
        return fullDayAbsent;
    }

    public static void initIfReqiured() {
        if (workingDay == null) {
            workingDay = HolidayType.find("code", "N").first();
            publicHoliday = HolidayType.find("code", "P").first();
            weekend = HolidayType.find("code", "W").first();
            morningAbsent = HolidayType.find("code", "M").first();
            afternoonAbsent = HolidayType.find("code", "A").first();
            fullDayAbsent    = HolidayType.find("code", "F").first();
        }
    }

}
