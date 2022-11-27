package pages;

import java.util.Map;

public class ManageBlockedPage extends Page{
    public ManageBlockedPage(Router router, PageState pageState) {
        super(router, pageState, "Manage Blocked Page");
    }

    private enum Option {
        BLOCK_FRIENDS,
        UNBLOCK_FRIENDS
    }

    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Block Friends", Option.BLOCK_FRIENDS,
                "Unblock Friends", Option.UNBLOCK_FRIENDS
        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case BLOCK_FRIENDS:
                redirect = this.router.getBlockFriendsPage();
                System.out.println("Redirecting to Block Friends...");
            case UNBLOCK_FRIENDS:
                redirect = this.router.getUnblockFriendsPage();
                System.out.println("Redirecting to Unblock Friends...");

        }
        return redirect;
    }
}