package week2.day2;
import java.util.Scanner;

public class ShopTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = {
                new Laptop(1, 5),
                new Mobile(2, 3),
                new Book(3, 10),
                new Medicine(4, 20)
        };

        UserAccount[] users = {
                new Admin(1, "admin", "admin123"),
                new User(2, "user1", "1111"),
                new User(3, "user2", "2222")
        };

        while (true) {
            System.out.println("1 Login 2 Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 2) break;

            System.out.print("Username: ");
            String uname = sc.nextLine();
            System.out.print("Password: ");
            String pass = sc.nextLine();

            UserAccount loggedUser = null;

            for (UserAccount u : users) {
                if (u.userName.equals(uname) && u.password.equals(pass)) {
                    loggedUser = u;
                    break;
                }
            }

            if (loggedUser == null) {
                System.out.println("Invalid login");
                continue;
            }

            System.out.println("Login success");

            if (loggedUser.type == UserType.ADMIN) {
                while (true) {
                    System.out.println("1 View 2 Restock 3 Details 4 Logout");
                    int c = sc.nextInt();

                    if (c == 4) break;

                    if (c == 1) {
                        for (Product p : products) p.printDetails();
                    } else if (c == 2) {
                        sc.nextLine();
                        System.out.print("Product name: ");
                        String name = sc.nextLine();
                        System.out.print("Qty: ");
                        int qty = sc.nextInt();

                        for (Product p : products) {
                            if (p.name.equalsIgnoreCase(name)) {
                                p.restock(qty);
                            }
                        }
                    } else if (c == 3) {
                        sc.nextLine();
                        System.out.println("Enter the product name: ");
                        String name = sc.nextLine();

                        for (Product p : products)  {
                            if (p.name.equalsIgnoreCase(name)) {
                                p.printDetails();
                            }
                        }
                    }
                }
            }
            else {
                while (true) {
                    System.out.println("1 View 2 Buy 3 Use 4 Purchased 5 Logout");
                    int c = sc.nextInt();

                    if (c == 5) break;

                    if (c == 1) {
                        for (Product p : products) p.printDetails();
                    }

                    else if (c == 2) {
                        sc.nextLine();
                        System.out.print("Product name: ");
                        String name = sc.nextLine();
                        System.out.print("Qty: ");
                        int qty = sc.nextInt();

                        for (Product p : products) {
                            if (p.name.equalsIgnoreCase(name)) {
                                loggedUser.buyProduct(p, qty);
                            }
                        }
                    }

                    else if (c == 3) {
                        sc.nextLine();
                        System.out.print("Product name: ");
                        String name = sc.nextLine();
                        loggedUser.useProduct(name);
                    }

                    else if (c == 4) {
                        loggedUser.printPurchasedProducts();
                    }
                }
            }
        }
    }
}
