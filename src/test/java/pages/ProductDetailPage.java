package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserDriver;

import java.time.Duration;

public class ProductDetailPage extends BrowserDriver {

    public static String lblProductTitle = "//div[text()= 'Jarvis Money Market Fund']//ancestor::*[contains(@class, 'TitleSection-styled__Title')]";

    public void assertProductDetailPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblProductTitle)));
        Assert.assertTrue(productTitle.isDisplayed());
    }
}
