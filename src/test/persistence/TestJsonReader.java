package persistence;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import model.Product;
import model.PurchasedList;
import model.ShoppingCart;
import persistance.JsonReader;
import static org.junit.jupiter.api.Assertions.*;

// Referenced from CPSC 210 content
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// tests for Json reader
class TestJsonReader extends TestJson {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ShoppingCart sp = reader.readSC();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyShoppingCart() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyShoppingList.json");
        try {
            ShoppingCart sc = reader.readSC();
            assertEquals(0, sc.getTotalItem());
            assertEquals(0, sc.getTotalPrice(), 0.05f);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderEmptyPurchasedList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPurchased.json");
        try {
            PurchasedList pl = reader.readPL();
            assertEquals(0, pl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralShoppingCart() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralShoppingCart.json");
        try {
            ShoppingCart sc = reader.readSC();
            ArrayList<Product> products = sc.getShoppingCart();
            assertEquals(1, sc.getTotalItem());
            assertEquals(54.00, sc.getTotalPrice(), 0.05f);
            ArrayList<String> ingredients = new ArrayList<>();
            ingredients.add("Water");
            ingredients.add("Dimethicone");
            ingredients.add("Talc");
            ingredients.add("PEG-10 Dimethicone");

            checkProduct("makeup", 54.0, "Pro Filtr Soft Matte Longwear Liquid Foundation",
                    "Fenty Beauty", 4.0, ingredients, 0, 1, 47693849,
                    products.get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }

    }

    @Test
    void testReaderGeneralPurchasedList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPurchasedList.json");
        try {
            PurchasedList pl = reader.readPL();
            ArrayList<Product> products = pl.getPurchased();
            assertEquals(1, pl.getSize());
            ArrayList<String> ingredients = new ArrayList<>();
            ingredients.add("Water");
            ingredients.add("Dimethicone");
            ingredients.add("Talc");
            ingredients.add("PEG-10 Dimethicone");

            checkProduct("makeup", 54.0, "Pro Filtr Soft Matte Longwear Liquid Foundation",
                    "Fenty Beauty", 4.0, ingredients, 0, 1, 47693849,
                    products.get(0));

        } catch (IOException e) {
            fail("Couldn't read from file");
        }

    }

}
