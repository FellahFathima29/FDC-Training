package week2.day1;

public class Aeroplane extends Vehicle implements Aircraft {
    int seats;

    Aeroplane(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel,int seats) {
        super(vehicleType, fuelType, mileage, tankCapacity, currentFuel);
        this.seats=seats;
    }

    @Override
    public void startEngine() {
        System.out.println("Aeroplane engine started! Please check the runway before takeoff. " + " Maximum seating capacity is " +
                seats + "." +  fuelType + " is at " + fuelPercentage() + " % " +
                " . With current amount of fuel, maximum distance achievable is " + maxDistance() + " . ");

    }
    @Override
    public void fly() {
        System.out.println("Aeroplane starts flying");
    }
    @Override
    public void stopEngine() {

        System.out.println("Engine stopped");
    }

}
