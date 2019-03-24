package com.abs.util;

import com.abs.model.Discount;
import com.abs.model.Product;
import com.abs.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ghani
 */
public class DiscountGenerator {

    private static final Logger LOGGER = Logger.getLogger(DiscountGenerator.class.getName());
    private Discount discount;

    public Discount generateDiscount(User user, Product product) {
        FactorsCalculator factorsCalculator = new FactorsCalculator();
        
        LOGGER.info("in discount generator - generating discount");
        long stickiness = factorsCalculator.calculateStickiness(user, product);
        LOGGER.log(Level.INFO, "Stickiness: {0}", stickiness);
        
        discount = null;
        return discount;
    }

}
