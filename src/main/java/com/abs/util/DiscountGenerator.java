package com.abs.util;

import com.abs.model.Discount;
import com.abs.model.Factors;
import com.abs.model.Product;
import com.abs.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fuzzylite.Engine;
import com.fuzzylite.variable.InputVariable;
import java.util.Map;
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
        ObjectMapper oMapper = new ObjectMapper();
        Map<String, Object> factorsMap = oMapper.convertValue(factors, Map.class);
        System.out.println(factorsMap);

        Engine discountEngine = new FuzzyEngine(factorsMap).getEngine();

        StringBuilder status = new StringBuilder();
        if (!discountEngine.isReady(status)) {
            throw new RuntimeException("[engine error] engine is not ready:n" + status);
        }

        for (InputVariable inputVariable : discountEngine.getInputVariables()) {
            System.out.println("name: " + inputVariable.getName());
            Object value = factorsMap.get(inputVariable.getName());
            inputVariable.setValue(convertToDouble(value));
        }

        discountEngine.process();
        System.out.println("FINAL VALUE: " + discountEngine.getOutputValue("discount"));

        discount = null;
        return discount;
    }

    private Double convertToDouble(Object value) {
        double inputValue = 0.000;
        if (value instanceof Boolean) {
            inputValue = (Boolean) value ? 1.000 : 0.000;
        } else if (value instanceof Integer) {
            inputValue = Double.valueOf((int) value);
        } else {
            inputValue = (long) value;
        }
        return inputValue;
    }
}
