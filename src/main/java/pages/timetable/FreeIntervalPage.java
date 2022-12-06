package pages.timetable;

import database.Database;
import entities.Course;
import entities.Interval;
import entities.Timetable;
import entities.User;
import pages.PageAction;
import pages.PageSession;
import presenter.CompareVisualizer;
import presenter.FreeSlotsVisualizer;
import useCases.FreeIntervalComparer;
import useCases.FriendsListManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FreeIntervalPage extends PageAction {
    @Override
    public void run(PageSession pageSession) {

        User currentUser = pageSession.getCurrentUser();
        Timetable myTimetable = currentUser.getTimetable();
        FriendsListManager friendsListManager = new FriendsListManager();
        Scanner in = new Scanner(System.in);
        User curr_user = pageSession.getCurrentUser();
        ArrayList<User> db = Database.getDatabase();
        ArrayList<User> fl = curr_user.getFriends();
        ArrayList<Timetable> ourTimetable;
        ArrayList<Interval> freeIntervals;

        while (true) {
            System.out.println("Enter your friend's username:");
            String friend = in.next();
            User curr_friend = Database.getUser(friend);

            if (!friendsListManager.checkUsername(db, friend) || !fl.contains(curr_friend)) {
                System.out.println("User not found. Try again.");
                continue;
            }
            System.out.printf("Selected user: %s.\n", friend);

            assert curr_friend != null;

            Timetable tt = curr_friend.getTimetable();

            ourTimetable = new ArrayList<>();
            ourTimetable.add(myTimetable);
            ourTimetable.add(tt);

            freeIntervals = FreeIntervalComparer.findFreeIntervals(ourTimetable);

            FreeSlotsVisualizer.windowVisualizer(freeIntervals);
            break;
        }

        System.out.println("Timetables processed:");
        System.out.println(ourTimetable);

        System.out.println("Free intervals:");
        System.out.println(freeIntervals);

        FreeSlotsVisualizer.windowVisualizer(freeIntervals);
    }
}
