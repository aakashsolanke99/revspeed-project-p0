package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
//import com.revature.dao.imple.UserDaoImple;
import com.revature.dao.imple.UserDaoImple;
import com.revature.services.BroadBandPlansService;
import com.revature.services.imple.BroadBandPlansServiceImple;
import com.revature.services.imple.UserServiceImple;
import com.revature.util.User;
import static java.lang.System.*;
import java.sql.SQLException;
import java.util.Scanner;

public class IhShowUserDetails {

    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    static  UserServiceImple userServiceImple=new UserServiceImple();
    static Scanner sc=new Scanner(System.in);

    public void UserDetailsAndOperation() throws SQLException {
        System.out.println("======================================");
        System.out.println("           User details               ");
        System.out.println("======================================");

        int userId=UserDaoImple.loginId;
        User user1= broadbandServicePlansDaoImple.getDetails(userId);


        System.out.println("First Name :- "+user1.getFirstName());
        System.out.println("Last Name :- "+user1.getLastName());
        System.out.println("Email :- "+user1.getEmail());
        System.out.println("Phone Number :- "+user1.getPhoneNumber());
        System.out.println("Address :- "+user1.getAddress());
        System.out.println("                                         ");

        int id=user1.getUserId();
        System.out.println("1- Change Password  \t   2-Update Profile Details");
        int choice=0;
        try{
            choice=sc.nextInt();
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Please provide Integer value");
        }
        String oldPassword=user1.getPassWord();
        if(choice==1){
            IhShowUserDetails.changePassword(oldPassword,id);
        }else if(choice==2){
           userServiceImple.pudateProfile(id);
        }

    }

   static public Boolean changePassword(String oldPass,int id) throws SQLException {

       System.out.println("Enter old PassWord");
       String oldPasswordForCheck=sc.nextLine();
       if(oldPasswordForCheck.equals(oldPass)){
           System.out.println("Enter New PassWord");
           String newPass=sc.nextLine();
           userServiceImple.changePassWordService(newPass,id);
       }
        return true;
    }


}
