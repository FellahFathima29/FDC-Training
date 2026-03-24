package week2.day2;

class FoodItem extends Product implements Consumable {
    FoodItem(int id, int stock) {
        super(id, "FoodItem", "Food", 200, stock, 3);
    }

    public void consume() {
        System.out.println("Eating Food");
    }

    void useProduct() {
        System.out.println("Using FoodItem");
    }

    void stopUsing() {
        System.out.println("Stopped FoodItem");
    }
}