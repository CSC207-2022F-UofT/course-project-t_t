package pages.timetable;

import Gateway.DatabaseGateway;
import entities.*;
import pages.PageAction;
import pages.PageSession;
import presenter.CompareVisualizer;
import useCases.CourseComparer;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class CompareCoursesPage extends PageAction {

    @Override
    public void run(PageSession pageSession) {
        assert pageSession.checkLoggedIn();
        User currentUser = pageSession.getCurrentUser();
        Timetable myTimetable = currentUser.getTimetable();
        FriendsListManager friendsListManager = new FriendsListManager();
        Scanner in = new Scanner(System.in);
        User curr_user = pageSession.getCurrentUser();
        ArrayList<User> db = DatabaseGateway.getDatabase();
        ArrayList<User> fl = curr_user.getFriends();
        Timetable tt;
        ArrayList<Course> sharedCourses;


        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();
            User curr_friend = DatabaseGateway.getUser(friend);

            if (!friendsListManager.checkUsername(db, friend) || !fl.contains(curr_friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Selected user: %s.\n", friend);

            assert curr_friend != null;
            tt = curr_friend.getTimetable();

            sharedCourses = CourseComparer.findCommonCourses(myTimetable, tt);

            System.out.println("Your timetable:");
            System.out.println(myTimetable.toString());
            CompareVisualizer.compareWindow(myTimetable.getCourses());

            System.out.println("Compared timetable:");
            System.out.println(tt.toString());
            CompareVisualizer.compareWindow(tt.getCourses());

            System.out.println("Shared courses:");
            System.out.println(sharedCourses);
            CompareVisualizer.compareWindow(sharedCourses);

            break;
        }
    }
}
