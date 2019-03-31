public class Flight {
    private Plane plane;
    private int flightNumber;
    private String destination;
    private int passengersBooked;

    public Flight(Plane plane, int flightNum, String destination, int passengersBooked) {
        this.plane = plane;
        this.plane.reassign();

        this.flightNumber = flightNum;
        this.destination = destination;
        this.passengersBooked = passengersBooked;
    }

    public void addPassenger() {
        this.passengersBooked += 1;
    }

    public int getPassengerCount() {
        return this.passengersBooked;
    }

    public boolean hasCapacity() {
        return this.plane.getCapacity() > this.passengersBooked;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void changePlane(Plane newPlane) {
        this.plane.reassign();
        this.plane = newPlane;
        newPlane.reassign();
    }


}
