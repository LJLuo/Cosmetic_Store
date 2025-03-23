package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Tests for Catologue class
public class TestCatologue {
    private Catologue catologue;

    @BeforeEach
    void runBefore() {
        catologue = new Catologue();
    }

    @Test
    void testConstructor() {
        assertEquals(0, catologue.getSize());
    }

    @Test
    void testAddProductsPartOne() {
        Product p1 = new MakeUp("p1", "b1");
        assertTrue(catologue.addProduct(p1));
        assertEquals(1, catologue.getSize());

        Product p2 = new MakeUp("p1", "b1");
        assertEquals(1, catologue.getSize());
        assertFalse(catologue.addProduct(p2));

        Product p3 = new MakeUp("p1", "b2");
        assertTrue(catologue.addProduct(p3));
        assertEquals(2, catologue.getSize());
    }

    @Test
    void testAddProductsPartTwo() {
        Product p1 = new MakeUp("p1", "b1");
        assertTrue(catologue.addProduct(p1));
        assertEquals(1, catologue.getSize());

        Product p4 = new SkinCare("p1", "b1");
        assertTrue(catologue.addProduct(p4));
        assertEquals(2, catologue.getSize());

        Product p5 = new MakeUp("p2", "b1");
        assertTrue(catologue.addProduct(p5));
        assertEquals(3, catologue.getSize());

        Product p6 = new MakeUp("p2", "b2");
        assertTrue(catologue.addProduct(p6));
        assertEquals(4, catologue.getSize());

        Product p7 = new SkinCare("p2", "b1");
        assertTrue(catologue.addProduct(p7));
        assertEquals(5, catologue.getSize());

        Product p8 = new SkinCare("p1", "b2");
        assertTrue(catologue.addProduct(p8));
        assertEquals(6, catologue.getSize());

        Product p9 = new SkinCare("p2", "b2");
        assertTrue(catologue.addProduct(p9));
        assertEquals(7, catologue.getSize());
    }

    @Test
    void testGetSize() {
        Product p1 = new MakeUp("p1", "b1");
        catologue.addProduct(p1);

        assertEquals(1, catologue.getSize());

        Product p2 = new SkinCare("p2", "b2");
        catologue.addProduct(p2);

        assertEquals(2, catologue.getSize());

    }

    @Test
    void testContains() {
        Product p1 = new MakeUp("p1", "b1");
        catologue.addProduct(p1);

        Product p2 = new SkinCare("p1", "b2");
        Product p3 = new SkinCare("p1", "b1");
        Product p4 = new SkinCare("p2", "b1");
        Product p5 = new SkinCare("p2", "b2");
        Product p6 = new MakeUp("p2", "b1");
        Product p7 = new MakeUp("p1", "b2");
        Product p8 = new MakeUp("p2", "b2");

        assertTrue(catologue.contains(p1));
        assertFalse(catologue.contains(p2));
        assertFalse(catologue.contains(p3));
        assertFalse(catologue.contains(p4));
        assertFalse(catologue.contains(p5));
        assertFalse(catologue.contains(p6));
        assertFalse(catologue.contains(p7));
        assertFalse(catologue.contains(p8));
    }

    @Test
    void testUpdateMakeUpTrue() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue.addProduct(p1);
        catologue.addProduct(p2);

        Product p3 = new MakeUp("p1", "b1");

        assertEquals(p1, catologue.updateMakeup(p3));

        Product p4 = new SkinCare("p1", "b2");
        assertEquals(p2, catologue.updateMakeup(p4));

    }

    @Test
    void testUpdateMakeUpFalse() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue.addProduct(p1);
        catologue.addProduct(p2);

        Product p3 = new MakeUp("p2", "b2");
        assertEquals(null, catologue.updateMakeup(p3));
        Product p4 = new MakeUp("p1", "b2");
        assertEquals(null, catologue.updateMakeup(p4));
        Product p5 = new MakeUp("p2", "b1");
        assertEquals(null, catologue.updateMakeup(p5));
        Product p6 = new SkinCare("p1", "b1");
        assertEquals(null, catologue.updateMakeup(p6));
    }

    @Test
    void testUpdateSkinCareTrue() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue.addProduct(p1);
        catologue.addProduct(p2);

        Product p3 = new MakeUp("p1", "b1");

        assertEquals(p1, catologue.updateSkincare(p3));

        Product p4 = new SkinCare("p1", "b2");
        assertEquals(p2, catologue.updateSkincare(p4));
    }

    @Test
    void testUpdateSkincareFalse() {
        Product p1 = new MakeUp("p1", "b1");
        Product p2 = new SkinCare("p1", "b2");
        catologue.addProduct(p1);
        catologue.addProduct(p2);

        Product p3 = new MakeUp("p2", "b2");
        assertEquals(null, catologue.updateSkincare(p3));
        Product p4 = new MakeUp("p1", "b2");
        assertEquals(null, catologue.updateSkincare(p4));
        Product p5 = new MakeUp("p2", "b1");
        assertEquals(null, catologue.updateSkincare(p5));
        Product p6 = new SkinCare("p1", "b1");
        assertEquals(null, catologue.updateSkincare(p6));
    }
}
