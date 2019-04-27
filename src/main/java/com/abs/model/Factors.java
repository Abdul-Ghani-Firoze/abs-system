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
public class Factors {

    private boolean details;
    private boolean festival;
    private boolean inCart;
    private int itemInCart;
    private boolean member;
    private boolean queries;
    private boolean recommended;
    private boolean regularPurchaser;
    private boolean reviewed;
    private boolean revisited;
    private long stickiness;
    private boolean viewedSimilarProducts;

    public boolean isDetails() {
        return details;
    }

    public void setDetails(boolean details) {
        this.details = details;
    }

    public boolean isFestival() {
        return festival;
    }

    public void setFestival(boolean festival) {
        this.festival = festival;
    }

    public boolean isInCart() {
        return inCart;
    }

    public void setInCart(boolean inCart) {
        this.inCart = inCart;
    }

    public int getItemInCart() {
        return itemInCart;
    }

    public void setItemInCart(int itemInCart) {
        this.itemInCart = itemInCart;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public boolean isQueries() {
        return queries;
    }

    public void setQueries(boolean queries) {
        this.queries = queries;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean isRegularPurchaser() {
        return regularPurchaser;
    }

    public void setRegularPurchaser(boolean regularPurchaser) {
        this.regularPurchaser = regularPurchaser;
    }

    public boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(boolean reviewed) {
        this.reviewed = reviewed;
    }

    public boolean isRevisited() {
        return revisited;
    }

    public void setRevisited(boolean revisited) {
        this.revisited = revisited;
    }

    public long getStickiness() {
        return stickiness;
    }

    public void setStickiness(long stickiness) {
        this.stickiness = stickiness;
    }

    public boolean isViewedSimilarProducts() {
        return viewedSimilarProducts;
    }

    public void setViewedSimilarProducts(boolean viewedSimilarProducts) {
        this.viewedSimilarProducts = viewedSimilarProducts;
    }

}
