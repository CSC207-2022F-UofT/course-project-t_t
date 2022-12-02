package useCases;

import entities.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class FreeIntervalComparer {
    public static ArrayList<Interval> findFreeIntervals(ArrayList<Timetable> timetables) {

        ArrayList<Integer> diff = new ArrayList<>();

        for (Timetable t : timetables)
            for (Course c : t.getCourses())
                for (Lecture l : c.getLectures()) {
                    Interval i = l.getInterval();
                    diff.add(i.getStart());
                    diff.add(- i.getEnd());
                }

        diff.sort(Comparator.comparingInt(Math::abs));

        int curr = 0;
        int prev;
        int buff = 0;
        ArrayList<Interval> free = new ArrayList<>();

        for (int d : diff) {
            int ad = Math.abs(d);
            prev = curr;
            curr += d / ad;
            if ((prev > 0) && (curr == 0))
                free.add(new Interval(buff, ad));
            else if ((prev == 0) && (curr > 0))
                buff = ad;
        }
        free.add(new Interval(buff, Integer.MAX_VALUE));

        return free;
    }
}
