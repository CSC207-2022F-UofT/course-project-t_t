import Gateway.DatabaseGateway;
import entities.Location;
import org.junit.Before;
import entities.User;
import org.junit.Test;
import useCases.LocationSetter;

import java.util.Objects;

public class LocationSetterTest {
    Location location = new Location("bahen");
    User user = DatabaseGateway.getUser("userone");

    @Test
    public void locationSetterTest(){
        user.setLocation(location);
        assert Objects.equals(user.getLocation().getName(), "bahen");
    }
}

