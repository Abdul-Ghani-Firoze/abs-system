/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.util;

import com.abs.model.Category;
import com.abs.entity.CategoryVisit;
import com.abs.model.Product;
import com.abs.entity.ProductVisit;
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

    private List<ProductVisit> productVisits;
    private List<List<CategoryVisit>> categoryVisits;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public List<ProductVisit> getProductVisits(String sessionId) {
        preparedStatement = null;
        resultSet = null;
        User user = getUserFromDB(sessionId);

        try (Connection conn = DBHelper.getConnection()) {
            preparedStatement = conn.prepareStatement("SELECT * FROM " + DBHelper.TABLE_PRODUCT_VISITS + " WHERE " + DBHelper.COLUMN_USER_ID + " = ?");
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();
            readProductVisits(resultSet);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return productVisits;
    }

    public List<List<CategoryVisit>> getCategoryVisits(User user) {
        preparedStatement = null;
        resultSet = null;

        try (Connection conn = DBHelper.getConnection()) {
            preparedStatement = conn.prepareStatement("SELECT * FROM " + DBHelper.TABLE_CATEGORY_VISITS + " WHERE " + DBHelper.COLUMN_USER_ID + " = ?");
            preparedStatement.setInt(1, user.getUserId());
            resultSet = preparedStatement.executeQuery();
            readCategoryVisits(resultSet);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categoryVisits;
    }

    private User getUserFromDB(String sessionId) {
        preparedStatement = null;
        resultSet = null;
        User user = null;

        try (Connection conn = DBHelper.getConnection()) {
            preparedStatement = conn.prepareStatement("SELECT * FROM " + DBHelper.TABLE_USERS + " WHERE " + DBHelper.COLUMN_SESSION_ID + " = ?");
            preparedStatement.setString(1, sessionId);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user = new User();
            user.setUserId(resultSet.getInt(DBHelper.COLUMN_USER_ID));
            user.setMember(resultSet.getBoolean(DBHelper.COLUMN_MEMBER));
            user.setSessionId(resultSet.getString(DBHelper.COLUMN_SESSION_ID));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;
    }

    private void readProductVisits(ResultSet resultSet) {
        try {
            productVisits = new ArrayList<>();
            while (resultSet.next()) {
                ProductVisit productVisit = new ProductVisit();
                productVisit.setUserId(resultSet.getInt(DBHelper.COLUMN_USER_ID));
                productVisit.setProductId(resultSet.getInt(DBHelper.COLUMN_PRODUCT_ID));
                productVisit.setProductUrl(resultSet.getString(DBHelper.COLUMN_PRODUCT_URL));
                productVisit.setEnteredAt(resultSet.getTimestamp(DBHelper.COLUMN_ENTERED_AT));
                productVisit.setLeftAt(resultSet.getTimestamp(DBHelper.COLUMN_LEFT_AT));
                productVisits.add(productVisit);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void readCategoryVisits(ResultSet resultSet) {
        try {
            categoryVisits = new ArrayList<>();
            List<CategoryVisit> categoryVisitList = new ArrayList<>();
            while (resultSet.next()) {
                CategoryVisit categoryVisit = new CategoryVisit();
//                categoryVisit.setUser(getUser(resultSet.getInt(DBHelper.COLUMN_USER_ID)));
                categoryVisit.setCategory(new Category(this.resultSet.getString(DBHelper.COLUMN_CATEGORY_URL)));
                categoryVisitList.add(categoryVisit);
            }
            categoryVisits.add(categoryVisitList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
