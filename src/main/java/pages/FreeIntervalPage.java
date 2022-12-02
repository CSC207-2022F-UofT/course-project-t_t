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

        int startInd = freeIntervals.get(0).getStart();
        int endInd = freeIntervals.get(0).getEnd();
        int hour = (startInd - 1440) / 60;

        for (Interval inter: freeIntervals) { // selecting the index j
            if (1440 <= startInd & startInd < 2880) { // monday
                int day = 1;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }
            else if (2880 <= startInd & startInd < 4320) { // tuesday
                int day = 2;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }
            else if (4320 <= startInd & startInd < 5760) { // wednesday
                int day = 3;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }

            else if (5760 <= startInd & startInd < 7200) { //thursday
                int day = 4;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }

            else if (7200 <= startInd & startInd < 8640) { //friday
                int day = 5;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }

            else if (8640 <= startInd & startInd < 10080) { // saturday
                int day = 6;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }

            else if (10080 <= startInd & startInd < 11520) { // sunday
                int day = 7;

                if (hour > 12) {
                    int pmHour = hour - 12;

                    schedule[pmHour][day] = "Free";
                }

                else {
                    schedule[hour][day] = "Free";
                }
            }

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
