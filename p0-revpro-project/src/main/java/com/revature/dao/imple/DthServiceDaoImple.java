package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.dao.DthServiceDao;

import java.sql.*;
import java.util.Scanner;

public class DthServiceDaoImple implements DthServiceDao {
    Connection connection = DbConnection.getConnection();

    @Override
    public void getDthPlansBasedOnMQEDao(String str) throws SQLException {
        String query="{CALL getDthPlanBasedOnMQE(?)}";
        CallableStatement cs=connection.prepareCall(query);
        cs.setString(1,str);
         ResultSet rs= cs.executeQuery();
        System.out.println("Dth plans\tLanguage\tchannel category\tname\tprice");
        while (rs.next()){
            System.out.println(rs.getString(1)+"  \t"+rs.getString(2)+"  \t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));

        }
    }


    public void purchasedDthPlans() throws SQLException{

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter plan type (e.g., monthly, quarterly, yearly): ");
        String planType = scanner.nextLine();

        System.out.print("Enter language (e.g., hindi): ");
        String language = scanner.nextLine();

        System.out.print("Enter channel category (e.g., entertainment, sports): ");
        String channelCategory = scanner.nextLine();

        // Create a parameterized SQL query
        String sql = "SELECT ds.dth_sr_id, ds.service_id, ds.dth_service_plans, " +
                "dsp.dth_sr_pl_id, dsp.language, dsp.channel_category, dsp.price, " +
                "dcd.dth_chnl_dt_id, dcd.channel_name, dcd.price " +
                "FROM DTH_service AS ds " +
                "JOIN DTH_service_plans AS dsp ON ds.dth_sr_id = dsp.dth_sr_id " +
                "JOIN DTH_channel_details AS dcd ON dsp.dth_sr_pl_id = dcd.dth_chnl_id " +
                "WHERE ds.dth_service_plans = ? AND dsp.language = ? AND dsp.channel_category = ?";

        // Prepare the statement
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set parameters
            preparedStatement.setString(1, planType);
            preparedStatement.setString(2, language);
            preparedStatement.setString(3, channelCategory);

            // Execute the query
            double totalAmount = 0.0;

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Process the result set
                while (resultSet.next()) {
                    // Retrieve and print the data
                    int dthSrId = resultSet.getInt("dth_sr_id");
                    String channelName = resultSet.getString("channel_name");
                    double channelPrice = resultSet.getDouble("price");

                    System.out.println("DTH Service ID: " + dthSrId);
                    System.out.println("Channel Name: " + channelName);
                    System.out.println("Channel Price: " + channelPrice);

                    // Accumulate the total amount
                    totalAmount += channelPrice;
                }
            }

            // Print the total amount
            System.out.println("Total Amount: " + totalAmount);
        }

        // Close the connection
        connection.close();
    } 

}
