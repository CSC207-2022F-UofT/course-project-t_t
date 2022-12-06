package presenter;

import entities.Interval;
import useCases.FreeSlotInverter;

import javax.swing.*;
import java.util.ArrayList;

public class FreeSlotsVisualizer {
    // given

    public static void windowVisualizer(ArrayList<Interval> intervals) {

        String[][] schedule = new String[24][8]; // setting up a 2d array
        String[] days = {"Time", "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

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
