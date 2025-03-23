package model;

import java.util.ArrayList;

import org.json.JSONObject;

//A type of product, skincare, that is sold in store
public class SkinCare implements Product {
    private static String type = "skincare";
    private double price;
    private String name;
    private String brand;
    private double rating;
    private ArrayList<String> ingredients;
    private int stockQuantity;
    private int totalPurchasedTime;
    private int productID;

    // EFFECTS: create new SkinCare Object, which implements the Product interface,
    // with name and brand
    // price, stock quantity, product ID, totalPurchasedTime and rating should be
    // initially set to zero
    // list of ingredients should initially be set to empty
    // product ID should be unique to every product
    public SkinCare(String productName, String brand) {
        this.price = 0;
        this.stockQuantity = 0;
        this.totalPurchasedTime = 0;
        this.rating = 0;
        this.name = productName;
        this.brand = brand;
        this.ingredients = new ArrayList<>();
        this.productID = 0;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    @Override
    public int getStockQuantity() {
        return stockQuantity;
    }

    @Override
    public int getTotalPurchased() {
        return totalPurchasedTime;
    }

    @Override
    public int getProductID() {
        return productID;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public void setTotalPurchasedTime(int newTPT) {
        this.totalPurchasedTime = newTPT;
    }

    @Override
    public void setProductID(int productID) {
        this.productID = productID;
    }

    // EFFECTS: return this skincare as JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("price", price);
        json.put("name", name);
        json.put("brand", brand);
        json.put("rating", rating);
        json.put("ingredients", ingredients);
        json.put("stockQuantity", stockQuantity);
        json.put("totalPurchasedTime", totalPurchasedTime);
        json.put("productID", productID);
        return json;
    }

}
