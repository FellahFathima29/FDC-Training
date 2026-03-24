package week2.day2;

class Refrigerator extends Product implements ElectronicItem {
    Refrigerator(int id, int stock) {
        super(id, "Refrigerator", "Electronics", 30000, stock, 7);
    }

    public void switchOn() {
        System.out.println("Refrigerator ON");
    }

    void useProduct() {
        System.out.println("Using Refrigerator");
    }

    void stopUsing() {
        System.out.println("Stopped Refrigerator");
    }
}

