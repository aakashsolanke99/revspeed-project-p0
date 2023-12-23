package com.revature.utile;

public class BroadBandServicePlans {

    private int palnId;
    private String subscription;
    private String palnDetails;
    private double amount;
    private int serviceId;
    private int ottPlatformId;

    public BroadBandServicePlans() {
    }

    public BroadBandServicePlans(int palnId, String subscription, String palnDetails, double amount, int serviceId, int ottPlatformId) {
        this.palnId = palnId;
        this.subscription = subscription;
        this.palnDetails = palnDetails;
        this.amount = amount;
        this.serviceId = serviceId;
        this.ottPlatformId = ottPlatformId;
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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getOttPlatformId() {
        return ottPlatformId;
    }

    public void setOttPlatformId(int ottPlatformId) {
        this.ottPlatformId = ottPlatformId;
    }

    @Override
    public String toString() {
        return "BroadBandServicePlans{" +
                "palnId=" + palnId +
                ", subscription='" + subscription + '\'' +
                ", palnDetails='" + palnDetails + '\'' +
                ", amount=" + amount +
                ", serviceId=" + serviceId +
                ", ottPlatformId=" + ottPlatformId +
                '}';
    }
}
