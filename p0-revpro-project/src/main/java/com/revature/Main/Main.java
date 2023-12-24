package com.revature.Main;


import com.revature.services.imple.UserServiceImple;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws SQLException {
        UserServiceImple userServiceImple=new UserServiceImple();
        Scanner sc=new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("==================================================");
            System.out.println("                  Wellcome To RevSpeed            ");
            System.out.println("==================================================");

            System.out.println("                                               ");
            System.out.println("Enter 1 For Register");
            System.out.println("Enter 2 For Login");
            System.out.println("Enter 0 For Exit");
            try{
                choice= sc.nextInt();
                sc.nextLine();
            }catch (Exception E){
                System.out.println("Enter Integer values");
            }


            switch (choice){
                case 1:
                    userServiceImple.register();break;
                case 2:
                    userServiceImple.login();break;
                case 0:
                    System.exit(0);
                default:


            }
        }while(true);


    }
    }
