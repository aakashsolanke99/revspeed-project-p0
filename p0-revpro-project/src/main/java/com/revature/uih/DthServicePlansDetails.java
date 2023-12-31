package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.dao.imple.DthServiceDaoImple;
import com.revature.services.imple.DthServicePlanServiceImple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Scanner;

public class DthServicePlansDetails {
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);

    Scanner sc=new Scanner(System.in);
    ShowPlans showPlans=new ShowPlans();
    DthServiceDaoImple dthServiceDaoImple=new DthServiceDaoImple();
    DthServicePlanServiceImple dthServicePlanServiceImple=new DthServicePlanServiceImple();
    public void getAllDthPlansDetails() throws SQLException {
        int choice=0;
        do{
            System.out.println();
            System.out.println("================= DTH Plans Details ====================");
            System.out.println("                                                        ");
            System.out.println("Enter 1 - For Monthly Plans");
            System.out.println("Enter 2 - For Quarterly Plans");
            System.out.println("Enter 3 - For Purchased plan");
            System.out.println("Enter 4 - For see Active Dth Plan");
            System.out.println("Enter 0 - Exit");
            System.out.print("Enter your choice :- ");
            int check=sc.nextInt();
            sc.nextLine();
            switch (check){
                case 1:dthServicePlanServiceImple.getDthPlansBasedOnMQE("MONTHOLY");
                break;
                case 2:dthServicePlanServiceImple.getDthPlansBasedOnMQE("QUATERLY");
                    break;
                case 3:
                    showPlans.addDthPlansToUserOrPerchesedPlan();
                    break;
                case 4:
                   dthServiceDaoImple.getSubscribedPlandForDTH();
                case 0:
                    return;

                default:
                    logger.warn("Wrong input");
                    System.out.println("Wrong input");

            }
            System.out.println("Want to continue with dth service press -1 otherwise press any key");
            choice= sc.nextInt();
            sc.nextLine();
        }while(choice==1);

    }
}
