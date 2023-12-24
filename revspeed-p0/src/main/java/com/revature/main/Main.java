package com.revature.main;


import com.revature.service.imple.UserServiceImple;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  throws SQLException{

        UserServiceImple userServiceImple=new UserServiceImple();
        Scanner sc=new Scanner(System.in);
        System.out.println("==================================================");
        System.out.println("                  Wellcome To RevSpeed            ");
        System.out.println("==================================================");

        do{
            System.out.println("                                               ");
            System.out.println("Enter 1 For Register");
            System.out.println("Enter 2 For Login");
            System.out.println("Enter 0 For Exit");
            int choice= sc.nextInt();

            switch (choice){
                case 1:
                    userServiceImple.register();break;
                case 2:
                    userServiceImple.login(); ;break;
                case 0:
                    System.exit(0);
                default:


            }
        }while(true);


    }
}