package pages;

import java.util.Map;

public class LoginPage extends Page{

    public LoginPage(Router router) {
        super(router, "Login Page");
    }
    @Override
    public Page run() {
        enum Option {
            SIGN_IN,
            SIGN_UP
        }
        Map<String, Option> options = Map.of(
                "Sign In", Option.SIGN_IN,
                "Sign Up", Option.SIGN_UP
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case SIGN_IN:
                redirect = this.router.getSignInPage();
                System.out.println("Redirecting to Sign In...");
                break;
            case SIGN_UP:
                redirect = this.router.getSignUpPage();
                System.out.println("Redirecting to Sign Up...");
                break;
        };
        return redirect;
    }
}
