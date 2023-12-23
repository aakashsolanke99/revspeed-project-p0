package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;

import java.util.Scanner;

public class InputHnadlerForServices {
    Scanner sc = new Scanner(System.in);
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple = new BroadbandServicePlansDaoImple();
    ShowPlans showPlans=new ShowPlans();
    public void getAllServices() {

        do {
            System.out.println("================ Broad Band Service Plans =============");
            System.out.println("1- For All Plans ");
            System.out.println("2- For Monthly Plans ");
            System.out.println("3- For Quaterly Plans");
            System.out.println("4- For Yearly plans");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    showPlans.AllPlans();break;
                case 2:
                    showPlans.getMonthlyPlans();break;
                default:
            }
        } while (true);
    }
}
