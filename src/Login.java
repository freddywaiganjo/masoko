package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.out.println("####Driver Configured");
        driver = new ChromeDriver();
        System.out.println("####Driver Created");
        driver.manage().window().maximize();
        System.out.println("####Driver found");
        baseUrl = "https://www.masoko.com/";
        System.out.println("####Opening URL "+ baseUrl);
    }

    //Login with correct email but wrong password Test
    @Test
    public void testLoginWithWrongPassword() throws Exception {
        System.out.println("Starting Login with wrong password");
        driver.get(baseUrl);
        driver.findElement(By.className("authorization-link")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("alex.waiganjo@compulynx.com");
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("send2")).click();
        WebElement errorMessage = driver.findElement(By.className("message"));
        String messageString = errorMessage.getAttribute("value");
//        System.out.println("Message "+errorMessage.getText());
        collector.checkThat(messageString, equalTo("Invalid login or password."));
        System.out.println("Finished Login Execution");
    }

    //Positive Test
    @Test
    public void testLogin() throws Exception {
        System.out.println("Starting Login Execution");
        driver.get(baseUrl);
        driver.findElement(By.className("authorization-link")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("alex.waiganjo@compulynx.com");
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Admin@2018");
        driver.findElement(By.id("send2")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("btn-minicart-close")).click();
        driver.findElement(By.xpath("(./[normalize-space(text()) and normalize-space(.)='Secure Checkout'])[1]/following::div[3]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Log Out")).click();
        System.out.println("Finished Login Execution");
    }

    //    More Test scenarios can be added here

    @Test
    public void testLoginWithInvalidCredentials() throws Exception {
        //TODO
    }





    @After
    public void tearDown() throws Exception {
//        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
