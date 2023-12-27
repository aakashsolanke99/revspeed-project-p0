package com.revature.dao;

import com.revature.dao.imple.UserDaoImple;
import com.revature.util.BroadBandServicePlans;
import com.revature.util.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface BroadbandServicePlansDao {
    public List<BroadBandServicePlans> getAllPlans();
    public List<BroadBandServicePlans> getPlansBasedOnMonthlyQuarterlyYearly(String str);

    public User getDetails(int id) throws SQLException;

    public void addUserAndPlansToUserServiceLink(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate);
    public String isWhichTypeOfPlan(int id) throws SQLException;

    public void planOptOutForBroadBand() throws SQLException;

    public void getSubscribedPlandForBroadBand() throws SQLException;
}
