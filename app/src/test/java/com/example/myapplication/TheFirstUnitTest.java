package com.example.myapplication;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class TheFirstUnitTest {
    private static final String APPIUM = "http://127.0.0.1:4723/wd/hub";
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Pixel XL API 30");
        driver = new AndroidDriver(new URL(APPIUM), capabilities);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addition_isCorrect() {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        //click on search field
        waiter.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.quicksearchbox:id/search_widget_text")));
        driver.findElement(AppiumBy.id("com.android.quicksearchbox:id/search_widget_text")).click();
        //type search text
        waiter.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.quicksearchbox:id/search_src_text")));
        driver.findElement(AppiumBy.id("com.android.quicksearchbox:id/search_src_text")).sendKeys("Gmail");
        //click on search button
        waiter.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.android.quicksearchbox:id/search_go_btn")));
        driver.findElement(AppiumBy.id("com.android.quicksearchbox:id/search_go_btn")).click();
        //click on search result
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[contains(@content-desc,'https://mail.google.com › mail Gmail - Google')]")));
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'https://mail.google.com › mail Gmail - Google')]")).click();
        //click on create new mail
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id='tltbt']/android.view.View[3]/android.widget.Button")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tltbt']/android.view.View[3]/android.widget.Button")).click();
        //type to email
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='composeto']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='composeto']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='composeto']")).sendKeys("andrijzaz@gmail.com");
        //type title mail
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcsubj']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcsubj']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcsubj']")).sendKeys("MyAppTest");
        //type mail text
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcbody']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcbody']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='cmcbody']")).sendKeys("Everything ends successful!");
        //close keyboard
        driver.navigate().back();
        //send mail
        waiter.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[@resource-id='cvtbt']/android.view.View[3]/android.widget.Button")));
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='cvtbt']/android.view.View[3]/android.widget.Button")).click();
    }
}
