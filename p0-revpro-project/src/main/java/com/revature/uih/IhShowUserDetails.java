package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
//import com.revature.dao.imple.UserDaoImple;
import com.revature.dao.imple.UserDaoImple;
import com.revature.services.BroadBandPlansService;
import com.revature.services.imple.BroadBandPlansServiceImple;
import com.revature.services.imple.UserServiceImple;
import com.revature.util.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.*;
import java.sql.SQLException;
import java.util.Scanner;

public class IhShowUserDetails {
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);

    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    static  UserServiceImple userServiceImple=new UserServiceImple();
    static Scanner sc=new Scanner(System.in);

    public void UserDetailsAndOperation() throws SQLException {
        int check=0;
        do{
        System.out.println("======================================");
        System.out.println("           User details               ");
        System.out.println("======================================");

        int userId=UserDaoImple.loginId;
        User user1= broadbandServicePlansDaoImple.getDetails(userId);


        System.out.println("First Name :-  "+user1.getFirstName());
        System.out.println("Last Name :-   "+user1.getLastName());
        System.out.println("Email :-       "+user1.getEmail());
        System.out.println("Phone Number:- "+user1.getPhoneNumber());
        System.out.println("Address :-     "+user1.getAddress());
        System.out.println("======================================");
        System.out.println("                                         ");


            int id=user1.getUserId();
            System.out.println("1- Change Password  \t   2-Update Profile Details   \t  3-Exit");
            int choice=0;
            try{
                choice=sc.nextInt();
                sc.nextLine();
            }catch (Exception e){
                logger.error("Please provide Integer value");
                System.out.println("Please provide Integer value");
            }
            String oldPassword=user1.getPassWord();
            if(choice==1){
                IhShowUserDetails.changePassword(oldPassword,id);
            }else if(choice==2){
                userServiceImple.pudateProfile(id);
            }else if(choice==3){
                check=0;
                return;
            }
            else{
                logger.warn("Invalid choice please provide correct input");
                out.println("Invalid choice please provide correct input");
            }

//            out.println("If you want to See or update profile press-1 otherwise any key");
//            check= sc.nextInt();
//            sc.nextLine();

        }while (check==1);

    }

   static public Boolean changePassword(String oldPass,int id) throws SQLException {

       System.out.print("Enter Your old PassWord :- ");
       String oldPasswordForCheck=sc.nextLine();
       if(oldPasswordForCheck.equals(oldPass)){
           System.out.println("Enter New PassWord :- ");
           String newPass=sc.nextLine();
           boolean validPassword = false;
           String password = "";

           while (!validPassword) {
               System.out.print("Enter new Password again :- ");
               logger.info("Enter new Password again :-");
               password = sc.nextLine();

               if (isValidPassword(password)) {
                   validPassword = true;
                   userServiceImple.changePassWordService(newPass,id);
               } else {
                   logger.warn("Wrong password. Please provide a correct password.");
                   System.out.println("Wrong password. Please provide a correct password.");
               }
           }

       }else{
           logger.warn("old password does not match");
           out.println("old password does not match ");
       }
        return true;
    }

    static boolean isValidPassword(String password) {
        // Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*");
    }


}
