import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.SignIn;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SignInTest {
    SignIn signIn;
    ArrayList<User> db;
    User a;
    User b;

    @Before
    public void setUp() {
        signIn = new SignIn();
        db = new ArrayList<>();
        a = new User("soomi", "choi7439", new ArrayList<>(), new ArrayList<>());
        b = new User("narae", "lee0828", new ArrayList<>(), new ArrayList<>());
    }

    @Test(timeout = 50)
    public void testCheckUsername() {
        db.add(a);
        db.add(b);
        String aUsername = a.getUsername();
        String bUsername = b.getUsername();
        assertTrue(signIn.checkUsername(db, aUsername));
        assertTrue(signIn.checkUsername(db, bUsername));
        assertFalse(signIn.checkUsername(db, "ashley"));
    }

    @Test(timeout = 50)
    public void testCheckPassword() {
        db.add(a);
        db.add(b);
        String aUsername = a.getUsername();
        String bUsername = b.getUsername();
        assertTrue(signIn.checkPassword(db, aUsername, "choi7439"));
        assertTrue(signIn.checkPassword(db, bUsername, "lee0828"));
        assertFalse(signIn.checkPassword(db, aUsername, "hi"));
        assertFalse(signIn.checkPassword(db, bUsername, "bye"));
    }
}
