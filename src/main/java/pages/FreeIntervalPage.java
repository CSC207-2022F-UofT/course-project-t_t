package pages;

import database.Database;
import entities.Interval;
import entities.Timetable;
import useCases.FreeIntervalComparer;

import javax.swing.*;
import java.util.ArrayList;

public class FreeIntervalPage extends Page{

    public FreeIntervalPage(Router router, PageState pageState) {
        super(router, pageState, "Free interval page");
    }

    @Override
    public Page run() {
        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();

        ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(dummyTimetables);

        System.out.println("Timetables processed:");
        System.out.println(dummyTimetables);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);

        String[][] schedule = new String[12][8]; // setting up a 2d array
        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = 9;
        int end = 10;

        for (int i = 0; i < 12; i++) {
            schedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }

        JTable table = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("Free Interval Finder");
        frame.add(new JScrollPane(table));
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        return router.getTimetablePage();
    }
}
