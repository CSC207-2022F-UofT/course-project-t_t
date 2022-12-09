import Gateway.DatabaseGateway;
import entities.Relations;
import entities.User;
import org.junit.Before;
import org.junit.Test;
import useCases.RelationsManager;

import javax.xml.crypto.Data;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RelationsManagerTest {
    @Before
    public void setUp() {
        DatabaseGateway.addUser(new User( "Kim", "cydfk123", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Soomi", "choi7439", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Jeff", "0101", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Ashley", "1111", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Narae", "1234", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Clarence", "5678", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("Tina", "0000", new ArrayList<>(), new ArrayList<>()));

        User Kim = DatabaseGateway.getUser("Kim");
        User Ashley = DatabaseGateway.getUser("Ashley");
        User narae = DatabaseGateway.getUser("Narae");
        User jeff = DatabaseGateway.getUser("Jeff");
        User clarence = DatabaseGateway.getUser("Clarence");
        User tina = DatabaseGateway.getUser("Tina");
        User soomi = DatabaseGateway.getUser("Soomi");


    }

    @Test(timeout = 1000)
    public void testAddFriends(){
        User Kim = DatabaseGateway.getUser("Kim");
        User Ashley = DatabaseGateway.getUser("Ashley");
        User tina = DatabaseGateway.getUser("Tina");
        RelationsManager.addFriends(Ashley, Kim);
        assert Ashley.getFriends().contains(Kim.getUsername());
    }
    @Test(timeout = 1000)
    public void testRemoveFriends(){
        User narae = DatabaseGateway.getUser("Narae");
        User Kim = DatabaseGateway.getUser("Kim");
        RelationsManager.addFriends(narae, Kim);
        RelationsManager.removeFriends(narae, Kim); // Removing user who exists in fl
        assert narae.getFriends().isEmpty();
    }

    @Test(timeout = 10000)
    public void testBlockUsers(){
        DatabaseGateway.addUser(new User("Jeff", "0101", new ArrayList<>(), new ArrayList<>()));
        User Kim = DatabaseGateway.getUser("Kim");
        User jeff = DatabaseGateway.getUser("Jeff");
        RelationsManager.addFriends(jeff, Kim); // Add user from db
        RelationsManager.blockUser(jeff, Kim); // Add user from fl to bl and remove from fl
        assert jeff.getFriends().isEmpty();
        assert jeff.getBlocked().contains(Kim.getUsername());
    }

    @Test(timeout = 1000)
    public void testUnblockFriends(){
        User jeff = DatabaseGateway.getUser("Jeff");
        User Kim = DatabaseGateway.getUser("Kim");
        RelationsManager.addFriends(jeff, Kim); // Add user from db
        RelationsManager.blockUser(jeff, Kim); // Block friend in fl
        RelationsManager.unblockUser(jeff, Kim); // Unblock user from bl
        assert jeff.getBlocked().isEmpty() & jeff.getFriends().isEmpty();

    }

    @Test(timeout = 1000)
    public void testBlockedCaseA(){
        User soomi = DatabaseGateway.getUser("Soomi");
        User Kim = DatabaseGateway.getUser("Kim");
        RelationsManager.blockUser(soomi, Kim); // soomi has blocked Kim
        RelationsManager.addFriends(soomi, Kim); // soomi tries to add blocked user Kim
        assert soomi.getFriends().isEmpty();
        assert soomi.getBlocked().contains(Kim.getUsername());
    }

    @Test(timeout = 1000)
    public void testBlockedCaseB(){
        User clarence = DatabaseGateway.getUser("Clarence");
        User tina = DatabaseGateway.getUser("Tina");
        RelationsManager.blockUser(tina, clarence); // tina has blocked clarence
        RelationsManager.addFriends(clarence, tina); // blocked user clarence tries to add tina
        assert clarence.getFriends().isEmpty();
        assert tina.getBlocked().contains(clarence.getUsername());

    }
}
