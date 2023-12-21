package com.revature.dao.imple;

import com.revature.config.DbConnection;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDaolmple implements LoginDao{
    static Scanner sc=new Scanner(System.in);

    private static Connection connection= DbConnection.getConnection();
    @Override
    public  void registorDao() {

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
//            if ((console= System.console())!= null) {
//                char[] passwordArray = console.readPassword("Enter your password: ");
//                password = new String(passwordArray);
//                System.exit(1);
//            }else{
//                System.out.println("Console is not available. Password masking might not work.");
//            }




            System.out.println("Enter your Phone Number");
            int phNumber = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Your Address");
            String address=sc.nextLine();

            try {
                String url="insert into Users(first_name,last_name,email,pass_word,phone_no,address) values(?,?,?,?,?,?)";

                PreparedStatement ps=connection.prepareStatement(url);
                ps.setString(1,firstName);
                ps.setString(2,lastName);
                ps.setString(3,email);
                ps.setString(4,password);
                ps.setInt(5,phNumber);
                ps.setString(6,address);

                ps.executeUpdate();
                System.out.println("Registeration successful");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("If you want to continue press - 1/0");
            reg=sc.nextInt();
            sc.nextLine();


        }while(reg==1);
    }

    @Override
    public void loginDao() {

    }
}
