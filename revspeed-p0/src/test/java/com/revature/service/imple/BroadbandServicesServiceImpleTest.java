package com.revature.service.imple;

import com.revature.dao.imple.BroadbandServicePlansDaoImple;
import com.revature.utile.BroadBandServicePlans;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BroadbandServicesServiceImpleTest {

    @Mock
    private BroadbandServicePlansDaoImple mockBroadbandServicePlansDaoImple;

    private BroadbandServicesServiceImple broadbandServicesServiceImpleUnderTest;

    @BeforeEach
    void setUp() {
        broadbandServicesServiceImpleUnderTest = new BroadbandServicesServiceImple();
        broadbandServicesServiceImpleUnderTest.broadbandServicePlansDaoImple = mockBroadbandServicePlansDaoImple;
    }

    @Test
    void testGetAllBroadbandServicePlans() {
        // Setup
        // Configure BroadbandServicePlansDaoImple.getAllPlans(...).
        final List<BroadBandServicePlans> broadBandServicePlans = List.of(
                new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName", "ottPlatformName"));
        when(mockBroadbandServicePlansDaoImple.getAllPlans()).thenReturn(broadBandServicePlans);

        // Run the test
        final List<BroadBandServicePlans> result = broadbandServicesServiceImpleUnderTest.getAllBroadbandServicePlans();

        // Verify the results
    }

    @Test
    void testGetAllBroadbandServicePlans_BroadbandServicePlansDaoImpleReturnsNoItems() {
        // Setup
        when(mockBroadbandServicePlansDaoImple.getAllPlans()).thenReturn(Collections.emptyList());

        // Run the test
        final List<BroadBandServicePlans> result = broadbandServicesServiceImpleUnderTest.getAllBroadbandServicePlans();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }
}
