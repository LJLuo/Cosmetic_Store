package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

// Test for WishList class
public class TestWishList {
    private WishList wishlist;

    @BeforeEach
    void runBefore() {
        wishlist = new WishList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, wishlist.getSize());
    }

    @Test
    void testAddProduct() {
        ArrayList<String> tfEyeShadowI = new ArrayList<>();
        tfEyeShadowI.add("Mica");
        tfEyeShadowI.add("Synthetic Fluorphlogopite");
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        wishlist.addProduct(tfEyeShadow);
        assertEquals(1, wishlist.getSize());

        ArrayList<String> skiiFaceWashI = new ArrayList<>();
        skiiFaceWashI.add("Water");
        skiiFaceWashI.add("Galactomyces Ferment Filtrate");
        Product skiiFaceWash = new SkinCare("SKII Face Wash", "SKII");
        wishlist.addProduct(skiiFaceWash);
        assertEquals(2, wishlist.getSize());
    }

    @Test
    void testRemoveProduct() {
        Product tfEyeShadow = new MakeUp("Tom Ford Eye Shadow", "Tom Ford");
        Product skiiFaceWash = new SkinCare("SKII Face Wash", "SKII");

        wishlist.addProduct(tfEyeShadow);
        wishlist.addProduct(skiiFaceWash);

        wishlist.removeProduct(tfEyeShadow);
        assertEquals(1, wishlist.getSize());
        wishlist.removeProduct(skiiFaceWash);
        assertEquals(0, wishlist.getSize());

    }
}
