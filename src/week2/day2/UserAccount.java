package week2.day2;

class UserAccount {
    int userId;
    String userName;
    String password;
    UserType type;

    PurchasedItem[] items = new PurchasedItem[10];
    int count = 0;

    UserAccount(int id, String name, String pass, UserType type) {
        this.userId = id;
        this.userName = name;
        this.password = pass;
        this.type = type;
    }

    void buyProduct(Product p, int qty) {
        if (p.stock < qty) {
            System.out.println("Out of stock");
            return;
        }

        double total = p.calculateTotalPrice(qty);
        double discount = p.calculateDiscount(qty);
        double finalPrice = p.calculateFinalPrice(qty);

        System.out.println("Total = " + total);
        System.out.println("Discount = " + discount);
        System.out.println("Final = " + finalPrice);


        for (int i = 0; i < count; i++) {
            if (items[i].product.name.equals(p.name)) {
                items[i].quantity += qty;
                System.out.println("Quantity updated in purchased list");
                p.sellProduct(qty);
                return;
            }
        }

        items[count++] = new PurchasedItem(p, qty);
        p.sellProduct(qty);
        System.out.println("Order successful");
    }

    void useProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (items[i].product.name.equalsIgnoreCase(name)) {
                items[i].product.useProduct();
                return;
            }
        }
        System.out.println("Product not purchased");
    }

    void printPurchasedProducts() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].product.name + " Qty: " + items[i].quantity);
        }
    }
}
