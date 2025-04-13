package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.BrowserDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LandingPage extends BrowserDriver {

    public static String btnLogin = "//*[contains(@class, 'navbarItem')][text()='Login']";

    public static void assertLoginBtnDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnLogin)));
        Assert.assertTrue(element.isDisplayed());
    }

    public static void clickLoginBtn() {
        driver.findElement(By.xpath(btnLogin)).click();
    }
}
