package test;

/**
 * Created by GaBi on 02.02.2016.
 */

import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import sun.java2d.SunGraphics2D;

public class ScreenShot {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void openPage() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }

    @After
    public void closePage() {
        driver.close();
    }

    @Test
    public void getNecessaryImage() throws InterruptedException, IOException {

        //Locate Image element to capture screenshot
        WebElement imageElement = driver.findElement(By.xpath("//*[@id='mp-itn-img']/*/a/img"));

        //Call getSubImage function to capture screenshot of element
        getSubImage(imageElement);
    }

    public void getSubImage (WebElement imageElement) throws InterruptedException, IOException {
        //Capture entire page screenshot as buffer
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Retrieve width of element
        int imageElementWidth = imageElement.getSize().getWidth();

        //Retrieve height of element
        int imageElementHeight = imageElement.getSize().getHeight();

        //get location(x y coordinates) of the element
        Point point = imageElement.getLocation();
        int x = point.getX();
        int y = point.getY();

        //Reading full image screenshot
        BufferedImage image = ImageIO.read(screenShot);

        //draw rectangle around image
        Graphics graph = image.getGraphics();
        graph.setColor(Color.red);
        graph.drawRect(x, y, imageElementWidth, imageElementHeight);
        graph.dispose();
        ImageIO.write(image, "png", screenShot);

        //cut Image using height, width and x y coordinates parameters
        BufferedImage subImage = image.getSubimage(x-5, y-5, imageElementWidth+10, imageElementHeight+10);
        ImageIO.write(subImage, "png", screenShot);

        //save Image screenshot in directory
        File screensShotFile = new File("screenshot.png");
        FileUtils.copyFile(screenShot, screensShotFile);
    }
}
