package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import com.revature.config.DbConnection;
import com.revature.dao.DthServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DthServiceDaoImple implements DthServiceDao {
    Connection connection = DbConnection.getConnection();
    GEmailSender gEmailSender=new GEmailSender();
    static  String from="aakashsolanke99@gmail.com";
    public static final Logger logger= LoggerFactory.getLogger(BroadbandServicePlansDaoImple.class);


    @Override
    public void purchasedDthPlansOraddPlanToUser(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, java.time.LocalDate endDate) {

        try {
            String query = "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,Broad_is_active,Dth_is_active) VALUES (?, ?, ?, ?, ?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, broadbandPlanId);
                ps.setInt(3, dthPlanId);
                ps.setDate(4,  Date.valueOf(startDate));
                ps.setDate(5,  Date.valueOf(endDate));
                ps.setInt(6,0);
                ps.setInt(7,1);

                String subject="DTH Plan Purchase Confirmation";
                String text="We are excited to inform you that your recent purchase of a DTH plan on RevSpeed has been successfully processed. Thank you for choosing our services!";
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    String email=UserDaoImple.userEmailId;
                    gEmailSender.sendEmail(email,from,subject,text);

                    System.out.println("Dth plan added successfully for user " + userId);
                    logger.info("Dth plan added successfully for user " + userId);
                } else {
                    System.out.println("Failed to add Dth plan for user " + userId);
                    logger.warn("Failed to add Dth plan for user " + userId);
                }
            }
        } catch (SQLException e) {
            logger.error("Error during user adding plans to user ");
            e.printStackTrace();
        }

    }

    @Override
    public String isWhichTypeOfPlan(int id) throws SQLException {
        String plan="";
        String query="select plan from dth_service_plans where dth_sr_pl_id=?";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            plan=rs.getString(1);
        }
        return plan;
    }

    @Override
    public void planOptOutForDth() throws SQLException {
        String sql="UPDATE user_service_link SET Dth_is_active =0  WHERE user_id = ? AND subscription_end_date <= CURDATE()";
        PreparedStatement ps= connection.prepareStatement(sql);
        ps.setInt(1,UserDaoImple.loginId);
        ps.executeUpdate();
        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {

            logger.info("Plane opt out successful");
        } else {
            logger.warn("Plan Not opt out successful");
        }
    }

    @Override
    public void getDthPlansBasedOnMQEDao(String str) throws SQLException {
        String query="{CALL getPlansBasedOnMQ(?)}";
        CallableStatement cs=connection.prepareCall(query);
        cs.setString(1,str);
         ResultSet rs= cs.executeQuery();
        System.out.println("======================================================= DTH Plans =========================================================");
        System.out.println("                                          ");
        System.out.println("==============================================================================================================================");
        System.out.printf("%10s %10s %10s %19s %16s %32s","plan id","Plan Type","Language","channel category","Amount","chanel names");
        System.out.println();
        System.out.println("==============================================================================================================================");

//        System.out.println("plan Id\tDth plans\tLanguage\tchannel category\tprice\tname");
        while (rs.next()){
            System.out.printf("%10s %10s %10s %18s %15s %38s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6));
            System.out.println();
        }
        System.out.println("==============================================================================================================================");
        System.out.println();

        int rowsAffected = cs.executeUpdate();
        if (rowsAffected > 0) {

            logger.info("DTH Planed successful fetch");
        } else {
            logger.warn("DTH Planed successful not fetch");
        }
    }



    @Override
    public void getSubscribedPlandForDTH() throws SQLException {
        String query= "{ call getsubscribePlanForDTH(?) }";

        CallableStatement ps=connection.prepareCall(query);
        ps.setInt(1,UserDaoImple.loginId);
        ResultSet rs= ps.executeQuery();

        System.out.println(rs);
        System.out.println("======================================================= Active DTH  Plans =========================================================");
        System.out.println("                                          ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %10s %15s %10s %15s %12s %20s","service Name","DTH plan","Language","channel category","Amount","subscription start date","subscription end date");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        while (rs.next()){
//            int id=rs.getInt(1);
//            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5)+"\t"+rs.getDate(6)+"\t"+rs.getDate(7)+"\t"+rs.getString(8));
            System.out.printf("%10s %10s %18s %10s %15s %15s %20s",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getDate(8));
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();


        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {

            logger.info("Active Broad Band Plan successful fetch");
        } else {
            logger.warn("Active Broad Band Plan not successful fetch");
        }


    }

}
