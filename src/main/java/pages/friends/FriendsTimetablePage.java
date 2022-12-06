package pages.friends;

import Gateway.DatabaseGateway;
import entities.Course;
import entities.Timetable;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import presenter.CompareVisualizer;
import useCases.FriendsListManager;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendsTimetablePage extends PageAction {
    @Override
    public void run(PageSession pagesession) {
        FriendsListManager friendsListManager = new FriendsListManager();

        Scanner in = new Scanner(System.in);

        User curr_user = pagesession.getCurrentUser();
        ArrayList<User> fl = curr_user.getFriends();

        while (true) {
            System.out.println("Enter your friend's username:");

            String friend = in.next();
            User curr_friend = DatabaseGateway.getUser(friend);

            if (!friendsListManager.checkUsername(friend) || !fl.contains(curr_friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }

            System.out.printf("Selected user: %s.\n", friend);


            assert curr_friend != null;
            Timetable tt = curr_friend.getTimetable();
            ArrayList<Course> courses = tt.getCourses();

            CompareVisualizer.compareWindow(courses);
            
//            if (curr_friend.getFriends().contains(curr_user)) {
//                CompareVisualizer.compareWindow(courses);
//            } else {
//                System.out.println("You do not have permission to view this user's timetable.");
//            }

            break;
        }
    }
}
