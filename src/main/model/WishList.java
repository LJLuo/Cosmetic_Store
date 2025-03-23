package model;

import java.util.ArrayList;
import java.util.List;

//A list of products that user wants to buy but is out of stock
public class WishList {

    private List<Product> wishlist;

    // EFFECTS: create empty WishList object
    public WishList() {
        this.wishlist = new ArrayList<Product>();
    }

    // REQUIRES: product is in store's catologue and out of stock
    // MODIFIES: this
    // EFFECTS: add p to WishList
    public void addProduct(Product p) {
        wishlist.add(p);
    }

    // REQUIRES: product is in wishlist
    // MODIFIES: this
    // EFFECTS: remove p from wishlist
    public void removeProduct(Product p) {
        wishlist.remove(p);
    }

    // EFFECTS: return number of items in wishlist
    public int getSize() {
        return wishlist.size();
    }

}
