package step_definitions;

import framework.pages.bbcLandingPage;
import framework.pages.bbcSettings;
import framework.pages.bbcSignIn;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class bbc_steps {

    private Scenario scenario;
    public static WebDriver driver;
    public static WebDriverWait wait;

// this before statement is called for each feature file and initialises the chromedriver with a timeout of 30 seconds to load and execute actions
    @Before(value = "@bbc_before", order = 0)
    public void bbc_before(Scenario scenario) {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        this.scenario = scenario;
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

// teardown, quit chromedriver
    @After(value = "@bbc_after", order = 0)
    public void bbc_after(Scenario scenario) {
        driver.quit();
    }

    // get the signin page, maximise display and signin. github secrets should really be used for sensitive details
    @Given("I am on the bbc login page")
    public void i_am_on_the_bbc_login_page() {
        driver.get("https://account.bbc.com/signin");
        driver.manage().window().maximize();
        try {
            wait.until(ExpectedConditions.visibilityOf(bbcSignIn.emailInput(driver))).sendKeys("mikestoneham43@gmail.com");
            bbcSignIn.passwordInput(driver).sendKeys("12157FGREDS");
        } catch (Exception e) {
            System.out.println("No login found");
        }
    }

    //
    @When("I press the Sign in button")
    public void i_press_the_sign_in_button() {
        bbcSignIn.buttonSubmit(driver).click();
    }

// simple assert (junit) to verify on correct next page
    @Then("I can successfully log into the bbc site")
    public void i_can_successfully_log_into_the_bbc_site() throws InterruptedException {
        WebElement welcomeToTheBBC = bbcLandingPage.landingPageTitle(driver);
        Assert.assertTrue(welcomeToTheBBC.isDisplayed());
    }

    @Then("I can access my accounts setting to change the postcode set")
    public void i_can_access_my_accounts_setting_to_change_the_postcode_set() throws InterruptedException {
        bbcLandingPage.yourAccount(driver).click();
        wait.until(ExpectedConditions.visibilityOf(bbcLandingPage.settings(driver))).click();
        wait.until(ExpectedConditions.visibilityOf(bbcSettings.settingsPostcode(driver)));
        WebElement postcodeField = bbcSettings.settingsPostcode(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", postcodeField, 5);
        postcodeField.click();
        wait.until(ExpectedConditions.visibilityOf(bbcSettings.postCodeInput(driver))).click();
        bbcSettings.postCodeInput(driver).sendKeys(Keys.CONTROL + "a");
        bbcSettings.updatePostcode();
        bbcSettings.saveAndContinue(driver).click();
        String newPC = wait.until(ExpectedConditions.visibilityOf(bbcSettings.newPostcode(driver))).getText();
        Assert.assertEquals(newPC, "RG265AJ");
    }

}
