package pages.timetable;

import Gateway.DatabaseGateway;
import entities.Interval;
import entities.Location;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.CourseModifier;
import useCases.TimeConverter;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCoursesPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
        CourseModifier courseModifier = new CourseModifier();
        TimeConverter timeConverter = new TimeConverter();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = DatabaseGateway.getDatabase();
        User currentUser = pageSession.getCurrentUser();

        while (true) {
            System.out.println("Enter course code in a format of \"ABC123\":");

            String courseCode = in.nextLine();

            if (!(courseModifier.checkCourseCodeLength(courseCode) && courseModifier.checkCourseCodeAlpha(courseCode)
                    && courseModifier.checkCourseCodeNum(courseCode))) {
                System.out.println("Enter again in \"ABC123\" format.");
                continue;
            }

            System.out.println("Enter section code in a format of \"LEC 0101\":");

            String sectionCode = in.nextLine();

            if (!(courseModifier.checkSectionCodeLength(sectionCode) && courseModifier.checkSectionCodeAlpha(sectionCode)
                    && courseModifier.checkSectionCodeNum(sectionCode))) {
                System.out.println("Enter again in \"LEC 0101\" format.");
                continue;
            }

            System.out.println("Enter the location in a format of \"BA 2222\":");

            String location = in.nextLine();

            if (!courseModifier.checkLocation(location)) {
                System.out.println("The first two characters should be alphabets.");
                continue;
            }

            System.out.println("Enter the day in a format of \"Mon\", \"Tue\", etc.:");

            String day = in.nextLine();

            if (!courseModifier.checkDay(day)) {
                System.out.println("Enter the day in an appropriate format.");
                continue;
            }

            System.out.println("Enter the start time in military time format 14, 15, etc.:");

            String startTime = in.nextLine();

            if (!courseModifier.checkTime(startTime)) {
                System.out.println("Enter the number between 0 and 24.");
                continue;
            }

            System.out.println("Enter the finish time in military time format 16, 17, etc.:");

            String endTime = in.nextLine();

            if (!(courseModifier.checkTime(endTime) && courseModifier.checkStartEndTime(startTime, endTime))) {
                System.out.println("Enter the number between 0 and 24, and the end time should be later than the start time.");
                continue;
            }

            Integer startTimeInt = Integer.parseInt(startTime);
            Integer endTimeInt = Integer.parseInt(endTime);

            System.out.printf("Adding %s. \n", courseCode);
            Integer calStartTime = timeConverter.convertMinutes(day, startTimeInt);
            Integer calEndTime = timeConverter.convertMinutes(day, endTimeInt);

            Interval interval = new Interval(calStartTime, calEndTime);
            Location courseLocation = new Location(location.toUpperCase());
            currentUser.getTimetable().addCourse(courseCode.toUpperCase(), sectionCode.toUpperCase(), interval, courseLocation);
            break;
        }
    }
}
