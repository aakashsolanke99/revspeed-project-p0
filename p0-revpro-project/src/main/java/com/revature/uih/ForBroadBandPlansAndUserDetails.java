package com.revature.uih;

import java.util.Scanner;

public class ForBroadBandPlansAndUserDetails {
    Scanner sc = new Scanner(System.in);
    MonthlyQuaterlyYerlyPlansDetails monthlyQuaterlyYerlyPlansDetails=new MonthlyQuaterlyYerlyPlansDetails();
    public void getAllBroadBandServicePlansAndUserDetails() {
        int choice;
        do{

            System.out.println("============= Types Of Service ============ ");
            System.out.println("1 - BroadBand Service ");
            System.out.println("2 - Dth Service");
            System.out.println("3 - See user Details");
            System.out.println("4 - Log out");
            System.out.println("Enter Yours choice");
            Scanner sc=new Scanner(System.in);
            int serviceId=sc.nextInt();
            sc.nextLine();

            switch(serviceId){
                case 1:
                  monthlyQuaterlyYerlyPlansDetails.getAllBroadBandServicePlansMQY();
                case 2:
                    break;
                case 3:
//                    userServiceImple.userDetails();
                    break;
                default:


            }

            System.out.println("If you want to continue press 1/0");
            choice=sc.nextInt();
        }while(choice==1);
    }
}