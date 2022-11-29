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

    private HomePage homePage;
    private LoginPage loginPage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private FriendsListPage friendsListPage;
    private BlockedListPage blockedListPage;
    private ManageFriendsPage manageFriendsPage;
    private ManageBlockedPage manageBlockedPage;
    private AddFriendsPage addFriendsPage;
    private RemoveFriendsPage removeFriendsPage;
    private BlockPage blockPage;
    private UnblockPage unblockPage;
    private FriendsPage friendsPage;

    public HomePage getHomePage() {
        return homePage;
    }
    public void setHomePage(HomePage homePage) {
        this.homePage = homePage;
    }

    public TimetableViewerPage getTimetableViewerPage() {
        return timetableViewerPage;
    }
    public void setTimetableViewerPage(TimetableViewerPage timetableViewerPage) {
        this.timetableViewerPage = timetableViewerPage;
    }
    private TimetableViewerPage timetableViewerPage;

    public FriendsListPage getFriendsListPage() {
        return friendsListPage;
    }
    public void setFriendsListPage(FriendsListPage friendsListPage) {
        this.friendsListPage = friendsListPage;
    }
    public BlockedListPage getBlockedListPage() { return blockedListPage; }
    public void setBlockedListPage(BlockedListPage blockedListPage) { this.blockedListPage = blockedListPage; }
    public ManageFriendsPage getManageFriendsPage() {
        return manageFriendsPage;
    }
    public void setManageFriendsPage(ManageFriendsPage manageFriendsPage) {
        this.manageFriendsPage = manageFriendsPage;
    }
    public ManageBlockedPage getManageBlockedPage() { return manageBlockedPage; }
    public void setManageBlockedPage(ManageBlockedPage manageBlockedPage) {
        this.manageBlockedPage = manageBlockedPage;
    }
    public Page getBlockPage() { return blockPage; }
    public void setBlockPage(BlockPage blockPage) {
        this.blockPage = blockPage;
    }
    public UnblockPage getUnblockPage() {
        return unblockPage;
    }
    public void setUnblockPage(UnblockPage unblockPage) { this.unblockPage = unblockPage; }
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
    }

}
