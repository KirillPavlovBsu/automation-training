package test;

import model.RegistrationParams;
import org.testng.Assert;
import org.testng.annotations.Test;
import model.SearchFieldParams;
import pageobject.CarRentalHomePage;
import service.ParamsCreator;

public class HomePageTest extends CommonConditions {

    @Test
    public void searchCarTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 1: Searching car without selecting dropoff place.");
        Boolean isValidationPassed = new CarRentalHomePage(driver)
                .openPage()
                .inputDate(params)
                .searchCar(params)
                .isCarPageVisible();
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void searchCarInTokyoTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 2: Searching car with selecting dropoff place.");
        String errorMessage = new CarRentalHomePage(driver)
                .openPage()
                .inputDate(params)
                .searchCarWithDropoff(params)
                .getResultAlert();
        Assert.assertEquals(errorMessage,"Unfortunately we were unable to find any cars matching your search for:");
    }


    @Test
    public void searchCarWithWrongTime(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromPropertySameDate();
        logger.info("\nTest 3: Searching car with impossible time options selected to check auto-correct.");
        Boolean isValidationPassed = new CarRentalHomePage(driver)
                .openPage()
                .timeOptionsWrong(params)
                .inputDate(params)
                .searchCar(params)
                .isCarPageVisible();
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void registrationValidationCheck(){
        RegistrationParams params = ParamsCreator.registrationWithCredentials();
        logger.info("\nTest 6: Registration validation test.");
        String validationMessage = new CarRentalHomePage(driver)
                .openPage()
                .registrationWindow()
                .registrationFillment(params)
                .errorMessageCheck();
        Assert.assertEquals(validationMessage,"Please enter a valid email address.");
    }
}
