import useCases.*;
import entities.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class TimeConverterTest {
    TimeConverter timeConverter;
    @Before
    public void setUp() {
        timeConverter = new TimeConverter();
    }

    @Test(timeout = 1000)
    public void testConvertMinutes() {
        int time = 1000;
        int mon = timeConverter.convertMinutes("MON", time);
        int tue = timeConverter.convertMinutes("TUE", time);
        int wed = timeConverter.convertMinutes("WED", time);
        int thu = timeConverter.convertMinutes("THU", time);
        int fri = timeConverter.convertMinutes("FRI", time);
        int sat = timeConverter.convertMinutes("SAT", time);
        int sun = timeConverter.convertMinutes("SUN", time);
        assertEquals(mon, 61440);
        assertEquals(tue, 62880);
        assertEquals(wed, 64320);
        assertEquals(thu, 65760);
        assertEquals(fri, 67200);
        assertEquals(sat, 68640);
        assertEquals(sun, 60000);
    }
}
