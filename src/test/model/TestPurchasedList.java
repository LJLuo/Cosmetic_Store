package model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

// Test for PurchasedList Class
public class TestPurchasedList {
    private PurchasedList purchased;

    @BeforeEach
    void runBefore() {
        purchased = new PurchasedList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, purchased.getSize());
    }

    @Test
    void testAddProduct() {
        Product testProduct1 = new MakeUp("n", "b");
        purchased.addProduct(testProduct1);
        assertEquals(1, purchased.getSize());

        Product testProduct2 = new SkinCare("n", "b");
        purchased.addProduct(testProduct2);
        assertEquals(2, purchased.getSize());

    }

    @Test
    void testRateProductToZero() {
        Product testProduct = new MakeUp("n", "b");
        purchased.addProduct(testProduct);
        testProduct.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct, 0);
        assertEquals(0, testProduct.getRating(), 0.05f);

    }

    @Test
    void testRateProductToOne() {
        Product testProduct1 = new SkinCare("n", "b");
        purchased.addProduct(testProduct1);
        testProduct1.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct1, 1);
        assertEquals(1, testProduct1.getRating(), 0.05f);
    }

    @Test
    void testRateProductToTwo() {
        Product testProduct = new MakeUp("n", "b");
        purchased.addProduct(testProduct);
        testProduct.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct, 2);
        assertEquals(2, testProduct.getRating(), 0.05f);
    }

    @Test
    void testRateProductToThree() {
        Product testProduct = new MakeUp("n", "b");
        purchased.addProduct(testProduct);
        testProduct.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct, 3);
        assertEquals(3, testProduct.getRating(), 0.05f);
    }

    @Test
    void testRateProductToFour() {
        Product testProduct = new SkinCare("n", "b");
        purchased.addProduct(testProduct);
        testProduct.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct, 4);
        assertEquals(4, testProduct.getRating(), 0.05f);
    }

    @Test
    void testRateProductToFive() {
        Product testProduct = new SkinCare("n", "b");
        purchased.addProduct(testProduct);
        testProduct.setTotalPurchasedTime(1);
        purchased.rateProduct(testProduct, 5);
        assertEquals(5, testProduct.getRating(), 0.05f);
    }

    @Test
    void testGetPurchased() {
        Product testProduct1 = new MakeUp("n", "b");
        testProduct1.setTotalPurchasedTime(2);
        purchased.addProduct(testProduct1);
        Product testProduct2 = new SkinCare("n", "b");
        testProduct2.setTotalPurchasedTime(93);
        purchased.addProduct(testProduct2);

        ArrayList<Product> testReturn = purchased.getPurchased();

        assertEquals(testProduct1, testReturn.get(0));
        assertEquals(testProduct2, testReturn.get(1));

    }
}
