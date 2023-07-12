package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class bbc_steps {

    private Scenario scenario;
    public static WebDriver driver;
    public static WebDriverWait wait;


    @Before(value = "@bbc_before", order = 0)
    public void bbc_before(Scenario scenario) {
        //Boolean isHeadless = configFileReader.getHeadless();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(isHeadless);
        driver = new ChromeDriver(options);
        this.scenario = scenario;
        driver.manage().timeouts().implicitlyWait(30, SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @After(value = "@bbc_after", order = 0)
    public void bbc_after(Scenario scenario) {
        driver.quit();
    }

    @Given("I am on the bbc login page")
    public void i_am_on_the_bbc_login_page() {
        driver.get("https://www.bbc.co.uk/");
        driver.manage().window().maximize();
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/header/nav/div[1]/div/div[2]/ul[1]/li[1]/a/span[2]")))).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-identifier-input")))).sendKeys("mikestoneham43@gmail.com");
            driver.findElement(By.id("password-input")).sendKeys("12157FGREDS");
        } catch (Exception e) {
            System.out.println("No login");
        }
    }

    @When("I press the Sign in button")
    public void i_press_the_sign_in_button() {
        driver.findElement(By.id("submit-button")).click();
    }

    @Then("I can successfully log into the bbc site")
    public void i_can_successfully_log_into_the_bbc_site() throws InterruptedException {
        WebElement welcomeToTheBBC = driver.findElement(By.xpath("//*[@id=\"header-content\"]/div[2]/div/div/div/div"));
        Assert.assertTrue(welcomeToTheBBC.isDisplayed());
    }


}
