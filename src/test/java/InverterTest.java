import entities.Interval;
import entities.Timetable;
import org.junit.Before;
import org.junit.Test;
import useCases.CompareInverter;
import useCases.FreeSlotInverter;

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
        assertEquals(3, FreeSlotInverter.dayHelper(number));
    }

    @Test(timeout = 50)
    public void testSunday() {
        Integer number = 0;
        assertEquals(0, FreeSlotInverter.dayHelper(number));
    }

    @Test(timeout = 50)
    public void testMax() {
        Integer number = 50000;
        assertEquals(6, FreeSlotInverter.dayHelper(number));
    }
}


