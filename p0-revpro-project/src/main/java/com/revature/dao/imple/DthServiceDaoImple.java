package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import com.revature.config.DbConnection;
import com.revature.dao.DthServiceDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DthServiceDaoImple implements DthServiceDao {
    Connection connection = DbConnection.getConnection();
    GEmailSender gEmailSender=new GEmailSender();
    static  String from="aakashsolanke99@gmail.com";
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
    }


     @Override
        public void purchasedDthPlansOraddPlanToUser(int userId, int broadbandPlanId, int dthPlanId, LocalDate startDate, java.time.LocalDate endDate) {

        try {
            String query = "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,is_active) VALUES (?, ?, ?, ?, ?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, userId);
                ps.setInt(2, broadbandPlanId);
                ps.setInt(3, dthPlanId);
                ps.setDate(4,  Date.valueOf(startDate));
                ps.setDate(5,  Date.valueOf(endDate));
                ps.setInt(6,1);

                String subject="DTH Plan Purchase Confirmation";
                String text="We are excited to inform you that your recent purchase of a DTH plan on RevSpeed has been successfully processed. Thank you for choosing our services!";
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    String email=UserDaoImple.userEmailId;
                    gEmailSender.sendEmail(email,from,subject,text);

                    System.out.println("Dth plan added successfully for user " + userId);
                } else {
                    System.out.println("Failed to add Dth plan for user " + userId);
                }
            }
        } catch (SQLException e) {
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

}
