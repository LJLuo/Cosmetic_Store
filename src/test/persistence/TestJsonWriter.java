package persistence;

import org.junit.jupiter.api.Test;

import model.MakeUp;
import model.Product;
import model.PurchasedList;
import model.ShoppingCart;
import model.SkinCare;
import persistance.JsonReader;
import persistance.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Referenced from CPSC 210 content
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Tests for Json writer
class TestJsonWriter extends TestJson {

    @Test
    void testWriterInvalidFile() {
        try {
            ShoppingCart sc = new ShoppingCart();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyShoppingCart() {
        try {
            ShoppingCart sc = new ShoppingCart();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyShoppingCart.json");
            writer.open();
            writer.writeSC(sc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyShoppingCart.json");
            sc = reader.readSC();
            assertEquals(0, sc.getTotalItem());
            assertEquals(0, sc.getTotalPrice(), 0.05f);
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptyPurchasedList() {
        try {
            PurchasedList pl = new PurchasedList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyShoppingCart.json");
            writer.open();
            writer.writePL(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyShoppingCart.json");
            pl = reader.readPL();
            assertEquals(0, pl.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralShoppingCart() {
        try {
            ShoppingCart sc = new ShoppingCart();
            MakeUp makeup1 = new MakeUp("p1", "n1");
            makeup1.setPrice(46);
            sc.addProduct(makeup1);
            sc.addProduct(new SkinCare("p2", "n2"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralShoppingCart.json");
            writer.open();
            writer.writeSC(sc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralShoppingCart.json");
            sc = reader.readSC();
            ArrayList<Product> products = sc.getShoppingCart();
            assertEquals(2, products.size());
            ArrayList<String> ingredients = new ArrayList<>();

            checkProduct("makeup", 46, "p1", "n1", 0.0, ingredients, 0,
                    0, 0, products.get(0));

            checkProduct("skincare", 0.0, "p2", "n2", 0.0, ingredients, 0,
                    0, 0, products.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPurchasedList() {
        try {
            PurchasedList pl = new PurchasedList();
            pl.addProduct(new MakeUp("p1", "n1"));
            pl.addProduct(new SkinCare("p2", "n2"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPurchasedList.json");
            writer.open();
            writer.writePL(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPurchasedList.json");
            pl = reader.readPL();
            ArrayList<Product> products = pl.getPurchased();
            assertEquals(2, products.size());
            ArrayList<String> ingredients = new ArrayList<>();

            checkProduct("makeup", 0.0, "p1", "n1", 0.0, ingredients, 0, 0,
                    0, products.get(0));

            checkProduct("skincare", 0.0, "p2", "n2", 0.0, ingredients, 0,
                    0, 0, products.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
