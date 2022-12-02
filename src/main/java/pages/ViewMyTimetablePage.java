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

        System.out.println("This is my timetable:");

        String[][] schedule = new String[23][6];

        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri"};

        schedule[0][0] = "9:00-9:30";
        schedule[1][0] = "9:30-10:00";
        schedule[2][0] = "10:00-10:30";
        schedule[3][0] = "10:30-11:00";
        schedule[4][0] = "11:00-11:30";
        schedule[5][0] = "11:30-12:00";
        schedule[6][0] = "12:00-12:30";
        schedule[7][0] = "12:30-13:00";
        schedule[8][0] = "13:30-14:00";
        schedule[9][0] = "14:00-14:30";
        schedule[10][0] = "14:30-15:00";
        schedule[11][0] = "15:00-15:30";
        schedule[12][0] = "15:30-16:00";
        schedule[13][0] = "16:00-16:30";
        schedule[14][0] = "16:30-17:00";
        schedule[15][0] = "17:00-17:30";
        schedule[16][0] = "17:30-18:00";
        schedule[17][0] = "18:00-18:30";
        schedule[18][0] = "18:30-19:00";
        schedule[19][0] = "19:00-19:30";
        schedule[20][0] = "19:30-20:00";
        schedule[21][0] = "20:00-20:30";
        schedule[22][0] = "20:30-21:00";

        JTable table = new JTable(schedule, days);

        JFrame frame = new JFrame("UTimetable");

        frame.add(new JScrollPane(table));

        frame.setSize(500, 500);
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