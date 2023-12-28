package com.revature.uih;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.services.imple.BroadBandPlansServiceImple;
import com.revature.services.imple.DthServicePlanServiceImple;
import com.revature.util.BroadBandServicePlans;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowPlansTest {

    @Mock
    private DthServicePlanServiceImple mockDthServicePlanServiceImple;
    @Mock
    private BroadBandPlansServiceImple mockBroadBandPlansServiceImple;
    @Mock
    private BroadbandServicePlansDaoImple mockBroadbandServicePlansDaoImple;

    private ShowPlans showPlansUnderTest;

    @BeforeEach
    void setUp() {
        showPlansUnderTest = new ShowPlans();
        showPlansUnderTest.dthServicePlanServiceImple = mockDthServicePlanServiceImple;
        showPlansUnderTest.broadBandPlansServiceImple = mockBroadBandPlansServiceImple;
        showPlansUnderTest.broadbandServicePlansDaoImple = mockBroadbandServicePlansDaoImple;
    }

    @Test
    void testAllPlans() {
        // Setup
        // Configure BroadbandServicePlansDaoImple.getAllPlans(...).
        final List<BroadBandServicePlans> broadBandServicePlans = List.of(
                new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName", "ottPlatformName"));
        when(mockBroadbandServicePlansDaoImple.getAllPlans()).thenReturn(broadBandServicePlans);

        // Run the test
        showPlansUnderTest.AllPlans();

        // Verify the results
    }

    @Test
    void testAllPlans_BroadbandServicePlansDaoImpleReturnsNoItems() {
        // Setup
        when(mockBroadbandServicePlansDaoImple.getAllPlans()).thenReturn(Collections.emptyList());

        // Run the test
        showPlansUnderTest.AllPlans();

        // Verify the results
    }

    @Test
    void testGetMonthlyPlans() {
        // Setup
        // Configure BroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(...).
        final List<BroadBandServicePlans> broadBandServicePlans = List.of(
                new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName", "ottPlatformName"));
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("Montholy"))
                .thenReturn(broadBandServicePlans);

        // Run the test
        showPlansUnderTest.getMonthlyPlans();

        // Verify the results
    }

    @Test
    void testGetMonthlyPlans_BroadbandServicePlansDaoImpleReturnsNoItems() {
        // Setup
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("Montholy"))
                .thenReturn(Collections.emptyList());

        // Run the test
        showPlansUnderTest.getMonthlyPlans();

        // Verify the results
    }

    @Test
    void testGetQuaterlyPlans() {
        // Setup
        // Configure BroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(...).
        final List<BroadBandServicePlans> broadBandServicePlans = List.of(
                new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName", "ottPlatformName"));
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("QUATERLY"))
                .thenReturn(broadBandServicePlans);

        // Run the test
        showPlansUnderTest.getQuaterlyPlans();

        // Verify the results
    }

    @Test
    void testGetQuaterlyPlans_BroadbandServicePlansDaoImpleReturnsNoItems() {
        // Setup
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("QUATERLY"))
                .thenReturn(Collections.emptyList());

        // Run the test
        showPlansUnderTest.getQuaterlyPlans();

        // Verify the results
    }

    @Test
    void testGetYearlyPlans() {
        // Setup
        // Configure BroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly(...).
        final List<BroadBandServicePlans> broadBandServicePlans = List.of(
                new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName", "ottPlatformName"));
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("YEARLY"))
                .thenReturn(broadBandServicePlans);

        // Run the test
        showPlansUnderTest.getYearlyPlans();

        // Verify the results
    }

    @Test
    void testGetYearlyPlans_BroadbandServicePlansDaoImpleReturnsNoItems() {
        // Setup
        when(mockBroadbandServicePlansDaoImple.getPlansBasedOnMonthlyQuarterlyYearly("YEARLY"))
                .thenReturn(Collections.emptyList());

        // Run the test
        showPlansUnderTest.getYearlyPlans();

        // Verify the results
    }

}
