package pages;

import constants.DribbbleSignedInUserHomePageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DribbbleSignedInUserHomePage {
    private WebDriver driver;
    private By logo = By.xpath(DribbbleSignedInUserHomePageLocator.LOGO);
    private By searchField = By.cssSelector(DribbbleSignedInUserHomePageLocator.SEARCH_FIELD);
    private By userIcon = By.cssSelector(DribbbleSignedInUserHomePageLocator.USER_ICON);
    private By followingButton = By.cssSelector(DribbbleSignedInUserHomePageLocator.FOLLOWING_BUTTON);
    public static final By USER_NAME = By.cssSelector("div.nav-v2-user__name");
    public static final By GO_PRO_BUTTON = By.xpath(DribbbleSignedInUserHomePageLocator.GO_PRO_BUTTON);

    public DribbbleSignedInUserHomePage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME));
    }

    public String getUserName() {
        WebElement userNameElement = driver.findElement(USER_NAME);
        return userNameElement.getText();
    }


    public boolean isLogoDisplayed() {
        try {
            return driver.findElement(logo).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean isUserLoggedIn() {
        try {

            WebElement userIconElement = driver.findElement(userIcon);
            return userIconElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    public boolean isGoProButtonDisplayed() {
        try {
            driver.findElement(DribbbleSignedInUserHomePage.GO_PRO_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }




}
