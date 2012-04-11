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
    private static HolidayType training;

    public static HolidayType getWorkingDay() {
        if (workingDay == null) {
            workingDay = HolidayType.find("code", "N").first();
        }
        return workingDay;
    }

    public static HolidayType getPublicHoliday() {
        if (publicHoliday == null) {
            publicHoliday = HolidayType.find("code", "P").first();
        }
        return publicHoliday;
    }

    public static HolidayType getWeekend() {
        if (weekend == null) {
            weekend = HolidayType.find("code", "W").first();
        }
        return weekend;
    }

    public static HolidayType getMorningAbsent() {
        if (morningAbsent == null) {
            morningAbsent = HolidayType.find("code", "M").first();
        }
        return morningAbsent;
    }

    public static HolidayType getTraining() {
        if (training == null) {
            training    = HolidayType.find("code", "T").first();
        }
        return training;
    }

    public static HolidayType getAfternoonAbsent() {
        if (afternoonAbsent == null) {
            afternoonAbsent = HolidayType.find("code", "A").first();
        }
        return afternoonAbsent;
    }

    public static HolidayType getFullDayAbsent() {
        if (fullDayAbsent == null) {
            fullDayAbsent    = HolidayType.find("code", "F").first();
        }
        return fullDayAbsent;
    }
}
