package com.revature.uih;

import java.sql.SQLException;
import java.util.Scanner;

public class ForBroadBandPlansAndUserDetails {
    Scanner sc = new Scanner(System.in);
    MonthlyQuaterlyYerlyPlansDetails monthlyQuaterlyYerlyPlansDetails=new MonthlyQuaterlyYerlyPlansDetails();
    IhShowUserDetails ihShowUserDetails=new IhShowUserDetails();
    DthServicePlansDetails dthServicePlansDetails=new DthServicePlansDetails();
    public void getAllBroadBandServicePlansAndUserDetails() throws SQLException {
        int choice;
        do{

            System.out.println("============= Types Of Service ============ ");
            System.out.println();
            System.out.println("1 - BroadBand Service ");
            System.out.println("2 - Dth Service");
            System.out.println("3 - See user Details");
            System.out.println("4 - Log out");
            System.out.print("Enter Yours choice :- ");
            Scanner sc=new Scanner(System.in);
            int serviceId=sc.nextInt();
            sc.nextLine();

            switch(serviceId){
                case 1:
                  monthlyQuaterlyYerlyPlansDetails.getAllBroadBandServicePlansMQY();break;
                case 2:
                  dthServicePlansDetails.getAllDthPlansDetails();
                  break;

                case 3:
                    ihShowUserDetails.UserDetailsAndOperation();  break;

                case 4:
                    System.exit(0);
                    System.out.println("                   ");
                     ;break;
                default:
                    System.out.println("Invalid input");break;


            }

            System.out.print("If you want to see types of service or user details press- 1 otherwise any key :- ");
            choice=sc.nextInt();
        }while(choice==1);
    }
}
