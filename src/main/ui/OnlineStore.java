package ui;

import model.PurchasedList;
import model.ShoppingCart;
import model.Singleton;
import model.SkinCare;
import model.Product;
import model.MakeUp;
import java.util.Scanner;
import java.util.ArrayList;

import persistance.*;

import java.io.FileNotFoundException;
import java.io.IOException;

//Code referenced the TellerApp code provided in CPSC 210

//Bank OnlineStore application
public class OnlineStore {
    private static final String onlineStoreSC = "./data/OnlineStoreSC.json";
    private static final String onlineStorePL = "./data/OnlineStorePL.json";
    private PurchasedList purchasedList;
    private ShoppingCart shoppingCart;

    private Scanner myScanner;
    Singleton catologue = Singleton.getInstance();
    private boolean keepGoing;

    private JsonWriter jsonWriterSC;
    private JsonReader jsonReaderSC;
    private JsonWriter jsonWriterPL;
    private JsonReader jsonReaderPL;

    // MODIFIES: this
    // EFFECTS: determines whether application is running or stopped
    public void runStore() {
        keepGoing = true;
        int choice = 0;

        purchasedList = new PurchasedList();
        shoppingCart = new ShoppingCart();
        myScanner = new Scanner(System.in);
        jsonReaderSC = new JsonReader(onlineStoreSC);
        jsonWriterSC = new JsonWriter(onlineStoreSC);
        jsonReaderPL = new JsonReader(onlineStorePL);
        jsonWriterPL = new JsonWriter(onlineStorePL);

        while (keepGoing) {
            displayMenu();
            choice = myScanner.nextInt();

            if (choice == 6) {
                keepGoing = false;
            } else {
                processChoice(choice);
            }
        }

        System.out.println("\nGoodbye!");

    }

    // EFFECTS: displays menu of application to user
    private void displayMenu() {
        System.out.println("What would you like to do today?");
        System.out.println("Select from: ");
        System.out.println("1. Shop for product");
        System.out.println("2. View shopping cart");
        System.out.println("3. View purchased list");
        System.out.println("4. Save progress to file");
        System.out.println("5. Load progress from file");
        System.out.println("6. Quit");
    }

    // MODIFIES: this
    // EFFECTS: process user choice
    private void processChoice(int choice) {
        if (choice == 1) {
            whichTypeProduct();
        } else if (choice == 2) {
            displayShoppingCart();
        } else if (choice == 3) {
            displayPurchasedList();
        } else if (choice == 4) {
            saveOnlineStore();
        } else if (choice == 5) {
            loadOnlineStore();
        } else {
            System.out.println("Selection is not valid.");
        }
    }

    // EFFECTS: saves the online store to file
    private void saveOnlineStore() {
        try {
            jsonWriterSC.open();
            jsonWriterPL.open();
            jsonWriterSC.writeSC(shoppingCart);
            jsonWriterPL.writePL(purchasedList);
            jsonWriterSC.close();
            jsonWriterPL.close();
            System.out.println("Saved progress");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file");
        }
    }

    // MODIFIES: this
    // EFFECTS: load shopping cart and purchased list from file
    private void loadOnlineStore() {
        try {
            shoppingCart = jsonReaderSC.readSC();
            purchasedList = jsonReaderPL.readPL();
            System.out.println("Loaded Online store");
        } catch (IOException e) {
            System.out.println("Unable to read from file");
        }
    }

    // MODIFIES: this
    // EFFECTS: determines what type of product user is interested in (makeup or
    // skincare)
    public void whichTypeProduct() {
        System.out.println("Are you interested in makeup or skincare product today?");
        System.out.println("Please answer makeup or skincare:");
        String productType = myScanner.next();

        if (productType.equalsIgnoreCase("makeup")) {
            whichProduct("makeup");
        } else if (productType.equalsIgnoreCase("skincare")) {
            whichProduct("skincare");
        } else {
            System.out.println("There seems to be a mistake.");
        }
    }

    // MODIFIES: this
    // EFFECTS: determine the name and brand of the product user is interested in
    public void whichProduct(String type) {
        System.out.println("Please insert the name of the product you are looking for:");
        myScanner.nextLine();
        String productName = myScanner.nextLine();
        System.out.println("Please insert the brand of the product you are looking for");
        String brand = myScanner.nextLine();

        checkContain(type, productName, brand);
    }

    // MODIFIES: this
    // EFFECTS: determines whether user's interested product is in store catologue
    public void checkContain(String type, String productName, String brand) {
        if (type == "makeup") {
            Product makeup = new MakeUp(productName, brand);
            if (catologue.contains(makeup)) {
                System.out.println("We have this product!");
                checkContainMakeUpHelper(makeup);
            } else {
                System.out.println("Sorry! We do not have that item!");
            }
        } else {
            Product skincare = new SkinCare(productName, brand);
            if (catologue.contains(skincare)) {
                System.out.println("We have this product!");
                checkContainSkinCareHelper(skincare);
            } else {
                System.out.println("Sorry! We do not have that item!");
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: update skincare such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void checkContainSkinCareHelper(Product skincare) {
        if (null == catologue.updateSkincare(skincare)) {
            System.out.println("There seems to be an issue!");
        } else {
            userChoiceGivenInCatologue(catologue.updateMakeUp(skincare));
        }
    }

    // MODIFIES: this
    // EFFECTS: update makeup such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void checkContainMakeUpHelper(Product makeup) {
        if (null == catologue.updateMakeUp(makeup)) {
            System.out.println("There seems to be an issue!");
        } else {
            userChoiceGivenInCatologue(catologue.updateMakeUp(makeup));
        }
    }

    // MODIFIES: this
    // EFFECTS: provide customer service to user
    public void customerService() {
        System.out.println("Please write your question below in one line.");
        System.out.println("When you are finished, hit enter.");
        System.out.println("Our customer service representatives will contact you as soon as we can.");
        myScanner.nextLine();
        String question = myScanner.nextLine();
        System.out.println("Thank you for contacting customer service! We have received your question.");
        System.out.println("Your question: " + question);
    }

    // MODIFIES: this
    // EFFECTS: provide application usage choices for user after checking their
    // interested product is in stores catologue
    public void userChoiceGivenInCatologue(Product product) {
        System.out.println("What would you like to do next?");
        System.out.println("Please choose among the following:");
        System.out.println("1. View product's detail");
        System.out.println("2. Add product to shopping cart");
        System.out.println("3. Find another product");
        System.out.println("4. Talk to customer service");
        System.out.println("5. Return to home page");
        System.out.println("Please type in 1, 2, 3, 4 or 5 based on above choices");
        int choice = myScanner.nextInt();
        if (choice == 1) {
            productDetail(product);
        } else if (choice == 2) {
            addProductToSomeCart(product);
        } else if (choice == 3) {
            whichTypeProduct();
        } else if (choice == 4) {
            customerService();
        }
    }

    // MODIFIES: this
    // EFFECTS: add user interested product to shopping cart if product is in stock.
    // Otherwise, pass product to outOfStock()
    public void addProductToSomeCart(Product product) {
        if (product.getStockQuantity() > 0) {
            shoppingCart.addProduct(product);
            System.out.println("Product has been added to shopping cart!");
            afterAddToCart(product);
        } else {
            outOfStock(product);
        }

    }

    // MODIFIES: this
    // EFFECTS: provide application usage choices for user after added user
    // interested product to shopping cart
    public void afterAddToCart(Product product) {
        System.out.println("What would you like to do next?");
        System.out.println("1. View Shopping Cart");
        System.out.println("2. Buy Product");
        System.out.println("3. Find another product");
        System.out.println("4. Talk to customer service");
        System.out.println("5. Return to home page");
        System.out.println("Please type in 1, 2, 3, 4 or 5 based on above choices");
        int choice = myScanner.nextInt();
        if (choice == 1) {
            displayShoppingCart();
        } else if (choice == 2) {
            buyFromShoppingCart(product);
        } else if (choice == 3) {
            whichTypeProduct();
        } else if (choice == 4) {
            customerService();
        }
    }

    // MODIFIES: this
    // EFFECTS: Based on user's choice, either add product to wishlist or pass
    // product to afterOutOfStock()
    public void outOfStock(Product product) {
        System.out.println("Sorry! product is out of stock.");
        System.out.println("Would you like to add" + product.getName() + "to wish list?");
        System.out.println("Please answer yes or no");
        String choice = myScanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            addProductToWishList(product);
        } else {
            afterOutOfStock(product);
        }

    }

    // MODIFIES: this
    // EFFECTS: provide application usage choices for user after checking their
    // interested product is out of stock but they do not wish to add it to wishlist
    public void afterOutOfStock(Product product) {
        System.out.println("What would you like to do next?");
        System.out.println("1. Sign up for restock notification");
        System.out.println("2. Find another product");
        System.out.println("3. Talk to customer service");
        System.out.println("4. Return to home page");
        System.out.println("Please type in 1, 2, 3, or 4 based on above choices");
        int secondChoice = myScanner.nextInt();
        if (secondChoice == 1) {
            restockNotification(product);
        } else if (secondChoice == 2) {
            whichTypeProduct();
        } else if (secondChoice == 3) {
            customerService();
        }

    }

    // MODIFIES: this
    // EFFECTS: Confirm to user that they have signed up for restock notification
    // for interested product
    public void restockNotification(Product product) {
        System.out.println("You have signed up for restock notification for "
                + product.getName() + ',' + product.getBrand() + ","
                + product.getType());
    }

    // MODIFIES: this
    // EFFECTS: Display product information page where product's type, name, brand,
    // price, rating, ingredients, product ID, in-stock quantity and total purchased
    // time
    // are displayed.
    public void productDetail(Product product) {
        System.out.println("Type: " + product.getType());
        System.out.println("Name: " + product.getName());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Rating: " + product.getRating());
        System.out.println("Ingredients: " + product.getIngredients());
        System.out.println("Product ID: " + product.getProductID());
        System.out.println("In-Stock Quantity: " + product.getStockQuantity());
        System.out.println("Total Purchased: " + product.getTotalPurchased());

        doWhatAfterProductDetail(product);

    }

    // MODIFIES: this
    // EFFECTS: Provide application usage choices for user after displaying
    // interested product's information page
    private void doWhatAfterProductDetail(Product product) {
        System.out.println("What would you like to do next?");
        System.out.println("1. Add product to shopping cart");
        System.out.println("2. Find another product");
        System.out.println("3. Speack to customer service");
        System.out.println("4. Return to home page");
        System.out.println("Please answer 1, 2, 3 or 4 based on above choices");
        int userChoice = myScanner.nextInt();

        if (userChoice == 1) {
            addProductToSomeCart(product);
        } else if (userChoice == 2) {
            whichTypeProduct();
        } else if (userChoice == 3) {
            customerService();
        }
    }

    // MODIFIES: this
    // EFFECTS: Display shopping cart by printing in-cart products' name, brand and
    // type.
    // Also displays shopping cart's total size and price at the bottom.
    public void displayShoppingCart() {
        ArrayList<Product> shoppingCartDisplay = shoppingCart.getShoppingCart();
        for (Product product : shoppingCartDisplay) {
            System.out.println(product.getName() + "," + product.getBrand() + ","
                    + product.getType());
        }
        System.out.println("Total number of items: " + shoppingCart.getTotalItem());
        System.out.println("Total cost of all items: " + shoppingCart.getTotalPrice());

        fromShoppingCart();
    }

    // MODIFIES: this
    // EFFECTS: Provides application usage choices for users after displaying their
    // shopping cart.
    public void fromShoppingCart() {
        System.out.println("What would you like to do next?");
        System.out.println("1. Buy a product in shopping cart");
        System.out.println("2. Remove a product from shopping cart");
        System.out.println("3. View details of a product in shopping cart");
        System.out.println("4. Find another product");
        System.out.println("5. Speack to customer service");
        System.out.println("6. Return to home page");
        System.out.println("Please answer 1, 2, 3, 4, 5 or 6 based on above choices");
        int userChoice = myScanner.nextInt();

        if (userChoice == 1) {
            buyWhichProduct();
        } else if (userChoice == 2) {
            removeFromCart();
        } else if (userChoice == 3) {
            viewWhichProduct();
        } else if (userChoice == 4) {
            whichTypeProduct();
        } else if (userChoice == 5) {
            customerService();
        }

    }

    // MODIFIES: this
    // EFFECTS: Determines of which product in shopping cart user wants to
    // view product information
    public void viewWhichProduct() {
        System.out.println("What is the product's name: ");
        myScanner.nextLine();
        String name = myScanner.nextLine();
        System.out.println("What is the product's brand: ");
        String brand = myScanner.nextLine();
        System.out.println("What is the product's type (makeup or skincare): ");
        String type = myScanner.nextLine();

        determineViewWhichProduct(name, brand, type);
    }

    // MODIFIES: this
    // EFFECTS: determine whether the product user wants to view is in shopping cart
    public void determineViewWhichProduct(String name, String brand, String type) {
        if (type.equalsIgnoreCase("makeup")) {
            MakeUp makeup = new MakeUp(name, brand);
            if (shoppingCart.contains(makeup)) {
                determineViewWhichProductHelperMakeUp(makeup);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        } else if (type.equalsIgnoreCase("skincare")) {
            SkinCare skincare = new SkinCare(name, brand);
            if (shoppingCart.contains(skincare)) {
                determineViewWhichProductHelperSkinCare(skincare);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: update skincare such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void determineViewWhichProductHelperSkinCare(SkinCare skincare) {
        if (null == catologue.updateMakeUp(skincare)) {
            System.out.println("There seems to be an issue!");
        } else {
            productDetail(catologue.updateMakeUp(skincare));
            System.out.println("Product removed from shopping cart");
        }
    }

    // MODIFIES: this
    // EFFECTS: update makeup such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void determineViewWhichProductHelperMakeUp(MakeUp makeup) {
        if (null == catologue.updateMakeUp(makeup)) {
            System.out.println("There seems to be an issue!");
        } else {
            productDetail(catologue.updateMakeUp(makeup));
            System.out.println("Product removed from shopping cart");
        }
    }

    // MODIFIES: this
    // EFFECTS: determines which product in shopping cart user wants to buy
    public void buyWhichProduct() {
        System.out.println("What is the product's name: ");
        myScanner.nextLine();
        String name = myScanner.nextLine();
        System.out.println("What is the product's brand: ");
        String brand = myScanner.nextLine();
        System.out.println("What is the product's type (makeup or skincare): ");
        String type = myScanner.nextLine();

        determineBuyWhichProduct(name, brand, type);

    }

    // MODIFIES: this
    // EFFECTS: determines whether the product in shopping cart user wants to see
    // is in shopping cart
    public void determineBuyWhichProduct(String name, String brand, String type) {
        if (type.equalsIgnoreCase("makeup")) {
            MakeUp makeup = new MakeUp(name, brand);
            if (shoppingCart.contains(makeup)) {
                determineBuyWhichProductMakeUpHelper(makeup);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        } else if (type.equalsIgnoreCase("skincare")) {
            SkinCare skincare = new SkinCare(name, brand);
            if (shoppingCart.contains(skincare)) {
                determineBuyWhichProductSkinCareHelper(skincare);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: update skincare such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void determineBuyWhichProductSkinCareHelper(SkinCare skincare) {
        if (null == catologue.updateMakeUp(skincare)) {
            System.out.println("There seems to be an issue!");
        } else {
            buyFromShoppingCart(catologue.updateMakeUp(skincare));
        }
    }

    // MODIFIES: this
    // EFFECTS: update makeup such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void determineBuyWhichProductMakeUpHelper(MakeUp makeup) {
        if (null == catologue.updateMakeUp(makeup)) {
            System.out.println("There seems to be an issue!");
        } else {
            buyFromShoppingCart(catologue.updateMakeUp(makeup));
        }
    }

    // MODIFES: this
    // EFFECTS: Buy product that is in shopping cart
    public void buyFromShoppingCart(Product product) {
        shoppingCart.buyProduct(product);
        purchasedList.addProduct(product);
        System.out.println("Product has been purchased");
        System.out.println("What would you like to do next?");
        System.out.println("1. Rate product");
        System.out.println("2. See all puchased product");
        System.out.println("3. Find another product");
        System.out.println("4. Speack to customer service");
        System.out.println("5. Return to home page");
        System.out.println("Please answer 1, 2, 3, 4 or 5 based on above choices");
        int userChoice = myScanner.nextInt();

        if (userChoice == 1) {
            ratePurchasedProduct(product);
        } else if (userChoice == 2) {
            displayPurchasedList();
        } else if (userChoice == 3) {
            whichTypeProduct();
        } else if (userChoice == 4) {
            customerService();
        }
    }

    // MODIFIES: this
    // EFFECTS: Display purchased list by printing in-list products' name, brand and
    // type.
    public void displayPurchasedList() {
        if (purchasedList.getPurchased().isEmpty()) {
            System.out.println("Your purchased list is currently empty");
        } else {
            ArrayList<Product> purchasedItems = purchasedList.getPurchased();
            for (Product product : purchasedItems) {
                System.out.println(product.getName() + "," + product.getBrand() + ","
                        + product.getType());
            }
        }

    }

    // MODIFIES: this
    // EFFECTS: rate product in purchased list
    public void ratePurchasedProduct(Product product) {
        System.out.println("What would you like to rate this product as?");
        System.out.println("Please answer 1, 2, 3, 4, or 5");
        int rate = myScanner.nextInt();
        if (rate == 1 || rate == 2 || rate == 3 || rate == 4 || rate == 5) {
            purchasedList.rateProduct(product, rate);
            System.out.println("Your rating was successful!");
            System.out.println("The new rating of this product is: " + product.getRating());
        }

    }

    // MODIFIES: this
    // EFFECTS: remove product from shopping cart
    public void removeFromCart() {
        System.out.println("Please enter name of product you want to remove: ");
        myScanner.nextLine();
        String name = myScanner.nextLine();
        System.out.println("Please enter brand of product you want to remove: ");
        String brand = myScanner.nextLine();
        System.out.println("Please enter type of product you want to remove: ");
        String type = myScanner.nextLine();

        doWhatAfterRemoveFromChart(name, brand, type);
    }

    // MODIFIES: this
    // EFFECTS: determine if product user wants to remove from shopping cart is in
    // shopping cart
    private void doWhatAfterRemoveFromChart(String name, String brand, String type) {
        if (type.equalsIgnoreCase("makeup")) {
            MakeUp makeup = new MakeUp(name, brand);
            if (shoppingCart.contains(makeup)) {
                doWhatAfterRemoveFromChartHelperMakeUp(makeup);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        } else if (type.equalsIgnoreCase("skincare")) {
            SkinCare skincare = new SkinCare(name, brand);
            if (shoppingCart.contains(skincare)) {
                doWhatAfterRemoveFromChartHelperSkinCare(skincare);
            } else {
                System.out.println("Product is not in shopping cart.");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: update skincare such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void doWhatAfterRemoveFromChartHelperSkinCare(SkinCare skincare) {
        if (null == catologue.updateMakeUp(skincare)) {
            System.out.println("There seems to be an issue!");
        } else {
            shoppingCart.removeProduct(catologue.updateMakeUp(skincare));
            System.out.println("Product removed from shopping cart");
        }
    }

    // MODIFIES: this
    // EFFECTS: update makeup such that the instatiation user produced is replaced
    // by the actual product
    // in catologue
    private void doWhatAfterRemoveFromChartHelperMakeUp(MakeUp makeup) {
        if (null == catologue.updateMakeUp(makeup)) {
            System.out.println("There seems to be an issue!");
        } else {
            shoppingCart.removeProduct(catologue.updateMakeUp(makeup));
            System.out.println("Product removed from shopping cart");
        }
    }

    // MODIFIES: this
    // EFFECTS: add product to wish list
    public void addProductToWishList(Product product) {
        System.out.println("Your product has been added to wish list!");
        System.out.println("Would you like to sign up for restock notification?");
        System.out.println("Please answer yes or no");
        String choice = myScanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            restockNotification(product);
        }

    }
}
