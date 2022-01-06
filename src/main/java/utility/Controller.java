package utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Controller {


    /* Clicking a button that has an xpath on it */
    public static void clickButtonByXpath(WebDriverWait wait, String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    /* Getting a text by Xpath */
    public static String getTextByXpath(WebDriverWait wait, String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
    }

    public static void scrollToElement(WebDriver driver, By element) {
        // identify element
        WebElement m = driver.findElement(element);
        // Javascript executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
    }

}