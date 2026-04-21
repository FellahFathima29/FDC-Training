package assessment;

import java.util.Scanner;

public class VehicleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of vehicle");
        String veh = sc.nextLine();
        if (veh.equals("Car")) {
            Car c = new Car();
            c.start();
        } else if (veh.equals("Bike")) {
            Bike b = new Bike();
            b.start();
        } else if (veh.equals("Scooter")) {
            Scooter s = new Scooter();
            s.start();
        }
    }
}
