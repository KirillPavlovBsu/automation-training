package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.dnd.DropTarget;

public class CarRentalHomePage {
    private final int TIMEOUT_SECONDS = 30;

    private final static String HOMEPAGE_URL="https://www.carrentals.com/";
    private final static String CITY_PICKUP="//*[@id=\"pickup_location\"]";
    private final static String DATE_PICKUP="//*[@id=\"startDateInput\"]";
    private final static String DATE_DROPOFF="//*[@id=\"endDateInput\"]";
    private final static String SEARCH_BUTTON="//*[@id=\"cr-wizard-1\"]/div[1]/form/button";
    private final static String DROPOFF_CITY_CHECKBOX="//*[@id=\"drop-off-checkbox'\"]";
    private final static String DROPOFF_CITY="//*[@id=\"dropoff_location\"]";

    private WebDriver driver;

    @FindBy(xpath = CITY_PICKUP)
    private WebElement cityPickup;

    @FindBy(xpath = DATE_PICKUP)
    private WebElement datePickup;

    @FindBy(xpath = DATE_DROPOFF)
    private WebElement dateDropoff;

    @FindBy(xpath = SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = DROPOFF_CITY)
    private WebElement dropoffCity;

    @FindBy(xpath = DROPOFF_CITY_CHECKBOX)
    private WebElement dropoffCityCheckbox;

    public CarRentalHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CarRentalHomePage openHomePage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchCarrentalResult searchCar(SearchCarrental params){
        cityPickup.sendKeys(params.getDatePickup());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATE_PICKUP)));
        datePickup.clear();
        datePickup.sendKeys(params.getDatePickup());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATE_DROPOFF)));
        dateDropoff.clear();
        dateDropoff.sendKeys(params.getDateDropoff());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BUTTON)));
        searchButton.click();
        return new SearchCarrentalResult(driver,params);
    }

    public SearchCarrentalResult searchCarWithDropoff(SearchCarrental params){
        cityPickup.clear();
        cityPickup.sendKeys(params.getPickupCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DROPOFF_CITY_CHECKBOX)));
        dropoffCityCheckbox.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DROPOFF_CITY)));
        dropoffCity.clear();
        dropoffCity.sendKeys(params.getDropoffCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATE_PICKUP)));
        datePickup.clear();
        datePickup.sendKeys(params.getDatePickup());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DATE_DROPOFF)));
        dateDropoff.clear();
        dateDropoff.sendKeys(params.getDateDropoff());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BUTTON)));
        searchButton.click();
        return new SearchCarrentalResult(driver,params);
    }


}
