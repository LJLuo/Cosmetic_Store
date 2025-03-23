package model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import persistance.Writable;

//List of products that has been purchased
public class PurchasedList implements Writable {
    private ArrayList<Product> purchased;

    // EFFECTS: create a PurchasedList object that is initially empty
    public PurchasedList() {
        this.purchased = new ArrayList<>();
    }

    // REQUIRES: product is in store's catologue and stockQuantity>0
    // MODIFIES: this
    // EFFECTS: add p to PurchasedList
    public void addProduct(Product p) {
        purchased.add(p);

    }

    // REQUIRES: product is in PurchasedList & rating parameter is one of 1, 2, 3,
    // 4, 5
    // MODIFIES: product
    // EFFECTS: recalculate makeUp's rating by multiplying product's
    // current rating by product's (totalNumPurchase - 1), then
    // adding rating, and dividing by totalNumPurchase.
    // setting product's rating to newRating.
    public void rateProduct(Product product, double rating) {
        double currentRating = product.getRating();
        int purchasedTime = product.getTotalPurchased();
        int withoutNewPT = purchasedTime - 1;

        double newRating = (((currentRating * withoutNewPT) + rating) / purchasedTime);
        product.setRating(newRating);

    }

    // EFFECTS: return products in purchased list
    public ArrayList<Product> getPurchased() {
        return purchased;
    }

    // EFFECTS: return purchased list size
    public int getSize() {
        return purchased.size();
    }

    // EFFECTS: return this purchased list as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("purchased", productToJson());
        return json;
    }

    // EFFECTS returns things in this purchased list as a JSON array
    private JSONArray productToJson() {
        JSONArray jsa = new JSONArray();

        for (Product p : purchased) {
            jsa.put(p.toJson());
        }

        return jsa;
    }

}
