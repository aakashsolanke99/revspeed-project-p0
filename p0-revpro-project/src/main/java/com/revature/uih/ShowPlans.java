package com.revature.uih;

import com.revature.dao.BroadbandServicePlansDao;
import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.dao.imple.UserDaoImple;
import com.revature.services.imple.BroadBandPlansServiceImple;
import com.revature.util.BroadBandServicePlans;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ShowPlans {

    BroadBandPlansServiceImple broadBandPlansServiceImple=new BroadBandPlansServiceImple();
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    public void AllPlans() {

        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getAllPlans();
        System.out.println("================= All Plans ============");
        System.out.println("                                          ");
        System.out.println("======================================================================");
        System.out.println("plan id\tPlan Type\tDescription\tAmountt\t service name\tott platform");
        System.out.println("======================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.println(p.getPalnId() + "\t" + p.getSubscription() + "\t" + p.getPalnDetails() + "\t" + p.getAmount() + "\t" + p.getServiceName() + "\t" + p.getOttPlatformName());
        }
        System.out.println("                                                                          ");
    }

    public void getMonthlyPlans(){
        String plan="Montholy";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("================= Montly Plans ============");
        System.out.println("                                          ");
        System.out.println("======================================================================");
        System.out.println("plan id\tPlan Type\tDescription\tAmountt\t service name\tott platform");
        System.out.println("======================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.println(p.getPalnId() + "\t" + p.getSubscription() + "\t" + p.getPalnDetails() + "\t" + p.getAmount() + "\t" + p.getServiceName() + "\t" + p.getOttPlatformName());
        }
        System.out.println("                                                                          ");
    }

    public void getQuaterlyPlans(){
        String plan="QUATERLY";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("================= Quaterly Plans ============");
        System.out.println("                                          ");
        System.out.println("======================================================================");
        System.out.println("plan id\tPlan Type\tDescription\tAmountt\t service name\tott platform");
        System.out.println("======================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.println(p.getPalnId() + "\t" + p.getSubscription() + "\t" + p.getPalnDetails() + "\t" + p.getAmount() + "\t" + p.getServiceName() + "\t" + p.getOttPlatformName());
        }
        System.out.println("                                                                          ");
    }
    public void getYearlyPlans(){
        String plan="YEARLY";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("================= Yearly Plans ============");
        System.out.println("                                          ");
        System.out.println("======================================================================");
        System.out.println("plan id\tPlan Type\tDescription\tAmountt\t service name\tott platform");
        System.out.println("======================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.println(p.getPalnId() + "\t" + p.getSubscription() + "\t" + p.getPalnDetails() + "\t" + p.getAmount() + "\t" + p.getServiceName() + "\t" + p.getOttPlatformName());
        }
        System.out.println("                                                                          ");
    }


    public void addPlansToUser() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter plan Id For For Plans");
        int planId=sc.nextInt();
        int userId= UserDaoImple.loginId;
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusDays(28);

        String plan=broadBandPlansServiceImple.isWhichTypeOfPlan(planId);
        if(plan.equals("MONTHOLY")){
            endDate=currentDate.plusDays(28);
        }else if(plan.equals("QUATERLY")){
            endDate=currentDate.plusDays(90);
        }else{
            endDate=currentDate.plusDays(365);
        }
        broadBandPlansServiceImple.addPlanToUser(userId,planId,1,currentDate,endDate);
    }
}
