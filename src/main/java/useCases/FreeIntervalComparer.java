package useCases;

import entities.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class which compares the free time intervals from a list of timetables.
 */
public class FreeIntervalComparer {
    /**
     * Algorithm which returns an ArrayList of intervals which represent the timeslots where every timetable in
     * timetables are free.
     *
     * @param timetables An ArrayList of Timetables
     * @return
     */
    public static ArrayList<Interval> findFreeIntervals(ArrayList<Timetable> timetables) {

        ArrayList<Integer> diff = getDifferenceArray(timetables);

        int curr = 0;
        int prev;
        int buff = 0;
        ArrayList<Interval> free = new ArrayList<>();

        for (int d : diff) {
            int ad = Math.abs(d);
            prev = curr;
            if (d == 0)
                curr += 1;
            else
                curr += d / ad;
            if ((prev > 0) && (curr == 0))
                buff = ad;
            else if ((prev == 0) && (curr > 0))
                free.add(new Interval(buff, ad));
        }
        free.add(new Interval(buff, Integer.MAX_VALUE));

        return free;
    }

    private static ArrayList<Integer> getDifferenceArray(ArrayList<Timetable> timetables) {
        ArrayList<Integer> diff = new ArrayList<>();

        for (Timetable t : timetables)
            for (Course c : t.getCourses())
                for (Lecture l : c.getLectures()) {
                    Interval i = l.getInterval();
                    diff.add(i.getStart());
                    diff.add(- i.getEnd());
                }

        diff.sort(Comparator.comparingInt(Math::abs));

        return diff;
    }

}
