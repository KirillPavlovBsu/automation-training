package model;

public class SearchFieldParams {
    private String pickupCity;
    private String dropoffCity;
    private String datePickup;
    private String dateDropoff;


    public SearchFieldParams(String pickupCity,String datePickup, String dateDropoff, String dropoffCity){
        this.pickupCity = pickupCity;
        this.dropoffCity = dropoffCity;
        this.dateDropoff = dateDropoff;
        this.datePickup = datePickup;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getDatePickup() {
        return datePickup;
    }

    public void setDatePickup(String datePickup) {
        this.datePickup = datePickup;
    }

    public String getDateDropoff() {
        return dateDropoff;
    }

    public void setDateDropoff(String dateDropoff) {
        this.dateDropoff = dateDropoff;
    }
}
