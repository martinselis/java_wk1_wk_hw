import org.junit.Before;
import org.junit.Test;

public class PassengerTest {

    public Passenger passenger;

    @Before
    public void setup() {
        passenger = new Passenger("Tim");
    }

    @Test
    public void canGetName() {
        passenger.getName();
    }
}
