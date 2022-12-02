package pages;


import java.util.Map;

public class ManageFriendsPage extends Page{
    public ManageFriendsPage(Router router, PageState pageState) {
        super(router, pageState, "Manage Friends Page");
    }

    private enum Option {
        ADD_FRIENDS,
        REMOVE_FRIENDS,
        BACK_FRIENDS
    }

    @Override
    public Page run() {

        Map<String, Option> options = Map.of(
                "Add Friends", Option.ADD_FRIENDS,
                "Remove Friends", Option.REMOVE_FRIENDS,
                "Back To Friends Page", Option.BACK_FRIENDS

        );
        Option selection = promptInput(options);

        Page redirect = null;
        switch (selection) {
            case BACK_FRIENDS:
                redirect = this.router.getFriendsPage();
                System.out.println("Redirecting to Friends Page...");
                break;
            case ADD_FRIENDS:
                redirect = this.router.getAddFriendsPage();
                System.out.println("Redirecting to Add Friends...");
                break;
            case REMOVE_FRIENDS:
                redirect = this.router.getRemoveFriendsPage();
                System.out.println("Redirecting to Remove Friends...");
                break;
        }
        return redirect;
    }
}
