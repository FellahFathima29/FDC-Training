package week2.day2;

class TV extends Product implements ElectronicItem {
    TV(int id, int stock) {
        super(id, "TV", "Electronics", 40000, stock, 8);
    }

    public void switchOn() {
        System.out.println("TV switched ON");
    }

    void useProduct() {
        System.out.println("Watching TV");
    }

    void stopUsing() {
        System.out.println("Stopped TV");
    }
}