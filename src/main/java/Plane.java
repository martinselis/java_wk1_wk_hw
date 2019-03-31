public class Plane {
    private FlightType flightType;
    private Airline airline;
    private int passengerCapacity;
    private boolean assigned;

    public Plane(FlightType flightType, Airline airline, int passengerCapacity, boolean assigned) {
        this.flightType = flightType;
        this.airline = airline;
        this.passengerCapacity = passengerCapacity;
        this.assigned = assigned;
    }

    public int getCapacity() {
        return this.passengerCapacity;
    }

    public boolean isAssigned() {
        return this.assigned;
    }

    public void reassign() {
       this.assigned = !this.assigned;
    }
}
