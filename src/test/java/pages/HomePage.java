package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserDriver;

import java.time.Duration;

public class HomePage extends BrowserDriver {

    public static String lblPortofolioValue = "//div[text()='Nilai Portofolio']";
    public static String btnProfile = "//div[@data-testid=\"tabbar-profile\"]";
    public static String btnExplore = "//div[@data-testid=\"tabbar-explore\"]";
    public static String btnLogout = "//div[@type=\"body1\"][text()= 'Log Out']";
    public static String tfSearch = "//*[text()= 'Cari produk investasi']";
    public static String tfSearchClicked = "//*[@class=\"custom-input-search\"]";
    public static String ctrFirstSearchResult = "//*[@class=\"ExploreSaham_card-watchlist-item__YmjQP\"][1]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertHomePageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblPortofolioValue)));
        Assert.assertTrue(element.isDisplayed());
    }

    public void clickProfileBtn() {
        Assert.assertTrue((driver.findElement(By.xpath(btnProfile)).isDisplayed()));
        driver.findElement(By.xpath(btnProfile)).click();
    }

    public void clickExploreBtn() {
        Assert.assertTrue((driver.findElement(By.xpath(btnExplore)).isDisplayed()));
        driver.findElement(By.xpath(btnExplore)).click();
    }

    public void searchProduct(String keys) {
        Assert.assertTrue((driver.findElement(By.xpath(btnExplore)).isDisplayed()));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tfSearch)));
        Assert.assertTrue(searchField.isDisplayed());
        driver.findElement(By.xpath(tfSearch)).click();
        Assert.assertTrue((driver.findElement(By.xpath(tfSearchClicked)).isDisplayed()));
        driver.findElement(By.xpath(tfSearchClicked)).sendKeys(keys);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ctrFirstSearchResult)));
        Assert.assertTrue((driver.findElement(By.xpath(ctrFirstSearchResult)).isDisplayed()));
        driver.findElement(By.xpath(ctrFirstSearchResult)).click();
    }
}
