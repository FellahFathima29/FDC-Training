package week2.day2;

    class Book extends Product implements Readable {
        Book(int id, int stock) {
            super(id, "Book", "Education", 500, stock, 2);
        }

        public void read() {
            System.out.println("Reading Book");
        }

        void useProduct() {
            System.out.println("Using Book");
        }

        void stopUsing() {
            System.out.println("Stopped Reading");
        }
    }





