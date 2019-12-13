package service;

import model.SearchFieldParams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParamsCreator {
    private static final String TEST_PICKUP_CITY="testdata.pickup.location";
    private static final String TEST_DROPOFF_CITY="testdata.dropoff.location";
    private static final String TEST_DROPOFF_CITY_WRONG="testdata.dropoff.location.wrong";

    private static String setDatePickup(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MM/dd/yyyy");
        return formatForDateNow.format(dateNow);
    }

    private static String setDateDropoff(){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("/dd/yyyy");
        SimpleDateFormat formatMonthNow= new SimpleDateFormat("MM");
        int month = Integer.parseInt(formatMonthNow.format(dateNow))%12+1;
        return month + formatForDateNow.format(dateNow);
    }

    public static SearchFieldParams withCredentialsFromProperty(){
        return new SearchFieldParams(TestDataReader.getTestData(TEST_PICKUP_CITY),setDatePickup(),setDateDropoff(),TestDataReader.getTestData(TEST_DROPOFF_CITY_WRONG));
    }
}
