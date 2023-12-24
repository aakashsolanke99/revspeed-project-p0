package com.revature.uih;

import com.revature.dao.imple.UserDaoImple;
import com.revature.utile.User;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHndlerForUser {
    UserDaoImple userDaoImple=new UserDaoImple();

   Scanner sc=new Scanner(System.in);
    public void getUserDetailsForRegistration() throws SQLException {
        int reg=0;
        do {
            System.out.println("========= Registration ==========");
            System.out.print("Enter your First Name");
            String firstName = sc.nextLine();
            if (!isValidName(firstName)) {
                System.out.println("Invalid first name. Please enter a valid name.");
                return;
            }
            System.out.print("Enter Yor Last Name");
            String lastName = sc.nextLine();
            if (!isValidName(lastName)) {
                System.out.println("Invalid last name. Please enter a valid name.");
                return;
            }
            System.out.print("Enter your Email Id");
            String email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
                return; // Exit the program or handle the error as needed
            }
            System.out.print("Enter Your PassWord");

            String password = sc.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
                return; // Exit the program or handle the error as needed
            }
//            Console console = System.console();
//            String password="";
//            if (console!= null) {
//                char[] passwordArray = console.readPassword("Enter your password: ");
//                password = new String(passwordArray);
//                System.exit(1);
//            }else{
//                System.out.println("Console is not available. Password masking might not work.");
//            }


            System.out.print("Enter your Phone Number");
            String phNumber = sc.nextLine();

            if (!isValidPhoneNumber(phNumber)) {
                System.out.println("Invalid phone number. Please enter a valid phone number.");
                return; // Exit the program or handle the error as needed
            }

            System.out.print("Enter Your Address :- ");
            String address = sc.nextLine();

           User user=new  User(firstName, lastName, email, password, phNumber, address);
            System.out.println(user.toString());
            userDaoImple.registorDao(user);

            System.out.print("If you want to continue press - 1/0");

            reg=sc.nextInt();
            sc.nextLine();



        }while(reg==1);
    }



    public void getDetailsForLogin() {

        do {
            System.out.println("====================== Login Here ================");
            System.out.println("                                                  ");
            System.out.print("Enter Email :- ");
            String email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Wrong Email Please provide Correct Email.");
                return; // Exit the program or handle the error as needed
            }
            System.out.print("Enter Password :- ");
            String password=sc.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Wrong password please provide wrong password");
                return; // Exit the program or handle the error as needed
            }

            try {
                userDaoImple.loginDao(email,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }while(true);
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate password criteria
    private static boolean isValidPassword(String password) {
        // Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    private static boolean isValidName(String name) {
        // Name should not be empty and should contain only letters
        return !name.trim().isEmpty() && name.matches("^[a-zA-Z]+$");
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Phone number should contain only digits and may include optional dashes or spaces
        return phoneNumber.matches("^[0-9\\-\\s]+$");
    }
}
