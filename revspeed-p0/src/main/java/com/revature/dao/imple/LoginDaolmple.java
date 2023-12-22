package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.utile.User;

import java.io.Console;
import java.sql.*;
import java.util.Scanner;

public class LoginDaolmple implements LoginDao{
    static Scanner sc=new Scanner(System.in);

    private static Connection connection= DbConnection.getConnection();
    @Override
    public  void registorDao(User user) {

        int reg=0;
        do{
            System.out.println("========= Registration ==========");
            System.out.println("Enter your First Name");
            String firstName= sc.nextLine();
            System.out.println("Enter Yor Last Name");
            String lastName= sc.nextLine();
            System.out.println("Enter your Email Id");
            String email=sc.nextLine();
            System.out.println("Enter Your PassWord");

           String  password=sc.nextLine();
//            Console console = System.console();
//            String password="";
//            if (console!= null) {
//                char[] passwordArray = console.readPassword("Enter your password: ");
//                password = new String(passwordArray);
//                System.exit(1);
//            }else{
//                System.out.println("Console is not available. Password masking might not work.");
//            }




            System.out.println("Enter your Phone Number");
            long phNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Your Address");
            String address=sc.nextLine();

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassWord(password);
            user.setPhoneNumber(phNumber);
            user.setAddress(address);
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
            System.out.println("If you want to continue press - 1/0");

            reg=sc.nextInt();
            sc.nextLine();


            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }while(reg==1);
    }

    @Override
    public void loginDaoImpl() throws SQLException {

        do{
            System.out.println("====================== Login Here ================");
            System.out.println("                                                  ");
            System.out.println("Enter Email");
            String email = sc.nextLine();
            System.out.println("Enter Password");
            String password=sc.nextLine();

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
                        int userId = resultSet.getInt("user_id");
                        String userEmail = resultSet.getString("email");
                        String userPassword = resultSet.getString("pass_word");

                        if (userEmail.equals(email) && userPassword.equals(password)) {
                            System.out.println("login successesful");
                            
                            return;
                        }
                    }
                }

            }catch(SQLException E){
                E.printStackTrace();
            }

            System.exit(0);
        }while(true);
    }
}
