package controllers;

import Utils.*;
import models.*;
import play.mvc.With;

import java.util.*;

import static controllers.Secure.Security.connected;

@With(Secure.class)
public class TimeSheet extends TimesheetController {
    public static void velocityCalculator(Team selectedTeam, Date startDate, Date endDate, Float focusFactor) {
        if (focusFactor == null) {
            focusFactor = 0.6F;
        }
        if (startDate == null || endDate == null) {
            startDate = CalendarUtil.createLastMonday();
            endDate = CalendarUtil.createNextFriday(startDate);
        }
        List<User> users;
        if (selectedTeam.id == null) {
            selectedTeam = ((User)User.find("userName=?", connected()).first()).team;
        }
        users = User.find("team = ?", selectedTeam).fetch();

        Map<User, List<Holiday>> holidayMap = createHolidayMaps(startDate, endDate, users);
        List<VelocityDetail> velocityDetails = new ArrayList<VelocityDetail>();

        float totalVelocity = 0.0F;
        for (User user : holidayMap.keySet()) {
            VelocityDetail velocityDetail = new VelocityDetail();
            velocityDetail.name = user.fullName;
            velocityDetail.devPart = user.devPart;
            velocityDetail.team = user.team;

            for (Holiday holiday : holidayMap.get(user)) {
                if (HolidayTypeUtil.getWorkingDay().equals(holiday.holidayType)) {
                    velocityDetail.availability++;
                } else if (HolidayTypeUtil.getAfternoonAbsent().equals(holiday.holidayType) || HolidayTypeUtil.getMorningAbsent().equals(holiday.holidayType)) {
                    velocityDetail.unavailability += 0.5F;
                } else if (HolidayTypeUtil.getFullDayAbsent().equals(holiday.holidayType) || HolidayTypeUtil.getTraining().equals(holiday.holidayType) || HolidayTypeUtil.getPublicHoliday().equals(holiday.holidayType)) {
                    velocityDetail.unavailability++;
                }
            }

            velocityDetail.focusFactor = focusFactor;
            velocityDetail.velocity = velocityDetail.availability * velocityDetail.devPart * focusFactor;
            velocityDetails.add(velocityDetail);

            totalVelocity += velocityDetail.velocity;
        }
        List<Team> teams = Team.findAll();

        render(focusFactor, selectedTeam, teams, startDate, endDate, users, velocityDetails, totalVelocity);
    }

    public static void show(int selectedYear, int selectedMonth, Team selectedTeam) {
        String connectedUser = connected();
        User user = User.find("userName=?", connected()).first();

        Date startDate = CalendarUtil.createDate(1, selectedMonth, selectedYear);
        if (selectedMonth == 0) {
            selectedMonth = CalendarUtil.getMonth(startDate);
        }
        if (selectedYear == 0) {
            selectedYear = CalendarUtil.getYear(startDate);
        }
        Date endDate = CalendarUtil.createDateWithLastDayOfMonth(startDate);

        List<User> users;
        if (selectedTeam.id == null) {
            selectedTeam = user.team;
        }
        users = User.find("team = ?", selectedTeam).fetch();
        Map<User, List<Holiday>> holidayMap = createHolidayMaps(startDate, endDate, users);
        Set<User> managerOf = buildManagerAccess(holidayMap.keySet());
        List<Date> datesBetweenRange = generateDatesBetweenRange(startDate, endDate);
        List<Integer> years = generateYearList(startDate);
        List<Date> months = generateMonthList();
        List<Team> teams = Team.findAll();
        List<HolidayType> allHolidayTypes = HolidayType.findAll();
        List<HolidayType> holidayTypes = allHolidayTypes;

        render(holidayMap, datesBetweenRange, years, selectedYear, months, selectedMonth, teams, selectedTeam, allHolidayTypes, holidayTypes, connectedUser, managerOf);
    }

    private static Set<User> buildManagerAccess(Set<User> userNames) {
        Set<User> result = new HashSet<User>();
        for (User user : userNames) {
            if (user.userName.equals(connected())) {
                result.add(user);
            } else {
                User user1 = User.find("userName = ?", user.userName).first();
                if (managerOf(user1)) {
                    result.add(user);
                }
            }
        }
        return result;
    }

    public static void createOrUpdate(Holiday holiday) {
//        if (!managerOf(holiday.user)) {
//            renderJSONResult("Failure");
//        }
        if (HolidayTypeUtil.getPublicHoliday().equals(holiday.holidayType)) {
            renderJSON(new JSONResult("Public holiday can be set only by the administrator using the admin module"));
        }
        if (HolidayTypeUtil.getWeekend().equals(holiday.holidayType) && !CalendarUtil.isWeekend(holiday.date)) {
            renderJSON(new JSONResult("The selected day is not a weekend."));
        }
        holiday.date = CalendarUtil.resetTime(holiday.date);
        holiday.save();
        System.out.println("## updated holiday");
        renderJSON(new JSONResult(JSONResult.SUCCESS));
    }

    private static boolean managerOf(User user) {
        User loggedUserDetails = User.find("userName = ?", Security.connected()).first();
        return loggedUserDetails.managerFor.contains(user.team);
    }

    private static Map<User, List<Holiday>> createHolidayMaps(Date startDate, Date endDate, List<User> users) {
        Map<User, List<Holiday>> holidayMap = new HashMap<User, List<Holiday>>(users.size());

        for (User user : users) {
            List<Holiday> currentHolidays = Holiday.find("user = ? and date >= ? and date <= ?", user, startDate, endDate).fetch();
            fillMissingDays(currentHolidays, startDate, endDate, user);
            Collections.sort(currentHolidays, new DateCompare());
            holidayMap.put(user, currentHolidays);
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
                String holidayDescription;
                if (CalendarUtil.isWeekend(date)) {
                    holidayType = HolidayTypeUtil.getWeekend();
                    holidayDescription = "Weekend";
                } else {
                    PublicHoliday publicHoliday = CalendarUtil.isPublicHoliday(date, user.location);
                    if (publicHoliday != null) {
                        holidayType = HolidayTypeUtil.getPublicHoliday();
                        holidayDescription = publicHoliday.description;
                    } else {
                        holidayType = HolidayTypeUtil.getWorkingDay();
                        holidayDescription = "Working day";
                    }
                }

                holidays.add(new Holiday(user, holidayType, date, holidayDescription));
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

