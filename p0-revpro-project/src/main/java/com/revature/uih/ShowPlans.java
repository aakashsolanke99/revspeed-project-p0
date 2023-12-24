package com.revature.uih;

import com.revature.dao.BroadbandServicePlansDao;
import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.util.BroadBandServicePlans;

import java.util.List;

public class ShowPlans {

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
}
