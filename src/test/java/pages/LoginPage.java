package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import utilities.BrowserDriver;

public class LoginPage extends BrowserDriver {

    public static String btnBackButton = "//div[@role=\"button\"][contains(@class, 'backbutton')]";
    public static String lblLoginHeader = "//div[@type=\"subtitle2\"]";
    public static String lblLoginSubheader = "//div[contains(@class,'login-register-heading')]";
    public static String ddCountry = "//select[@class='PhoneInputCountrySelect']";
    public static String tfPhoneNumber = "//input[@class='PhoneInputInput']";
    public static String btnLogin = "//button[@data-testid='login-btn-login']";
    public static String ctrRegister = "//div[@class='dont-have-account']";
    public static String btnRegister = "//span[contains(@class,'regist')]";
    public static String lblOtpPopupHeader = "//div[text()='Pilih Metode Pengiriman Kode Verifikasi']";
    public static String tfOtpEmail = "//div[@data-testid=\"login-method-email\"]";
    public static String tfOtpCall = "//div[@data-testid=\"login-method-missed_call\"]";
    public static String tfOtpSms = "//div[@data-testid=\"login-method-sms\"]";
    public static String btnChoose = "//button[@data-content=\"Pilih\"]";


    public static void assertLoginPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblLoginHeader)));
        Assert.assertTrue((driver.findElement(By.xpath(lblLoginHeader)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(btnBackButton)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(lblLoginSubheader)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(ddCountry)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(tfPhoneNumber)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(ctrRegister)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(btnRegister)).isDisplayed()));
    }

    public static void inputPhoneNumber(String phoneNumber) {
        driver.findElement(By.xpath(tfPhoneNumber)).sendKeys(phoneNumber);
    }

    public static void clickLoginButton() {
        driver.findElement(By.xpath(btnLogin)).click();
    }

    public static void assertOTPPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblOtpPopupHeader)));
        Assert.assertTrue((driver.findElement(By.xpath(lblOtpPopupHeader)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(tfOtpEmail)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(tfOtpCall)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(tfOtpSms)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(btnChoose)).isDisplayed()));
    }

    public static void chooseOtpByEmail() {
        driver.findElement(By.xpath(tfOtpEmail)).click();
    }

    public static void clickChooseBtn() {
        driver.findElement(By.xpath(btnChoose)).click();
    }
}
