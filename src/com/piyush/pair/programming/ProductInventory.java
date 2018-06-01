package com.piyush.pair.programming;

import java.util.HashMap;
import java.util.Map;

public class ProductInventory {

    Map<String, Item> barcodeItemMap;

    public ProductInventory() {
        barcodeItemMap = new HashMap<>();
        populateInventory();
    }


    /*
01001|Apple|2.99
01002|Mango|6.66
01003|Melon|3.33
 */
    public void populateInventory() {
        String barcode = "01001";
        Item item = new Product(barcode, "Apple", 2.99);
        barcodeItemMap.put(barcode, item);

        String barcode2 = "01002";
        Item item2 = new Product(barcode2, "Melon", 3.33);
        barcodeItemMap.put(barcode2, item2);


        String barcode3 = "01003";
        Item item3 = new Product(barcode3, "Mango", 6.66);
        barcodeItemMap.put(barcode3, item3);
    }

    public Item getItem(String barcode) {
        return barcodeItemMap.get(barcode);
    }
}
