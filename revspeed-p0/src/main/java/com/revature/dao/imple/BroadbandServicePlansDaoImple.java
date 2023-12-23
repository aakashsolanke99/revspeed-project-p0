package com.revature.dao.imple;

import com.revature.config.DbConnection;
import com.revature.dao.BroadbandServicePlansDao;
import com.revature.utile.BroadBandServicePlans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BroadbandServicePlansDaoImple implements BroadbandServicePlansDao {

    static Connection connection=DbConnection.getConnection();
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
}
