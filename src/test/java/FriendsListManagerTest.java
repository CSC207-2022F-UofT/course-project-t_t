import database.Database;
import entities.FriendsList;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import useCases.FriendsListManager;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FriendsListManagerTest {
    FriendsList fl;
    FriendsList bl;

    @Before
    public void setUp() {
        fl = new FriendsList(new ArrayList<>(), new ArrayList<>());
        bl = new FriendsList(new ArrayList<>(), new ArrayList<>());
        Database.getDatabase();
    }

    @Test(timeout = 50)
    public void testAddFriends(){
        User ashley = new User("Ashley", "1111", new ArrayList<>(), new ArrayList<>());
        User Kim = Database.getUser("Kim");
        FriendsListManager.addFriends(ashley, Kim);
        fl.getFriends().add(Kim);                           // Adding user who exists in db
        assertEquals(fl.getFriends(), ashley.getFriends()); // added user should be in fl


        fl.getFriends().remove(Kim);
        ashley.getFriends().remove(Kim);
        User tina = new User("Tina", "0000", new ArrayList<>(), new ArrayList<>());
        FriendsListManager.addFriends(ashley, tina);        // Adding user not in db
        assertEquals(fl.getFriends(), ashley.getFriends()); // fl should be empty
    }
    @Test(timeout = 50)
    public void testRemoveFriends(){
        User narae = new User("Narae", "1234", new ArrayList<>(), new ArrayList<>());
        User Kim = Database.getUser("Kim");
        FriendsListManager.addFriends(narae, Kim);
        FriendsListManager.removeFriends(narae, Kim); // Removing user who exists in fl
        assertEquals(fl.getFriends(), narae.getFriends()); // fl should be empty
    }

    @Test(timeout = 50)
    public void testBlockFriends(){
        User jeff = new User("Jeff", "0101", new ArrayList<>(), new ArrayList<>());
        User Kim = Database.getUser("Kim");
        FriendsListManager.addFriends(jeff, Kim); // Add user from db
        FriendsListManager.blockFriends(jeff, Kim); // Add user from fl to bl and remove from fl
        bl.getBlocked().add(Kim);
        assertEquals(fl.getFriends(), jeff.getFriends()); // fl should be empty
        assertEquals(bl.getBlocked(), jeff.getBlocked()); // blocked user should be in bl
    }

    @Test(timeout = 50)
    public void testUnblockFriends(){
        User jeff = new User("Jeff", "0101", new ArrayList<>(), new ArrayList<>());
        User Kim = Database.getUser("Kim");
        FriendsListManager.addFriends(jeff, Kim); // Add user from db
        FriendsListManager.blockFriends(jeff, Kim); // Block friend in fl
        bl.getBlocked().add(Kim);
        FriendsListManager.unblockFriends(jeff, Kim); // Unblock user from bl
        bl.getBlocked().remove(Kim);
        assertEquals(fl.getFriends(), jeff.getFriends()); // fl should be empty
        assertEquals(bl.getBlocked(), jeff.getBlocked()); // bl should be empty

    }

    @Test(timeout = 50)
    public void testBlockedCaseA(){
        User soomi = new User("Soomi", "3333", new ArrayList<>(), new ArrayList<>());
        User Kim = Database.getUser("Kim");
        FriendsListManager.blockFriends(soomi, Kim); // soomi has blocked Kim
        bl.getBlocked().add(Kim);
        FriendsListManager.addFriends(soomi, Kim); // soomi tries to add blocked user Kim
        assertEquals(fl.getFriends(), soomi.getFriends()); // fl should be empty
        assertEquals(bl.getBlocked(), soomi.getBlocked()); // blocked user should be in bl
        bl.getBlocked().remove(Kim);

    }

    @Test(timeout = 50)
    public void testBlockedCaseB(){
        User clarence = new User("Clarence", "5678", new ArrayList<>(), new ArrayList<>());
        User tina = new User("Tina", "4321", new ArrayList<>(), new ArrayList<>());
        FriendsListManager.blockFriends(tina, clarence); // tina has blocked clarence
        bl.getBlocked().add(clarence);
        FriendsListManager.addFriends(clarence, tina); // blocked user clarence tries to add tina
        assertEquals(fl.getFriends(), clarence.getFriends()); // fl should be empty
        assertEquals(bl.getBlocked(), tina.getBlocked()); // blocked user should be in bl

    }
}
