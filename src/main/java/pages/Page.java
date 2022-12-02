package pages;

import java.util.*;

public class Page {
    protected Page[] routes;
    protected PageCache pageCache;

    private final String pageName;
    public String getPageName() {
        return this.pageName;
    }
    private final PageAction pageAction;

    public Page(PageCache pageCache, String pageName, PageAction pageAction) {
        this.pageCache = pageCache;
        this.pageName = pageName;
        this.pageAction = pageAction;
    }

    public void setRoutes(Page[] routes) {
        this.routes = routes;
    }

    public void run(){this.pageAction.run(this.pageCache);};


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