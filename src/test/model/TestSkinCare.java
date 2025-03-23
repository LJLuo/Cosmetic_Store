package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Test for SkinCare class
public class TestSkinCare {
    private SkinCare skincare;

    @BeforeEach
    void runBefore() {
        skincare = new SkinCare("n1", "b1");
    }

    @Test
    void testConstructor() {
        assertEquals(0, skincare.getPrice(), 0.05f);
        assertEquals("n1", skincare.getName());
        assertEquals("b1", skincare.getBrand());
        assertTrue(skincare.getIngredients().isEmpty());
        assertEquals(0, skincare.getStockQuantity());
        assertEquals(0, skincare.getRating(), 0.05f);
        assertEquals(0, skincare.getTotalPurchased());
        assertEquals(0, skincare.getProductID());
        assertEquals("skincare", skincare.getType());
    }

    @Test
    void testSetPrice() {
        skincare.setPrice(14.2);
        assertEquals(14.2, skincare.getPrice(), 0.05f);

        skincare.setPrice(0.00);
        assertEquals(0, skincare.getPrice(), 0.05f);
    }

    @Test
    void testSetName() {
        skincare.setName("name1");
        assertEquals("name1", skincare.getName());

        skincare.setName("I am name");
        assertEquals("I am name", skincare.getName());
    }

    @Test
    void testSetBrand() {
        skincare.setBrand("Tom Ford");
        assertEquals("Tom Ford", skincare.getBrand());
    }

    @Test
    void testSetRating() {
        skincare.setRating(0.0);
        assertEquals(0, skincare.getRating(), 0.05f);

        skincare.setRating(0.21);
        assertEquals(0.21, skincare.getRating(), 0.05);

        skincare.setRating(4.98);
        assertEquals(4.98, skincare.getRating(), 0.05);

        skincare.setRating(5);
        assertEquals(5, skincare.getRating(), 0.05);
    }

    @Test
    void testSetIngredients() {
        ArrayList<String> testIngredient = new ArrayList<>();
        skincare.setIngredients(testIngredient);
        assertEquals(testIngredient, skincare.getIngredients());

        testIngredient.add("water");
        skincare.setIngredients(testIngredient);
        assertEquals(testIngredient, skincare.getIngredients());
    }

    @Test
    void testSetStockQuantity() {
        skincare.setStockQuantity(0);
        assertEquals(0, skincare.getStockQuantity());

        skincare.setStockQuantity(77);
        assertEquals(77, skincare.getStockQuantity());
    }

    @Test
    void testSetTotalPurchasedTime() {
        skincare.setTotalPurchasedTime(5);
        assertEquals(5, skincare.getTotalPurchased());
    }

    @Test
    void testSetProductID() {
        skincare.setProductID(1924);
        assertEquals(1924, skincare.getProductID());
    }

}
