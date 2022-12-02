package pages;

import entities.Timetable;
import presenter.TimetableViewer;

import java.util.Map;

public class TimetableViewerPage extends Page{
    public TimetableViewerPage(Router router, PageState pageState) {
        super(router, pageState, "Timetable Viewer Page");
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
        TIMETABLE_MENU,
    }

    private Timetable timetable;
    private TimetableViewer timetableViewer;

    @Override
    public Page run() {
        System.out.println("This is my timetable:");
        // using timetableViewer.visualizeTimetable, print the timetable below
        System.out.println("CSC207, CSC236 ...");

        Map<String, Option> options = Map.of(
                "Back to Timetable Menu", Option.TIMETABLE_MENU
        );
        Option selection = promptInput(options);

        Page redirect = null;

        switch (selection) {
            case TIMETABLE_MENU:
                redirect = this.router.getTimetablePage();
                System.out.println("Redirecting to Home Page...");
                break;
        }
        return redirect;
    }
}

