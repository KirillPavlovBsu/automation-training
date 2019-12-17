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
import utils.StringFormatter;

import java.util.List;

import static utils.StringFormatter.getNumberFromString;

public class CarSelectorPage extends AbstractPage{
    private final static String RESULT_GOOD="//*[@id=\"carlisting\"]";
    private final static String RESULT_ALERT="//*[@id=\"carlisting\"]/div/div[2]/div[2]/div/h3";
    private final static String CAR_HEADER_NAME="h2.car-title-review-feature";
    private final static String MINI_VAN="input[name=\"mini_van\"";
    private final static String PRICE_HEADER="//*[@id=\"carlisting\"]/div/div[2]/div[4]/div/h3/div[1]";
    private final static String PRICE_BOX="div.page-loader + div > div >div>div + div > div >div + div >span";
    private final static String SCORE="span.highScore";
    private final static String SELECT="select.sortBySelect";
    private final static String OPTION="select.sortBySelect > option[value=HighestRated]";
    private final static String BUTTON="div.page-loader + div > div > div > div + div > div > button";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = RESULT_GOOD)
    private WebElement carListing;

    @FindBy(xpath = RESULT_ALERT)
    private WebElement infoTitle;

    @FindBy(xpath = PRICE_HEADER)
    private WebElement price;

    private SearchFieldParams params;

    public CarSelectorPage(WebDriver driver, SearchFieldParams params){
        super(driver);
        this.params = params;
        PageFactory.initElements(driver,this);
    }

    public boolean isCarPageVisible() {
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS*2)
                        .until(ExpectedConditions
                                .visibilityOf(carListing));
        logger.info("Page opened successfully");
        return errorMessage.isDisplayed();
    }

    public String getResultAlert(){
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS*2)
                    .until(ExpectedConditions
                        .visibilityOf(infoTitle));
        logger.warn(infoTitle.getText());
        return infoTitle.getText();
    }

    public List<WebElement> getListOfCars(){
        new WebDriverWait(driver,TIMEOUT_SECONDS).until((ExpectedConditions.presenceOfElementLocated(By.cssSelector(CAR_HEADER_NAME))));
        return driver.findElements(By.cssSelector(CAR_HEADER_NAME));
    }


    public int getPriceDifference(){
        new WebDriverWait(driver,TIMEOUT_SECONDS*2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_HEADER)));
        int headerPrice = getNumberFromString(price.getText().substring(3));
        int bucketPrice = getNumberFromString(driver.findElement(By.cssSelector(PRICE_BOX)).getText());
        logger.info("Price difference checked.");
        return headerPrice-bucketPrice;
    }

    public CarSelectorPage sortByCarType(){
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(MINI_VAN)));
        WebElement carType = driver.findElement(By.cssSelector(MINI_VAN));
        carType.click();
        new WebDriverWait(driver, TIMEOUT_SECONDS*3);
        logger.info("Sorted by type.");
        return new CarSelectorPage(driver,params);
    }

    public CarSelectorPage sortByRating(){
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPTION)));
        driver.findElement(By.cssSelector(SELECT)).click();
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPTION)));
        driver.findElement(By.cssSelector(OPTION)).click();
        logger.info("Sorted by rating.");
        return new CarSelectorPage(driver,params);
    }

    public Boolean isRatingHigherOrSame(){
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(OPTION)));
        List<WebElement> scores = driver.findElements(By.cssSelector(SCORE));
        int percentage=100;
        for (WebElement score : scores){
            if (percentage-StringFormatter.getNumberFromString(score.getText())>=0){
                percentage=StringFormatter.getNumberFromString(score.getText());
            } else return false;
        }
        logger.info("Rating sort checked.");
        return true;
    }

    public CarBookingPage carBookingButton(){
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(RESULT_GOOD)));
        driver.findElement(By.cssSelector(BUTTON)).click();
        new WebDriverWait(driver,TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"book-button\"]")));
        return new CarBookingPage(driver,params);
    }

    @Override
    public CarSelectorPage openPage() {
        CarSelectorPage page = new CarRentalHomePage(driver)
                .openPage()
                .inputDate(params)
                .searchCar(params);
        return page;
    }
}
