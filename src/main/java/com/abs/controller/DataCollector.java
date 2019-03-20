/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.controller;

import com.abs.model.Product;
import com.abs.model.ProductVisit;
import com.abs.model.User;
import com.abs.util.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghani
 */
public class DataCollector {

    private List<List<ProductVisit>> productVisits;
    private List categoryVisits;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<List<ProductVisit>> getProductVisits(String sessionId) {
        preparedStatement = null;
        resultSet = null;

        try (Connection conn = DBHelper.getConnection()) {
            preparedStatement = conn.prepareStatement("SELECT * FROM product_visits WHERE sessionId = ?");
            preparedStatement.setString(1, sessionId);
            resultSet = preparedStatement.executeQuery();
            readResultSet(resultSet);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productVisits;
    }

    private List getCategoryVisits() {
        return null;
    }

    private void readResultSet(ResultSet resultSet) {
        try {
            productVisits = new ArrayList<>();
            List<ProductVisit> productVisitList = new ArrayList<>();
            while (resultSet.next()) {
                ProductVisit productVisit = new ProductVisit();
                productVisit.setUser(new User(resultSet.getString("sessionId")));
                productVisit.setProduct(new Product(this.resultSet.getInt("productId"), resultSet.getString("productUrl")));
                productVisit.setEnteredAt(this.resultSet.getTimestamp("enteredAt"));
                productVisit.setLeftAt(resultSet.getTimestamp("leftAt"));
                productVisitList.add(productVisit);
            }
            productVisits.add(productVisitList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
