package com.revature.dao.imple;

import com.revature.Main.GEmailSender;
import com.revature.util.BroadBandServicePlans;
import com.revature.util.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BroadbandServicePlansDaoImpleTest {

    @Mock
    private GEmailSender mockGEmailSender;

    @Mock
    private BroadbandServicePlansDaoImple broadbandServicePlansDaoImpleUnderTest;

    @BeforeEach
    void setUp() {
        broadbandServicePlansDaoImpleUnderTest = new BroadbandServicePlansDaoImple();
        broadbandServicePlansDaoImpleUnderTest.gEmailSender = mockGEmailSender;
    }

    @Test
    void testGetAllPlans() {
        // Setup
        // Run the test
        final List<BroadBandServicePlans> result = broadbandServicePlansDaoImpleUnderTest.getAllPlans();

        // Verify the results
    }

    @Test
    void testGetPlansBasedOnMonthlyQuarterlyYearly() {
        // Setup
        // Run the test
        final List<BroadBandServicePlans> result = broadbandServicePlansDaoImpleUnderTest.getPlansBasedOnMonthlyQuarterlyYearly(
                "str");

        // Verify the results
    }


    @Test
    void testGetDetails_ThrowsSQLException() {
        // Setup
        // Run the test
        assertThrows(SQLException.class, () -> broadbandServicePlansDaoImpleUnderTest.getDetails(0));
    }

//    @Test
//    void testAddUserAndPlansToUserServiceLink() {
//        // Setup
//        // Run the test
////        broadbandServicePlansDaoImpleUnderTest.addUserAndPlansToUserServiceLink(0, 0, 0, LocalDate.of(2020, 1, 1),
////                LocalDate.of(2020, 1, 1));
//
//        // Verify the results
//        verify(mockGEmailSender).sendEmail("userEmailId", "from", "Broad Band Plan Purchase Confirmation",
//                "We are excited to inform you that your recent purchase of a BroadBand plan on RevSpeed has been successfully processed. Thank you for choosing our services!");
//    }

    @Test
    void testIsWhichTypeOfPlan() throws Exception {
        assertEquals("", broadbandServicePlansDaoImpleUnderTest.isWhichTypeOfPlan(0));
//        assertThrows(SQLException.class, () -> broadbandServicePlansDaoImpleUnderTest.isWhichTypeOfPlan(0));
    }

    @Test
    void testPlanOptOutForBroadBand() throws Exception {
        // Setup
        // Run the test
        broadbandServicePlansDaoImpleUnderTest.planOptOutForBroadBand();

        // Verify the results
    }



    @Test
    void testGetSubscribedPlandForBroadBand() throws Exception {
        // Setup
        // Run the test
        broadbandServicePlansDaoImpleUnderTest.getSubscribedPlandForBroadBand();

        // Verify the results
    }

}
