package week2.day1;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of vehicle");
        String type = sc.nextLine();
//        System.out.println("Enter mileage:");
//        double mileage = sc.nextDouble();
//
//        System.out.println("Enter tank capacity:");
//        double capacity = sc.nextDouble();
//
//        System.out.println("Enter current fuel:");
//        double currentFuel = sc.nextDouble();
//
//        Car car = new Car(VehicleType.LMV, FuelType.PETROL, mileage, capacity, currentFuel);
//
//        car.printDetails();
//        car.startEngine();
//        car.stopEngine();
//    }
//}

        if (type.equals("Car")) {
            Car car = new Car(VehicleType.LMV, FuelType.PETROL, 15, 45, 87);
            car.printDetails();
            car.startEngine();
            car.stopEngine();
        } else if (type.equals("Bike")) {
            Bike bike = new Bike(VehicleType.LMV, FuelType.PETROL, 40, 16, 95);
            bike.printDetails();
            bike.startEngine();
            bike.stopEngine();
        } else if (type.equals("Bus")) {
            Bus bus = new Bus(VehicleType.HMV, FuelType.DIESEL, 5, 20, 56, 87);
            bus.printDetails();
            bus.startEngine();
            bus.stopEngine();
        } else if (type.equals("Boat")) {
            Boat boat = new Boat(VehicleType.HMV, FuelType.DIESEL, 15, 47, 68, 90);
            boat.printDetails();
            boat.startEngine();
            boat.stopEngine();
        } else if (type.equals("Aeroplane")) {
            Aeroplane aeroplane = new Aeroplane(VehicleType.OTHERS, FuelType.JETFUEL, 2500, 5679, 8900, 1678);
            aeroplane.printDetails();
            aeroplane.startEngine();
            aeroplane.stopEngine();
        } else if (type.equals("Helicopter")) {
            Helicopter helicopter = new Helicopter(VehicleType.OTHERS, FuelType.JETFUEL, 5000, 8000, 1500);
            helicopter.printDetails();
            helicopter.startEngine();
            helicopter.stopEngine();
        }
    }
}