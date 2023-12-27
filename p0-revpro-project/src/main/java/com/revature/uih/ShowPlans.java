package com.revature.uih;

import com.revature.dao.BroadbandServicePlansDao;
import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.dao.imple.UserDaoImple;
import com.revature.services.imple.BroadBandPlansServiceImple;
import com.revature.services.imple.DthServicePlanServiceImple;
import com.revature.util.BroadBandServicePlans;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ShowPlans {
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);


    DthServicePlanServiceImple dthServicePlanServiceImple=new DthServicePlanServiceImple();
    BroadBandPlansServiceImple broadBandPlansServiceImple=new BroadBandPlansServiceImple();
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    public void AllPlans() {

        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getAllPlans();
        System.out.println("==================================================== All Plans ==============================================================");
        System.out.println("                                          ");
        System.out.println("==============================================================================================================================");
        System.out.printf("%10s %10s %20s %10s %18s %27s","plan id","Plan Type","Description","Amountt","service name","ott platform");
        System.out.println();
        System.out.println("==============================================================================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.printf("%10s %10s %20s %10s %15s %32s",p.getPalnId() , p.getSubscription() , p.getPalnDetails() , p.getAmount() , p.getServiceName() ,p.getOttPlatformName());
            System.out.println();
        }
        System.out.println("================================================================================================================================");
        System.out.println("                                                                          ");
    }

    public void getMonthlyPlans(){
        String plan="Montholy";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("===================================================== Monthly Plans ==========================================================");
        System.out.println("                                          ");
        System.out.println("==============================================================================================================================");
        System.out.printf("%10s %10s %20s %10s %18s %27s","plan id","Plan Type","Description","Amount","service name","ott platform");
        System.out.println();
        System.out.println("==============================================================================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.printf("%10s %10s %20s %10s %15s %32s",p.getPalnId() , p.getSubscription() , p.getPalnDetails() , p.getAmount() , p.getServiceName() ,p.getOttPlatformName());
            System.out.println();
        }
        System.out.println("================================================================================================================================");
        System.out.println("                                                                          ");
    }

    public void getQuaterlyPlans(){
        String plan="QUATERLY";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("===================================================== Quarterly Plans ========================================================");
        System.out.println("                                          ");
        System.out.println("==============================================================================================================================");
        System.out.printf("%10s %10s %20s %10s %18s %27s","plan id","Plan Type","Description","Amountt","service name","ott platform");
        System.out.println();
        System.out.println("==============================================================================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.printf("%10s %10s %20s %10s %15s %32s",p.getPalnId() , p.getSubscription() , p.getPalnDetails() , p.getAmount() , p.getServiceName() ,p.getOttPlatformName());
            System.out.println();
        }
        System.out.println("================================================================================================================================");
        System.out.println("                                                                          ");
    }
    public void getYearlyPlans(){
        String plan="YEARLY";
        List<BroadBandServicePlans> broadBandServicePlans = broadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(plan);
        System.out.println("======================================================= Yearly Plans =========================================================");
        System.out.println("                                          ");
        System.out.println("==============================================================================================================================");
        System.out.printf("%10s %10s %20s %10s %18s %27s","plan id","Plan Type","Description","Amountt","service name","ott platform");
        System.out.println();
        System.out.println("==============================================================================================================================");

        for (BroadBandServicePlans p : broadBandServicePlans) {
            System.out.printf("%10s %10s %20s %10s %15s %32s",p.getPalnId() , p.getSubscription() , p.getPalnDetails() , p.getAmount() , p.getServiceName() ,p.getOttPlatformName());
            System.out.println();
        }
        System.out.println("================================================================================================================================");
        System.out.println("                                                                          ");
    }


    public void addBroadBandPlansToUser() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter plan Id For Plan purchased :- ");
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


    public void addDthPlansToUserOrPerchesedPlan() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter plan Id For For Plans");
        int DthplanId=sc.nextInt();
        int userId= UserDaoImple.loginId;
//        System.out.println(userId+"this is usr id of login users");
        LocalDate currentDate = LocalDate.now();
        LocalDate endDate = currentDate.plusDays(28);

        String plan=dthServicePlanServiceImple.isWhichTypeOfPlan(DthplanId);
        if(plan.equals("MONTHOLY")){
            endDate=currentDate.plusDays(28);
        }else if(plan.equals("QUATERLY")){
            endDate=currentDate.plusDays(90);
        }
        dthServicePlanServiceImple.addDthPlanToUserService(userId,1,DthplanId,currentDate,endDate);
    }
}
