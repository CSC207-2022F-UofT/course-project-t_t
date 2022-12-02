package pages;

import database.Database;

import java.util.Map;
import java.util.Scanner;

public class TimetablePage extends Page{
    public TimetablePage(Router router, PageState pageState) {
        super(router, pageState, "Timetable Page");
    }

    private enum Option {
        HOME,
        FIND_COURSES,
        FIND_FREE,
        TIMETABLE_VIEWER,
    }

    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Back to home", Option.HOME,
                "Find common courses", Option.FIND_COURSES,
                "Find common free intervals", Option.FIND_FREE,
                "Timetable Viewer", Option.TIMETABLE_VIEWER
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case HOME:
                redirect = this.router.getHomePage();
                break;
            case FIND_COURSES:
                redirect = this.router.getCompareCoursesPage();
                break;
            case FIND_FREE:
                redirect = this.router.getFreeIntervalPage();
                break;
            case TIMETABLE_VIEWER:
                redirect = this.router.getTimetableViewerPage();
                System.out.println("Loading timetable...");
                break;
        };
        return redirect;



    }
}
