package com.abs.controller;

import com.abs.model.Discount;
import com.abs.model.Product;
import com.abs.model.User;
import java.util.logging.Logger;

/**
 *
 * @author ghani
 */
public class DiscountGenerator {

    private static final Logger LOGGER = Logger.getLogger(DiscountGenerator.class.getName());
    private Discount discount;

    public Discount generateDiscount(User user, Product product) {
        LOGGER.info("in discount generator - generating discount");

        discount = null;
        return discount;
    }

}