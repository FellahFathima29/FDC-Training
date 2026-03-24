package week2.day2;

class Laptop extends Product implements ElectronicItem {
    Laptop(int id, int stock) {
        super(id, "Laptop", "Electronics", 50000, stock, 10);
    }

    public void switchOn() {
        System.out.println("Laptop switched ON");
    }

    void useProduct() {
        System.out.println("Using Laptop");
    }

    void stopUsing() {
        System.out.println("Stopped Laptop");
    }
}

