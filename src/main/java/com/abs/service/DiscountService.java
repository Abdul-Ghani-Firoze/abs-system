/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import com.abs.model.Discount;

/**
 *
 * @author ghani
 */
public interface DiscountService {
        
    public void test();
    public Discount getDiscount(String sessionId, int productId);
}
