package pages;

public class Router {
    public Router() {
    }

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

    public HomePage getHomePage() {
        return homePage;
    }

    public TimetableViewerPage getTimetableViewerPage() {
        return timetableViewerPage;
    }
    public void setTimetableViewerPage(TimetableViewerPage timetableViewerPage) {
        this.timetableViewerPage = timetableViewerPage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
    private LoginPage loginPage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private HomePage homePage;
    private TimetableViewerPage timetableViewerPage;

}
