package pages;

public class SignUpPage extends Page{
    public SignUpPage(Router router, PageState pageState) {
        super(router, pageState, "Sign Up Page");
    }

    @Override
    public Page run() {
        System.out.println("This is a Sign Up page.");

        return null;
    }
}
