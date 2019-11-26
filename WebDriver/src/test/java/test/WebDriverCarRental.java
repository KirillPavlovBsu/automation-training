package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.SearchCarrental;
import pageobject.CarRentalHomePage;

public class WebDriverCarRental {
    private String datePickup="28/11/2019";
    private String dateDropoff="28/12/2019";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void searchCarTest(){
        SearchCarrental params = new SearchCarrental("Tallinn",datePickup,dateDropoff,"Tokyo");
        Boolean isValidationPassed = new CarRentalHomePage(driver)
                .openHomePage()
                .searchCar(params)
                .isCarPageVisible(driver);
        Assert.assertTrue(isValidationPassed);
    }

    @Test
    public void searchCarInTokyoTest(){
        SearchCarrental params = new SearchCarrental("Tallinn",datePickup,dateDropoff,"Tokyo");
        Boolean isValidationPassed = new CarRentalHomePage(driver)
                .openHomePage()
                .searchCarWithDropoff(params)
                .isCarPageVisible(driver);
        Assert.assertTrue(isValidationPassed);
    }


}
