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


    public int dayHelper(Integer inter) {
        if (0 <= inter && inter < 1440) { // sunday
            return 0;
        }

        else if (1440 <= inter && inter < 2880) { //monday
            return 1;
        }

        else if (2880 <= inter && inter < 4320) { // tuesday
            return 2;
        }

        else if (4320 <= inter && inter < 5760) { // wednesday
            return 3;
        }

        else if (5760 <= inter && inter < 7200) { // thursday
            return 4;
        }

        else if (7200 <= inter && inter < 8640) { // friday
            return 5;
        }

        else if (8640 <= inter && inter < 10080) { // saturday
            return 6;
        }

        else {
            return 6;
        }
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

        String[][] mySchedule = new String[12][8]; // setting up a 2d array
        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = 9;
        int end = 10;

        for (int i = 0; i < 12; i++) {
            mySchedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }






        JTable myTimetable = new JTable(mySchedule, days); // visualizing into JTable
        JFrame frame = new JFrame("My Timetable");
        frame.add(new JScrollPane(myTimetable));
        frame.setSize(800, 500);
        frame.setVisible(true);

//        JTable comparedTable = new JTable(schedule, days); // visualizing into JTable
//        JFrame comparedFrame = new JFrame("Your Timetable");
//        comparedFrame.add(new JScrollPane(comparedTable));
//        comparedFrame.setSize(800, 500);
//        comparedFrame.setVisible(true);
//
//        JTable sharedTable = new JTable(schedule, days); // visualizing into JTable
//        JFrame sharedFrame = new JFrame("Mutual Timetable");
//        sharedFrame.add(new JScrollPane(sharedTable));
//        sharedFrame.setSize(800, 500);
//        sharedFrame.setVisible(true);


        return router.getTimetablePage();
    }
}
