package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.MaximizeWindow;

public class Registration {

    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.out.println("####Driver found1");
         driver = new ChromeDriver();
        System.out.println("###Driver found2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("####Driver found");
        baseUrl = "https://www.masoko.com/";
        System.out.println("###Opening URL "+ baseUrl);
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void testRegistration() throws Exception {
        System.out.println("Starting Registration Execution");

        driver.get(baseUrl);
        System.out.println("###Opened URL "+ baseUrl);
        driver.findElement(By.className("registration-link__text")).click();
        driver.findElement(By.id("firstname")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("alex");
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("waiganjo");
        driver.findElement(By.id("mobile")).click();
        driver.findElement(By.id("mobile")).clear();
        driver.findElement(By.id("mobile")).sendKeys("+254708395926");
        driver.findElement(By.id("email_address")).click();
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("email_address")).sendKeys("alex.waiganjo@compulynx.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Admin@2018");
        driver.findElement(By.id("password-confirmation")).click();
        driver.findElement(By.id("password-confirmation")).clear();
        driver.findElement(By.id("password-confirmation")).sendKeys("Admin@2018");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign Up for Newsletter'])[1]/following::span[1]")).click();
        driver.findElement(By.id("password-confirmation")).click();
        driver.findElement(By.id("password-confirmation")).click();
        driver.findElement(By.id("password-confirmation")).clear();
        driver.findElement(By.id("password-confirmation")).sendKeys("Admin@2018");
        driver.findElement(By.id("email_address")).click();
        System.out.println((char)27 + "[32m" + "Finished Registration Execution");

    }
}
