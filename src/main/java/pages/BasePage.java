package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private By userIcon = By.className("nav-v2-avatar__image");
    private By searchField = By.className("nav-v2-search__input");
    private By followingButton = By.cssSelector("[data-test='filter-active-shot-view']");
    private By goProButton = By.xpath("//a[contains(@class, 'framer-text') and contains(@data-styles-preset, 'tZm06TWqh') and @href='/pro']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSeconds(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000.0));
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }
    }

    public DribbbleSignedInUserHomePage navigateToUserHomePage() {
        driver.findElement(userIcon).click();
        return new DribbbleSignedInUserHomePage(driver);
    }

    public void search(String query) {
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(searchField).submit();
    }

    public void clickFollowingButton() {
        driver.findElement(followingButton).click();
    }

    public void clickGoProButton() {
        driver.findElement(goProButton).click();
    }


}






















