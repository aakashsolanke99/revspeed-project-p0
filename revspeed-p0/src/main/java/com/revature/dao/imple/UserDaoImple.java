package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.dao.UserDao;
import com.revature.service.imple.ServicesServiceImple;
import com.revature.utile.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDaoImple implements UserDao {
    static Scanner sc=new Scanner(System.in);
    ServicesServiceImple servicesServiceImple=new ServicesServiceImple();
    private static Connection connection= DbConnection.getConnection();
    @Override
    public  void registorDao(User user) {


        try {
            String url="insert into Users(first_name,last_name,email,pass_word,phone_no,address) values(?,?,?,?,?,?)";

            PreparedStatement ps=connection.prepareStatement(url);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPassWord());
            ps.setLong(5,user.getPhoneNumber());
            ps.setString(6,user.getAddress());

            ps.executeUpdate();
            System.out.println("Registeration successful");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void loginDao(String email,String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND pass_word = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for parameters
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                // Execute query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data from the result set
//                        int userId = resultSet.getInt("user_id");
                        String userEmail = resultSet.getString("email");
                        String userPassword = resultSet.getString("pass_word");

                        if (userEmail.equals(email) && userPassword.equals(password)) {
                            System.out.println("login successesful");
                            servicesServiceImple.getServices();
                            return;
                        }
                    }
                }

            }catch(SQLException E){
                E.printStackTrace();
            }
    }

//    @Override
//    public void loginDaoImpl() throws SQLException {
//
//        do{
//            System.out.println("====================== Login Here ================");
//            System.out.println("                                                  ");
//            System.out.println("Enter Email");
//            String email = sc.nextLine();
//            System.out.println("Enter Password");
//            String password=sc.nextLine();
//
//            String sql = "SELECT * FROM users WHERE email = ? AND pass_word = ?";
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                // Set values for parameters
//                preparedStatement.setString(1, email);
//                preparedStatement.setString(2, password);
//
//                // Execute query
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    // Process the result set
//                    while (resultSet.next()) {
//                        // Retrieve data from the result set
//                        int userId = resultSet.getInt("user_id");
//                        String userEmail = resultSet.getString("email");
//                        String userPassword = resultSet.getString("pass_word");
//
//                        if (userEmail.equals(email) && userPassword.equals(password)) {
//                            System.out.println("login successesful");
//                            servicesServiceImple.getServices();
//                            return;
//                        }
//                    }
//                }
//
//            }catch(SQLException E){
//                E.printStackTrace();
//            }
//
//            System.exit(0);
//        }while(true);
//    }
}
