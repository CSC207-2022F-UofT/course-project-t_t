package pages;

import java.util.Map;

public class ManageBlockedPage extends Page{
    public ManageBlockedPage(Router router, PageState pageState) {
        super(router, pageState, "Manage Blocked Page");
    }

    private enum Option {
        BLOCK_FRIENDS,
        UNBLOCK_FRIENDS,
        BACK_FRIENDS
    }

    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Block Friends", Option.BLOCK_FRIENDS,
                "Unblock Friends", Option.UNBLOCK_FRIENDS,
                "Back to Friends Page", Option.BACK_FRIENDS
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case BACK_FRIENDS:
                redirect = this.router.getFriendsPage();
                System.out.println("Redirecting to Friends Page...");
                break;
            case BLOCK_FRIENDS:
                redirect = this.router.getBlockPage();
                System.out.println("Redirecting to Block Friends...");
                break;
            case UNBLOCK_FRIENDS:
                redirect = this.router.getUnblockPage();
                System.out.println("Redirecting to Unblock Friends...");
                break;
        }
        return redirect;
    }
}
