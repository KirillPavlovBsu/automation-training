package test;

import model.CarSelectorParams;
import model.SearchFieldParams;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CarSelectorPage;
import service.ParamsCreator;

import java.util.List;

public class CarSelectorTest extends CommonConditions {

    @Test
    public void sortByCarType(){
        CarSelectorParams params = ParamsCreator.withCredentialsFromPropertyForCars();
        SearchFieldParams defaultParams = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 4: Sorting cars by the type of a car.");
        Boolean check=true;
        List<WebElement> cars = new CarSelectorPage(driver,defaultParams)
                .openPage()
                .sortByCarType()
                .getListOfCars();
        for (WebElement element : cars)
            if (element.getText()!=params.getCarType()) check=false;
        Assert.assertTrue(check);
    }

    @Test
    public void lowestCostCheck(){
        SearchFieldParams defaultParams = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 5: Comparing cost in header and in the cars list.");
        int difference = new CarSelectorPage(driver,defaultParams)
                .openPage()
                .getPriceDifference();
        Assert.assertEquals(difference,0);
    }

    @Test
    public void ratingTest(){
        SearchFieldParams params = ParamsCreator.withCredentialsFromProperty();
        logger.info("\nTest 7: Testing rating sort.");
        Boolean isValidationPassed = new CarSelectorPage(driver,params)
                .openPage()
                .sortByRating()
                .isRatingHigherOrSame();
        Assert.assertTrue(isValidationPassed);
    }
}
