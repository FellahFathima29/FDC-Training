package week2.day1;

public class Boat extends Vehicle implements Seacraft {
    int seats;

    Boat(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel, int seats) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
        this.seats = seats;
    }

    @Override
    public void startEngine() {

        System.out.println("Boat engine started and ready to sail!" + " Maximum seating capacity is " + seats + ". "
                + fuelType + " is at " + fuelPercentage() + " % " +
                ". With current amount of fuel, maximum distance achievable is " + maxDistance() + " . ");
    }

    public void sail() {
        System.out.println("Boat starts sailing");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }
}
