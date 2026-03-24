package week2.day1;

public class Car extends Vehicle {

    Car(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
    }

    @Override
    void startEngine() {
        System.out.println("Car engine started! " + fuelType +
                " is at " + fuelPercentage() + " % " +
                " . With current amount of fuel, maximum distance achievable is "
                + maxDistance() + " . ");
    }

    @Override
    void stopEngine() {
        System.out.println("Engine stopped");
    }
}




