import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.SignUp;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SignUpTest {
    SignUp signUp;
    ArrayList<User> db;
    User a;
    User b;

    @Before
    public void setUp() {
        signUp = new SignUp();
        db = new ArrayList<>();
        a = new User("soomi", "choi7439", new ArrayList<>(), new ArrayList<>());
        b = new User("narae", "lee0828", new ArrayList<>(), new ArrayList<>());
    }

    @Test(timeout = 50)
    public void testCheckNewUsername() {
        db.add(a);
        db.add(b);
        String aUsername = a.getUsername();
        String bUsername = b.getUsername();
        assertFalse(signUp.checkNewUsername(db, aUsername));
        assertFalse(signUp.checkNewUsername(db, bUsername));
        assertTrue(signUp.checkNewUsername(db, "ashley"));
    }
}
