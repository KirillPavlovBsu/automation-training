package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import model.SearchFieldParams;
import pageobject.CarRentalHomePage;
import service.ParamsCreator;

public class WebDriverCarRental extends CommonConditions {

    @Test
    public void searchCarTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        Boolean isValidationPassed = new CarRentalHomePage(driver)
                .openPage()
                .searchCar(params)
                .isCarPageVisible(driver);
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void searchCarInTokyoTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        Boolean isValidationFailed = new CarRentalHomePage(driver)
                .openPage()
                .searchCarWithDropoff(params)
                .getResultAlert(driver);
        Assert.assertTrue(isValidationFailed);
    }


}
