package pages;

import database.Database;
import entities.*;
import useCases.CourseComparer;

import javax.swing.*;
import java.util.ArrayList;

public class CompareCoursesPage extends Page{
    public CompareCoursesPage(Router router, PageState pageState) {
        super(router, pageState, "Compare Courses Page");
    }

    @Override
    public Page run() {
        assert super.checkLoggedIn();

        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();
        Timetable dummyTimetable1 = dummyTimetables.get(0);
        Timetable dummyTimetable2 = dummyTimetables.get(1);

        ArrayList<Course> sharedCourses = CourseComparer.findCommonCourses(dummyTimetable1, dummyTimetable2);

        System.out.println("Your timetable:");
        System.out.println(dummyTimetable1.toString());
        System.out.println("Compared timetable:");
        System.out.println(dummyTimetable2.toString());
        System.out.println("Shared courses:");
        System.out.println(sharedCourses);

        String[][] schedule = new String[12][8]; // setting up a 2d array
        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = 9;
        int end = 10;

        for (int i = 0; i < 12; i++) {
            schedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }

        JTable myTimetable = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("My Timetable");
        frame.add(new JScrollPane(myTimetable));
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JTable comparedTable = new JTable(schedule, days); // visualizing into JTable
        JFrame comparedFrame = new JFrame("Your Timetable");
        comparedFrame.add(new JScrollPane(comparedTable));
        comparedFrame.setSize(800, 500);
        comparedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comparedFrame.setVisible(true);

        JTable sharedTable = new JTable(schedule, days); // visualizing into JTable
        JFrame sharedFrame = new JFrame("Mutual Timetable");
        sharedFrame.add(new JScrollPane(sharedTable));
        sharedFrame.setSize(800, 500);
        sharedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sharedFrame.setVisible(true);


        return router.getTimetablePage();
    }
}
