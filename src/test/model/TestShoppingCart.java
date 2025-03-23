package model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;

// Test for ShoppingCart class
public class TestShoppingCart {
    private ShoppingCart shoppingcart;

    @BeforeEach
    void runBefore() {
        shoppingcart = new ShoppingCart();
    }

    @Test
    void testConstructor() {
        assertEquals(0, shoppingcart.getTotalItem());
        assertEquals(0, shoppingcart.getTotalPrice(), 0.05f);
    }

    @Test
    void testAddProduct() {
        ArrayList<String> tfEyeShadowI = new ArrayList<>();
        tfEyeShadowI.add("Mica");
        tfEyeShadowI.add("Synthetic Fluorphlogopite");
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        tfEyeShadow.setPrice(87.5);
        tfEyeShadow.setIngredients(tfEyeShadowI);
        tfEyeShadow.setStockQuantity(45);

        shoppingcart.addProduct(tfEyeShadow);
        assertEquals(1, shoppingcart.getTotalItem());
        assertEquals(87.5, shoppingcart.getTotalPrice(), 0.05f);
    }

    @Test
    void testRemoveProduct() {
        ArrayList<String> tfEyeShadowI = new ArrayList<>();
        tfEyeShadowI.add("Mica");
        tfEyeShadowI.add("Synthetic Fluorphlogopite");
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        tfEyeShadow.setPrice(87.5);
        tfEyeShadow.setIngredients(tfEyeShadowI);
        tfEyeShadow.setStockQuantity(45);

        ArrayList<String> skiiFaceWashI = new ArrayList<>();
        skiiFaceWashI.add("Water");
        skiiFaceWashI.add("Galactomyces Ferment Filtrate");
        Product skiiFaceWash = new SkinCare("SKII Face Wash", "SKII");
        skiiFaceWash.setPrice(124.89);
        skiiFaceWash.setIngredients(skiiFaceWashI);
        skiiFaceWash.setStockQuantity(2);

        shoppingcart.addProduct(tfEyeShadow);

        shoppingcart.removeProduct(tfEyeShadow);

        assertEquals(0, shoppingcart.getTotalItem());
        assertEquals(0, shoppingcart.getTotalPrice(), 0.05f);
    }

    @Test
    void testBuyProduct() {
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        tfEyeShadow.setPrice(87.5);
        tfEyeShadow.setStockQuantity(45);
        Product skiiFaceWash = new SkinCare("SKII Face Wash", "SKII");
        skiiFaceWash.setPrice(124.89);
        skiiFaceWash.setStockQuantity(2);
        shoppingcart.addProduct(tfEyeShadow);
        shoppingcart.addProduct(skiiFaceWash);

        shoppingcart.buyProduct(skiiFaceWash);

        assertEquals(1, shoppingcart.getTotalItem());
        assertEquals(87.5, shoppingcart.getTotalPrice(), 0.05f);
        assertEquals(1, skiiFaceWash.getTotalPurchased());
        assertEquals(1, skiiFaceWash.getStockQuantity());
    }

    @Test
    void testGetProducts() {
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        tfEyeShadow.setPrice(87.5);
        tfEyeShadow.setStockQuantity(45);

        Product skiiFaceWash = new SkinCare("SKII Face Wash", "SKII");
        skiiFaceWash.setPrice(124.89);
        skiiFaceWash.setStockQuantity(2);
        shoppingcart.addProduct(tfEyeShadow);
        shoppingcart.addProduct(skiiFaceWash);

        ArrayList<Product> testList = shoppingcart.getShoppingCart();
        assertEquals(tfEyeShadow, testList.get(0));
        assertEquals(skiiFaceWash, testList.get(1));
    }

    @Test
    void testContains() {
        MakeUp m1 = new MakeUp("n", "b");
        shoppingcart.addProduct(m1);

        MakeUp m2 = new MakeUp("n1", "b");
        MakeUp m3 = new MakeUp("n", "b1");
        MakeUp m4 = new MakeUp("n1", "b1");

        SkinCare s1 = new SkinCare("n", "b");
        SkinCare s2 = new SkinCare("n1", "b");
        SkinCare s3 = new SkinCare("n", "b1");
        SkinCare s4 = new SkinCare("n1", "b1");

        assertTrue(shoppingcart.contains(m1));
        assertFalse(shoppingcart.contains(m2));
        assertFalse(shoppingcart.contains(m3));
        assertFalse(shoppingcart.contains(m4));
        assertFalse(shoppingcart.contains(s1));
        assertFalse(shoppingcart.contains(s2));
        assertFalse(shoppingcart.contains(s3));
        assertFalse(shoppingcart.contains(s4));

    }

}
