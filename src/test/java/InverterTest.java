import entities.Interval;
import entities.Timetable;
import org.junit.Before;
import org.junit.Test;
import useCases.compareInverter;
import useCases.freeSlotInverter;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InverterTest {

    Timetable my;
    Timetable your;

    @Before
    public void SetUp() {
        my = new Timetable(new ArrayList<>());
        your = new Timetable(new ArrayList<>());
    }

    @Test(timeout = 50)
    public void testWednesday() {
        Integer number = 5000;
        assertEquals(3, freeSlotInverter.dayHelper(number));
    }

    @Test(timeout = 50)
    public void testSunday() {
        Integer number = 0;
        assertEquals(0, freeSlotInverter.dayHelper(number));
    }

    @Test(timeout = 50)
    public void testMax() {
        Integer number = 50000;
        assertEquals(6, freeSlotInverter.dayHelper(number));
    }
}


