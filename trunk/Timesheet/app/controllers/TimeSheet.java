package controllers;

import Utils.*;
import models.Holiday;
import models.HolidayType;
import models.Team;
import models.User;
import play.mvc.Controller;

import java.util.*;

public class TimeSheet extends Controller {

    public static void show(int selectedYear, int selectedMonth, Team selectedTeam) {
        Date startDate = CalendarUtil.createDate(1, selectedMonth - 1, selectedYear);
        if (selectedMonth == 0) {
            selectedMonth = CalendarUtil.getMonth(startDate);
        }
        if (selectedYear == 0) {
            selectedYear = CalendarUtil.getYear(startDate);
        }
        Date endDate = CalendarUtil.createDateWithLastDayOfMonth(startDate);

        List<User> users;
        if (selectedTeam.id == null) {
            users = User.all().fetch();
        } else {
            users = User.find("team = ?", selectedTeam).fetch();
        }
        Map<String, List<Holiday>> holidayMap = createHolidayMaps(startDate, endDate, users);
        List<Date> datesBetweenRange = generateDatesBetweenRange(startDate, endDate);
        List<Integer> years = generateYearList(startDate);
        List<Date> months = generateMonthList();
        List<Team> teams = Team.findAll();
        List<HolidayType> allHolidayTypes = HolidayType.findAll();
        List<HolidayType> holidayTypes = filterHolidayType(allHolidayTypes);

        render(holidayMap, datesBetweenRange, years, selectedYear, months, selectedMonth, teams, selectedTeam, allHolidayTypes, holidayTypes);
    }

    public static void createOrUpdate(Holiday holiday) {
        holiday.save();
        System.out.println("## updated holiday");
        renderJSON("Success");
    }

    private static List<HolidayType> filterHolidayType(List<HolidayType> allHolidayTypes) {
        List<HolidayType> filteredHolidayTypes = new ArrayList<HolidayType>();
        for (HolidayType holidayType : allHolidayTypes) {
            if (!holidayType.equals(HolidayTypeUtil.getPublicHoliday()) && !holidayType.equals(HolidayTypeUtil.getWeekend())) {
                filteredHolidayTypes.add(holidayType);
            }
        }
        return filteredHolidayTypes;
    }

    private static Map<String, List<Holiday>> createHolidayMaps(Date startDate, Date endDate, List<User> users) {
        Map<String, List<Holiday>> holidayMap = new HashMap<String, List<Holiday>>(users.size());

        for (User user : users) {
            List<Holiday> currentHolidays = Holiday.find("user = ? and date >= ? and date <= ?", user, startDate, endDate).fetch();
            fillMissingDays(currentHolidays, startDate, endDate, user);
            Collections.sort(currentHolidays, new DateCompare());
            holidayMap.put(user.userName, currentHolidays);
        }
        return holidayMap;
    }

    private static List<Date> generateMonthList() {
        List<Date> result = new ArrayList<Date>(12);
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 12; i++) {
            calendar.set(Calendar.MONTH, i);
            result.add(calendar.getTime());
        }
        return result;
    }

    private static List<Integer> generateYearList(Date startDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);

        List<Integer> result = new ArrayList<Integer>(8);
        for (int i = -3; i < 4; i++) {
            result.add(c.get(Calendar.YEAR) + i);
        }

        return result;
    }

    private static List<Date> generateDatesBetweenRange(Date startDate, Date endDate) {
        List<Date> result = new ArrayList<Date>();
        DateIterator dateIterator = new DateIterator(startDate, endDate);
        for (Date date : dateIterator) {
            result.add(date);
        }

        return result;
    }

    private static void fillMissingDays(List<Holiday> holidays, Date startDate, Date endDate, User user) {
        DateIterator dateIterator = new DateIterator(startDate, endDate);
        for (Date date : dateIterator) {
            if (!hasHoliday(holidays, date)) {
                HolidayType holidayType;
                if (CalendarUtil.isWeekend(date)) {
                    holidayType = HolidayTypeUtil.getWeekend();
                } else if (CalendarUtil.isPublicHoliday(date, user.location)) {
                    holidayType = HolidayTypeUtil.getPublicHoliday();
                } else {
                    holidayType = HolidayTypeUtil.getWorkingDay();
                }

                holidays.add(new Holiday(user, holidayType, date));
            }
        }
    }

    private static boolean hasHoliday(List<Holiday> holidays, Date dateToFind) {
        Calendar dateToFindAsCalendar = Calendar.getInstance();
        dateToFindAsCalendar.setTime(dateToFind);

        for (Holiday holiday : holidays) {
            Calendar dateToCompare = Calendar.getInstance();
            dateToCompare.setTime(holiday.date);
            if (new TimeIgnoringComparator().compare(dateToFind, holiday.date) == 0) {
                return true;
            }
        }
        return false;
    }
}