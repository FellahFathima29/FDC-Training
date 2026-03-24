package week2.day2;

    class FoodItem extends Product implements Consumable {
        FoodItem(int id, int stock) {
            super(id, "Medicine", "Health", 100, stock, 1);
        }

        public void consume() {
            System.out.println("Consuming FoodItem");
        }

        void useProduct() {
            System.out.println("Using FoodItem");
        }

        void stopUsing() {
            System.out.println("Stopped FoodItem");
        }
    }
