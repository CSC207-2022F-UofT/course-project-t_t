package pages;

public class Router {
    public LoginPage getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    public void setSignInPage(SignInPage signInPage) {
        this.signInPage = signInPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public void setSignUpPage(SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }
    private LoginPage loginPage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;


    private HomePage homePage;

    private ManageBlockedPage manageBlockedPage;
    private BlockFriendsPage blockFriendsPage;
    private UnblockFriendsPage unblockFriendsPage;
    private BlockedListPage blockedListPage;

    public ManageBlockedPage getManageBlockedPage() {
        return manageBlockedPage;
    }

    public void setManageBlockedPage(ManageBlockedPage manageBlockedPage) {
        this.manageBlockedPage = manageBlockedPage;
    }

    public BlockFriendsPage getBlockFriendsPage() {
        return blockFriendsPage;
    }
    public void setBlockFriendsPage(BlockFriendsPage blockFriendsPage) {
        this.blockFriendsPage = blockFriendsPage;
    }

    public UnblockFriendsPage getUnblockFriendsPage() {
        return unblockFriendsPage;
    }

    public void setUnblockFriendsPage(UnblockFriendsPage unblockFriendsPage) {
        this.unblockFriendsPage = unblockFriendsPage;
    }

    public BlockedListPage getFriendsListPage() {
        return blockedListPage;
    }

    public void setFriendsListPage(BlockedListPage blockedListPage) {
        this.blockedListPage = blockedListPage;
    }
}
