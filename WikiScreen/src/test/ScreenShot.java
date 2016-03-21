package test;

/**
 * Created by GaBi on 08.02.2016.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;


public class ScreenShot {

    public static File getNecessaryImage(WebDriver driver) throws InterruptedException, IOException {

        // Capture entire page screenshot as buffer
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("screenshot.png"));

        return screenShot;
    }

    public static void getSubImage (WebElement elementForScreenShot, File screenShot) throws InterruptedException, IOException {

        // Retrieve width of element
        int imageElementWidth = elementForScreenShot.getSize().getWidth();

        // Retrieve height of element
        int imageElementHeight = elementForScreenShot.getSize().getHeight();

        // Get location(x y coordinates) of the element
        Point point = elementForScreenShot.getLocation();
        int x = point.getX();
        int y = point.getY();

        // Reading full image screenshot
        BufferedImage image = ImageIO.read(screenShot);

        // Cut Image using height, width and x y coordinates parameters
        BufferedImage subImage = image.getSubimage(x-5, y-5, imageElementWidth+10, imageElementHeight+10);
        ImageIO.write(subImage, "png", screenShot);

        // Save Image screenshot in directory
        File screensShotFile = new File("screenshot.png");
        FileUtils.copyFile(screenShot, screensShotFile);


    }
}

