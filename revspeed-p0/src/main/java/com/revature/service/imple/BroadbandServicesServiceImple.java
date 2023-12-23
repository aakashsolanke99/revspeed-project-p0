package com.revature.service.imple;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.service.BroadbandServicesService;
import com.revature.utile.BroadBandServicePlans;

import java.util.List;


public class BroadbandServicesServiceImple implements BroadbandServicesService {
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();

    @Override
    public List<BroadBandServicePlans> getAllBroadbandServicePlans() {

        return broadbandServicePlansDaoImple.getAllPlans();
    }
}
