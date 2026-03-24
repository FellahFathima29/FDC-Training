package week2.day2;


    class TV extends Product implements ElectronicItem {
        TV(int id, int stock) {
            super(id, "TV", "Electronics", 20000, stock, 5);
        }

        public void switchOn() {
            System.out.println("TV ON");
        }

        void useProduct() {
            System.out.println("Using TV");
        }

        void stopUsing() {
            System.out.println("Stopped TV");
        }
    }

