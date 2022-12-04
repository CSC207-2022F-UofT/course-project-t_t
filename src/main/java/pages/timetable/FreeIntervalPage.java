package pages.timetable;

import database.Database;
import entities.Interval;
import entities.Timetable;
import pages.PageAction;
import pages.PageSession;
import useCases.FreeIntervalComparer;

import javax.swing.*;
import java.util.ArrayList;

public class FreeIntervalPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();

        ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(dummyTimetables);

        System.out.println("Timetables processed:");
        System.out.println(dummyTimetables);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);
    }
}
