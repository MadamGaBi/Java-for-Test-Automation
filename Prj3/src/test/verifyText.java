package test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class verifyText {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://docs.seleniumhq.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testVerifyText() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("Download")).click();
        try {
            assertTrue(driver.findElement(By.xpath("//*[@id='mainContent']/h3[2]")).getText().matches("^[\\s\\S]*Server[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(driver.findElement(By.xpath("//*[@id='mainContent']/table[1]")).getText().matches("^[\\s\\S]*Ruby[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertFalse(driver.findElement(By.xpath("//*[@id='mainContent']/table[2]")).getText().matches("^[\\s\\S]*Ruby[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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