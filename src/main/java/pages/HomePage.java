package pages;

import java.util.Map;

public class HomePage extends Page{
    public HomePage(Router router, PageState pageState) {
        super(router, pageState, "Home Page");
    }

    private enum Option {
        LOG_OUT,
    }
    @Override
    public Page run() {
        assert this.checkLoggedIn();

        System.out.printf("Welcome %s to the Home Page.", this.pageState.getCurrentUser().getName());

        Map<String, Option> options = Map.of(
                "Log Out", Option.LOG_OUT
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case LOG_OUT:
                redirect = this.router.getLoginPage();
                System.out.println("Logging out...");
                this.pageState.setCurrentUser(null);
                break;
        };
        return redirect;


    }
}
