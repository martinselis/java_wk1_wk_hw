import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    public Airport airport;
    public Plane plane;
    public Plane plane2;
    public Plane plane4;
    public Plane plane5;

    @Before
    public void setup() {
        airport = new Airport("EDI");
        plane = new Plane(FlightType.AIRBUS636, Airline.EMIRATES, 50, false);
        plane2 = new Plane(FlightType.BOEING737, Airline.JET2, 21, false);
        plane4 = new Plane(FlightType.BOEING737, Airline.JET2, 50, false);
        plane5 = new Plane(FlightType.BOEING737, Airline.JET2, 20, false);

    }

    @Test
    public void canGetAirportCode() {
        assertEquals("EDI", airport.getAirportCode());
    }

    @Test
    public void canAddRemovePlaneToHangar() {
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane2);
        assertEquals(plane2, airport.removePlaneFromHangar(plane2));
    }

    @Test
    public void addPlaneToFlightFromHangar() {
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane2);
        airport.addPlaneToHangar(plane4);

        Plane plane3 = new Plane(FlightType.BOEING737, Airline.JET2, 20, false);
        Flight flight = new Flight(plane3, 1111, "Edinburgh", 0);
        flight.addPassenger();
        flight.addPassenger();

        airport.changePlaneFromHangar(flight);
        assertEquals(plane, flight.getPlane());
        assertEquals(false, plane3.isAssigned());
        assertEquals(true, plane.isAssigned());

    }

    @Test
    public void canSellTicket() {
        Plane plane = new Plane(FlightType.BOEING737, Airline.JET2, 2, false);
        Flight flight = new Flight(plane, 1111, "Edinburgh", 0);
        airport.sellTicket(flight);
        airport.sellTicket(flight);
        airport.sellTicket(flight);

        assertEquals(2, flight.getPassengerCount());
    }

    @Test
    public void canCheckBaggageLimitation() {
        Plane plane = new Plane(FlightType.BOEING737, Airline.JET2, 2, false);
        Flight flight = new Flight(plane, 1111, "Edinburgh", 0);
        assertEquals(40, airport.getBaggageLimits(flight));
    }

    @Test
    public void checkMostOptimalPlane() {
        airport.addPlaneToHangar(plane);
        airport.addPlaneToHangar(plane4);
        airport.addPlaneToHangar(plane5);

        Plane plane3 = new Plane(FlightType.BOEING737, Airline.JET2, 20, false);
        Flight flight = new Flight(plane3, 1111, "Edinburgh", 0);

        airport.changePlaneFromHangar(flight);

        assertEquals(true, plane5.isAssigned());


    }

}
