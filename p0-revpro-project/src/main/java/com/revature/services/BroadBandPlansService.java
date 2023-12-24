package com.revature.services;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public interface BroadBandPlansService {
    public void addPlanToUser(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate);
    public String isWhichTypeOfPlan(int id) throws SQLException;
}
