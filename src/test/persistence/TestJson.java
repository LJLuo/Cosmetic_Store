package persistence;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Product;

// test class for Json
public class TestJson {
    protected void checkProduct(String type, double price, String name,
            String brand, double rating, ArrayList<String> ingredients, int stockQuantity,
            int totalPurchasedTime, int productID, Product m) {
        assertEquals(type, m.getType());
        assertEquals(price, m.getPrice());
        assertEquals(name, m.getName());
        assertEquals(brand, m.getBrand());
        assertEquals(rating, m.getRating());
        assertEquals(ingredients, m.getIngredients());
        assertEquals(stockQuantity, m.getStockQuantity());
        assertEquals(totalPurchasedTime, m.getTotalPurchased());
        assertEquals(productID, m.getProductID());
    }
}
