package com.revature.utile;

public class BroadBandServicePlans {

    private int palnId;
    private String subscription;
    private String palnDetails;
    private double amount;
    private String serviceName;
    private String ottPlatformName;

    public BroadBandServicePlans() {
    }

    public BroadBandServicePlans(int palnId, String subscription, String palnDetails, double amount, String serviceName, String ottPlatformName) {
        this.palnId = palnId;
        this.subscription = subscription;
        this.palnDetails = palnDetails;
        this.amount = amount;
        this.serviceName = serviceName;
        this.ottPlatformName = ottPlatformName;
    }

    public int getPalnId() {
        return palnId;
    }

    public void setPalnId(int palnId) {
        this.palnId = palnId;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getPalnDetails() {
        return palnDetails;
    }

    public void setPalnDetails(String palnDetails) {
        this.palnDetails = palnDetails;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOttPlatformName() {
        return ottPlatformName;
    }

    public void setOttPlatformName(String ottPlatformName) {
        this.ottPlatformName = ottPlatformName;
    }
}
