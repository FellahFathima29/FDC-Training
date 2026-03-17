package week2.day1;

public abstract class Vehicle {


    VehicleType vehicleType;
    FuelType fuelType;
    double mileage;
    double tankCapacity;
    double currentFuel;

    Vehicle(VehicleType vehicleType, FuelType fuelType, double mileage, double tankCapacity, double currentFuel) {
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.tankCapacity = tankCapacity;
        this.currentFuel = currentFuel;
    }

    void printDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Mileage: " + mileage + " km/L");
        System.out.println("Fuel Tank Capacity: " + tankCapacity);
        System.out.println("Current Fuel Level: " + currentFuel);
    }

    double maxDistance() {
        return (mileage * currentFuel);
    }

    double fuelPercentage() {
        return (currentFuel / tankCapacity) * 100;
    }

    abstract void startEngine();

    abstract void stopEngine();
}

interface Seacraft {
    void sail();
}

interface Aircraft {
    void fly();
}
