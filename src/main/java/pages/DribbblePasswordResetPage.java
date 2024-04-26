package pages;

import constants.DribbblePasswordResetPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DribbblePasswordResetPage {
    private WebDriver driver;
    private By emailField = By.id(DribbblePasswordResetPageLocator.EMAIL_FIELD);
    private By sendInstructionsButton = By.cssSelector(DribbblePasswordResetPageLocator.SEND_INSTRUCTIONS_BUTTON);


    public DribbblePasswordResetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailAddress(String emailAddress) {
        driver.findElement(emailField).sendKeys(emailAddress);
    }

    public void clickSendResetInstructionsButton() {
        driver.findElement(sendInstructionsButton).click();
    }
}
