package week2.day2;

abstract class Product {
    int productId;
    String name;
    String category;
    double price;
    int stock;
    double discount;

    Product(int id, String name, String category, double price, int stock, double discount) {
        this.productId = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
    }

    void printDetails() {
        System.out.println(name + " Price: " + price + " Stock: " + stock);
    }

    double calculateTotalPrice(int qty) {
        return price * qty;
    }

    double calculateDiscount(int qty) {
        return calculateTotalPrice(qty) * discount / 100;
    }

    double calculateFinalPrice(int qty) {
        return calculateTotalPrice(qty) - calculateDiscount(qty);
    }

    void sellProduct(int qty) {
        stock -= qty;
    }

    void restock(int qty) {
        stock += qty;
    }

    abstract void useProduct();

    abstract void stopUsing();
}



