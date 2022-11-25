package pages;

import entities.User;

import java.util.*;

public abstract class Page {
    protected Router router;
    protected PageState pageState;

    private final String pageName;
    public String getPageName() {
        return this.pageName;
    }

    public Page(Router router, PageState pageState, String pageName) {
        this.router = router;
        this.pageState = pageState;
        this.pageName = pageName;
    }

    public abstract Page run();

    protected boolean checkLoggedIn(){
        return this.pageState.getCurrentUser() == null;
    }

    protected <T> T promptInput(Map<String, T> options) {

        Scanner in = new Scanner(System.in);

        List<String> optionsIndex = new ArrayList<>(options.keySet());

        for (int i = 0; i < optionsIndex.size(); i ++) {
            System.out.printf("%s. %s\n", i, optionsIndex.get(i));
        }
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Invalid input.");
        }
        return options.get(optionsIndex.get(in.nextInt()));
    }
}
