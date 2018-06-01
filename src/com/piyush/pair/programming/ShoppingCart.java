package com.piyush.pair.programming;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Item, Integer> itemToCountMap;
    private Double total;

    private ProductInventory productInventory;

    public ShoppingCart() {
        this.itemToCountMap = new HashMap<>();
        this.productInventory = new ProductInventory();
    }

    public void addItem(String barCode) {
        if(barCode == null || barCode.trim().length() == 0) throw new IllegalArgumentException("Invalid barcode entry");
        Item item = productInventory.getItem(barCode);
        if(itemToCountMap.isEmpty() || !itemToCountMap.containsKey(item)) {
            itemToCountMap.put(item, 1);
        }
        else {
             Integer count = itemToCountMap.get(item);
             count++;
             itemToCountMap.put(item, count);
        }
    }

    public void removeItem(String barCode) {
        if(barCode == null || barCode.trim().length() == 0) throw new IllegalArgumentException("Invalid barcode entry");
        Item item = productInventory.getItem(barCode);
        if(!itemToCountMap.isEmpty() && itemToCountMap.containsKey(item)) {
            if(itemToCountMap.get(item) > 1) {
                int count = itemToCountMap.get(item);
                count--;
                itemToCountMap.put(item, count);
            }
            else {
                itemToCountMap.remove(item);
            }
        }
    }

    public void viewCartSummary() {
        this.total = calculateTotal();
        for(Map.Entry<Item, Integer> entry : itemToCountMap.entrySet()) {
            System.out.println(entry.getKey().getBarcode() + " " + entry.getKey().getProductName() + "  " + entry.getKey().getPrice()  + " " + entry.getValue());
        }
        System.out.println(" Total : " + this.total);
    }

    private Double calculateTotal() {
        Double d = new Double(0);
        for(Map.Entry<Item, Integer> entry : itemToCountMap.entrySet()) {
            d += entry.getKey().getPrice() * entry.getValue();
        }
        return d;
    }

    public Map<Item, Integer> getItemDetails() {
        return this.itemToCountMap;
    }


}
