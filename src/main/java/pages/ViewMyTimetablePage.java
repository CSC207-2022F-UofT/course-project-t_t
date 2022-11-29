package pages;

import entities.Timetable;
import presenter.TimetableViewer;

import java.util.ArrayList;

public class ViewMyTimetablePage extends Page{
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

    private Timetable timetable;
    private TimetableViewer timetableViewer;

    public ViewMyTimetablePage(Router router, PageState pageState) {
        super(router, pageState, "Timetable Viewer");
        this.timetableViewer = new TimetableViewer();
    }

    @Override
    public Page run() {
        ArrayList<String> visualization = this.timetableViewer.visualizeTimetable(this.timetable);

        // show visualization
        // prompt user to continue

        System.out.println(visualization);

        return this.router.getHomePage();
    }
}
