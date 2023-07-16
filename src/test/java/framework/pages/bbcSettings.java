package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static step_definitions.bbc_steps.driver;

public class bbcSettings {

    private static WebElement element = null;
    public static String updatePostc;

    public static WebElement settingsPostcode (WebDriver sharedDriver) throws InterruptedException {
        element = sharedDriver.findElement(By.xpath("//*[@id=\"Postcode-field\"]/div[2]/a/span"));
        Thread.sleep(1000);
        return element;
    }

    public static WebElement postCodeInput (WebDriver sharedDriver) throws InterruptedException {
        element = sharedDriver.findElement(By.id("new-postcode-input"));
        Thread.sleep(1000);
        return element;
    }
    public static WebElement saveAndContinue (WebDriver sharedDriver) throws InterruptedException {
        element = sharedDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[2]/div[1]/div[2]/div/div[2]/form/div[3]/button"));
        Thread.sleep(1000);
        return element;
    }

    public static WebElement newPostcode (WebDriver sharedDriver) {
        element = sharedDriver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[7]/div[1]/div[1]"));
        return element;
    }

    //methods:
    public static String updatePostcode () throws InterruptedException {
        //update postcode
        int pCodeLength = bbcSettings.postCodeInput(driver).getText().length();
        for (int i = pCodeLength; i <= pCodeLength; i++){
            try{
                bbcSettings.postCodeInput(driver).sendKeys(Keys.BACK_SPACE);
            } catch (Exception e) {
                System.out.println("count wrong");
            }
        }
        bbcSettings.postCodeInput(driver).sendKeys("RG265AJ");
        return updatePostc;
    }

}
