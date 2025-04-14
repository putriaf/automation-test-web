package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.LoginPage;
import pages.OtpPage;
import pages.HomePage;
import pages.ProductDetailPage;

import static utilities.BrowserDriver.driver;

public class LoginSteps {
    String phoneNumber = "081284109204";
    String OTP = "1111";
    String PIN = "181201";
    String productName = "Jarvis";

    LandingPage landingPage = new LandingPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    OtpPage otpPage = new OtpPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);


    @Given("^User on Bibit Homepage$")
    public void assertLandingPage() throws Throwable {
        landingPage.assertLoginBtnDisplayed();
    }

    @When("^User click on the Login button$")
    public void clickLogin() throws Throwable {
        landingPage.clickLoginBtn();
    }

    @And("^User enter phone number$")
    public void enterPhoneNumber() {
        loginPage.assertLoginPageDisplayed();
        loginPage.inputPhoneNumber(phoneNumber);
    }

    @And("^User tap on Login button$")
    public void tapOnLoginBtn() {
        loginPage.clickLoginButton();
        loginPage.assertOTPPopup();
        loginPage.chooseOtpByEmail();
        loginPage.clickChooseBtn();
    }

    @And("^And User submit OTP and PIN$")
    public void verifyAccount() throws InterruptedException {
        loginPage.assertOTPPopup();
        loginPage.chooseOtpByEmail();
        loginPage.clickChooseBtn();
        otpPage.enterOtpCode(OTP);
        otpPage.inputPIN(PIN);
        Thread.sleep(20000);
    }

    @Then("^User redirected to Bibit Homepage$")
    public void assertSearchProductSuccess() {
        homePage.assertHomePageDisplayed();
        homePage.clickExploreBtn();
        homePage.searchProduct(productName);
        productDetailPage.assertProductDetailPageDisplayed();
    }
}
