/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.service;

import com.abs.util.DiscountGenerator;
import com.abs.model.Discount;
import com.abs.model.Product;
import com.abs.model.User;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author ghani
 */
@Path("discount")
public class DiscountServiceImpl implements DiscountService {

    private static final Logger LOGGER = Logger.getLogger(DiscountServiceImpl.class.getName());

    @Override
    @Path("{sessionId}/{productId}")
    @POST
    public Discount getDiscount(
            @PathParam("sessionId") String sessionId,
            @PathParam("productId") int productId) {

        System.out.println("in discount service - get discount");
        LOGGER.info("in discount service - get discount");

        User user = new User();
        user.setSessionId(sessionId);

        Product product = new Product();
        product.setProductId(productId);

        DiscountGenerator discountGenerator = new DiscountGenerator();
        return discountGenerator.generateDiscount(user, product);
    }

    @Override
    @Path("test")
    @GET
    public String test() {
        System.out.println("TESTINGGGGG");
        return "TEST";
    }

}
