package pages;

import entities.Timetable;
import entities.User;
import presenter.TimetableViewer;

import java.util.ArrayList;
import java.util.Map;

public class ViewMyTimetablePage extends Page{
    // User curr_user = this.pageState.getCurrentUser();
    public ViewMyTimetablePage(Router router, PageState pageState) {
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

//    public ViewMyTimetablePage(Router router, PageState pageState) {
//        super(router, pageState, "Timetable Viewer");
//        this.timetableViewer = new TimetableViewer();
//    }

    @Override
    public Page run() {

        System.out.println("This is my timetable:");
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


//        System.out.println("This is my timetable: ");
//        ArrayList<String> visualization = this.timetableViewer.visualizeTimetable(this.timetable);
//        ArrayList<String> visualization1 = new ArrayList<String>();
//
//        for (int i = 0; i < 5; i++) {
//            visualization1.add(Integer.toString(i));
//        }
//
//        for (String vs : visualization1) {
//            System.out.println(vs);
//        }
//
//        // show visualization
//        // prompt user to continue
//
//        System.out.println(visualization);
//
//        return router.getHomePage();
    }
}
