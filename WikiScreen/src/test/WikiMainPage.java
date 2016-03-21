package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

/**
 * Created by GaBi on 11.02.2016.
 */

public class WikiMainPage extends Page{
    public WikiMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='mp-itn']/*/li[3]")
    private WebElement elementForScreenShot;

    public void getImageOfWikiMain() throws IOException, InterruptedException {
        File imageOfWikiMain = ScreenShot.getNecessaryImage(_driver);
        ScreenShot.getSubImage(elementForScreenShot, imageOfWikiMain);
    }
}
