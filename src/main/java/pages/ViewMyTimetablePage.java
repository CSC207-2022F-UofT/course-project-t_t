package pages;

import entities.Timetable;
import presenter.TimetableViewer;

import javax.swing.*;
import java.util.Map;


public class ViewMyTimetablePage extends Page{
    // User curr_user = this.pageState.getCurrentUser();
    public ViewMyTimetablePage(Router router, PageState pageState) {
        super(router, pageState, "View My Timetable Page");
    }
    public Timetable getTimetable() {
        return timetable;
    }
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