package week2.day2;

    class Mobile extends Product implements ElectronicItem {
        Mobile(int id, int stock) {
            super(id, "Mobile", "Electronics", 20000, stock, 5);
        }

        public void switchOn() {
            System.out.println("Mobile ON");
        }

        void useProduct() {
            System.out.println("Using Mobile");
        }

        void stopUsing() {
            System.out.println("Stopped Mobile");
        }
    }








