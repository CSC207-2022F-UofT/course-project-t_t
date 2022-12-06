package controller;

import pages.*;
import pages.block.BlockPage;
import pages.block.BlockedListPage;
import pages.block.UnblockPage;
import pages.friends.AddFriendsPage;
import pages.friends.FriendsListPage;
import pages.friends.FriendsTimetablePage;
import pages.friends.RemoveFriendsPage;
import pages.timetable.*;
import pages.user.SignInPage;
import pages.user.SignUpPage;

public class Client {
    public static void main(String[] args) {
        Page current = generatePages();

        while (current != null) {
            System.out.println("\n---------------------------------");
            System.out.printf("Current Page: %s\n", current.getPageName());
            System.out.println("---------------------------------");

            current.run();
            current = current.getRedirect();
        }
        System.out.println("Exiting...");
    }

    private static Page generatePages() {
        PageSession pageSession = new PageSession();
        PageFactory pf = new PageFactory(pageSession);

        Page logoutPage = pf.buildPage("Log out");
        Page signInPage = pf.buildPage(new SignInPage(), "Sign in");
        Page signUpPage = pf.buildPage(new SignUpPage(), "Sign up");
        Page homePage = pf.buildPage("Home");

        Page friendsPage = pf.buildPage("Friends");
        Page friendsListPage = pf.buildPage(new FriendsListPage(), "Friends list");
        Page manageFriendsPage = pf.buildPage("Manage friends");
        Page addFriendsPage = pf.buildPage(new AddFriendsPage(), "Add friends");
        Page removeFriendsPage = pf.buildPage(new RemoveFriendsPage(), "Remove friends");
        Page friendsTimetablePage = pf.buildPage(new FriendsTimetablePage(), "View friend's timetable");

        Page blockedListPage = pf.buildPage(new BlockedListPage(), "Blocked list");
        Page manageBlockedPage = pf.buildPage("Manage blocked");
        Page blockPage = pf.buildPage(new BlockPage(), "Block user");
        Page unblockPage = pf.buildPage(new UnblockPage(), "Unblock user");

        Page timetablePage = pf.buildPage("Timetable");
        Page compareCoursesPage = pf.buildPage(new CompareCoursesPage(), "Find common courses");
        Page freeIntervalPage = pf.buildPage(new FreeIntervalPage(), "Find common free intervals");
        Page timetableViewerPage = pf.buildPage(new TimetableViewerPage(), "View my timetable");
        Page modifyTimetablePage = pf.buildPage("Modify Timetable");
        Page addCoursesPage = pf.buildPage(new AddCoursesPage(), "Add courses");
        Page removeCoursesPage = pf.buildPage(new RemoveCoursesPage(), "Remove courses");

        logoutPage.setRoutes(new Page[]{signInPage, signUpPage});
        signUpPage.setRoutes(new Page[]{signInPage});
        signInPage.setRoutes(new Page[]{homePage});
        homePage.setRoutes(new Page[]{logoutPage, friendsPage, timetablePage});

        friendsPage.setRoutes(new Page[]{homePage, manageFriendsPage, friendsListPage, manageBlockedPage, blockedListPage});
        friendsListPage.setRoutes(new Page[]{friendsPage, friendsTimetablePage});
        manageFriendsPage.setRoutes(new Page[]{friendsPage, addFriendsPage, removeFriendsPage});
        addFriendsPage.setRoutes(new Page[]{manageFriendsPage});
        removeFriendsPage.setRoutes(new Page[]{manageFriendsPage});
        friendsTimetablePage.setRoutes(new Page[]{friendsListPage});

        blockedListPage.setRoutes(new Page[]{friendsPage});
        manageBlockedPage.setRoutes(new Page[]{friendsPage, blockPage, unblockPage});
        blockPage.setRoutes(new Page[]{manageBlockedPage});
        unblockPage.setRoutes(new Page[]{manageBlockedPage});

        timetablePage.setRoutes(new Page[]{homePage, compareCoursesPage, freeIntervalPage, timetableViewerPage, modifyTimetablePage});
        modifyTimetablePage.setRoutes(new Page[]{timetablePage, addCoursesPage, removeCoursesPage});
        addCoursesPage.setRoutes(new Page[]{timetablePage});
        removeCoursesPage.setRoutes(new Page[]{timetablePage});
        compareCoursesPage.setRoutes(new Page[]{timetablePage});
        freeIntervalPage.setRoutes(new Page[]{timetablePage});
        timetableViewerPage.setRoutes(new Page[]{timetablePage});

        return logoutPage;
    }
}
