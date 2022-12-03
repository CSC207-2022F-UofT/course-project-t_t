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

    public int dayHelper(Integer inter) {
        if (0 <= inter && inter < 1440) { // sunday
            return 0;
        }

        else if (1440 <= inter && inter < 2880) { //monday
            return 1;
        }

        else if (2880 <= inter && inter < 4320) { // tuesday
            return 2;
        }

        else if (4320 <= inter && inter < 5760) { // wednesday
            return 3;
        }

        else if (5760 <= inter && inter < 7200) { // thursday
            return 4;
        }

        else if (7200 <= inter && inter < 8640) { // friday
            return 5;
        }

        else if (8640 <= inter && inter < 10080) { // saturday
            return 6;
        }

        else {
            return 6;
        }
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

