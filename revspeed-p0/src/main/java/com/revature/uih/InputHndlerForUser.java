package com.revature.uih;

import com.revature.dao.imple.UserDaoImple;
import com.revature.utile.User;

import java.sql.SQLException;
import java.util.Scanner;

public class InputHndlerForUser {
    UserDaoImple uerUserDaoImple=new UserDaoImple();

   Scanner sc=new Scanner(System.in);
    public void getUserDetailsForRegistration(){
        int reg=0;
        do {
            System.out.println("========= Registration ==========");
            System.out.println("Enter your First Name");
            String firstName = sc.nextLine();
            System.out.println("Enter Yor Last Name");
            String lastName = sc.nextLine();
            System.out.println("Enter your Email Id");
            String email = sc.nextLine();
            System.out.println("Enter Your PassWord");

            String password = sc.nextLine();
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
            String address = sc.nextLine();

           User user=new  User(firstName, lastName, email, password, phNumber, address);
            System.out.println(user);
            uerUserDaoImple.registorDao(user);

            System.out.println("If you want to continue press - 1/0");

            reg=sc.nextInt();
            sc.nextLine();



        }while(reg==1);
    }



    public void getDetailsForLogin() throws SQLException {

        do {
            System.out.println("====================== Login Here ================");
            System.out.println("                                                  ");
            System.out.println("Enter Email");
            String email = sc.nextLine();
            System.out.println("Enter Password");
            String password=sc.nextLine();

            uerUserDaoImple.loginDao(email,password);
        }while(true);
    }
}
