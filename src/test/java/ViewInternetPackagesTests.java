import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class ViewInternetPackagesTests extends BaseTests {

    HomePage homePage;
    InternetPackagePage internetPackagePage;
    InternetPackageDetailPage internetPackageDetailPage;
    String first = "1";
    String third = "3";
    String sixth = "6";
    String packageName;
    String packageMBPS;

    @Test(priority = 1, description = "Assert the correct Page & click on 'Cari Paket'. ")
    public void navigateProdukInternet() throws InterruptedException {
        homePage = new HomePage(driver,wait);
        assertEquals(homePage.getWelcomeMessage(), // Assert we are on the HomePage
                "Selamat datang di IndiHome!",
                "Wrong URL or section");
        internetPackagePage = new InternetPackagePage(driver, wait);
        internetPackagePage = homePage.clickCariPaketButton();
        assertEquals(internetPackagePage.getHeaderPageText(), // Assert Successfully navigated to Produk Internet
                "Produk Internet",
                "Wrong Page");
    }

    @Test(priority = 2, description = "Search for the First package and assert the details")
    public void checkFirstPackage() throws InterruptedException {

        internetPackagePage.scrollToPaketFirstRow();
        Thread.sleep(1000);
        packageName = internetPackagePage.getNamaPaket(first); // To match with the Details page later
        packageMBPS = internetPackagePage.getMbpsPaket(first); // To match with the Details page later


        internetPackageDetailPage = new InternetPackageDetailPage(driver, wait);
        internetPackageDetailPage = internetPackagePage.clickLihatDetailButton(first); // Direct to the Packages Detail
        Thread.sleep(2000);

        assertEquals(internetPackageDetailPage.getNamaPaketDetail().toUpperCase(Locale.ROOT),
                packageName,
                "Package Name does not match with the cards shown");
        assertEquals(internetPackageDetailPage.getMbpsPaketDetail(),
                packageMBPS,
                "Package Mbps does not match with the cards shown");

        internetPackagePage = internetPackageDetailPage.clickBackToPaketInternetButton();

    }

    @Test(priority = 3, description = "Search for the Third package and assert the details")
    public void checkThirdPackage() throws InterruptedException {

        internetPackagePage.scrollToPaketFirstRow();
        Thread.sleep(1000);
        packageName = internetPackagePage.getNamaPaket(third); // To match with the Details page later
        packageMBPS = internetPackagePage.getMbpsPaket(third); // To match with the Details page later


        internetPackageDetailPage = new InternetPackageDetailPage(driver, wait);
        internetPackageDetailPage = internetPackagePage.clickLihatDetailButton(third); // Direct to the Packages Detail
        Thread.sleep(2000);

        assertEquals(internetPackageDetailPage.getNamaPaketDetail().toUpperCase(Locale.ROOT),
                packageName,
                "Package Name does not match with the cards shown");
        assertEquals(internetPackageDetailPage.getMbpsPaketDetail(),
                packageMBPS,
                "Package Mbps does not match with the cards shown");

        internetPackagePage = internetPackageDetailPage.clickBackToPaketInternetButton();
    }

    @Test(priority = 4, description = "Search for the Sixth package and assert the details")
    public void checkSixthPackage() throws InterruptedException {

        internetPackagePage.scrollToPaketSecondRow();
        Thread.sleep(1000);
        packageName = internetPackagePage.getNamaPaket(sixth); // To match with the Details page later
        packageMBPS = internetPackagePage.getMbpsPaket(sixth); // To match with the Details page later


        internetPackageDetailPage = new InternetPackageDetailPage(driver, wait);
        internetPackageDetailPage = internetPackagePage.clickLihatDetailButton(sixth); // Direct to the Packages Detail
        Thread.sleep(2000);

        assertEquals(internetPackageDetailPage.getNamaPaketDetail().toUpperCase(Locale.ROOT),
                packageName,
                "Package Name does not match with the cards shown");
        assertEquals(internetPackageDetailPage.getMbpsPaketDetail(),
                packageMBPS,
                "Package Mbps does not match with the cards shown");

        internetPackageDetailPage.clickLanggananSekarangButton();
        assertEquals(internetPackageDetailPage.getPopupLoginText(),
                "Masuk atau Daftar untuk Melanjutkan",
                "User might have already logged in or Popup did not show");

    }





}
