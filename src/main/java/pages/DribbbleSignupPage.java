package pages;

import constants.DribbbedSignupPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DribbbleSignupPage {
    private WebDriver driver;
    private DribbbedSignupPageLocator locator;

    public DribbbleSignupPage(WebDriver driver) {
        this.driver = driver;
        this.locator = new DribbbedSignupPageLocator();
    }

    public void clickSignUpWithGoogleButton() {
        driver.findElement(By.xpath(locator.SIGN_UP_WITH_GOOGLE_BUTTON)).click();
    }

    public void clickContinueWithEmailButton() {
        driver.findElement(By.xpath(locator.CONTINUE_WITH_EMAIL_BUTTON)).click();
    }


    
        public void invalidRegistration(String validName, String validPassword, String invalidEmail) {
            fillNameField(validName);
            fillPasswordField(validPassword);
            fillEmailField(invalidEmail);
            clickSignUpButton();
        }
    private void fillNameField(String validName) {
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.clear();
        nameField.sendKeys(validName);
    }

    private void fillPasswordField(String validPassword) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(validPassword);
    }

    private void fillEmailField(String invalidEmail) {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.clear();
        emailField.sendKeys(invalidEmail);
    }

    private void clickSignUpButton() {
        WebElement signUpButton = driver.findElement(By.cssSelector("button[type='submit']")); // Assuming the sign-up button locator is a CSS selector for a button with type 'submit'
        signUpButton.click();
    }


    public String getErrorMessage() {
        WebElement errorMessageElement = driver.findElement(By.cssSelector("YOUR_ERROR_MESSAGE_CSS_SELECTOR"));
        return errorMessageElement.getText();
    }
}
