package controller;

import pages.*;

public class Client {
    public static void main(String[] args) {

        Router router = new Router();
        PageState pageState = new PageState();

        LoginPage loginPage = new LoginPage(router, pageState);
        SignInPage signInPage = new SignInPage(router, pageState);
        SignUpPage signUpPage = new SignUpPage(router, pageState);
        HomePage homePage = new HomePage(router, pageState);

        FriendsPage friendsPage = new FriendsPage(router, pageState);
        FriendsListPage friendsListPage = new FriendsListPage(router, pageState);
        ManageFriendsPage manageFriendsPage = new ManageFriendsPage(router, pageState);
        AddFriendsPage addFriendsPage = new AddFriendsPage(router, pageState);
        RemoveFriendsPage removeFriendsPage = new RemoveFriendsPage(router, pageState);
        ViewMyTimetablePage viewMyTimetablePage = new ViewMyTimetablePage(router, pageState);

        BlockedListPage blockedListPage = new BlockedListPage(router, pageState);
        ManageBlockedPage manageBlockedPage = new ManageBlockedPage(router, pageState);
        BlockPage blockPage = new BlockPage(router, pageState);
        UnblockPage unblockPage = new UnblockPage(router, pageState);



        router.setLoginPage(loginPage);
        router.setSignInPage(signInPage);
        router.setSignUpPage(signUpPage);
        router.setHomePage(homePage);

        router.setFriendsPage(friendsPage);
        router.setFriendsListPage(friendsListPage);
        router.setManageFriendsPage(manageFriendsPage);
        router.setAddFriendsPage(addFriendsPage);
        router.setRemoveFriendsPage(removeFriendsPage);
        router.setViewMyTimetablePage(viewMyTimetablePage);

        router.setBlockedListPage(blockedListPage);
        router.setManageBlockedPage(manageBlockedPage);
        router.setBlockPage(blockPage);
        router.setUnblockPage(unblockPage);
        ;

        Page current = loginPage;
        while (current != null) {
            System.out.printf("Current Page: %s\n", current.getPageName());
            current = current.run();
        }
        System.out.println("Exiting...");
    }
}
