package main;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * Gabe Castelli
 * Calendar created for a specific year
 */

public class Calendar {
    private final long YEAR;
    private boolean isLeapYear;

    public Calendar(long year) {
        YEAR = year;
        isLeapYear = YEAR % 4 == 0 && YEAR % 100 != 0 || YEAR % 400 == 0;
    }

    public Calendar() {
        this((long) LocalDate.now().getYear());
    }

    // @post: return ASCII representation of a calendar
    @Override
    public String toString() {
        String result = "\n"; 
        byte startDay = (byte) (((((YEAR - 1) * 365) + (YEAR - 1) / 4 - (YEAR - 1) / 100 + (YEAR - 1) / 400) + 1) % 7);

        // loops through months
        for (byte i = 0; i < 12; i++) {
            // month and year
            
            /* ---------------------------------------------------------------------------------------------------- */
            result += "\t" + Resources.MONTHS[i];

            // add proper spacing between month and year
            for (byte l = 0; l < 5; l++) {
                result += "\t";
            }

            // extra tabs for compensate for shorter month names
            final int length = Resources.MONTHS[i].length();
            byte extraTabs;
            if (IntStream.of(new int[]{7, 6, 5, 4, 3}).anyMatch(x -> x == length)) {
               extraTabs = 1; 
            } else {
                extraTabs = 0;
            }
            for (byte l = 0; l < extraTabs; l++) {
                result += "\t";   
            } 

            result += YEAR + "\n\n";
            /* ---------------------------------------------------------------------------------------------------- */

            // days of week

            /* ---------------------------------------------------------------------------------------------------- */
            result += "\t";
            for (String day : Resources.DAYS_PER_WEEK) {
                result += day + "\t";
            }
            result += "\n\n\t" + divider() + "\n\n";
            /* ---------------------------------------------------------------------------------------------------- */

            // days of month
            
            /* ---------------------------------------------------------------------------------------------------- */
            // first week
            byte currentDay = 1;
            result += "\t";
            for (byte l = 0; l < startDay; l++) {
                result += "\t";
            }
            for (byte l = 0; l < 7 - startDay; l++) {
                result += currentDay++ + "\t";
            }
            result += "\n\n\t";

            // rest of weeks
            while (currentDay <= Resources.getDaysPerMonth(isLeapYear)[i]) {
                result += currentDay++;
                if ((startDay + currentDay - 1) % 7 == 0) {
                    result += "\n\n\t";
                } else {
                    result += "\t";
                }
            }
            
            startDay = Resources.getNextStartDay(Resources.getDaysPerMonth(isLeapYear)[i], startDay);
            if (i != 11) result += "\n\n\n\t" + divider() + "\n\t" + divider() + "\n\n\n";
            else result += "\n\n\n";
        }

        return result;
    }

    private static String divider() {
        String result = "";
        for (byte i = 0; i < 52; i++) {
            result += "-";
        }
        return result; 
    }
}

