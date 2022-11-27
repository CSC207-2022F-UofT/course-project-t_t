package pages;

import java.util.Map;

public class HomePage extends Page{
    public HomePage(Router router, PageState pageState) {
        super(router, pageState, "Home Page");
    }

    @Override
    public Page run() {
        assert this.checkLoggedIn();

        System.out.printf("Welcome %s to the Home Page.", this.pageState.getCurrentUser().getName());

        enum Option {
            LOG_OUT,
            FRIENDS_LIST
        }
        Map<String, Option> options = Map.of(
                "Log Out", Option.LOG_OUT,
                "Friends List", Option.FRIENDS_LIST
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case FRIENDS_LIST:
                redirect = this.router.getFriendsPage();
                System.out.println("Redirecting to Friends page...");
            case LOG_OUT:
                redirect = this.router.getLoginPage();
                System.out.println("Logging out...");
                this.pageState.setCurrentUser(null);
                break;
        };
        return redirect;


    }
}
