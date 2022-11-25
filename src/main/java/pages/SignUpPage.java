package pages;

public class SignUpPage extends Page{
    public SignUpPage(Router router) {
        super(router, "Sign Up Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Sign Up page.");

        return null;
    }
}
