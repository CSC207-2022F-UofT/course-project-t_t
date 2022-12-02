package pages;

public class PageFactory {
    private PageCache pageCache;

    public PageFactory(PageCache pageCache) {
        this.pageCache = pageCache;
    }

    public Page buildPage(PageAction pageAction, String pageName){
        return new Page(pageCache, pageName, pageAction);
    }

    public Page buildPage(String pageName){
        PageAction EmptyAction = new EmptyAction();
        return new Page(pageCache, pageName, EmptyAction);
    }

    class EmptyAction extends PageAction{
        @Override
        public void run(PageCache pageCache) {}
    }
}
