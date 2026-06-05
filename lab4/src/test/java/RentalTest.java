import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RentalTest {

    @Test
    public void testSedanDailyRate() {
        Sedan sedan = new Sedan("Toyota Camry", 40.0);
        assertEquals(40.0, sedan.getDailyRate());
    }

    @Test
    public void testSportsCarDailyRate() {
        SportsCar sports = new SportsCar("Ferrari 488", 200.0);
        assertEquals(500.0, sports.getDailyRate());
    }

    @Test
    public void testTruckDailyRate() {
        Truck truck = new Truck("Volvo FH", 80.0);
        assertEquals(144.0, truck.getDailyRate());
    }

    @Test
    public void testRentalTotalCostNoInsuranceNoPenalty() {
        Car car = new Sedan("Toyota Camry", 40.0);
        Client client = new Client("Іван", "DL-001");
        Rental rental = new Rental(car, client, 3, "NONE", new NoPenalty());
        assertEquals(120.0, rental.calculateTotalCost());
    }

    @Test
    public void testRentalTotalCostWithFullInsurance() {
        Car car = new Sedan("Toyota Camry", 40.0);
        Client client = new Client("Іван", "DL-001");
        Rental rental = new Rental(car, client, 3, "FULL", new NoPenalty());
        assertEquals(195.0, rental.calculateTotalCost());
    }

    @Test
    public void testLatePenalty() {
        LatePenalty penalty = new LatePenalty(2);
        double dailyRate = 40.0;
        assertEquals(120.0, penalty.calculatePenalty(dailyRate));
    }

    @Test
    public void testDamagePenalty() {
        DamagePenalty penalty = new DamagePenalty();
        double dailyRate = 100.0;
        assertEquals(300.0, penalty.calculatePenalty(dailyRate));
    }

    @Test
    public void testNoPenalty() {
        NoPenalty penalty = new NoPenalty();
        assertEquals(0.0, penalty.calculatePenalty(999.0));
    }
}
