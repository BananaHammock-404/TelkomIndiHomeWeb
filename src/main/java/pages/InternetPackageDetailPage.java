package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utility.Controller.*;

public class InternetPackageDetailPage {

    private final WebDriver driver;
    WebDriverWait wait;

    public InternetPackageDetailPage (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public InternetPackagePage clickBackToPaketInternetButton() throws InterruptedException {
        clickButtonByXpath(wait, "//a[contains(text(),'PAKET INTERNET')]");
        Thread.sleep(2000);
        return new InternetPackagePage(driver, wait);
    }

    public void clickLanggananSekarangButton(){
        clickButtonByXpath(wait, "(//button[contains(text(),'Langganan Sekarang')])[1]");
    }
    public String getNamaPaketDetail(){ // To see if the Name matches with what the user chose before
        return getTextByXpath(wait, "//h1[@class='cover-title animated fadeInUp delayp1']");
    }
    public String getMbpsPaketDetail(){ // To see if the Mbps matches with what the user chose before
        return getTextByXpath(wait, "(//h3[contains(text(),'')])[3]");
    }
    public String getPopupLoginText(){
        return getTextByXpath(wait, "//h3[contains(text(),'Masuk atau Daftar untuk Melanjutkan')]");
    }



}
