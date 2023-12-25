package com.revature.services.imple;

import com.revature.dao.imple.DthServiceDaoImple;
import com.revature.services.DthServicePlanService;

import java.sql.SQLException;

public class DthServicePlanServiceImple implements DthServicePlanService {
    DthServiceDaoImple dthServiceDaoImple=new DthServiceDaoImple();
    @Override
    public void getDthPlansBasedOnMQE(String str) throws SQLException {
        dthServiceDaoImple.getDthPlansBasedOnMQEDao(str);
    }

    @Override
    public void purchasedDthPlansService() throws SQLException {
        dthServiceDaoImple.purchasedDthPlans();
    }
}
