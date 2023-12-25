package com.revature.dao;

import java.sql.SQLException;

public interface DthServiceDao {
    public void getDthPlansBasedOnMQEDao(String str) throws SQLException;
    public void purchasedDthPlans() throws SQLException;
}
