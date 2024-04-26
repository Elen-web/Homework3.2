
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.junit.Assert;
import pages.DribbbleHomePage;
import pages.DribbbleSigninPage;
import pages.DribbbleSignupPage;

public class SignupTest extends BaseTest {


    @Test
    public void navigateToHomePageFromSignUpPageTest() {

        homePage.clickSignUpButton();
        String signUpPageUrl = driver.getCurrentUrl();
        driver.navigate().back();
        String expectedUrl = "https://dribbble.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("The current URL should be the home page URL", expectedUrl, actualUrl);
    }




    @Test
    public void navigateToResetPasswordPage() {

        WebDriver driver = new ChromeDriver();
        DribbbleHomePage homePage = new DribbbleHomePage(driver);

        homePage.clickSignUpButton();
        DribbbleSignupPage signupPage = new DribbbleSignupPage(driver);
        signupPage.clickContinueWithEmailButton();

        DribbbleSigninPage signinPage = new DribbbleSigninPage(driver);
        signinPage.clickForgotPasswordLink();


        driver.quit();
    }

}






