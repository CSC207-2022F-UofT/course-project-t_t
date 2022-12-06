package pages.timetable;

import Database.Database;
import entities.Interval;
import entities.Timetable;
import pages.PageAction;
import pages.PageSession;
import useCases.FreeIntervalComparer;

import javax.swing.*;
import java.util.ArrayList;

public class FreeIntervalPage extends PageAction {


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
    public void run(PageSession pageSession) {
        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();

        ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(dummyTimetables);

        System.out.println("Timetables processed:");
        System.out.println(dummyTimetables);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);

        String[][] schedule = new String[24][8]; // setting up a 2d array
        String[] days = {"Time", "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        int start = 0;
        int end = 1;

        for (int i = 0; i < 24; i++) {
            schedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }

        for (Interval inter : freeIntervals) {
            int startTime = inter.getStart();
            int endTime = inter.getEnd();
            while (startTime < endTime &&  startTime <= 10080 && endTime <= 10080) {
                int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                schedule[startIndex][dayHelper(startTime) + 1] = "███████";
                startTime += 60;
            }
        }

        JTable table = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("Free Interval Finder");
        frame.add(new JScrollPane(table));
        frame.setSize(1000, 1000);
        frame.setVisible(true);


    }
}
