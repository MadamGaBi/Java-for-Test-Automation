package test;

/**
 * Created by GaBi on 08.02.2016.
 */

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class ScreenRunner {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void openPage() {
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
//        driver.manage().window().maximize();
    }

    @After
    public void closePage() {
        driver.close();
    }

    @Test
    public void run() throws InterruptedException, IOException {
        WikiMainPage wikiHome = PageFactory.initElements(driver, WikiMainPage.class);
        wikiHome.getImageOfWikiMain();
    }
}
