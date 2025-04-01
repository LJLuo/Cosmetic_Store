package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

// Test for Singleton Class
public class TestSingleton {
    private Singleton catologue1;
    private Singleton catologue2;

    @BeforeEach
    void runBefore() {
        catologue1 = Singleton.getInstance();
        catologue2 = Singleton.getInstance();
    }

    @Test
    void testConstructor() {
        assertTrue(catologue1 == catologue2);
    }

    @Test
    void testContains() {
        Product makeup = new MakeUp("Eye Color Quad Eye Shadow", "Tom Ford");
        assertTrue(catologue1.contains(makeup));

        Product skincare = new SkinCare("Facial Treatment Cleanser", "SKII");
        assertTrue(catologue1.contains(skincare));
    }

    @Test
    void testAddProduct() {
        Product tfEyeShadow = new MakeUp("Eye Color Quad Eye Shadow", "Tom Ford");
        ArrayList<String> tfEyeShadowI = new ArrayList<>();
        tfEyeShadowI.add("Mica");
        tfEyeShadowI.add("Synthetic Fluorphlogopite");
        tfEyeShadow.setTotalPurchasedTime(38);
        tfEyeShadow.setIngredients(tfEyeShadowI);
        tfEyeShadow.setPrice(128.94);
        tfEyeShadow.setStockQuantity(93);
        tfEyeShadow.setProductID(98675623);
        tfEyeShadow.setRating(4.5);
        assertFalse(catologue1.addProduct(tfEyeShadow));

        Product diorCleanser = new SkinCare("Dior Cleanser", "Dior");
        ArrayList<String> diorCleanserI = new ArrayList<>();
        diorCleanserI.add("Water");
        diorCleanserI.add("Sodium Lauroyl Glutamate");
        diorCleanserI.add("Propylene Glycol");
        diorCleanserI.add("PEG-150 Stearate");
        diorCleanserI.add("Galactomyces Ferment Filtrate");
        diorCleanser.setTotalPurchasedTime(12);
        diorCleanser.setIngredients(diorCleanserI);
        diorCleanser.setPrice(98.99);
        diorCleanser.setStockQuantity(2);
        diorCleanser.setProductID(98264735);
        diorCleanser.setRating(3.9);

        assertTrue(catologue1.addProduct(diorCleanser));
    }

    @Test
    void testUpdateMakeUp() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue1.addProduct(p1);
        catologue1.addProduct(p2);

        Product p3 = new MakeUp("p1", "b1");

        assertEquals(p1, catologue1.updateMakeUp(p3));

        Product p4 = new SkinCare("p1", "b2");
        assertEquals(p2, catologue1.updateMakeUp(p4));
    }

    @Test
    void testUpdateSkinCare() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue1.addProduct(p1);
        catologue1.addProduct(p2);

        Product p3 = new MakeUp("p2", "b2");
        assertEquals(null, catologue1.updateSkincare(p3));
        Product p4 = new MakeUp("p1", "b2");
        assertEquals(null, catologue1.updateSkincare(p4));
        Product p5 = new MakeUp("p2", "b1");
        assertEquals(null, catologue1.updateSkincare(p5));
        Product p6 = new SkinCare("p1", "b1");
        assertEquals(null, catologue1.updateSkincare(p6));
    }

}
