//package test;

/**
 * Created by GaBi on 11.02.2016.
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScreenShot {

    private static final Logger logger=LogManager.getLogger("SearchPage");

    public static void getScreenShot(WebDriver _driver) throws InterruptedException, IOException {
        WebElement imageElement = _driver.findElement(By.xpath("//*[@class='f kv _SWb']/cite[contains(text(),'vit.ua')]"));
        logger.info(imageElement);

        // Capture entire page screenshot as buffer
        File screenShot = ((TakesScreenshot) _driver).getScreenshotAs(OutputType.FILE);

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
}
