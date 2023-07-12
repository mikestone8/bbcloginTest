package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bbcPage1 {

    private static WebElement element = null;

    public static WebElement menu (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("/html/body/app-root/app-navbar/div/div[1]/div"));
        return element;
    }

}
