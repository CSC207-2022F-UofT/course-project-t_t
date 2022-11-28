package pages;

import java.util.Map;

public class HomePage extends Page{
    public HomePage(Router router, PageState pageState) {
        super(router, pageState, "Home Page");
    }

    private enum Option {
        LOG_OUT,
        TIMETABLE_VIEWER,
    }
    @Override
    public Page run() {
        assert this.checkLoggedIn();

        System.out.printf("Welcome %s to the Home Page.\n", this.pageState.getCurrentUser().getUsername());

        Map<String, Option> options = Map.of(
                "Log Out", Option.LOG_OUT,
                "Timetable Viewer", Option.TIMETABLE_VIEWER
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case LOG_OUT:
                redirect = this.router.getLoginPage();
                System.out.println("Logging out...");
                this.pageState.setCurrentUser(null);
                break;
            // add 'user' to set it as a current user
            case TIMETABLE_VIEWER:
                redirect = this.router.getTimetableViewerPage();
                System.out.println("Loading timetable...");
                this.pageState.setCurrentUser(null);
                break;
        };
        return redirect;


    }
}
