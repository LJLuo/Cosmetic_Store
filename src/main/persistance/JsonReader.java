package persistance;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Product;
import model.PurchasedList;
import model.ShoppingCart;
import model.MakeUp;
import model.SkinCare;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;

// Referenced from CPSC 210 content
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads shopping cart or purchased
// list from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads shopping cart from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ShoppingCart readSC() throws IOException {
        String jsonData = readFile(source);
        JSONObject jso = new JSONObject(jsonData);
        return parseShoppingCart(jso);
    }

    // EFFECTS: read source file as string and return it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source),
                StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses shoppingcart from JSON object and returns it
    private ShoppingCart parseShoppingCart(JSONObject jso) {
        ShoppingCart sc = new ShoppingCart();
        addProductsSC(sc, jso);
        return sc;
    }

    // MODIFIES: sc
    // EFFECTS: parses products from JSON object and adds them to
    // shopping cart
    private void addProductsSC(ShoppingCart sc, JSONObject jso) {
        JSONArray jsa = jso.getJSONArray("shopping cart");
        for (Object json : jsa) {
            JSONObject nextProduct = (JSONObject) json;
            addProductSC(sc, nextProduct);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses product from JSON object and adds it to shopping
    // cart
    private void addProductSC(ShoppingCart sc, JSONObject jso) {
        String name = jso.getString("name");
        String type = jso.getString("type");
        Double price = jso.getDouble("price");
        String brand = jso.getString("brand");
        Double rating = jso.getDouble("rating");
        ArrayList<String> ingredients = changeToString(jso);
        int stockQuantity = jso.getInt("stockQuantity");
        int totalPurchasedTime = jso.getInt("totalPurchasedTime");
        int productID = jso.getInt("productID");

        if (type.equals("makeup")) {
            getMakeUpSC(sc, name, price, brand, rating, ingredients, stockQuantity, totalPurchasedTime, productID);
        } else {
            getSkinCareSC(sc, name, price, brand, rating, ingredients, stockQuantity, totalPurchasedTime, productID);
        }
    }

    // EFFECTS: create skincare with input name, price, brand, rating, ingredients,
    // stockQuantity, totalPruchased time
    // and productID
    // Add newly created skincare to shopping cart
    private void getSkinCareSC(ShoppingCart sc, String name, Double price, String brand, Double rating,
            ArrayList<String> ingredients, int stockQuantity, int totalPurchasedTime, int productID) {
        Product p = new SkinCare(name, brand);
        p.setBrand(brand);
        p.setPrice(price);
        p.setRating(rating);
        p.setIngredients(ingredients);
        p.setStockQuantity(stockQuantity);
        p.setTotalPurchasedTime(totalPurchasedTime);
        p.setProductID(productID);
        sc.addProduct(p);
    }

    // EFFECTS: create makeup with input name, price, brand, rating, ingredients,
    // stockQuantity, totalPruchased time
    // and productID
    // Add newly created makeup to shopping cart
    private void getMakeUpSC(ShoppingCart sc, String name, Double price, String brand, Double rating,
            ArrayList<String> ingredients, int stockQuantity, int totalPurchasedTime, int productID) {
        Product p = new MakeUp(name, brand);
        p.setBrand(brand);
        p.setPrice(price);
        p.setRating(rating);
        p.setIngredients(ingredients);
        p.setStockQuantity(stockQuantity);
        p.setTotalPurchasedTime(totalPurchasedTime);
        p.setProductID(productID);
        sc.addProduct(p);
    }

    // EFFECTS: change a JSONArray to an ArrayList of String
    private ArrayList<String> changeToString(JSONObject jso) {
        JSONArray jsa = jso.getJSONArray("ingredients");
        ArrayList<String> ingredients = new ArrayList<>();
        for (int i = 0; i < jsa.length(); i++) {
            ingredients.add(jsa.getString(i));
        }

        return ingredients;
    }

    // EFFECTS: reads purchased list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public PurchasedList readPL() throws IOException {
        String jsonData = readFile(source);
        JSONObject jso = new JSONObject(jsonData);
        return parsePurchasedList(jso);
    }

    // EFFECTS: parses shoppingcart from JSON object and returns it
    private PurchasedList parsePurchasedList(JSONObject jso) {
        PurchasedList pl = new PurchasedList();
        addProductsPL(pl, jso);
        return pl;
    }

    // MODIFIES: sc
    // EFFECTS: parses products from JSON object and adds them to
    // shopping cart
    private void addProductsPL(PurchasedList pl, JSONObject jso) {
        JSONArray jsa = jso.getJSONArray("purchased");
        for (Object json : jsa) {
            JSONObject nextProduct = (JSONObject) json;
            addProductPL(pl, nextProduct);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses product from JSON object and adds it to shopping
    // cart
    private void addProductPL(PurchasedList pl, JSONObject jso) {
        String name = jso.getString("name");
        String type = jso.getString("type");
        Double price = jso.getDouble("price");
        String brand = jso.getString("brand");
        Double rating = jso.getDouble("rating");
        ArrayList<String> ingredients = changeToString(jso);
        int stockQuantity = jso.getInt("stockQuantity");
        int totalPurchasedTime = jso.getInt("totalPurchasedTime");
        int productID = jso.getInt("productID");

        if (type.equals("makeup")) {
            getMakeUpPL(pl, name, price, brand, rating, ingredients, stockQuantity, totalPurchasedTime, productID);
        } else {
            getSkinCarePL(pl, name, price, brand, rating, ingredients, stockQuantity, totalPurchasedTime, productID);
        }
    }

    // EFFECTS: create skincare with input name, price, brand, rating, ingredients,
    // stockQuantity, totalPruchased time
    // and productID
    // Add newly created skincare to purchased list
    private void getSkinCarePL(PurchasedList pl, String name, Double price, String brand, Double rating,
            ArrayList<String> ingredients, int stockQuantity, int totalPurchasedTime, int productID) {
        Product p = new SkinCare(name, brand);
        p.setBrand(brand);
        p.setPrice(price);
        p.setRating(rating);
        p.setIngredients(ingredients);
        p.setStockQuantity(stockQuantity);
        p.setTotalPurchasedTime(totalPurchasedTime);
        p.setProductID(productID);
        pl.addProduct(p);
    }

    // EFFECTS: create makeup with input name, price, brand, rating, ingredients,
    // stockQuantity, totalPruchased time
    // and productID
    // Add newly created makeup to purchased list
    private void getMakeUpPL(PurchasedList pl, String name, Double price, String brand, Double rating,
            ArrayList<String> ingredients, int stockQuantity, int totalPurchasedTime, int productID) {
        Product p = new MakeUp(name, brand);
        p.setBrand(brand);
        p.setPrice(price);
        p.setRating(rating);
        p.setIngredients(ingredients);
        p.setStockQuantity(stockQuantity);
        p.setTotalPurchasedTime(totalPurchasedTime);
        p.setProductID(productID);
        pl.addProduct(p);
    }

}