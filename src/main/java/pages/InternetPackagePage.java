package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class InternetPackagePage {

    private final WebDriver driver;
    WebDriverWait wait;

    public InternetPackagePage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public InternetPackageDetailPage clickLihatDetailButton(String paketKe) throws InterruptedException { // Choose which package to see the detail
        clickButtonByXpath(wait, "(//span[contains(text(),'Lihat Detail')])[\"" +paketKe+ "\"]");
        Thread.sleep(2000);
        return new InternetPackageDetailPage(driver, wait);
    }
    public String getNamaPaket(String paketKe){ // Fetch the name to match with the Package detail chosen
        return getTextByXpath(wait, "/html[1]/body[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/section[1]/div[1]/div[\"" +paketKe+ "\"]/a[1]/div[2]/div[1]/div[1]/p[1]");
    }
    public String getMbpsPaket(String paketKe){ // Fetch the Mbps to match with the Package detail chosen
        return getTextByXpath(wait, "/html[1]/body[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/section[1]/div[1]/div[\"" +paketKe+ "\"]/a[1]/div[1]/div[1]/div[1]/h3[1]");
    }
    public void scrollToPaket(String paketKe){
        scrollToElement(driver, By.xpath("(//span[contains(text(),'Lihat Detail')])[\"" +paketKe+ "\"]"));
    }
}
