package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CatatanKeuanganDanPemasukanTest {
    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "3 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "com.chad.financialrecord");
        dc.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        delay(5);
    }

    @Test(priority = 1)
    public void transaksiPemasukandanpengeluaran() {
        delay(4);
        MobileElement menuTransaksi = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        menuTransaksi.click();
        delay(3);

        //Menu Income
        MobileElement menuPemasukkan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        menuPemasukkan.click();
        System.out.println(menuPemasukkan.getText());
        Assert.assertTrue(menuPemasukkan.getText().contains("Pemasukan"));

        //Fiture Date
        MobileElement clickDate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvDate']");
        clickDate.click();
        MobileElement chooseDate = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc='15 Desember 2023']");
        chooseDate.click();
        MobileElement btnOkDate = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1']");
        btnOkDate.click();
        delay(3);
        System.out.println(clickDate.getText());
        Assert.assertEquals(clickDate.getText(), "15 Des 2023");
        delay(4);

        //Category
        MobileElement clickCategory = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[@resource-id='com.chad.financialrecord:id/spCategory']");
        clickCategory.click();
        MobileElement chooseCategory = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Gaji']");
        chooseCategory.click();
        delay(6);
        MobileElement category = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName']");
        System.out.println(category.getText());
        Assert.assertEquals(category.getText(), "Gaji");
        delay(6);

        //Pake sendKeys
        MobileElement jumlah = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id='com.chad.financialrecord:id/etAmount']");
        jumlah.click();
        jumlah.sendKeys("7.000.000");
        System.out.println(jumlah.getText());
        Assert.assertEquals(jumlah.getText(), "7.000.000");

        //Keterangan
        MobileElement keterangan = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id='com.chad.financialrecord:id/etNote']");
        keterangan.click();
        keterangan.sendKeys("Bulan ini harus hemat, saving sekitar 5-6 juta");
        System.out.println(keterangan.getText());
        Assert.assertEquals(keterangan.getText(), "Bulan ini harus hemat, saving sekitar 5-6 juta");

        //ButtonSimpan
        MobileElement btnSaveIncome = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id='com.chad.financialrecord:id/btSave']");
        System.out.println(btnSaveIncome.getText());
        Assert.assertEquals(btnSaveIncome.getText(), "SIMPAN");
        btnSaveIncome.click();
        delay(10);
        System.out.println("Finish Transaksi Pemasukan");

    }

    //Action Transaksi Pengeluaran
    @Test(priority = 2)
    public void transaksiPengeluaran() {
        delay(4);
        MobileElement menuTransaksiPengeluaram = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        menuTransaksiPengeluaram.click();
        delay(4);

        //Menu Outcome
        MobileElement menuOutcome = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/btnExpense']");
        menuOutcome.click();
        System.out.println(menuOutcome.getText());
        Assert.assertTrue(menuOutcome.getText().contains("Pengeluaran"));

        //Button Date
        MobileElement clickPengeluaranDate = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvDate']");
        clickPengeluaranDate.click();
        MobileElement menuchooseDate = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc='15 Desember 2023']");
        menuchooseDate.click();
        delay(3);
        MobileElement btnOkDateOut = (MobileElement) driver.findElementById("android:id/button1");
        btnOkDateOut.click();
        delay(2);
        System.out.println(clickPengeluaranDate.getText());
        Assert.assertEquals(clickPengeluaranDate.getText(), "15 Des 2023");
        delay(4);

        //Button Cattegory
        MobileElement menuCategory = (MobileElement) driver.findElementByXPath("//android.widget.Spinner[@resource-id='com.chad.financialrecord:id/spCategory']");
        menuCategory.click();
        MobileElement clickCategory = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName' and @text='Mobil']");
        clickCategory.click();
        delay(5);
        MobileElement resultCategory = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.chad.financialrecord:id/tvName']");
        System.out.println(resultCategory.getText());
        Assert.assertEquals(resultCategory.getText(), "Mobil");
        delay(5);

        MobileElement jumlah = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id='com.chad.financialrecord:id/etAmount']");
        jumlah.click();
        jumlah.sendKeys("1.000.000");
        System.out.println(jumlah.getText());
        Assert.assertEquals(jumlah.getText(), "1.000.000");

        //Fitur Note
        MobileElement menuPengeluaranKeterangan = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@resource-id='com.chad.financialrecord:id/etNote']");
        menuPengeluaranKeterangan.click();
        menuPengeluaranKeterangan.sendKeys("Cicilan mobil ke 12 bulan");
        System.out.println(menuPengeluaranKeterangan.getText());
        Assert.assertEquals(menuPengeluaranKeterangan.getText(), "Cicilan mobil ke 12 bulan");

        MobileElement btnSavePengeluaran = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id='com.chad.financialrecord:id/btSave']");
        delay(2);
        System.out.println(btnSavePengeluaran.getText());
        Assert.assertEquals(btnSavePengeluaran.getText(), "SIMPAN");
        btnSavePengeluaran.click();
        delay(5);

        System.out.println("Finish Testing Transaksi Pengeluaran");
    }

    @AfterClass
    public void finish() {
        delay(6);
        driver.quit();
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
