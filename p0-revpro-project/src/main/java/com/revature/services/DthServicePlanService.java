package com.revature.services;

import java.sql.SQLException;
import java.time.LocalDate;

public interface DthServicePlanService {
    public void getDthPlansBasedOnMQE(String str) throws SQLException;
//    public void purchasedDthPlansService() throws SQLException;
    public void addDthPlanToUserService(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate);

    public String isWhichTypeOfPlan(int id) throws SQLException;
}
