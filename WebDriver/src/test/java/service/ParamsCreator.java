package service;

import model.CarSelectorParams;
import model.RegistrationParams;
import model.SearchFieldParams;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParamsCreator {
    private static final String TEST_PICKUP_CITY="testdata.pickup.location";
    private static final String TEST_DROPOFF_CITY="testdata.dropoff.location";
    private static final String TEST_DROPOFF_CITY_WRONG="testdata.dropoff.location.wrong";
    private static final String TEST_TIME_OPTION_PICKUP_WRONG="testdata.time.option.pickup.wrong";
    private static final String TEST_TIME_OPTION_DROPOFF="testdata.time.option.dropoff";

    private static final String TEST_CAR_TYPE="testdata.car.type";

    private static final String TEST_NAME="testdata.name";
    private static final String TEST_LAST_NAME="testdata.last.name";
    private static final String TEST_EMAIL="testdata.email";
    private static final String TEST_PASSWORD="testdata.password";
    private static final String TEST_PASSWORD_REPEAT="testdata.password.repeat";
    private static final String TEST_PHONE="testdata.phone";

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
        return new SearchFieldParams(TestDataReader.getTestData(TEST_PICKUP_CITY),TestDataReader.getTestData(TEST_DROPOFF_CITY_WRONG),setDatePickup(),setDateDropoff(),
                TestDataReader.getTestData(TEST_TIME_OPTION_PICKUP_WRONG),TestDataReader.getTestData(TEST_TIME_OPTION_DROPOFF));
    }

    public static SearchFieldParams withCredentialsFromPropertySameDate(){
        return new SearchFieldParams(TestDataReader.getTestData(TEST_PICKUP_CITY),TestDataReader.getTestData(TEST_DROPOFF_CITY_WRONG),setDatePickup(),setDatePickup(),
                TestDataReader.getTestData(TEST_TIME_OPTION_PICKUP_WRONG),TestDataReader.getTestData(TEST_TIME_OPTION_DROPOFF));
    }

    public static CarSelectorParams withCredentialsFromPropertyForCars(){
        return new CarSelectorParams((TestDataReader.getTestData(TEST_CAR_TYPE)));
    }

    public static RegistrationParams registrationWithCredentials(){
        return new RegistrationParams(TestDataReader.getTestData(TEST_NAME),TestDataReader.getTestData(TEST_LAST_NAME),TestDataReader.getTestData(TEST_EMAIL),
                TestDataReader.getTestData(TEST_PASSWORD),TestDataReader.getTestData(TEST_PASSWORD_REPEAT),TestDataReader.getTestData(TEST_PHONE));
    }
}
