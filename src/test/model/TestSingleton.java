package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertFalse(catologue1.addProduct(tfEyeShadow));

        Product diorCleanser = new SkinCare("Dior Cleanser", "Dior");
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
