package week1.day2;

public class Bike extends Vehicle{
    @Override
    public void start() {
        System.out.println("Bike starts with a kick");
    }
    public void stop(){
        System.out.println("Bike stops");
    }
}
