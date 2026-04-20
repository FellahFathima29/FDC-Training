package junit;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private static class Product {
        int productId;
        String name;
        int quantity;

        Product(int productId, String name, int quantity) {
            this.productId = productId;
            this.name = name;
            this.quantity = quantity;
        }
    }

    private final Map<Integer, Product> inventory = new HashMap<>();
    public void addProduct(int productId, String name, int quantity) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if(inventory.containsKey(productId)) {
            throw new IllegalArgumentException("Product ID must be unique");
        }
        if (quantity <=0) {
            throw new IllegalArgumentException("Quantity must not be negative");
        }
        inventory.put(productId, new Product(productId, name, quantity));
    }

     public void updateStock(int productId, int quantityChange) {
        Product product = inventory.get(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product does not exist");
        }

        int newStock = product.quantity + quantityChange;

        if (newStock < 0) {
            throw new IllegalArgumentException("Stock cannot go below zero");
        }

        product.quantity = newStock;
    }

    public int getStock(int productId) {
        Product product = inventory.get(productId);

        if (product == null) {
            throw new IllegalArgumentException("Product does not exist");
        }

        return product.quantity;
    }
    public void deleteProduct(int productId) {
        if (!inventory.containsKey(productId)) {
            throw new IllegalArgumentException("Product does not exist");
        }

        inventory.remove(productId);
    }
    public void clear() {
        inventory.clear();
    }
}