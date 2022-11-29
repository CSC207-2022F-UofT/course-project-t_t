package pages;

import java.util.Map;

public class FriendsPage extends Page{
    public FriendsPage(Router router, PageState pageState) {
        super(router, pageState, "Friends Page");
    }

    private enum Option {
        MANAGE_FRIENDS,
        MANAGE_BLOCKED,
        VIEW_FRIENDS,
        VIEW_BLOCKED,
        BACK_HOME,
    }
    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Manage Friends", Option.MANAGE_FRIENDS,
                "Manage Blocked Friends", Option.MANAGE_BLOCKED,
                "View Friends", Option.VIEW_FRIENDS,
                "View Blocked Users", Option.VIEW_BLOCKED,
                "Back to Home Page", Option.BACK_HOME
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case BACK_HOME:
                redirect = this.router.getHomePage();
                System.out.println("Redirecting to Home Page...");
            case VIEW_BLOCKED:
                redirect = this.router.getBlockedListPage();
                System.out.println("Redirecting to Blocked User List...");
                break;
            case MANAGE_BLOCKED:
                redirect = this.router.getManageBlockedPage();
                System.out.println("Redirecting to Manage Blocked Friends...");
                break;
            case MANAGE_FRIENDS:
                redirect = this.router.getManageFriendsPage();
                System.out.println("Redirecting to Manage Friends...");
                break;
            case VIEW_FRIENDS:
                redirect = this.router.getFriendsListPage();
                System.out.println("Redirecting to Friends List...");
                break;
        }
        return redirect;
    }
}