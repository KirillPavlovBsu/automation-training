package pageobject;

import model.SearchFieldParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarRentalHomePage extends AbstractPage{

    private final static String HOMEPAGE_URL="https://www.carrentals.com/";
    private final static String CITY_PICKUP="//*[@id=\"pickup_location\"]";
    private final static String DATE_PICKUP="//*[@id=\"startDateInput\"]";
    private final static String DATE_DROPOFF="//*[@id=\"endDateInput\"]";
    private final static String SEARCH_BUTTON="//*[@id=\"cr-wizard-1\"]/div[1]/form/button";
    private final static String DROPOFF_CITY_CHECKBOX="//*[@id=\"drop-off-checkbox-label\"]";
    private final static String DROPOFF_CITY="//*[@id=\"dropoff_location\"]";
    private final static String OUTSIDE_FIELD="//*[@id=\"in-farefinder-tagline\"]";
    private final static String SELECT_CITY="//*[@id=\"aria-option-0\"]";
    private final static String BUTTON_CLEAR="//*[@id=\"cr-wizard-1\"]/div/form/div[2]/div[2]/button";

    private final Logger logger = LogManager.getRootLogger();

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

    @FindBy(xpath = OUTSIDE_FIELD)
    private WebElement outsideField;

    @FindBy(xpath = SELECT_CITY)
    private WebElement selectCity;

    @FindBy(xpath = BUTTON_CLEAR)
    private WebElement buttonClear;

    public CarRentalHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CarRentalHomePage openPage(){
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Page opened");
        return this;
    }


    public SearchCarrentalResult searchCar(SearchFieldParams params){
        cityPickup.sendKeys(params.getPickupCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_CITY)));
        selectCity.click();
        datePickup.clear();
        datePickup.sendKeys(params.getDatePickup());
        dateDropoff.clear();
        dateDropoff.sendKeys(params.getDateDropoff());
        outsideField.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BUTTON)));
        searchButton.click();
        logger.info("Performed search with pickup city ["+ params.getDatePickup() + "] and rent date from "
                + params.getDatePickup()+ " to " + params.getDateDropoff());
        return new SearchCarrentalResult(driver,params);
    }

    public SearchCarrentalResult searchCarWithDropoff(SearchFieldParams params) {
        cityPickup.sendKeys(params.getPickupCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_CITY)));
        selectCity.click();
        dropoffCityCheckbox.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(DROPOFF_CITY)));
        dropoffCity.sendKeys(params.getDropoffCity());
        buttonClear.click();
        dropoffCity.sendKeys(params.getDropoffCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_CITY)));
        selectCity.click();
        datePickup.clear();
        datePickup.sendKeys(params.getDatePickup());
        dateDropoff.clear();
        dateDropoff.sendKeys(params.getDateDropoff());
        outsideField.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_BUTTON)));
        searchButton.click();
        logger.info("Performed search with pickup city ["+ params.getDatePickup() + "] and dropoff city ["
                + params.getDropoffCity()+"] and rent date from ["
                + params.getDatePickup()+ "] to [" + params.getDateDropoff()+"]");
        return new SearchCarrentalResult(driver,params);
    }

}
