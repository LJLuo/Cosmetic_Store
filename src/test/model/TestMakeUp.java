package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Test for MakeUp class
public class TestMakeUp {
    private MakeUp makeup;

    @BeforeEach
    void runBefore() {
        makeup = new MakeUp("n1", "b1");
    }

    @Test
    void testConstructor() {
        assertEquals(0, makeup.getPrice(), 0.05f);
        assertEquals("n1", makeup.getName());
        assertEquals("b1", makeup.getBrand());
        assertTrue(makeup.getIngredients().isEmpty());
        assertEquals(0, makeup.getStockQuantity());
        assertEquals(0, makeup.getRating(), 0.05f);
        assertEquals(0, makeup.getTotalPurchased());
        assertEquals(0, makeup.getProductID());
        assertEquals("makeup", makeup.getType());
    }

    @Test
    void testSetPrice() {
        makeup.setPrice(14.2);
        assertEquals(14.2, makeup.getPrice(), 0.05f);

        makeup.setPrice(0.00);
        assertEquals(0, makeup.getPrice(), 0.05f);
    }

    @Test
    void testSetName() {
        makeup.setName("name1");
        assertEquals("name1", makeup.getName());

        makeup.setName("I am name");
        assertEquals("I am name", makeup.getName());
    }

    @Test
    void testSetBrand() {
        makeup.setBrand("Tom Ford");
        assertEquals("Tom Ford", makeup.getBrand());
    }

    @Test
    void testSetRating() {
        makeup.setRating(0.0);
        assertEquals(0, makeup.getRating(), 0.05f);

        makeup.setRating(0.21);
        assertEquals(0.21, makeup.getRating(), 0.05);

        makeup.setRating(4.98);
        assertEquals(4.98, makeup.getRating(), 0.05);

        makeup.setRating(5);
        assertEquals(5, makeup.getRating(), 0.05);
    }

    @Test
    void testSetIngredients() {
        ArrayList<String> testIngredient = new ArrayList<>();
        makeup.setIngredients(testIngredient);
        assertEquals(testIngredient, makeup.getIngredients());

        testIngredient.add("water");
        makeup.setIngredients(testIngredient);
        assertEquals(testIngredient, makeup.getIngredients());
    }

    @Test
    void testSetStockQuantity() {
        makeup.setStockQuantity(0);
        assertEquals(0, makeup.getStockQuantity());

        makeup.setStockQuantity(77);
        assertEquals(77, makeup.getStockQuantity());
    }

    @Test
    void testSetTotalPurchasedTime() {
        makeup.setTotalPurchasedTime(5);
        assertEquals(5, makeup.getTotalPurchased());
    }

    @Test
    void testSetProductID() {
        makeup.setProductID(1924);
        assertEquals(1924, makeup.getProductID());
    }

}
