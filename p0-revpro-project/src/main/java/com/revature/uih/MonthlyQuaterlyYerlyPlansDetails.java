package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;

import java.sql.SQLException;
import java.util.Scanner;

public class MonthlyQuaterlyYerlyPlansDetails {
    Scanner sc = new Scanner(System.in);

    ShowPlans showPlans=new ShowPlans();


    public void getAllBroadBandServicePlansMQY() throws SQLException {
        Boolean forExit=true;
        do {
            System.out.println("================ Broad Band Plans =============");
            System.out.println("1- For All Plans ");
            System.out.println("2- For Monthly Plans ");
            System.out.println("3- For Quaterly Plans");
            System.out.println("4- For Yearly plans");
            System.out.println("5 - Purches Plan");
            System.out.println("0 - For Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    showPlans.AllPlans();break;
                case 2:
                    showPlans.getMonthlyPlans();break;
                case 3:
                    showPlans.getQuaterlyPlans();break;
                case 4:
                    showPlans.getYearlyPlans();break;
                case 5:
                    showPlans.addPlansToUser();break;
                case 0:
                    forExit=false; break;
                default:
            }
        } while (forExit);
    }
}
