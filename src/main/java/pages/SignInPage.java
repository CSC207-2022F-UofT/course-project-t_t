package pages;

public class SignInPage extends Page{
    public SignInPage(Router router) {
        super(router, "Sign In Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Sign In page.");

        return null;
    }
}
