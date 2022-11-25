package controller;

import pages.*;

public class Client {
    public static void main(String[] args) {

        Router router = new Router();

        LoginPage loginPage = new LoginPage(router);
        SignInPage signInPage = new SignInPage(router);
        SignUpPage signUpPage = new SignUpPage(router);

        router.setLoginPage(loginPage);
        router.setSignInPage(signInPage);
        router.setSignUpPage(signUpPage);

        Page current = loginPage;
        while (current != null) {
            System.out.printf("Current Page: %s\n", current.getName());
            current = current.run();
        }
        System.out.println("Exiting...");
    }
}
