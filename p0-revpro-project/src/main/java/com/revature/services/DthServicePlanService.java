package com.revature.services;

import java.sql.SQLException;

public interface DthServicePlanService {
    public void getDthPlansBasedOnMQE(String str) throws SQLException;
    public void purchasedDthPlansService() throws SQLException;
}
