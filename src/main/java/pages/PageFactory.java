package pages;

public class PageFactory {
    private final PageSession pageSession;

    public PageFactory(PageSession pageSession) {
        this.pageSession = pageSession;
    }

    public Page buildPage(PageAction pageAction, String pageName){
        return new Page(pageSession, pageName, pageAction);
    }

    public Page buildPage(String pageName){
        return new Page(pageSession, pageName, new EmptyAction());
    }

    static class EmptyAction extends PageAction{
        @Override
        public void run(PageSession pageSession) {}
    }
}
