package pages.timetable;

import database.Database;
import entities.Timetable;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import useCases.CourseModifier;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveCoursesPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {
        CourseModifier courseModifier = new CourseModifier();

        Scanner in = new Scanner(System.in);

        ArrayList<User> db = Database.getDatabase();
        User currentUser = pageSession.getCurrentUser();
        Timetable timetable = currentUser.getTimetable();

        while (true) {
            System.out.println("Enter course code in a format of \"ABC123\":");

            String courseCode1 = in.nextLine();
            String courseCode = courseCode1.toUpperCase();

            if (!(courseModifier.checkCourseCodeLength(courseCode) && courseModifier.checkCourseCodeAlpha(courseCode)
                    && courseModifier.checkCourseCodeNum(courseCode) && courseModifier.checkCourseExists(timetable, courseCode))) {
                System.out.println("Enter the existing course in \"ABC123\" format.");
                continue;
            }

            System.out.printf("Removing %s. \n", courseCode);
            currentUser.getTimetable().removeCourse(courseCode);
            break;
        }
    }
}
