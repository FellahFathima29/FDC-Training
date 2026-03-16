package week1.day2;

public class Car extends Vehicle{
    @Override
    public void start() {
        System.out.println("Car starts with a key");
    }
    public void stop() {
        System.out.println("Car stops");
    }
}
