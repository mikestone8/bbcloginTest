package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bbcSignIn {

    private static WebElement element = null;

    public static WebElement menu (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("/html/body/app-root/app-navbar/div/div[1]/div"));
        return element;
    }

    public static WebElement emailInput (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.id("user-identifier-input"));
        return element;
    }

    public static WebElement passwordInput (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.id("password-input"));
        return element;
    }

    public static WebElement buttonSubmit (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.id("submit-button"));
        return element;
    }



}
