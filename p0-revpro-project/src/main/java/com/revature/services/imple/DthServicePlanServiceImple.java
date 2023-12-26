package com.revature.services.imple;

import com.revature.dao.imple.DthServiceDaoImple;
import com.revature.services.DthServicePlanService;

import java.sql.SQLException;
import java.time.LocalDate;

public class DthServicePlanServiceImple implements DthServicePlanService {
    DthServiceDaoImple dthServiceDaoImple=new DthServiceDaoImple();
    @Override
    public void getDthPlansBasedOnMQE(String str) throws SQLException {
        dthServiceDaoImple.getDthPlansBasedOnMQEDao(str);
    }

//    @Override
//    public void purchasedDthPlansService() throws SQLException {
//        dthServiceDaoImple.purchasedDthPlans();
//    }

    @Override
    public void addDthPlanToUserService(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate) {
        dthServiceDaoImple.purchasedDthPlansOraddPlanToUser(userId,broadbandPlanId,dthPlanId,startDate,endDate);
    }

    @Override
    public String isWhichTypeOfPlan(int id) throws SQLException {
        return dthServiceDaoImple.isWhichTypeOfPlan( id);
    }
}
