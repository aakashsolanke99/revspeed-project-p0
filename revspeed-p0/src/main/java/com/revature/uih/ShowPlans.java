package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.utile.BroadBandServicePlans;

import java.util.List;

public class ShowPlans {
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    public void AllPlans(){
        List<BroadBandServicePlans> broadBandServicePlans=broadbandServicePlansDaoImple.getAllPlans();
        System.out.println("================= All Plans ============");
        System.out.println("                                          ");
        System.out.println("Plan Type"+"/t+");
    }
}
