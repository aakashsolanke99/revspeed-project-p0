package com.revature.dao;

import com.revature.utile.BroadBandServicePlans;

import java.util.List;

public interface BroadbandServicePlansDao {
    public List<BroadBandServicePlans> getAllPlans();
    public List<BroadBandServicePlans> getPlansBasedOnMonthlyQuarterlyYearly(String str);
}
