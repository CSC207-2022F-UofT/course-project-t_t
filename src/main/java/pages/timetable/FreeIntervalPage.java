package pages.timetable;

import database.Database;
import entities.Interval;
import entities.Timetable;
import pages.PageAction;
import pages.PageSession;
import presenter.FreeSlotsVisualizer;
import useCases.FreeIntervalComparer;

import java.util.ArrayList;

public class FreeIntervalPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
         ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();
         ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(dummyTimetables);

//        User currentUser = pageSession.getCurrentUser();
//        Timetable currentTimetable = currentUser.getTimetable();

        // get timetable for another user
        // store current user's and another user's timetables in ArrayList<Timetable>

//        ArrayList<Timetable> timetables =
//
//        ArrayList<Interval> freeIntervals = FreeIntervalComparer.findFreeIntervals(currentTimetable);

        System.out.println("Timetables processed:");
        System.out.println(dummyTimetables);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);

        FreeSlotsVisualizer.windowVisualizer(freeIntervals);
    }
}
