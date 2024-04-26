import messages.AssertionMessages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SigninPageTest extends BaseTest {

    @Test
    public void navigateFromSignInToSignUpPage() {
        signinPage.clickSignUpLink();
        String expectedUrl = "https://dribbble.com/signup/new";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(AssertionMessages.SIGN_UP_PAGE_URL_INCORRECT, expectedUrl, actualUrl);
    }



    @After
    public void tearDown() {
        if (driver != null) {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot camera = (TakesScreenshot) driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);
                String screenshotDirectory = "screenshots/";
                String screenshotName = "failure_" + System.currentTimeMillis() + ".png";
                String screenshotPath = screenshotDirectory + screenshotName;
                try {
                    Files.createDirectories(Paths.get(screenshotDirectory));
                    Files.move(screenshot.toPath(), new File(screenshotPath).toPath());
                    System.out.println("Screenshot saved for failed test: " + screenshotPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            driver.quit();
        }
    }



//    @Test
//    public void navigateToPasswordResetPageFromSigninPage() {
//        signinPage.clickForgotPasswordLink();
//        String expectedUrl = "https://dribbble.com/password_resets/new";
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals( expectedUrl, currentUrl);
//    }
}