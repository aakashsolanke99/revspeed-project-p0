package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import com.revature.config.DbConnection;
import com.revature.dao.BroadbandServicePlansDao;
import com.revature.util.BroadBandServicePlans;
import com.revature.util.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BroadbandServicePlansDaoImple implements BroadbandServicePlansDao {
    GEmailSender gEmailSender=new GEmailSender();
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);

    static Connection connection= DbConnection.getConnection();
    static  String from="aakashsolanke99@gmail.com";
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
            int rowsAffected = st.executeUpdate();
            if (rowsAffected > 0) {

                logger.info("All Broadband Planed successful fetch");
            } else {
                logger.warn("Not able to fetch plan successful");
            }

        } catch (SQLException e) {
            logger.error("Error during getting all plan");
            throw new RuntimeException(e);
        }

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

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Plans get Successfully");
            } else {
                logger.warn("Plans does Not get Successfully");
            }
        } catch (SQLException e) {
            logger.warn("Error during getting plans based on month year and quarter");
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
//        int rowsAffected = ps.executeUpdate();
//        if (rowsAffected > 0) {
//            logger.info("Users Details get Successfully");
//        } else {
//            logger.warn("Users Details Not get Successfully");
//        }


        return user;
    }


    @Override
    public void addUserAndPlansToUserServiceLink(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, LocalDate endDate) {
        try {
            String query = "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,Broad_is_active,Dth_is_active) VALUES (?, ?, ?, ?, ?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, broadbandPlanId);
                ps.setInt(3, dthPlanId);
                ps.setDate(4,  Date.valueOf(startDate));
                ps.setDate(5,  Date.valueOf(endDate));
                ps.setInt(6,1);
                ps.setInt(7,0);

                String subject="Broad Band Plan Purchase Confirmation";
                String text="We are excited to inform you that your recent purchase of a BroadBand plan on RevSpeed has been successfully processed. Thank you for choosing our services!";
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    String email=UserDaoImple.userEmailId;
                    gEmailSender.sendEmail(email,from,subject,text);
                    System.out.println("BroadBand Service plan added successfully for user " + userId);
                    logger.info("BroadBand Service plan added successfully for user " + userId);
                    System.out.println();
                } else {
                    System.out.println("Failed to add service plan for user " + userId);
                    logger.warn("Failed to add service plan for user " + userId);
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            logger.error("Error during adding plan to user");
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

    @Override
    public void planOptOutForBroadBand() throws SQLException {
            String sql="UPDATE user_service_link SET Broad_is_active =0  WHERE user_id = ? AND subscription_end_date <= CURDATE()";
            PreparedStatement ps= connection.prepareStatement(sql);
            ps.setInt(1,UserDaoImple.loginId);
            ps.executeUpdate();
//            System.out.println("Plan opt out");
        }

    @Override
    public void getSubscribedPlandForBroadBand() throws SQLException {
        String query= "{ call getsubscribePlanForBroadBand(?) }";

        CallableStatement ps=connection.prepareCall(query);
        ps.setInt(1,UserDaoImple.loginId);
        ResultSet rs= ps.executeQuery();

        System.out.println(rs);
        System.out.println("======================================================= Active Broad Band Plans =========================================================");
        System.out.println("                                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %15s %10s %15s %12s %20s","service Name","Plan type","Plan Details","Amoount","subscription start date","subscription end date","OTT platform");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        while (rs.next()){
//            int id=rs.getInt(1);
//            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getDate(6)+"\t"+rs.getDate(7)+"\t"+rs.getString(8));
            System.out.printf("%10s %10s %18s %10s %15s %15s %30s",rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6),rs.getDate(7),rs.getString(8));
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            logger.info("Active plan Details get Successfully");
        } else {
            logger.warn("Active plan Details Not get Successfully");
        }


    }
}



