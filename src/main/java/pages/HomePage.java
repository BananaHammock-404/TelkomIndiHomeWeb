package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class HomePage {

    private final WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getWelcomeMessage(){ // to ensure we are in the right URL
        return getTextByXpath(wait, "//h3[contains(text(),'Selamat datang di IndiHome!')]");
    }

    public InternetPackagePage clickCariPaketButton() throws InterruptedException {
        clickButtonByXpath(wait, "//a[@class='btn btn-light']");
        Thread.sleep(2000);
        return new InternetPackagePage(driver, wait);
    }



}
