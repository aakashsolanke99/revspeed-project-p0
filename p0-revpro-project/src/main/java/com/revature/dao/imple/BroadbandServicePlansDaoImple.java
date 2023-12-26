package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.dao.BroadbandServicePlansDao;
import com.revature.util.BroadBandServicePlans;
import com.revature.util.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BroadbandServicePlansDaoImple implements BroadbandServicePlansDao {

    static Connection connection= DbConnection.getConnection();
    @Override
    public List<BroadBandServicePlans> getAllPlans() {
        List<BroadBandServicePlans> broadBandServicePlans=new ArrayList<>();



        String url= "{CALL getAllPlansDetails()}";
        try {
            CallableStatement st= connection.prepareCall(url);
            ResultSet rs= st.executeQuery();
            while(rs.next()){
                BroadBandServicePlans broadBandServicePlans1=new BroadBandServicePlans();
                broadBandServicePlans1.setPalnId(rs.getInt(1));
                broadBandServicePlans1.setSubscription(rs.getString(2));
                broadBandServicePlans1.setPalnDetails(rs.getString(3));
                broadBandServicePlans1.setAmount(rs.getDouble(4));
                broadBandServicePlans1.setServiceName(rs.getString(5));
                broadBandServicePlans1.setOttPlatformName(rs.getString(6));

                broadBandServicePlans.add(broadBandServicePlans1);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        for(BroadBandServicePlans p:broadBandServicePlans){
//            System.out.println(p);
//        }

        return  broadBandServicePlans;
    }

    @Override
    public List<BroadBandServicePlans> getPlansBasedOnMonthlyQuarterlyYearly(String str) {
        List<BroadBandServicePlans> broadBandServicePlansOnChoice=new ArrayList<>();
        String url= "{CALL GetPlansByMonthQuaterlyYearly(?)}";
        try {
            PreparedStatement ps=connection.prepareCall(url);
            ps.setString(1,str);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                BroadBandServicePlans broadBandServicePlans=new BroadBandServicePlans();
                broadBandServicePlans.setPalnId(rs.getInt(1));
                broadBandServicePlans.setSubscription(rs.getString(2));
                broadBandServicePlans.setPalnDetails(rs.getString(3));
                broadBandServicePlans.setAmount(rs.getDouble(4));
                broadBandServicePlans.setServiceName(rs.getString(5));
                broadBandServicePlans.setOttPlatformName(rs.getString(6));

                broadBandServicePlansOnChoice.add(broadBandServicePlans);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return broadBandServicePlansOnChoice;
    }

    @Override
    public User getDetails(int id) throws SQLException {
        User user=new User();
        String url="Select * from users where user_id=?";

        PreparedStatement ps=connection.prepareStatement(url);
        ps.setInt(1,id);
        ResultSet rs= ps.executeQuery();
        while (rs.next()){
            user.setUserId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setPassWord(rs.getString(5));
            user.setPhoneNumber(rs.getString(6));
            user.setAddress(rs.getString(7));
        }

        return user;
    }


    @Override
    public void addUserAndPlansToUserServiceLink(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate) {
        try {
            String query = "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,is_active) VALUES (?, ?, ?, ?, ?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, broadbandPlanId);
                ps.setInt(3, dthPlanId);
                ps.setDate(4,  Date.valueOf(startDate));
                ps.setDate(5,  Date.valueOf(endDate));
                ps.setInt(6,1);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("BroadBand Service plan added successfully for user " + userId);
                    System.out.println();
                } else {
                    System.out.println("Failed to add service plan for user " + userId);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String isWhichTypeOfPlan(int id) throws SQLException {
        String plan="";
        String query="select plan from broadband_serice_plan where br_sr_pl_id=?";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            plan=rs.getString(1);
        }
        return plan;
    }


}
