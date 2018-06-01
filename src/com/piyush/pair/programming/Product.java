package com.piyush.pair.programming;

public class Product implements Item {

    private String barcode;
    private String productName;
    private Double price;

    public Product(String barcode, String productName, Double price) {
        this.barcode = barcode;
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
