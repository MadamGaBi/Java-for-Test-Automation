package test;

/**
 * Created by GaBi on 03.02.2016.
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;

public class Oscylohraf {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.google.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOscylohraf() throws InterruptedException, IOException {
        driver.get(baseUrl + "/?gws_rd=ssl");
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys("осцилограф");
        driver.findElement(By.name("btnG")).click();
        checkIfNecessaryPageIsFound();
    }

    public void checkIfNecessaryPageIsFound()throws InterruptedException, IOException{
        while (true){
            try {
                boolean necessaryPageIsFound = driver.findElement(By.xpath("//*[@id='center_col']/div[2]")).getText().matches("^[\\s\\S]*vit\\.ua[\\s\\S]*$");

                // If link to vit.ua page is found
                if (necessaryPageIsFound) {

                    // Print number of page
                    System.out.println(driver.findElement(By.xpath("//div[@id='resultStats']")).getText());

                    // Get screenshot of page and save it
                    getScreenShot();
                    break;
                } else {

                    // If link to vit.ua page is not found
                    // Go to the next page with list of links
                    try {
                        driver.findElement(By.xpath("//*[@id='pnnext']/span[2]")).click();
                    } catch (NoSuchElementException exp) {
                        System.out.println("Sorry, the page \"vit.ua\" was not found");
                        break;
                    }
                }
            } catch (Error e) {
            verificationErrors.append(e.toString());
            }
        }
    }

    public void getScreenShot () throws InterruptedException, IOException {
        WebElement imageElement = driver.findElement(By.xpath("//*[@class='f kv _SWb']/cite[contains(text(),'vit.ua')]"));

        // Capture entire page screenshot as buffer
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Retrieve width of element
        int imageElementWidth = imageElement.getSize().getWidth();

        // Retrieve height of element
        int imageElementHeight = imageElement.getSize().getHeight();

        // Get location(x y coordinates) of the element
        Point point = imageElement.getLocation();
        int x = point.getX();
        int y = point.getY();

        // Reading full image screenshot
        BufferedImage image = ImageIO.read(screenShot);

        // Draw rectangle around link vit.ua
        Graphics graph = image.getGraphics();
        graph.setColor(Color.red);
        graph.drawRect(x-10, y-25, 530, 80);
        graph.dispose();
        ImageIO.write(image, "png", screenShot);

        // Save Image screenshot in directory
        File screensShotFile = new File("screenshot.png");
        FileUtils.copyFile(screenShot, screensShotFile);
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
