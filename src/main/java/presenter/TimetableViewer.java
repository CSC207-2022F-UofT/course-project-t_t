package presenter;

import entities.Course;
import entities.Timetable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TimetableViewer {
    public ArrayList<String> visualizeTimetable(Timetable timetable) {

        ArrayList<Course> courses = timetable.getCourses();
        ArrayList<String> schedule = new ArrayList<>();

        StringBuilder sch = new StringBuilder();

        for (Course cou : courses) {
            sch.append('\n' + '[' + cou.getCourseCode() + '\n');
            sch.append(cou.getSectionCode() + '\n');
            sch.append(+']');

            schedule.add(sch.toString());

        }

        return schedule;

//        String[][] tab = new String[5][22];
//
//        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
//
//        JTable table = new JTable(tab, days);
//
//        JFrame frame = new JFrame("Table demo");
//
//        frame.add(new JScrollPane(table));
//
//        frame.setSize(500, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.setVisible(true);
//
//        System.out.println("Hello World!");



    }
}