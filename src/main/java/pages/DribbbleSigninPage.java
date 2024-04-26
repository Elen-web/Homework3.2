package pages;

import constants.DribbblePasswordResetPageLocator;
import constants.DribbbleSigninPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DribbbleSigninPage {
    private WebDriver driver;
    private By usernameField = By.name(DribbbleSigninPageLocator.USERNAME_FIELD);
    private By passwordField = By.name(DribbbleSigninPageLocator.PASSWORD_FIELD);
    private By signInBtn = By.cssSelector(DribbbleSigninPageLocator.SIGN_IN_BUTTON);
    private By signUpLink = By.linkText("Sign up");
    private By forgotLink = By.xpath(DribbblePasswordResetPageLocator.FORGOT_lINK);


    public DribbbleSigninPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInBtn() {
        driver.findElement(signInBtn).click();
    }




    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public DribbbleSignedInUserHomePage login(String username, String password) {
        fillUsernameField(username);
        fillPasswordField(password);
        clickSignInBtn();
        return new DribbbleSignedInUserHomePage(driver);
    }

    public void clickSignUpLink() {
        driver.findElement(signUpLink).click();
    }

    public boolean isLoginPageDisplayed() {
        try {
            return isElementDisplayed(usernameField) && isElementDisplayed(passwordField) && isElementDisplayed(signInBtn);
        } catch (NoSuchElementException e) {
            return false;
        }
    }




    public void clickForgotPasswordLink() {
        driver.findElement(forgotLink).click();
    }

}
