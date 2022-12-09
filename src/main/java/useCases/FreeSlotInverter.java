package useCases;

import entities.Interval;
import java.util.ArrayList;
public class FreeSlotInverter {
    /**
     * Based on the interval, returns an index integer which indicates the day.
     *
     * @param inter an integer which indicates each interval.
     * @return the index of each day for JTable.
     */
    public static int dayHelper(Integer inter) {
        if (0 <= inter && inter < 1440) { // sunday
            return 0;
        } else if (1440 <= inter && inter < 2880) { //monday
            return 1;
        } else if (2880 <= inter && inter < 4320) { // tuesday
            return 2;
        } else if (4320 <= inter && inter < 5760) { // wednesday
            return 3;
        } else if (5760 <= inter && inter < 7200) { // thursday
            return 4;
        } else if (7200 <= inter && inter < 8640) { // friday
            return 5;
        } else if (8640 <= inter && inter < 10080) { // saturday
            return 6;
        } else {
            return 6;
        }
    }

    /**
     * Given the input courses, converts each interval into the corresponding index in the format of day and time.
     *
     * @param intervals arraylist of intervals.
     * @param schedule a variable indicating a free slot.
     */
    public static void timeToIndex(ArrayList<Interval> intervals, String[][] schedule) {
        for (Interval inter : intervals) {
            int startTime = inter.getStart();
            int endTime = inter.getEnd();
            while (startTime < endTime && startTime <= 10080 && endTime <= 10080) {
                int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                schedule[startIndex][dayHelper(startTime) + 1] = "███████";
                startTime += 60;
            }
        }
    }
}
