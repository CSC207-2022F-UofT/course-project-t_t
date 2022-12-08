import Gateway.DatabaseGateway;
import entities.*;
import org.junit.Before;
import org.junit.Test;
import useCases.SignUp;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SignUpTest {
    @Before
    public void setUp() {
        DatabaseGateway.addUser(new User("soomi", "choi7439", new ArrayList<>(), new ArrayList<>()));
        DatabaseGateway.addUser(new User("narae", "lee0828", new ArrayList<>(), new ArrayList<>()));
    }

    @Test(timeout = 1000)
    public void testCheckNewUsername() {
        String aUsername = "soomi";
        String bUsername = "narae";
        assertFalse(SignUp.checkNewUsername(aUsername));
        assertFalse(SignUp.checkNewUsername(bUsername));
        assertTrue(SignUp.checkNewUsername("Arbus"));
    }
}
