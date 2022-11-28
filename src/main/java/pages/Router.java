package pages;

public class Router {
    public Router() {
    }

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

    private LoginPage loginPage;
    private SignInPage signInPage;
    private HomePage homePage;

    private SignUpPage signUpPage;
    private FriendsListPage friendsListPage;
    private ManageBlockedPage manageBlockedPage;
    private ManageFriendsPage manageFriendsPage;

    private RemoveFriendsPage removeFriendsPage;
    private AddFriendsPage addFriendsPage;
    private FriendsPage friendsPage;

    public HomePage getHomePage() {
        return homePage;
    }

    public FriendsListPage getFriendsListPage() {
        return friendsListPage;
    }

    public void setFriendsListPage(FriendsListPage friendsListPage) {
        this.friendsListPage = friendsListPage;
    }

    public ManageBlockedPage getManageBlockedPage() {
        return manageBlockedPage;
    }

    public TimetableViewerPage getTimetableViewerPage() {
        return timetableViewerPage;
    }
    public void setTimetableViewerPage(TimetableViewerPage timetableViewerPage) {
        this.timetableViewerPage = timetableViewerPage;
    }

    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    private TimetableViewerPage timetableViewerPage;

    public void setManageBlockedPage(ManageBlockedPage manageBlockedPage) {
        this.manageBlockedPage = manageBlockedPage;
    }

    public ManageFriendsPage getManageFriendsPage() {
        return manageFriendsPage;
    }

    public void setManageFriendsPage(ManageFriendsPage manageFriendsPage) {
        this.manageFriendsPage = manageFriendsPage;
    }

    public Page getAddFriendsPage() {
        return addFriendsPage;
    }

    public void setAddFriendsPage(AddFriendsPage addFriendsPage) {
        this.addFriendsPage = addFriendsPage;
    }

    public Page getRemoveFriendsPage() {
        return removeFriendsPage;
    }

    public void setRemoveFriendsPage(RemoveFriendsPage removeFriendsPage) {
        this.removeFriendsPage = removeFriendsPage;
    }

    public Page getFriendsPage() {
        return friendsPage;
    }

    public void setFriendsPage(FriendsPage friendsPage) {
        this.friendsPage = friendsPage;

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
