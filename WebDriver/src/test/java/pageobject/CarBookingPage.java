package pageobject;

import model.RegistrationParams;
import model.SearchFieldParams;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.StringFormatter;

public class CarBookingPage extends AbstractPage {

    private SearchFieldParams params;

    public CarBookingPage(WebDriver driver, SearchFieldParams params){
        super(driver);
        this.params = params;
        PageFactory.initElements(driver,this);
    }


    @Override
    public CarBookingPage openPage() {
        CarBookingPage page = new CarSelectorPage(driver,params)
                .openPage()
                .carBookingButton();
        return page;
    }

    public String bookingAlert(){
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.bubble-tooltip--errorValidation > div")));
        logger.warn("Alert found: " + driver.findElement(By.cssSelector("div.bubble-tooltip--errorValidation > div")).getText());
        return driver.findElement(By.cssSelector("div.bubble-tooltip--errorValidation > div")).getText();
    }

    public CarBookingPage fillFirstSector(RegistrationParams regParams){
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("label.js-rental-driver-last-name > input")));
        driver.findElement(By.cssSelector("label.js-rental-driver-first-name > input")).sendKeys(regParams.getName());
        driver.findElement(By.cssSelector("label.js-rental-driver-last-name > input")).sendKeys(regParams.getLastName());
        driver.findElement(By.cssSelector("label.js-customer-email > input")).sendKeys(regParams.getEmail());
        driver.findElement(By.cssSelector("label.js-customer-email-conf > input")).sendKeys(regParams.getEmail());
        driver.findElement(By.cssSelector("label.js-customer-phone-number > input")).sendKeys(regParams.getPhone());
        logger.info("First sector filled.");
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("label.js-customer-phone-number.has-success > input")));
        return new CarBookingPage(driver,params);
    }

    public Boolean checkCalculations(){
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.price-per-day.pay-later")));
        double sum = StringFormatter.getDoubleFromString(driver.findElement(By.cssSelector("div.price-per-day.pay-later")).getText());
        double perDaySum = StringFormatter.getDoubleFromString(driver.findElement(By.xpath("//*[@id=\"price-details\"]/div[1]/div[2]")).getText());
        double localTax = StringFormatter.getDoubleFromString(driver.findElement(By.xpath("//*[@id=\"price-details\"]/div[3]/div[2]")).getText());
        logger.info("Calculataions checked.");
        return (sum-(perDaySum+localTax)<=0.20) ? true : false;

    }

    public CarBookingPage bookingButton(){
        driver.findElement(By.xpath("//*[@id=\"book-button\"]")).click();
        return new CarBookingPage(driver,params);
    }
}
