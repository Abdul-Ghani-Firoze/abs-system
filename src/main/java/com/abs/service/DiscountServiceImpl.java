/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import com.abs.controller.DiscountGenerator;
import com.abs.model.Discount;
import com.abs.model.Product;
import com.abs.model.User;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author ghani
 */
@Path("abs")
public class DiscountServiceImpl implements DiscountService {

    private static final Logger LOGGER = Logger.getLogger(DiscountServiceImpl.class.getName());

    @Override
    @Path("discount")
    @GET
    public Discount getDiscount(String sessionId, int productId) {
        LOGGER.info("in discount service - get discount");

        User user = new User();
        user.setSessionId(sessionId);

        Product product = new Product();
        product.setProductId(productId);

        DiscountGenerator discountGenerator = new DiscountGenerator();
        return discountGenerator.generateDiscount(user, product);
    }

    @Override
    public void test() {
        System.out.println("TEST");
    }

}
