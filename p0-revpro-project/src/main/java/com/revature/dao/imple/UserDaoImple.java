package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.dao.UserDao;
import com.revature.uih.ForBroadBandPlansAndUserDetails;
import com.revature.util.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserDaoImple implements UserDao {

    ForBroadBandPlansAndUserDetails forBroadBandPlansAndUserDetails=new ForBroadBandPlansAndUserDetails();
    static Scanner sc=new Scanner(System.in);
//    ServicesServiceImple servicesServiceImple=new ServicesServiceImple();
    private static Connection connection= DbConnection.getConnection();
    static int loginId;
    @Override
    public  void registorDao(User user) throws SQLException {


        try {
            String url="insert into Users(first_name,last_name,email,pass_word,phone_no,address) values(?,?,?,?,?,?)";

            PreparedStatement ps=connection.prepareStatement(url);
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getPassWord());
            ps.setString(5,user.getPhoneNumber());
            ps.setString(6,user.getAddress());

            ps.executeUpdate();
            System.out.println("Registeration successful");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        connection.close();
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
                            loginId= resultSet.getInt(1);
                            forBroadBandPlansAndUserDetails.getAllBroadBandServicePlansAndUserDetails();
//                            servicesServiceImple.getServices();
                            return;
                        }else{
                            System.out.println("PassWord Does not match/ Wrong PassWWORD");
                        }
                    }
                }

            }catch(SQLException E){
                E.printStackTrace();
            }
    }
    public static boolean passwordExists(String password) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE pass_word = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, password);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    }


//    public User getUsersDetails() throws SQLException{
//        User user=new User();
//        int userId=loginId;
//        String url="Select * from Users where user_id=?";
//        PreparedStatement ps=connection.prepareStatement(url);
//        ps.setInt(1,userId);
//        ResultSet rs= ps.executeQuery();
//        while (rs.next()){
//             user.setFirstName(rs.getString(2));
//             user.setLastName(rs.getString(3));
//             user.setEmail(rs.getString(4));
//             user.setPhoneNumber(rs.getString(6));
//             user.setAddress(rs.getString(7));
//        }
//
//        return user;
//    }
}