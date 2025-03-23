package model;

import java.util.ArrayList;

//A single instance of store's catologue that will be static
public class Singleton {
    private static Singleton single_instance = null;

    private Catologue catologue;
    private Product tfEyeShadow;
    private Product skiiFaceWash;
    private Product fentyBeautyFoundation;
    private Product ordinarySerum;

    // EFFECTS: Creates a Singleton Object of type Catologue which is the store's
    // static catologue
    private Singleton() {
        catologue = new Catologue();
        tfEyeShadow = getTfEyeShadow();
        skiiFaceWash = getSkiiFaceWash();
        fentyBeautyFoundation = getFentyBeautyFoundation();
        ordinarySerum = getOrdinarySerum();

        catologue.addProduct(skiiFaceWash);
        catologue.addProduct(tfEyeShadow);
        catologue.addProduct(fentyBeautyFoundation);
        catologue.addProduct(ordinarySerum);
    }

    // EFFECTS: helper function to Singleton(). Creates product object ordinarySerum
    private Product getOrdinarySerum() {
        ArrayList<String> ordinarySerumI = new ArrayList<>();
        ordinarySerumI.add("Water");
        ordinarySerumI.add("Sodium Hyaluronate");
        ordinarySerumI.add("Propanediol");
        ordinarySerumI.add("Pentylene Glycol");
        Product ordinarySerum = new SkinCare("Hyaluronic Acid 2% + B5 Hydrating Serum",
                "The Ordinary");
        ordinarySerum.setIngredients(ordinarySerumI);
        ordinarySerum.setPrice(15.00);
        ordinarySerum.setStockQuantity(23);
        ordinarySerum.setProductID(78367485);
        ordinarySerum.setRating(2.7);
        return ordinarySerum;

    }

    // EFFECTS: helper function to Singleton(). Creates product object
    // fentyBeautyFoundation
    private Product getFentyBeautyFoundation() {
        ArrayList<String> fentyBeautyFoundationI = new ArrayList<>();
        fentyBeautyFoundationI.add("Water");
        fentyBeautyFoundationI.add("Dimethicone");
        fentyBeautyFoundationI.add("Talc");
        fentyBeautyFoundationI.add("PEG-10 Dimethicone");
        Product fentyBeautyFoundation = new MakeUp(
                "Pro Filtr Soft Matte Longwear Liquid Foundation",
                "Fenty Beauty");
        fentyBeautyFoundation.setTotalPurchasedTime(1);
        fentyBeautyFoundation.setIngredients(fentyBeautyFoundationI);
        fentyBeautyFoundation.setPrice(54.00);
        fentyBeautyFoundation.setStockQuantity(12);
        fentyBeautyFoundation.setProductID(47693849);
        fentyBeautyFoundation.setRating(4.0);
        return fentyBeautyFoundation;
    }

    // EFFECTS: helper function to Singleton(). Creates product object skiiFaceWash
    private Product getSkiiFaceWash() {
        ArrayList<String> skiiFaceWashI = new ArrayList<>();
        skiiFaceWashI.add("Water");
        skiiFaceWashI.add("Sodium Lauroyl Glutamate");
        skiiFaceWashI.add("Propylene Glycol");
        skiiFaceWashI.add("PEG-150 Stearate");
        skiiFaceWashI.add("Galactomyces Ferment Filtrate");
        Product skiiFaceWash = new SkinCare("Facial Treatment Cleanser", "SKII");
        skiiFaceWash.setTotalPurchasedTime(12);
        skiiFaceWash.setIngredients(skiiFaceWashI);
        skiiFaceWash.setPrice(98.99);
        skiiFaceWash.setStockQuantity(2);
        skiiFaceWash.setProductID(98264735);
        skiiFaceWash.setRating(3.9);
        return skiiFaceWash;
    }

    // EFFECTS: helper function to Singleton(). Creates product object tfEyeShadow
    private Product getTfEyeShadow() {
        ArrayList<String> tfEyeShadowI = new ArrayList<>();
        tfEyeShadowI.add("Mica");
        tfEyeShadowI.add("Synthetic Fluorphlogopite");
        Product tfEyeShadow = new MakeUp("Eye Color Quad Eye Shadow", "Tom Ford");
        tfEyeShadow.setTotalPurchasedTime(38);
        tfEyeShadow.setIngredients(tfEyeShadowI);
        tfEyeShadow.setPrice(128.94);
        tfEyeShadow.setStockQuantity(93);
        tfEyeShadow.setProductID(98675623);
        tfEyeShadow.setRating(4.5);
        return tfEyeShadow;

    }

    // EFFECTS: creates a new instance of Singleton catologue
    public static Singleton getInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }

        return single_instance;
    }

    // EFFECTS: return true if p is in store's catologue
    // return false if p is not in store's catologue
    public boolean contains(Product p) {
        return (catologue.contains(p));
    }

    // EFFECTS: return true if p is added to store's catologue
    // return false if p is not added to store's catologue
    // (i.e. p is already in store's catologue)
    public boolean addProduct(Product p) {
        return catologue.addProduct(p);
    }

    // EFFECTS: return makeup product that is in catologue which has the same name,
    // brand and type as
    // the parameter product
    public Product updateMakeUp(Product product) {
        return catologue.updateMakeup(product);
    }

    // EFFECTS: return skincare product that is in catologue which has the same
    // name, brand and type as the parameter product
    public Product updateSkincare(Product p) {
        return catologue.updateSkincare(p);
    }

}
