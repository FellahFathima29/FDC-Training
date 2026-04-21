package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book1", 300));
        products.add(new Product("Book2", 1800));
        products.add(new Product("Book3", 1150));

        System.out.println("1.Print products with price greater than 1000");
        System.out.println("2.Update price of a given product");
        int ch = sc.nextInt();
        sc.nextLine();
        if (ch == 1) {
            for (Product p : products) {
                if (p.getPrice() > 1000) {
                    System.out.println(p.getName() + " " + p.getPrice());
                }
            }
        } else if (ch == 2) {
            System.out.println("Enter the product to be updated");
            String name = sc.nextLine();
            for (Product p : products) {
                System.out.println("Enter new price");
                double newPrice = sc.nextDouble();
                p.setPrice(newPrice);
                System.out.println("Price of the product updated");

            }
        }

    }
}
