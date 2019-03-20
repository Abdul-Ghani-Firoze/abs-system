/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author ghani
 */
public class DBHelper {

    public static final String TABLE_PRODUCT_VISITS = "product_visits";
    public static final String TABLE_CATEGORY_VISITS = "category_visits";
    public static final String COLUMN_SESSION_ID = "sessionId";
    public static final String COLUMN_PRODUCT_ID = "productId";
    public static final String COLUMN_PRODUCT_URL = "productUrl";
    public static final String COLUMN_CATEGORY_URL = "categoryUrl";
    public static final String COLUMN_ENTERED_AT = "enteredAt";
    public static final String COLUMN_LEFT_AT = "leftAt";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        ResourceBundle dbResource = ResourceBundle.getBundle("db");

        // assign db parameters
        String url = dbResource.getString("url");
        String user = dbResource.getString("user");
        String password = dbResource.getString("password");

        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
