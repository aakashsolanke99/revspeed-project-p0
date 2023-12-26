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

import static java.lang.System.out;

public class UserDaoImple implements UserDao {

    ForBroadBandPlansAndUserDetails forBroadBandPlansAndUserDetails=new ForBroadBandPlansAndUserDetails();
    static Scanner sc=new Scanner(System.in);

    private static Connection connection= DbConnection.getConnection();
    public static int loginId;
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
//        connection.close();
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
                            out.println();
                            System.out.println("login successesful");
                            System.out.println();
                            loginId= resultSet.getInt(1);
                            forBroadBandPlansAndUserDetails.getAllBroadBandServicePlansAndUserDetails();

                        }else{
                            System.out.println("PassWord Does not match / Wrong Password");
                        }
                    }
                }

            }catch(SQLException E){
                E.printStackTrace();
            }
    }

    @Override
    public void changePassword(String newPass,int id) throws SQLException {
        String query=" update  users set pass_word=? where user_id=?";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setString(1,newPass);
        ps.setInt(2,id);
//        ResultSet rs= ps.executeQuery();
        System.out.println("password update Successfully");

    }

    @Override
    public void updateProfile(int id) throws SQLException {

        System.out.println("==================== Update profile ==========");
        int check;
        do {
            out.println("Select what you want to update");
            out.println("1- First Name");

            out.println("2- Last Name");
            out.println("3- Email ID");
            out.println("4- Phone Number");
            out.println("5- Address");

            out.println("Enter your choice");
            int  check1= sc.nextInt();
            sc.nextLine();

            switch(check1) {

                case 1:
                    String query="Update users set first_name=? where user_id=?";
                    out.print("Enter The first Name which you want to change :- ");
                    String firstName= sc.nextLine();
                    PreparedStatement ps=connection.prepareStatement(query);
                    ps.setString(1,firstName);
                    ps.setInt(2,id);
                    ps.executeUpdate();
                    out.println("First Name Update Successful");
                    ;break;

                case 2:
                    String query1="Update users set last_name=? where user_id=?";
                    out.print("Enter The Last Name which you want to change :- ");
                    String LastName= sc.nextLine();
                    PreparedStatement ps1=connection.prepareStatement(query1);
                    ps1.setString(1,LastName);
                    ps1.setInt(2,id);
                    ps1.executeUpdate();
                    out.println("Last name Update Successful");
                    ;break;

                case 3:
                    String query3="Update users set email=? where user_id=?";
                    out.print("Enter The email id which you want to change :- ");
                    String email= sc.nextLine();
                    PreparedStatement ps3=connection.prepareStatement(query3);
                    ps3.setString(1,email);
                    ps3.setInt(2,id);
                    ps3.executeUpdate();
                    out.println("Email Update Successful");
                    ;break;

                case 4:
                    String query4="Update users set phone_no=? where user_id=?";
                    out.print("Enter The phone number which you want to change :- ");
                    String phoneNumber= sc.nextLine();
                    PreparedStatement ps4=connection.prepareStatement(query4);
                    ps4.setString(1,phoneNumber);
                    ps4.setInt(2,id);
                    ps4.executeUpdate();
                    out.println("Phone no Update Successful")
                    ;break;

                case 5:
                    String query5="Update users set phone_no=? where user_id=?";
                    out.print("Enter The phone number which you want to change :- ");
                    String address= sc.nextLine();
                    PreparedStatement ps5=connection.prepareStatement(query5);
                    ps5.setString(1,address);
                    ps5.setInt(2,id);
                    ps5.executeUpdate();
                    out.println("Adress Update Successful");
                    break;

                default :
                    out.println("Number not found");

            }

            out.println("if you want to update more press 1 otherwise any key");
            check=sc.nextInt();
            sc.nextLine();
        }while(check==1);
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


}
