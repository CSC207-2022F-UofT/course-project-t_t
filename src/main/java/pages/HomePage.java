package pages;

import entities.User;

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
            TIMETABLE_VIEWER,
        }
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
            case TIMETABLE_VIEWER:
                redirect = this.router.getTimetableViewerPage();
                System.out.println("Loading timetable...");
                // get user info to set current user as 'user'
                this.pageState.setCurrentUser(null);
                break;
        };
        return redirect;


    }
}
