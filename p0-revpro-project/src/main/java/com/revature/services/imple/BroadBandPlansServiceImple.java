package com.revature.services.imple;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.services.BroadBandPlansService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class BroadBandPlansServiceImple implements BroadBandPlansService {
    BroadbandServicePlansDaoImple broadbandServicePlansDaoImple=new BroadbandServicePlansDaoImple();
    @Override
    public void addPlanToUser(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate) {
         broadbandServicePlansDaoImple.addUserAndPlansToUserServiceLink(userId, broadbandPlanId, dthPlanId, startDate, endDate);
    }

    @Override
    public String isWhichTypeOfPlan(int id) throws SQLException {
        return broadbandServicePlansDaoImple.isWhichTypeOfPlan( id);
    }
}
