package model;

import org.json.JSONArray;
import org.json.JSONObject;

import persistance.Writable;

import java.util.ArrayList;

//List of products in shopping cart which user can buy products through
public class ShoppingCart implements Writable {
    private ArrayList<Product> shoppingCart;

    // EFFECTS: create empty ShoppingCart object for user to add products into.
    public ShoppingCart() {
        this.shoppingCart = new ArrayList<>();
    }

    // REQUIRES: product is in store's catologue and is not out of stock
    // MODIFIES: this
    // EFFECTS: add product to shoppingCart and log event to eventlog
    public void addProduct(Product product) {
        shoppingCart.add(product);
        EventLog.getInstance()
                .logEvent(new Event("Added " + product.getBrand() + " " + product.getName() + " to shopping cart."));
    }

    // REQUIRES: product is in shoppingCart
    // MODIFIES: this
    // EFFECTS: remove product from shoppingCart and log event to eventlog
    public void removeProduct(Product product) {
        shoppingCart.remove(product);
        EventLog.getInstance().logEvent(
                new Event("Removed " + product.getBrand() + " " + product.getName() + " product from shopping cart."));
    }

    // REQUIRES: product is in shoppingCart
    // MODIFIES: this and product
    // EFFECTS: increase product's totalPurchasedTime by 1, decrease product's
    // stockQuantity by 1
    // and remove item from shoppingCart.
    public void buyProduct(Product product) {
        int stockQuantity = product.getStockQuantity();
        int ttp = product.getTotalPurchased();
        ttp = ttp + 1;
        stockQuantity = stockQuantity - 1;
        product.setTotalPurchasedTime(ttp);
        product.setStockQuantity(stockQuantity);
        shoppingCart.remove(product);
    }

    // EFFECTS: return true if product is in shopping cart; return false if product
    // is not in shopping cart
    public boolean contains(Product product) {
        for (Product cartProduct : shoppingCart) {
            if ((product.getName().equalsIgnoreCase(cartProduct.getName()))
                    && (product.getBrand().equalsIgnoreCase(cartProduct.getBrand()))
                    && (product.getType().equalsIgnoreCase(cartProduct.getType()))) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: return totalPrice of all products in shoppingCart
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : shoppingCart) {
            double productPrice = product.getPrice();
            totalPrice = totalPrice + productPrice;
        }
        return totalPrice;
    }

    // EFFECTS: return list of products in shoppingCart
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    // EFFECTS: return number of items in shoppingCart
    public int getTotalItem() {
        return shoppingCart.size();
    }

    // EFFECTS: return this shopping cart as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        JSONArray jssc = new JSONArray();

        for (Product product: shoppingCart) {
            jssc.put(product.toJson());
        }

        json.put("shopping cart", jssc);
        return json;
    }

    /* // EFFECTS: returns things in shopping cart as a JSON array
    private JSONArray productToJson() {
        JSONArray jsa = new JSONArray();

        for (Product p : shoppingCart) {
            jsa.put(p.toJson());
        }

        return jsa;
    } */

}