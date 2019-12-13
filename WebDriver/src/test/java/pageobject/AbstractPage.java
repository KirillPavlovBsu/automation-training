package pageobject;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }
}