import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    public Flight flight;
    public Plane plane;

    @Before
    public void setup() {
        plane = new Plane(FlightType.BOEING777, Airline.EMIRATES, 10, false);
        flight = new Flight(plane, 1111, "Edinburgh", 0);
    }

    @Test
    public void canAddPassenger() {
        flight.addPassenger();
        assertEquals(1, flight.getPassengerCount());
    }

    @Test
    public void canAddPlaneToFlight() {
        Plane newPlane = new Plane(FlightType.AIRBUS636, Airline.AIRBALTIC, 20, false);
        flight.changePlane(newPlane);
        boolean oldPlaneAssigned = plane.isAssigned();
        assertEquals(false, oldPlaneAssigned);
        assertEquals(newPlane, flight.getPlane());
    }


}

