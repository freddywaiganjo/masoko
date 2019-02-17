import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by Alex on 2/16/2019.
 */
public class AddToCart {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.out.println("####Driver Configured");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("####Driver found");
        baseUrl = "https://www.masoko.com/";
    }

    //Positive Test
    @Test
    public void testShopping() throws Exception {
        System.out.println("Starting addToCart Execution");
        driver.get(baseUrl + "customer/account/login/referer/aHR0cHM6Ly93d3cubWFzb2tvLmNvbS8%2C/");
        System.out.println("####Opening URL " + baseUrl + "customer/account/login/referer/aHR0cHM6Ly93d3cubWFzb2tvLmNvbS8%2C/");
        driver.findElement(By.className("authorization-link")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("alex.waiganjo@compulynx.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("Admin@2018");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("send2")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("electronics");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='electronic soni brush'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to Compare'])[3]/following::img[1]")).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        driver.findElement(By.className("minicart-wrapper__text")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("label_method_fcourier_fcourier")).click();
        driver.findElement(By.id("lipanampesa")).click();
        driver.findElement(By.id("lipanampesaNumber")).click();
        driver.findElement(By.id("lipanampesaNumber")).clear();
        driver.findElement(By.id("lipanampesaNumber")).sendKeys("0708395926");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add a Note'])[1]/following::button[1]")).click();

        System.out.println("Finished shopping finished");
    }

//    More Test scenarios can be added here

    @Test
    public void testShoppingNonExistingProduct() throws Exception {
        //TODO
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
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


