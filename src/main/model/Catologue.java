package model;

import java.util.ArrayList;

//Represent a store's catologue that stores all products that will be sold in store
public class Catologue {
    private ArrayList<Product> products;

    // EFFECTS: create empty store's catologue
    // will be stored in.
    public Catologue() {
        this.products = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: add product to catologue
    public boolean addProduct(Product p) {
        for (Product product : products) {
            if (p.equals(product)) {
                return false;
            }
        }
        products.add(p);
        return true;
    }

    // EFFECTS: return true if product is in catologue.
    // return false if product is not in catologue.
    public boolean contains(Product p) {
        for (Product product : products) {
            if ((p.getName().equalsIgnoreCase(product.getName())) && (p.getBrand().equalsIgnoreCase(product.getBrand()))
                    && (p.getType().equalsIgnoreCase(product.getType()))) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: return makeup product that is in catologue which has the same name,
    // brand and type as
    // the parameter product
    public Product updateMakeup(Product p) {
        Product updatedProduct = new MakeUp("n", "b");
        for (Product product : products) {
            if ((p.getName().equalsIgnoreCase(product.getName())) && (p.getBrand().equalsIgnoreCase(product.getBrand()))
                    && (p.getType().equalsIgnoreCase(product.getType()))) {
                updatedProduct = product;
                return updatedProduct;
            }
        }
        return null;
    }

    // EFFECTS: return skincare product that is in catologue which has the same
    // name, brand and type as
    // the parameter product
    public Product updateSkincare(Product p) {
        Product updatedProduct = new SkinCare("n", "b");
        for (Product product : products) {
            if ((p.getName().equalsIgnoreCase(product.getName())) && (p.getBrand().equalsIgnoreCase(product.getBrand()))
                    && (p.getType().equalsIgnoreCase(product.getType()))) {
                updatedProduct = product;
                return updatedProduct;
            }
        }
        return null;
    }

    // EFFECTS: return size of catologues
    public int getSize() {
        return products.size();
    }

}
