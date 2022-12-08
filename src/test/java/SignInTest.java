import Gateway.DatabaseGateway;
import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.SignIn;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SignInTest {

    @Before
    public void setUp() {
        DatabaseGateway.addUser(new User("soomi", "choi7439", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("narae", "lee0828", new ArrayList<>(), new ArrayList<>()));
    }

    @Test(timeout = 1000)
    public void testCheckUsername() {
        String aUsername = "soomi";
        String bUsername = "narae";
        assertTrue(SignIn.checkUsername(aUsername));
        assertTrue(SignIn.checkUsername(bUsername));
    }

    @Test(timeout = 1000)
    public void testCheckPassword() {
        assertTrue(SignIn.checkPassword("soomi", "choi7439"));
        assertTrue(SignIn.checkPassword("narae", "lee0828"));
        assertFalse(SignIn.checkPassword("soomi", "hi"));
        assertFalse(SignIn.checkPassword("narae", "bye"));
    }
}
