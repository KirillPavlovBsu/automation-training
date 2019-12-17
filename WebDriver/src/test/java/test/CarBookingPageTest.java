package test;

import model.RegistrationParams;
import model.SearchFieldParams;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CarBookingPage;
import service.ParamsCreator;

public class CarBookingPageTest extends CommonConditions {
    @Test
    public void bookingWithEmptyForm(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 8: Testing validation of booking form.");
        Assert.assertEquals(new CarBookingPage(driver,params)
                .openPage()
                .bookingButton()
                .bookingAlert(),"The following sections have missing or incorrect information:" +
                "\nDriver Information"+
                "\nRental Car Damage Protection"+
                "\nPayment Information");

    }

    @Test
    public void bookingValidation(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        RegistrationParams paramsReg = ParamsCreator.registrationWithCredentials();
        logger.info("\nTest 9: Testing sector validation of booking form.");
        Assert.assertEquals(new CarBookingPage(driver,params)
                .openPage()
                .fillFirstSector(paramsReg)
                .bookingButton()
                .bookingAlert(),"The following sections have missing or incorrect information:" +
                "\nRental Car Damage Protection"+
                "\nPayment Information");
    }

    @Test
    public void calculationsTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 10: Testing calculations on the booking car page.");
        Assert.assertTrue(new CarBookingPage(driver,params)
                .openPage()
                .checkCalculations());
    }
}
