package model;

import java.util.ArrayList;

import org.json.JSONObject;

import persistance.Writable;

//Interface for all products sold in store, with sub-classes MakeUp and SkinCare
public interface Product extends Writable {

    @Override
    boolean equals(Object o);
    

    @Override
    int hashCode();


    // EFFECTS: return price of product.
    double getPrice();

    // EFFECTS: return name of product.
    String getName();

    // EFFECTS: return brand of product.
    String getBrand();

    // EFFECTS: return rating of product.
    double getRating();

    // EFFECTS: return ingredient list of product.
    ArrayList<String> getIngredients();

    // EFFECTS: return product's stock quantity
    int getStockQuantity();

    // EFFECTS: return product's total purchased times
    int getTotalPurchased();

    // EFFECTS: return product's product ID
    int getProductID();

    // EFFECTS: return product's type
    String getType();

    // REQUIRES: price >= 0
    // MODIFIES: this
    // EFFECTS: set price of product to parameter price's value
    void setPrice(double price);

    // MODIES: this
    // EFFECTS: set name of product to paramter name's value
    void setName(String name);

    // MODIFIES: this
    // EFFECTS: set brand of product to parameter brand's value
    void setBrand(String brand);

    // REQUIRES: rating >= 0 & rating <= 5
    // MODIFIES: this
    // EFFECTS: set rating of product to parameter rating's value
    void setRating(double rating);

    // MODIFIES: this
    // EFFECTS: set ingredients of product to parameter ingredients's value
    void setIngredients(ArrayList<String> ingredients);

    // REQUIRES: stockQuantity >= 0
    // MODIFIES: this
    // EFFECTS: set product's stockQuantity to parameter stockQuantity's value
    void setStockQuantity(int stockQuantity);

    // REQUIRES: newTPT >= 0
    // MODIFIES: this
    // EFFECTS: set product's totalPurchasedTime to newTPT's value
    void setTotalPurchasedTime(int newTPT);

    // REQUIRES: productID >= 0 and has not been used for other products
    // MODIFIES: this
    // EFFECTS: set product's productID to parameter productID's value
    void setProductID(int productID);

    // EFFECTS:return product as JSON object
    JSONObject toJson();
}