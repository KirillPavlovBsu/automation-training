package pageobject;

public class SearchCarrental {
    private String pickupCity;
    private String dropoffCity;
    private String datePickup;
    private String dateDropoff;

    public SearchCarrental(String pickupCity, String datePickup, String dateDropoff, String dropoffCity){
        this.pickupCity = pickupCity;
        this.dropoffCity = dropoffCity;
        this.dateDropoff = dateDropoff;
        this.datePickup = datePickup;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public String getDatePickup() {
        return datePickup;
    }

    public String getDateDropoff() {
        return dateDropoff;
    }
}
