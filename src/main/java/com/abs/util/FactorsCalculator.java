/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.util;

import com.abs.entity.ProductVisit;
import com.abs.model.Factors;
import com.abs.model.Product;
import com.abs.model.User;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author ghani
 */
public class FactorsCalculator {

    private static final Logger LOGGER = Logger.getLogger(FactorsCalculator.class.getName());
    private final DataCollector DATA_COLLECTOR = new DataCollector();
    private Factors factors;
    private User user;
    private Product product;

    public Factors getFactors(User user, Product product) {
        this.user = user;
        this.product = product;

        factors = new Factors();
        long stickiness = calculateStickiness();
        boolean hasRevisitedThisProduct = stickiness > 0;

        factors.setStickiness(stickiness);
        factors.setRevisited(hasRevisitedThisProduct);

        return factors;
    }

    /**
     * Calculates stickiness of a user on the product
     *
     * @param user
     * @param product
     * @return
     */
    private long calculateStickiness() {
        long stickiness = 0;
        LOGGER.info("Calculating stickiness...");
        List<ProductVisit> productVisits = DATA_COLLECTOR.getProductVisits(this.user.getSessionId());

        // check whether user has visited this product earlier
        List<ProductVisit> thisProductVisits = productVisits.stream()
                .filter(productVisit -> productVisit.getProductId() == this.product.getProductId())
                .collect(Collectors.toList());

        if (!thisProductVisits.isEmpty()) {
            LOGGER.info("User HAS visited this product earlier");

            LocalDate dateOfFirstVisit = thisProductVisits.get(0).getEnteredAt().toLocalDateTime().toLocalDate();;
            LOGGER.log(Level.INFO, "Date of first visit of this product: {0}", dateOfFirstVisit);

            LocalDate dateofLastVisit = thisProductVisits.get(thisProductVisits.size() - 1).getEnteredAt().toLocalDateTime().toLocalDate();
            LOGGER.log(Level.INFO, "Date of last visit of this product: {0}", dateofLastVisit);

            long daysDifference = DAYS.between(dateOfFirstVisit, dateofLastVisit);
            LOGGER.log(Level.INFO, "Difference of days between first & last visit {0}", daysDifference);

            if (daysDifference < 7) {
                LocalDateTime timeOfLastVisitEntered = thisProductVisits.get(thisProductVisits.size() - 1).getEnteredAt().toLocalDateTime();
                LocalDateTime timeOfLastVisitLeft = thisProductVisits.get(thisProductVisits.size() - 1).getLeftAt().toLocalDateTime();
                long timeDifference = SECONDS.between(timeOfLastVisitEntered, timeOfLastVisitLeft);

                LOGGER.log(Level.INFO, "Difference of time between last visit entered & left {0}", timeDifference);

                stickiness = timeDifference;
            } else {
                LOGGER.info("Difference is greater than 7");
            }
        } else {
            LOGGER.info("User has not visited this product earlier");
            stickiness = 0;
        }

        LOGGER.log(Level.INFO, "Stickiness: {0}", stickiness);
        return stickiness;
    }

    private boolean isViewingSimilarProducts() {
        return false;
    }

    private boolean isProductInCartOrWishlist() {
        return false;
    }

    private boolean hasRevisitedThisProduct() {
        return false;
    }

    private boolean isFestivalToday() {
        return false;
    }

    private boolean hasViewedDetails() {
        return false;
    }

    private boolean hasAskedQueries() {
        return false;
    }

    private boolean hasRecommendedThisProduct() {
        return false;
    }

    private boolean isMember() {
        return false;
    }

    private boolean hasReviewedThisProduct() {
        return false;
    }

    private boolean isRegularPurchaser() {
        return false;
    }

    private int numberOfItemsInCart() {
        return 0;
    }

}
