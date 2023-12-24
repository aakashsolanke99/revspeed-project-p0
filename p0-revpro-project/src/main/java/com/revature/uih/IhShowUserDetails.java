package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
//import com.revature.dao.imple.UserDaoImple;
import com.revature.dao.imple.UserDaoImple;
import com.revature.services.imple.UserServiceImple;
import com.revature.util.User;

import java.sql.SQLException;
import java.util.Scanner;

public class IhShowUserDetails {

    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    Scanner sc=new Scanner(System.in);

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

        System.out.println("1- Change Password");
        int choice=sc.nextInt();



    }

    public Boolean changePassword(){
        System.out.println("");
        return true;
    }

}
