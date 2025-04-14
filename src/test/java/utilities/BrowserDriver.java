package utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver {
    public static WebDriver driver;

    public static void initialize() {
        if (driver == null) {
            WebDriverManager.chromedriver().browserVersion("134").setup();
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--blink-settings=imagesEnabled=false");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.get("https://bibit.id/");
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
