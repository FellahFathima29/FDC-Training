package junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Inventory Service Test")
public class InventoryServiceTest {
    static InventoryService service = new InventoryService();

    @BeforeAll
    public static void setup() {
    }
    @BeforeEach
    public void addProduct()
    {
        service.addProduct(1, "AC", 6);
        service.addProduct(2, "Heater", 12);

    }
    @AfterEach
    public void clearDb()
    {

        service.clear();
    }

    @Test
    void testAddProductInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addProduct(-5,"Fridge",6));
        assertEquals("Product ID must be positive", e.getMessage());
    }

    @Test
    void testAddProductPositiveId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addProduct(2,"Fridge",4));
        assertEquals("Product ID must be unique", e.getMessage());
    }

    @Test
    void testAddProductEmptyName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addProduct(2, "",2));
        assertEquals("Product name cannot be null or empty", e.getMessage());
    }

    @Test
    void testAddProductNegativeQuantity() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addProduct(3,"Heater",-4));
        assertEquals("Quantity must not be negative", e.getMessage());
    }

    @Test
    void testUpdateStockIncrease() {
        service.updateStock(1, 3);
        assertEquals(9, service.getStock(1));
    }

    @Test
    void testUpdateStockDecrease() {
        service.updateStock(2, -4);
        assertEquals(8, service.getStock(2));
    }

    @Test
    void testUpdateStockBelowZero() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {service.updateStock(1, -10);});
        assertEquals("Stock cannot go below zero", e.getMessage());
    }


    @Test
    void testDeleteNonExistingProduct() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {service.deleteProduct(99);});
        assertEquals("Product does not exist", e.getMessage());
    }
}



