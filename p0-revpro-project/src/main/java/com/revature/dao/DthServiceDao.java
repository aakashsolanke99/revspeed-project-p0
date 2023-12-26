package com.revature.dao;

import java.sql.SQLException;
import java.time.LocalDate;

public interface DthServiceDao {
    public void getDthPlansBasedOnMQEDao(String str) throws SQLException;
    public void purchasedDthPlansOraddPlanToUser(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, java.time.LocalDate endDate) throws SQLException;
    public String isWhichTypeOfPlan(int id) throws SQLException;
}
