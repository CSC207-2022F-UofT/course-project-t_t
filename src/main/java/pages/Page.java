package pages;

import entities.User;

import java.util.*;

public class Page {
    protected Page[] routes;
    protected PageState pageState;

    private final String pageName;
    public String getPageName() {
        return this.pageName;
    }

    public Page(PageState pageState, String pageName) {
        this.pageState = pageState;
        this.pageName = pageName;
    }

    public void setRoutes(Page[] routes) {
        this.routes = routes;
    }

    public void run(){};

    protected boolean checkLoggedIn(){
        return this.pageState.getCurrentUser() == null;
    }

    public Page getRedirect(){
        if (this.routes.length == 0)
            return null;
        else if (this.routes.length == 1) {
            return this.routes[0];
        }

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < this.routes.length; i ++)
            System.out.printf("%s. %s\n", i, this.routes[i].getPageName());

        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Invalid input.");
        }
        return this.routes[in.nextInt()];
    }
}