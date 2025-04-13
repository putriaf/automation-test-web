package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import utilities.BrowserDriver;
public class OtpPage extends BrowserDriver {

    public static String lblOtpPageHeader = "//div[text()=\"Verifikasi\"]";
    public static String lblOtpPageSubheader = "//div[@class='login-register-heading']";
    public static String tfOtpCode = "//div[@class=\"bit-custom-input-code\"]";
    public static String btnResendCode = "//div[@class=\"login-register-right-resend-text\"]";
    public static String lblPinPageHeader = "//div[text()=\"Masukkan PIN Kamu\"]";

    public static void assertOtpPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblOtpPageHeader)));
        Assert.assertTrue((driver.findElement(By.xpath(lblOtpPageHeader)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(lblOtpPageSubheader)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(tfOtpCode)).isDisplayed()));
        Assert.assertTrue((driver.findElement(By.xpath(btnResendCode)).isDisplayed()));
    }

    public void enterOtpCode(String otpCode) {
        for (char digit : otpCode.toCharArray()) {
            WebElement keypadButton = driver.findElement(By.cssSelector("[data-testid='num-" + digit + "']"));
            keypadButton.click();
        }
    }

    public void inputPIN(String PIN) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblPinPageHeader)));
        for (char digit : PIN.toCharArray()) {
            WebElement keypadButton = driver.findElement(By.cssSelector("[data-num='" + digit + "']"));
            keypadButton.click();
        }
    }
}
