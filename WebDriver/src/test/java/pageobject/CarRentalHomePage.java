package pageobject;

import model.RegistrationParams;
import model.SearchFieldParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private final static String TIME_SELECTOR_PICKUP="//*[@id=\"pu-time-select\"]";
    private final static String TIME_SELECTOR_DROPOFF="//*[@id=\"do-time-select\"]";
    private final static String SIGN_IN="//*[@id=\"sign-in-link\"]";
    private final static String REGISTRATION="//*[@id=\"register\"]/a";
    private final static String NAME="//*[@id=\"first-name-register-field\"]";
    private final static String LASTNAME="//*[@id=\"last-name-register-field\"]";
    private final static String EMAIL="//*[@id=\"email-register-field\"]";
    private final static String PASSWORD=".password-user > div >input";
    private final static String PASSWORD_REPEAT=".user-confirm-password > div >input";
    private final static String ERROR="//*[@id=\"user-sign-up\"]/div[2]/div/div/form/div[3]/label/p";



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

    @FindBy(xpath = TIME_SELECTOR_DROPOFF)
    private WebElement timeSelectorDropoff;

    @FindBy(xpath = TIME_SELECTOR_PICKUP)
    private WebElement timeSelectorPickup;

    @FindBy(xpath = SIGN_IN)
    private WebElement signIn;

    @FindBy(xpath = REGISTRATION)
    private WebElement registration;

    @FindBy(xpath = NAME)
    private WebElement name;

    @FindBy(xpath = LASTNAME)
    private WebElement lastName;

    @FindBy(xpath = EMAIL)
    private WebElement email;

    @FindBy(xpath = ERROR)
    private WebElement error;


    public CarRentalHomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public CarRentalHomePage timeOptionsWrong(SearchFieldParams params){
        Select timePickup = new Select(timeSelectorPickup);
        timePickup.selectByValue(params.getTimeOptionPickup());
        Select timeDropoff = new Select(timeSelectorDropoff);
        timeDropoff.selectByValue(params.getTimeOptionDropoff());
        timeSelectorPickup.click();
        timePickup.getFirstSelectedOption().click();
        timeSelectorDropoff.click();
        timeDropoff.getFirstSelectedOption().click();
        logger.info("Time selected.");
        return new CarRentalHomePage(driver);
    }

    @Override
    public CarRentalHomePage openPage(){
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Page opened");
        return this;
    }

    public CarRentalHomePage registrationWindow(){
        signIn.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS*2).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"register\"]/a")));
        registration.click();
        logger.info("Registration window selected.");
        return new CarRentalHomePage(driver);
    }

    public CarRentalHomePage registrationFillment(RegistrationParams params){
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(NAME)));
        name.sendKeys(params.getName());
        lastName.sendKeys(params.getLastName());
        email.sendKeys(params.getEmail().substring(0,10));
        WebElement password = driver.findElement(By.cssSelector(PASSWORD));
        WebElement passwordRepeat = driver.findElement(By.cssSelector(PASSWORD_REPEAT));
        password.sendKeys(params.getPassword());
        passwordRepeat.sendKeys(params.getPasswordRepeat());
        logger.info("Registration filled.");
        return new CarRentalHomePage(driver);
    }

    public String errorMessageCheck(){
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ERROR)));
        logger.info("Error message appeared: "+ error.getText());
        return error.getText();
    }

    public CarRentalHomePage inputDate(SearchFieldParams params){
        dateDropoff.clear();
        dateDropoff.sendKeys(params.getDateDropoff());
        datePickup.clear();
        datePickup.sendKeys(params.getDatePickup());
        outsideField.click();
        logger.info("Date entered.");
        return new CarRentalHomePage(driver);
    }

    public CarSelectorPage searchCar(SearchFieldParams params){
        cityPickup.sendKeys(params.getPickupCity());
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(SELECT_CITY)));
        selectCity.click();
        searchButton.click();
        logger.info("Performed search with pickup city ["+ params.getDatePickup() + "] and rent date from "
                + params.getDatePickup()+ " to " + params.getDateDropoff());
        return new CarSelectorPage(driver,params);
    }

    public CarSelectorPage searchCarWithDropoff(SearchFieldParams params) {
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
        searchButton.click();
        logger.info("Performed search with pickup city ["+ params.getDatePickup() + "] and dropoff city ["
                + params.getDropoffCity()+"] and rent date from ["
                + params.getDatePickup()+ "] to [" + params.getDateDropoff()+"]");
        return new CarSelectorPage(driver,params);
    }

}
