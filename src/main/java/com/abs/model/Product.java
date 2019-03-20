/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.model;

/**
 *
 * @author ghani
 */
public class Product {

    private int productId;
    private String productUrl;

    public Product(int productId, String productUrl) {
        this.productId = productId;
        this.productUrl = productUrl;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }
}
