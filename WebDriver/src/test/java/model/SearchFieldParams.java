package model;

import java.util.Objects;

public class SearchFieldParams {
    private String pickupCity;
    private String dropoffCity;
    private String datePickup;
    private String dateDropoff;
    private String timeOptionPickup;
    private String timeOptionDropoff;


    public SearchFieldParams(String pickupCity, String dropoffCity, String datePickup, String dateDropoff, String timeOptionPickup, String timeOptionDropoff) {
        this.pickupCity = pickupCity;
        this.dropoffCity = dropoffCity;
        this.datePickup = datePickup;
        this.dateDropoff = dateDropoff;
        this.timeOptionPickup = timeOptionPickup;
        this.timeOptionDropoff = timeOptionDropoff;
    }

    public String getTimeOptionPickup() {
        return timeOptionPickup;
    }

    public void setTimeOptionPickup(String timeOptionPickup) {
        this.timeOptionPickup = timeOptionPickup;
    }

    public String getTimeOptionDropoff() {
        return timeOptionDropoff;
    }

    public void setTimeOptionDropoff(String timeOptionDropoff) {
        this.timeOptionDropoff = timeOptionDropoff;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchFieldParams that = (SearchFieldParams) o;
        return Objects.equals(getPickupCity(), that.getPickupCity()) &&
                Objects.equals(getDropoffCity(), that.getDropoffCity()) &&
                Objects.equals(getDatePickup(), that.getDatePickup()) &&
                Objects.equals(getDateDropoff(), that.getDateDropoff()) &&
                Objects.equals(getTimeOptionPickup(), that.getTimeOptionPickup()) &&
                Objects.equals(getTimeOptionDropoff(), that.getTimeOptionDropoff());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPickupCity(), getDropoffCity(), getDatePickup(), getDateDropoff(), getTimeOptionPickup(), getTimeOptionDropoff());
    }

    @Override
    public String toString() {
        return "SearchFieldParams{" +
                "pickupCity='" + pickupCity + '\'' +
                ", dropoffCity='" + dropoffCity + '\'' +
                ", datePickup='" + datePickup + '\'' +
                ", dateDropoff='" + dateDropoff + '\'' +
                ", timeOptionPickup='" + timeOptionPickup + '\'' +
                ", timeOptionDropoff='" + timeOptionDropoff + '\'' +
                '}';
    }
}
