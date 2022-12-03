package pages;

import database.Database;
import entities.*;
import useCases.CourseComparer;

import javax.swing.*;
import java.util.ArrayList;

public class CompareCoursesPage extends Page {
    public CompareCoursesPage(Router router, PageState pageState) {
        super(router, pageState, "Compare Courses Page");
    }


    public int dayHelper(Integer inter) {
        if (0 <= inter && inter < 1440) { // sunday
            return 0;
        } else if (1440 <= inter && inter < 2880) { //monday
            return 1;
        } else if (2880 <= inter && inter < 4320) { // tuesday
            return 2;
        } else if (4320 <= inter && inter < 5760) { // wednesday
            return 3;
        } else if (5760 <= inter && inter < 7200) { // thursday
            return 4;
        } else if (7200 <= inter && inter < 8640) { // friday
            return 5;
        } else if (8640 <= inter && inter < 10080) { // saturday
            return 6;
        } else {
            return 6;
        }
    }

    @Override
    public Page run() {
        assert super.checkLoggedIn();

        ArrayList<Timetable> dummyTimetables = Database.getDummyTimetablesTemp();
        Timetable dummyTimetable1 = dummyTimetables.get(0);
        Timetable dummyTimetable2 = dummyTimetables.get(1);

        ArrayList<Course> sharedCourses = CourseComparer.findCommonCourses(dummyTimetable1, dummyTimetable2);

        System.out.println("Your timetable:");
        System.out.println(dummyTimetable1.toString());
        System.out.println("Compared timetable:");
        System.out.println(dummyTimetable2.toString());
        System.out.println("Shared courses:");
        System.out.println(sharedCourses);

        String[][] mySchedule = new String[24][8]; // setting up a 2d array
        String[] days = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

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

            for (Lecture lecture : myLectures) {
                int startTime = lecture.getInterval().getStart();
                int endTime = lecture.getInterval().getEnd();


                while (startTime < endTime) {

                    int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                    String courseName = myCourse.getCourseCode();
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

            // compared timetable

            String[][] comparedSchedule = new String[24][8]; // setting up a 2d array
            String[] comparedDays = {"Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

            for (int i = 0; i < 24; i++) {
                comparedSchedule[i][0] = start + "-" + end;

                start += 1;
                end += 1;
            }

            for (Course comparedCourse : dummyTimetable1.getCourses()) {
                ArrayList<Lecture> comparedLectures = comparedCourse.getLectures();

                for (Lecture lecture : comparedLectures) {
                    int startTime = lecture.getInterval().getStart();
                    int endTime = lecture.getInterval().getEnd();


                    while (startTime < endTime) {

                        int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                        String courseName = comparedCourse.getCourseCode();
                        comparedSchedule[startIndex][dayHelper(startTime) + 1] = courseName;

                        startTime += 60;

                    }
                }
            }

            JTable comparedTable = new JTable(comparedSchedule, comparedDays); // visualizing into JTable
            JFrame comparedFrame = new JFrame("Compared Timetable");
            comparedFrame.add(new JScrollPane(comparedTable));
            comparedFrame.setSize(800, 500);
            comparedFrame.setVisible(true);


            // shared timetable

        String[][] sharedSchedule = new String[24][8]; // setting up a 2d array
        String[] sharedDays = {"Time", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        for (int i = 0; i < 24; i++) {
            sharedSchedule[i][0] = start + "-" + end;

            start += 1;
            end += 1;
        }

        for (Course sharedCourse : dummyTimetable1.getCourses()) {
            ArrayList<Lecture> sharedLectures = sharedCourse.getLectures();

            for (Lecture lecture : sharedLectures) {
                int startTime = lecture.getInterval().getStart();
                int endTime = lecture.getInterval().getEnd();


                while (startTime < endTime) {

                    int startIndex = (startTime / 60) - (24 * dayHelper(startTime));
                    String courseName = sharedCourse.getCourseCode();
                    sharedSchedule[startIndex][dayHelper(startTime) + 1] = courseName;

                    startTime += 60;

                }
            }
        }

        JTable sharedTable = new JTable(sharedSchedule, sharedDays); // visualizing into JTable
        JFrame sharedFrame = new JFrame("Shared Courses Timetable");
        sharedFrame.add(new JScrollPane(sharedTable));
        sharedFrame.setSize(800, 500);
        sharedFrame.setVisible(true);


            return router.getTimetablePage();
        }
    }

