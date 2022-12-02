package pages;

import entities.Timetable;
import presenter.TimetableViewer;

import javax.swing.*;
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

        String[][] schedule = new String[12][8]; // setting up a 2d array
        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = 9;
        int end = 10;

        for (int i = 0; i < 12; i++) {
            schedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }

        JTable table = new JTable(schedule, days); // visualizing into JTable
        JFrame frame = new JFrame("My Timetable Viewer");
        frame.add(new JScrollPane(table));
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

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

