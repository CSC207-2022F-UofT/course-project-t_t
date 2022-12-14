package presenter;

import entities.Interval;
import useCases.FreeSlotInverter;

import javax.swing.*;
import java.util.ArrayList;

public class FreeSlotsVisualizer {
    /**
     * Creates a window that shows free intervals of time in a given week.
     *
     * @param intervals converted into a 2D array of strings representing the free time slots.
     */
    public static void windowVisualizer(ArrayList<Interval> intervals) {
        String[][] schedule = new String[24][8];
        String[] days = {"Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        int start = 0;
        int end = 1;

        for (int i = 0; i < 24; i++) {
            schedule[i][0] = start + "-" + end;
            start += 1;
            end += 1;
        }

        FreeSlotInverter.timeToIndex(intervals, schedule);

        JTable table = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("Free Interval Finder");
        frame.add(new JScrollPane(table));
        frame.setSize(1000, 500);
        frame.setVisible(true);

    }
}
