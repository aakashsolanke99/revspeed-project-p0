package com.revature.config;

import com.revature.Main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnection {
    private static Connection connection = null;
    public static final Logger logger= LoggerFactory.getLogger(DbConnection.class);


    public static Connection getConnection(){
        if (connection == null) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("mysql");
            String url = resourceBundle.getString("dburl");
            String userNmae = resourceBundle.getString("username");
            String passWord = resourceBundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, userNmae, passWord);
                System.out.println("Connection Successful");
                logger.info("Connection Successful");

            } catch (SQLException e) {
                logger.warn("connection fail");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
