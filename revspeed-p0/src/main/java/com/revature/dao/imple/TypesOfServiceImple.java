package com.revature.dao.imple;

import java.sql.SQLException;
import java.util.Scanner;

public class TypesOfServiceImple implements TypesOfServiceDao{
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    @Override
    public void getTypesOfService()    {
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
                    broadbandServicePlansDaoImple.getAllPlans();break;
                case 2:
                    break;
                default:


            }

            System.out.println("If you want to continue press 1/0");
            choice=sc.nextInt();
        }while(choice==1);
    }
}
