package week2.day2;

class Medicine extends Product implements Consumable {
    Medicine(int id, int stock) {
        super(id, "Medicine", "Health", 100, stock, 1);
    }

    public void consume() {
        System.out.println("Consuming Medicine");
    }

    void useProduct() {
        System.out.println("Using Medicine");
    }

    void stopUsing() {
        System.out.println("Stopped Medicine");
    }
}


