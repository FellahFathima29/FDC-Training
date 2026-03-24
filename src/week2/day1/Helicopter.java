package week2.day1;

public class Helicopter extends Vehicle implements Aircraft {

    Helicopter(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
    }

    @Override
    public void startEngine() {

        System.out.println("Helicopter engine started!Please check helipad before takeoff. " + fuelType + " is at " + fuelPercentage() + " % " +
                " . With current amount of fuel, maximum distance achievable is " + maxDistance() + " . ");

    }
    public void fly() {
        System.out.println("Helicopter starts flying");
    }

    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }
}
