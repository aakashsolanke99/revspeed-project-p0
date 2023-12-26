package com.revature.Main;


import com.revature.services.imple.UserServiceImple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final Logger logger= LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws SQLException {

        UserServiceImple userServiceImple=new UserServiceImple();
        Scanner sc=new Scanner(System.in);
        int choice=0;
        int check=0;
        do{
            System.out.println("==================================================");
            System.out.println("                  Wellcome To RevSpeed            ");
            System.out.println("==================================================");

            System.out.println("                                               ");
            System.out.println("Enter 1 For Register");
            logger.info("Example log from {}", Main.class);
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
            System.out.println("Do you want to continue with the application press -1 Otherwise any key");
            check=sc.nextInt();
        }while(check==1);


    }
    }
