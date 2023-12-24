package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.ResourceBundle;

public class DbConnection {

    private static Connection connection = null;


    public static Connection getConnection(){
        if (connection == null) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
            String url = resourceBundle.getString("dburl");
            String userNmae = resourceBundle.getString("username");
            String passWord = resourceBundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, userNmae, passWord);
                System.out.println("Connection Successful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}