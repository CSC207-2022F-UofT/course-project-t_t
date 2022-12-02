package pages;

import database.Database;
import entities.Interval;
import entities.Timetable;
import useCases.FreeIntervalComparer;

import java.util.ArrayList;

public class FreeIntervalPage extends Page{

    public FreeIntervalPage(PageState pageState) {
        super(pageState, "Free Interval");
    }

    @Override
    public void run() {
        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();

        ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(dummyTimetables);

        System.out.println("Timetables processed:");
        System.out.println(dummyTimetables);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);
    }
}
