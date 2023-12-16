package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName",  "3 API 30");
        dc.setCapability("udid",  "emulator-5554");
        dc.setCapability("platformName",  "android");
        dc.setCapability("platformVersion",  "11");
        dc.setCapability("appPackage",  "com.google.android.calculator");
        dc.setCapability("appActivity",  "com.android.calculator2.Calculator");
        dc.setCapability("noReset",  true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, dc);

        //Action
        delay(5);
        MobileElement one = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement two = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement plus = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement negatif = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_sub");
        MobileElement equals = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");


        //MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
//        MobileElement btnOne = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='1']");
//        MobileElement btnTwo = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='2']");
//        MobileElement btnPlus = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='plus']");
//        MobileElement equals = driver.findElementByXPath("//android.widget.ImageButton[@content-desc='equals']");
//        MobileElement hasil = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']");
//        btnOne.click();
//        btnPlus.click();
//        btnTwo.click();
//        equals.click();
//        System.out.println(hasil.getText());

        one.click();
        plus.click();
        two.click();
        equals.click();
        delay(3);
        MobileElement resultPlus = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println(resultPlus.getText());
        negatif.click();
        two.click();
        equals.click();
        MobileElement resultNegatif = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        System.out.println(resultNegatif.getText());




    }
    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}