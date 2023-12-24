package com.revature.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BroadBnadServicePlansTest {

    private BroadBandServicePlans broadBandServicePlansUnderTest;

    @BeforeEach
    void setUp() {
        broadBandServicePlansUnderTest = new BroadBandServicePlans(0, "subscription", "palnDetails", 0.0, "serviceName",
                "ottPlatformName");
    }

    @Test
    void testPalnIdGetterAndSetter() {
        final int palnId = 0;
        broadBandServicePlansUnderTest.setPalnId(palnId);
        assertEquals(palnId, broadBandServicePlansUnderTest.getPalnId());
    }

    @Test
    void testSubscriptionGetterAndSetter() {
        final String subscription = "subscription";
        broadBandServicePlansUnderTest.setSubscription(subscription);
        assertEquals(subscription, broadBandServicePlansUnderTest.getSubscription());
    }

    @Test
    void testPalnDetailsGetterAndSetter() {
        final String palnDetails = "palnDetails";
        broadBandServicePlansUnderTest.setPalnDetails(palnDetails);
        assertEquals(palnDetails, broadBandServicePlansUnderTest.getPalnDetails());
    }

    @Test
    void testAmountGetterAndSetter() {
        final double amount = 0.0;
        broadBandServicePlansUnderTest.setAmount(amount);
        assertEquals(amount, broadBandServicePlansUnderTest.getAmount(), 0.0001);
    }

    @Test
    void testServiceNameGetterAndSetter() {
        final String serviceName = "serviceName";
        broadBandServicePlansUnderTest.setServiceName(serviceName);
        assertEquals(serviceName, broadBandServicePlansUnderTest.getServiceName());
    }

    @Test
    void testOttPlatformNameGetterAndSetter() {
        final String ottPlatformName = "ottPlatformName";
        broadBandServicePlansUnderTest.setOttPlatformName(ottPlatformName);
        assertEquals(ottPlatformName, broadBandServicePlansUnderTest.getOttPlatformName());
    }
}
