package com.abs.util;

import com.abs.model.Discount;
import com.abs.model.Factors;
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
    private final FactorsCalculator FACTORS_CALCULATOR = new FactorsCalculator();
    private Factors factors;
    private Discount discount;

    public Discount generateDiscount(User user, Product product) {
        LOGGER.info("in discount generator - generating discount");

        factors = FACTORS_CALCULATOR.getFactors(user, product);

        discount = null;
        return discount;
    }

}
