/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abs.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author ghani
 */
public class DBHelper {

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
