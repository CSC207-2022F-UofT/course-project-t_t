package pages;

import java.util.Map;

public class HomePage extends Page{
    public HomePage(Router router, PageState pageState) {
        super(router, pageState, "Home Page");
    }

    private enum Option {
        LOG_OUT,
        FRIENDS,
        TIMETABLE,

    }
    @Override
    public Page run() {
        assert this.checkLoggedIn();

        System.out.printf("Welcome %s to the Home Page.\n", this.pageState.getCurrentUser().getUsername());

        Map<String, Option> options = Map.of(
                "Log Out", Option.LOG_OUT,
                "Friends", Option.FRIENDS,

                "Timetable", Option.TIMETABLE
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case FRIENDS:
                redirect = this.router.getFriendsPage();
                System.out.println("Redirecting to Friends page...");
                break;
            case LOG_OUT:
                redirect = this.router.getLoginPage();
                System.out.println("Logging out...");
                this.pageState.setCurrentUser(null);
                break;
            // add 'user' to set it as a current user
            case TIMETABLE:
                redirect = this.router.getTimetablePage();
                break;
        };
        return redirect;


    }
}
