package week2.day1;

public class Bus extends Vehicle{
    int seats;

    Bus(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel,int seats) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
        this.seats = seats;
    }

    @Override

    void startEngine() {
        System.out.println("Bus engine started! " + " Maximum seating capacity is " + seats + "." + fuelType +
                " is at " + fuelPercentage() + " % "
              + " . With current amount of fuel, maximum distance achievable is "
                + maxDistance() + " . ");
    }
    @Override
    public void stopEngine() {
        System.out.println("Engine stopped");
    }
}
