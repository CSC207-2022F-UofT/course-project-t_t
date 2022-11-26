package pages;

public class Router {
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public void setSignInPage(SignInPage signInPage) {
        this.signInPage = signInPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public void setSignUpPage(SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    private LoginPage loginPage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;

    private HomePage homePage;

    public HomePage getHomePage() {
        return homePage;
    }
    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
}
