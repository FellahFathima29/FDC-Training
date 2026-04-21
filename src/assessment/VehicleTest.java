

package assessment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class VehicleTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testCarStart() {
        provideInput("Car");
        VehicleMain.main(new String[0]);
        assertTrue(testOut.toString().contains("Car starts"));
    }

    @Test
    public void testBikeStart() {
        provideInput("Bike");
        VehicleMain.main(new String[0]);
        assertTrue(testOut.toString().contains("Bike starts"));
    }

    @Test
    public void testScooterStart() {
        provideInput("Scooter");
        VehicleMain.main(new String[0]);
        assertTrue(testOut.toString().contains("Scooter starts"));
    }
}
