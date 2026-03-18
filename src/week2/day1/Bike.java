package week2.day1;

public class Bike extends Vehicle {
    Bike(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
    }

    @Override
    public void startEngine() {
        System.out.println("Bike engine started! " + fuelType + " is at " + fuelPercentage() + " % " +
                " . With current amount of fuel, maximum distance achievable is "
                + maxDistance() + " . ");

    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }
}
