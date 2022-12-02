package controller;

import entities.User;
import pages.*;
import useCases.FreeIntervalComparer;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

        PageState pageState = new PageState();


        Page logoutPage = new Page(pageState, "Log out");
        Page signInPage = new SignInPage(pageState);
        Page signUpPage = new SignUpPage(pageState);
        Page homePage = new Page(pageState, "Home");

        Page friendsPage = new Page(pageState, "Friends");
        Page friendsListPage = new FriendsListPage(pageState);
        Page manageFriendsPage = new Page(pageState, "Manage Friends");
        Page addFriendsPage = new AddFriendsPage(pageState);
        Page removeFriendsPage = new RemoveFriendsPage(pageState);

        Page blockedListPage = new BlockedListPage(pageState);
        Page manageBlockedPage = new Page(pageState, "Manage Blocked");
        Page blockPage = new BlockPage(pageState);
        Page unblockPage = new UnblockPage(pageState);

        Page timetablePage = new Page(pageState, "Timetable");
        Page compareCoursesPage = new CompareCoursesPage(pageState);
        Page freeIntervalPage = new FreeIntervalPage(pageState);



        logoutPage.setRoutes(new Page[]{signInPage, signUpPage});
        signUpPage.setRoutes(new Page[]{signInPage});
        signInPage.setRoutes(new Page[]{homePage});
        homePage.setRoutes(new Page[]{logoutPage, friendsPage, timetablePage});

        friendsPage.setRoutes(new Page[]{homePage, blockedListPage, manageBlockedPage, manageFriendsPage, friendsListPage});
        friendsListPage.setRoutes(new Page[]{friendsPage});
        manageFriendsPage.setRoutes(new Page[]{friendsPage, addFriendsPage, removeFriendsPage});
        addFriendsPage.setRoutes(new Page[]{manageFriendsPage});
        removeFriendsPage.setRoutes(new Page[]{manageFriendsPage});

        blockedListPage.setRoutes(new Page[]{friendsPage});
        manageBlockedPage.setRoutes(new Page[]{friendsPage, blockPage, unblockPage});
        blockPage.setRoutes(new Page[]{manageBlockedPage});
        unblockPage.setRoutes(new Page[]{manageBlockedPage});

        timetablePage.setRoutes(new Page[]{homePage, compareCoursesPage, freeIntervalPage});
        compareCoursesPage.setRoutes(new Page[]{timetablePage});
        freeIntervalPage.setRoutes(new Page[]{timetablePage});


        Page current = logoutPage;
        while (current != null) {
            System.out.println("\n---------------------------------");
            System.out.printf("Current Page: %s\n", current.getPageName());
            System.out.println("---------------------------------");

            current.run();
            current = current.getRedirect();
            System.out.println("Redirecting...");
        }
        System.out.println("Exiting...");
    }
}
