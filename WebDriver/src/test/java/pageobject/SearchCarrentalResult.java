package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCarrentalResult {
    private final int TIMEOUT_SECONDS=20;
    private final static String RESULT_GOOD="//[@id='ember1895']";
    private final static String RESULT_ALERT="//[@id='carlisting']/div/div[2]/div[2]/div/h3";

    @FindBy(xpath = RESULT_GOOD)
    private WebElement ember1895;

    @FindBy(xpath = RESULT_ALERT)
    private WebElement infoTitle;

    private WebDriver driver;
    private SearchCarrental params;

    public SearchCarrentalResult(WebDriver driver, SearchCarrental params){
        this.driver = driver;
        this.params = params;
        PageFactory.initElements(driver,this);
    }

    public boolean isCarPageVisible(WebDriver driver) {
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                                .visibilityOf(ember1895));
        return errorMessage.isDisplayed();
    }

    public boolean getResultAlert(WebDriver driver){
        WebElement errorMessage =
                new WebDriverWait(driver, TIMEOUT_SECONDS)
                    .until(ExpectedConditions
                        .visibilityOf(infoTitle));
        return errorMessage.isDisplayed();
    }


}
