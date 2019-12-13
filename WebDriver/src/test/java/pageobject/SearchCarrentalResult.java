package pageobject;

import model.SearchFieldParams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCarrentalResult extends AbstractPage{
    private final static String RESULT_GOOD="//*[@id=\"carlisting\"]";
    private final static String RESULT_ALERT="//*[@id=\"carlisting\"]/div/div[2]/div[2]/div/h3";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = RESULT_GOOD)
    private WebElement carListing;

    @FindBy(xpath = RESULT_ALERT)
    private WebElement infoTitle;

    private SearchFieldParams params;

    public SearchCarrentalResult(WebDriver driver, SearchFieldParams params){
        super(driver);
        this.params = params;
        PageFactory.initElements(driver,this);
    }

    public boolean isCarPageVisible(WebDriver driver) {
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .visibilityOf(carListing));
        logger.info("Page opened successfully");
        return errorMessage.isDisplayed();
    }

    public boolean getResultAlert(WebDriver driver){
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                    .until(ExpectedConditions
                        .visibilityOf(infoTitle));
        logger.warn(infoTitle.getText());
        return errorMessage.isDisplayed();
    }


    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
