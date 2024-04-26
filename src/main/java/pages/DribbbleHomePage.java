package pages;

import constants.DribbbleHomePageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DribbbleHomePage extends BasePage {
    private By searchField = By.cssSelector(DribbbleHomePageLocator.SEARCH_FIELD);
    private By getStartedButton = By.cssSelector(DribbbleHomePageLocator.GET_STARTED_BUTTON);
    private By signUpButton = By.cssSelector(DribbbleHomePageLocator.SIGN_UP_BUTTON);
    private By logInButton = By.cssSelector(DribbbleHomePageLocator.LOG_IN_BUTTON);

    public DribbbleHomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String query) {
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
    }

    public void clickGetStartedButton() {
        driver.findElement(getStartedButton).click();
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(logInButton).click();
    }


}
