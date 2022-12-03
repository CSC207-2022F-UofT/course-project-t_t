package pages;

import database.Database;
import entities.Course;
import entities.Lecture;
import entities.Timetable;
import presenter.TimetableViewer;

import javax.swing.*;
import java.util.ArrayList;
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
        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();
        Timetable dummyTimetable1 = dummyTimetables.get(0);

        String[][] mySchedule = new String[24][8]; // setting up a 2d array
        String[] days = {"Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        int start = 0;
        int end = 1;

        // my (your) timetable
        for (int i = 0; i < 24; i++) {
            mySchedule[i][0] = start + "-" + end;
            start += 1;
            end += 1;
        }

        for (Course myCourse : dummyTimetable1.getCourses()) {
            ArrayList<Lecture> myLectures = myCourse.getLectures();
            String courseName = myCourse.getCourseCode();

            for (Lecture lecture : myLectures) {
                int startTime = lecture.getInterval().getStart();
                int endTime = lecture.getInterval().getEnd();

                while (startTime < endTime) {
                    int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                    mySchedule[startIndex][dayHelper(startTime) + 1] = courseName;
                    startTime += 60;
                }
            }
        }

        JTable myTimetable = new JTable(mySchedule, days); // visualizing into JTable
        JFrame frame = new JFrame("My Timetable");
        frame.add(new JScrollPane(myTimetable));
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

