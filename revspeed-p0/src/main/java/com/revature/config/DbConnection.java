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


//    public static void closeConnection() {
//        boolean myCon;
//        try {
//            connection.close();
//            System.out.println("connection closed");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

//    public static Connection getConnection() throws SQLException {
//        if (connection != null){
//            return  connection;
//        }
//
//        String db_name="practice_reppro";
//        String user = "root";
//        String pass = "Aakash@123";
//
//        return DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+user+"&password="+pass);
//    }




}