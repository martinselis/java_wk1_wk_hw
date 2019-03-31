import java.util.ArrayList;
import java.util.Collections;

public class Airport {

    public ArrayList<Plane> hangar;
    public String code;
    public ArrayList<Flight> flights;

    public Airport(String code) {
        this.hangar = new ArrayList<>();
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getAirportCode() {
        return this.code;
    }

    public void addPlaneToHangar(Plane newPlane) {
        this.hangar.add(newPlane);
    }

    public Plane removePlaneFromHangar(Plane planeToRemove) {
        int indexOfPlaneToRemove = this.hangar.indexOf(planeToRemove);
        return this.hangar.remove(indexOfPlaneToRemove);
    }

    public Plane changePlaneFromHangar(Flight flight) {

        Plane oldPlane = flight.getPlane();
        this.addPlaneToHangar(oldPlane);

        Plane bestPlane = checkMostOptimalPlane(flight);


        flight.changePlane(bestPlane);
        return bestPlane;
    }

    public Plane checkMostOptimalPlane(Flight flight) {

        //// check most optimal one
        int passengersBooked = flight.getPassengerCount();

        ArrayList<Plane> freePlanes = new ArrayList<>();
        for (Plane plane : hangar) {
            if ((!plane.isAssigned()) && (plane.getCapacity() >= flight.getPlane().getCapacity())) {
                freePlanes.add(plane);
            }
        }

        Plane smallestCapacity = freePlanes.get(0);

        for (Plane planeToCheck : freePlanes) {
            if (smallestCapacity.getCapacity() > planeToCheck.getCapacity()) {
                smallestCapacity = planeToCheck;
            }
        }

        return smallestCapacity;
    }

    public void sellTicket(Flight flight) {
        if (flight.hasCapacity()) {
            flight.addPassenger();
        }
    }

    public int getBaggageLimits(Flight flight) {
        return flight.getPlane().getCapacity() * 20;
    }

}
