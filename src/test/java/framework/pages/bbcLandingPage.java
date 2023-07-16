package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bbcLandingPage {

    private static WebElement element = null;

    public static WebElement landingPageTitle (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("//*[@id=\"header-content\"]/div[2]/div/div/div/div"));
        return element;
    }

    public static WebElement yourAccount (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("//*[@id=\"header-content\"]/nav/div[1]/div/div[2]/ul[1]/li[1]/a"));
        return element;
    }

    public static WebElement settings (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[1]/div/div/nav/ul/li[2]/a/span"));
        return element;
    }

    public static WebElement settingsPostcode (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("//*[@id=\"Postcode-field\"]/div[2]/a/span"));
        return element;
    }


}
