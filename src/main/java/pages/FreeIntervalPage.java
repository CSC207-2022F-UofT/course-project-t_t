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


        return router.getTimetablePage();
    }
}
