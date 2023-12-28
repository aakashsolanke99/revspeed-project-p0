package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DthServiceDaoImpleTest {

    @Mock
    private Connection mockConnection;
    @Mock
    private GEmailSender mockGEmailSender;

    private DthServiceDaoImple dthServiceDaoImpleUnderTest;

    @BeforeEach
    void setUp() {
        dthServiceDaoImpleUnderTest = new DthServiceDaoImple();
        dthServiceDaoImpleUnderTest.connection = mockConnection;
        dthServiceDaoImpleUnderTest.gEmailSender = mockGEmailSender;
    }

    @Test
    void testPurchasedDthPlansOraddPlanToUser() throws Exception {

//        GEmailSender mockGEmailSender = mock(GEmailSender.class);
//        when(mockGEmailSender.sendEmail(anyString(), anyString(), anyString(), anyString())).thenReturn(true);

        final PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(
                "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,Broad_is_active,Dth_is_active) VALUES (?, ?, ?, ?, ?,?,?)"))
                .thenReturn(mockPreparedStatement);

        dthServiceDaoImpleUnderTest.purchasedDthPlansOraddPlanToUser(0, 0, 0, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

//        verify(mockGEmailSender).sendEmail(eq("userEmailId"), eq("from"),
//                eq("DTH Plan Purchase Confirmation"),
//                eq("We are excited to inform you that your recent purchase of a DTH plan on RevSpeed has been successfully processed. Thank you for choosing our services!"));
    }

    @Test
    void testPurchasedDthPlansOraddPlanToUser_ConnectionThrowsSQLException() throws Exception {
        // Setup
        when(mockConnection.prepareStatement(
                "INSERT INTO user_service_link (user_id, br_sr_pl_id, dth_sr_pl_id, subscription_start_date, subscription_end_date,Broad_is_active,Dth_is_active) VALUES (?, ?, ?, ?, ?,?,?)"))
                .thenThrow(SQLException.class);

        // Run the test
        dthServiceDaoImpleUnderTest.purchasedDthPlansOraddPlanToUser(0, 0, 0, LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 1));

        // Verify the results
    }

    @Test
    void testIsWhichTypeOfPlan() throws Exception {
        final PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        final ResultSet mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement("select plan from dth_service_plans where dth_sr_pl_id=?"))
                .thenReturn(mockPreparedStatement);


        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);


        when(mockResultSet.next()).thenReturn(false);


        final String result = dthServiceDaoImpleUnderTest.isWhichTypeOfPlan(0);


        assertEquals("", result);


    }

    @Test
    void testIsWhichTypeOfPlan_ConnectionThrowsSQLException() throws Exception {
        // Setup
        when(mockConnection.prepareStatement("select plan from dth_service_plans where dth_sr_pl_id=?"))
                .thenThrow(SQLException.class);

        // Run the test
        assertThrows(SQLException.class, () -> dthServiceDaoImpleUnderTest.isWhichTypeOfPlan(0));
    }

    @Test
    void testPlanOptOutForDth() throws Exception {
        // Setup
        // Configure Connection.prepareStatement(...).
        final PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(
                "UPDATE user_service_link SET Dth_is_active =0  WHERE user_id = ? AND subscription_end_date <= CURDATE()"))
                .thenReturn(mockPreparedStatement);

        // Run the test
        dthServiceDaoImpleUnderTest.planOptOutForDth();

    }

    @Test
    void testPlanOptOutForDth_ConnectionThrowsSQLException() throws Exception {
        // Setup
        when(mockConnection.prepareStatement(
                "UPDATE user_service_link SET Dth_is_active =0  WHERE user_id = ? AND subscription_end_date <= CURDATE()"))
                .thenThrow(SQLException.class);

        // Run the test
        assertThrows(SQLException.class, () -> dthServiceDaoImpleUnderTest.planOptOutForDth());
    }

    @Test
    void testGetDthPlansBasedOnMQEDao() throws Exception {

        final CallableStatement mockCallableStatement = mock(CallableStatement.class);
        final ResultSet mockResultSet = mock(ResultSet.class);
        when(mockConnection.prepareCall("{CALL getPlansBasedOnMQ(?)}")).thenReturn(mockCallableStatement);
        when(mockCallableStatement.executeQuery()).thenReturn(mockResultSet);

        // Run the test
        dthServiceDaoImpleUnderTest.getDthPlansBasedOnMQEDao("str");

    }

    @Test
    void testGetDthPlansBasedOnMQEDao_ConnectionThrowsSQLException() throws Exception {
        // Setup
        when(mockConnection.prepareCall("{CALL getPlansBasedOnMQ(?)}")).thenThrow(SQLException.class);

        // Run the test
        assertThrows(SQLException.class, () -> dthServiceDaoImpleUnderTest.getDthPlansBasedOnMQEDao("str"));
    }

    @Test
    void testGetSubscribedPlandForDTH() throws Exception {

        final ResultSet mockResultSet = mock(ResultSet.class);
        final CallableStatement mockCallableStatement = mock(CallableStatement.class);

        when(mockCallableStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockConnection.prepareCall("{ call getsubscribePlanForDTH(?) }")).thenReturn(mockCallableStatement);

        // Run the test
        dthServiceDaoImpleUnderTest.getSubscribedPlandForDTH();

    }

    @Test
    void testGetSubscribedPlandForDTH_ConnectionThrowsSQLException() throws Exception {
        // Setup
        when(mockConnection.prepareCall("{ call getsubscribePlanForDTH(?) }")).thenThrow(SQLException.class);

        // Run the test
        assertThrows(SQLException.class, () -> dthServiceDaoImpleUnderTest.getSubscribedPlandForDTH());
    }
}
