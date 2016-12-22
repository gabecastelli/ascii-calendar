package main;

/**
  * Gabe Castelli
  * Contains constant data regarding components of a calendar
  */

public class Resources {
    public static final String[] DAYS_PER_WEEK = {
            "Sun",
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat"
    };

    public static final String[] MONTHS = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    // @param: numLast : byte - number of days in last month; lastStartDay : byte
    // @post: returns first day of next month where [0-6] = [Sun-Sat]
    public static byte getNextStartDay(byte numLast, byte lastStartDay) {
        return (byte) ((numLast - 28 + lastStartDay) % 7);
    } 

    public static byte[] getDaysPerMonth(boolean isLeapYear) {
        return new byte[]{
            31,
            (byte) (isLeapYear ? 29 : 28),
            31,
            30,
            31,
            30,
            31,
            31,
            30,
            31,
            30,
            31
        };
    }
}

