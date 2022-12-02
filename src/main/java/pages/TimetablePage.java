package pages;

import entities.Timetable;
import presenter.TimetableViewer;

import java.util.Map;

public class TimetablePage extends Page{
    public TimetablePage(Router router, PageState pageState) {
        super(router, pageState, "View My Timetable Page");
    }
    public Timetable getTimetable() {
        return timetable;
    }
    // if student1 and student2 both added each other to their friend lists,
    // then student1 can view student2's timetable and student2 can view student1's timetable
    // else if only student1 added student2 to its friend list,
    // then student1 cannot view student2's timetable
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    private enum Option {
        RETURN_TO_HOME_PAGE
    }

    private Timetable timetable;
    private TimetableViewer timetableViewer;

    @Override
    public Page run() {
        System.out.println("This is my timetable:");
        // using timetableViewer.visualizeTimetable, print the timetable below
        System.out.println("CSC207, CSC236 ...");

        Map<String, Option> options = Map.of(
                "Return to Home Page", Option.RETURN_TO_HOME_PAGE
        );
        Option selection = promptInput(options);

        Page redirect = null;

        switch (selection) {
            case RETURN_TO_HOME_PAGE:
                redirect = this.router.getHomePage();
                System.out.println("Redirecting to Home Page...");
                break;
        }
        return redirect;
    }
}
