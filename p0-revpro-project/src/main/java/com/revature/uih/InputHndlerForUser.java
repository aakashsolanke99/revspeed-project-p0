package com.revature.uih;

import com.revature.dao.imple.UserDaoImple;
import com.revature.util.User;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHndlerForUser {

    UserDaoImple userDaoImple=new UserDaoImple();
    ForBroadBandPlansAndUserDetails forBroadBandPlansAndUserDetails=new ForBroadBandPlansAndUserDetails();
    Scanner sc=new Scanner(System.in);
    public void getUserDetailsForRegistration() throws SQLException {
        int reg=0;
        do {
            System.out.println("========= Registration ==========");
            System.out.print("Enter your First Name :- ");
            String firstName = sc.nextLine();
            if (!isValidName(firstName)) {
                System.out.println("Invalid first name. Please enter a valid name.");
                return;
            }
            System.out.print("Enter Yor Last Name :- ");
            String lastName = sc.nextLine();
            if (!isValidName(lastName)) {
                System.out.println("Invalid last name. Please enter a valid name.");
                return;
            }
            System.out.print("Enter your Email Id :- ");
            String email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
                return; // Exit the program or handle the error as needed
            }
            System.out.print("Enter Your PassWord :- ");

            String password = sc.nextLine();
//            Boolean isPasswordPresent = userDaoImple.passwordExists(password);
            if (!isValidPassword(password)) {
                System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.");
                return; // Exit the program or handle the error as needed
            }


            System.out.print("Enter your Phone Number :- ");
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

            System.out.print("If you want to continue Registration press - 1 or any key");

            reg=sc.nextInt();
            sc.nextLine();



        }while(reg==1);
    }



    public void getDetailsForLogin() throws SQLException {

        int choic=0;
        do {
            System.out.println("====================== Login Here ================");
            System.out.println("                                                  ");
            System.out.print("Enter Email :- ");
            String email = sc.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("Wrong Email Please provide Correct Email.");
                return; // Exit the program or handle the error as needed
            }
//            System.out.print("Enter Password :- ");
//            String password=sc.nextLine();
//            if (!isValidPassword(password)) {
//                System.out.println("Wrong password please provide correct password");
//
//            }
            boolean validPassword = false;
            String password = "";

            while (!validPassword) {
                System.out.print("Enter Password: ");
                password = sc.nextLine();

                if (isValidPassword(password)) {
                    validPassword = true;
                } else {
                    System.out.println("Wrong password. Please provide a correct password.");
                }
            }


            try {
                userDaoImple.loginDao(email,password);
//                forBroadBandPlansAndUserDetails.getAllBroadBandServicePlansAndUserDetails();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            forBroadBandPlansAndUserDetails.getAllBroadBandServicePlansAndUserDetails();
            System.out.println("want to login press 1 otherwise any key");
            choic= sc.nextInt();
            sc.nextLine();
        }while(choic==1);
    }


//    public void getUserDetailsInInputHnadlerForUser() throws SQLException {
//       User userDetails= userDaoImple.getUsersDetails();
//        System.out.println(userDetails);
//    }

    static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate password criteria
    static boolean isValidPassword(String password) {
        // Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }

    static boolean isValidName(String name) {
        // Name should not be empty and should contain only letters
        return !name.trim().isEmpty() && name.matches("^[a-zA-Z]+$");
    }

    static boolean isValidPhoneNumber(String phoneNumber) {
        // Phone number should contain only digits and may include optional dashes or spaces
        return phoneNumber.matches("^[0-9\\-\\s]+$");
    }


}


