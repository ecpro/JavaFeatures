package com.piyush.pair.programming;

import java.util.Map;

/*
01001|Apple|2.99
01002|Mango|6.66
01003|Melon|3.33
 */
public class CartClient {

    public static void main(String[] args) throws Exception {
//        ShoppingCart shoppingCart = new ShoppingCart();
//
//        shoppingCart.addItem("01001");
//        shoppingCart.addItem("01002");
//        shoppingCart.addItem("01003");
//        shoppingCart.addItem("01003");
//
//        shoppingCart.removeItem("01003");

        //shoppingCart.viewCartSummary();

        testAddItems();
        testRemoveItem();
        showCartDetails();


    }

    public static void testRemoveItem() throws Exception {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("01001");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01003");
        shoppingCart.addItem("01003");

        String barCode = "01003";
        shoppingCart.removeItem(barCode);

        Map<Item, Integer> itemDetails = shoppingCart.getItemDetails();
        boolean flag = true;
        for(Map.Entry<Item, Integer> entry : itemDetails.entrySet()) {
            if(entry.getKey().getBarcode().equals(barCode) && entry.getValue() > 0) {
                flag = false;
            }
        }

        if(flag == true) throw new Exception("Item should be present in the cart");

    }

    public static void testAddItems() throws Exception {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("01001");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01003");
        shoppingCart.addItem("01003");
        String barCode = "01003";
        int count = 2;

        Map<Item, Integer> itemDetails = shoppingCart.getItemDetails();

        for(Map.Entry<Item, Integer> entry : itemDetails.entrySet()) {
            if(entry.getKey().getBarcode().equals(barCode)) {
                if(entry.getValue() < 2) throw new Exception("Item count is invalid in the cart");
            }
        }

    }

    public static void showCartDetails() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("01001");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01002");
        shoppingCart.addItem("01003");
        shoppingCart.addItem("01003");
        shoppingCart.viewCartSummary();
    }

}
