package presenter;

import entities.Course;
import useCases.CompareInverter;

import javax.swing.*;
import java.util.ArrayList;

public class CompareVisualizer {
    /**
     * Creates a window that shows a timetable for a set of courses.
     *
     * @param courses are converted into a 2D array of strings representing the timetable.
     */
    public static void compareWindow(ArrayList<Course> courses) {
        String[][] schedule = new String[24][8]; // setting up a 2d array
        String[] days = {"Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        int start = 0;
        int end = 1;

        for (int i = 0; i < 24; i++) {
            schedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
            }

        CompareInverter.timetableToIndex(courses, schedule);

        JTable table = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("UTimetable");
        frame.add(new JScrollPane(table));
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
