import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    public Plane plane;
    public Plane plane2;

    @Before
    public void setup() {
        plane = new Plane(FlightType.AIRBUS636, Airline.EMIRATES, 50, false);
        plane2 = new Plane(FlightType.BOEING737, Airline.JET2, 20, true);
    }

    @Test
    public void canGetCapacity() {
        assertEquals(50, plane.getCapacity());
    }

    @Test
    public void canGetAssignStatus() {
        assertEquals(false, plane.isAssigned());
        assertEquals(true, plane2.isAssigned());
    }

    @Test
    public void canReassign() {
        plane.reassign();
        plane2.reassign();
        assertEquals(true, plane.isAssigned());
        assertEquals(false, plane2.isAssigned());
    }
}
