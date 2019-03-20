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
public class Category {

    private String categoryUrl;

    public Category() {
    }

    public Category(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }
}
