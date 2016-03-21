package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchRunner {

    WebDriver driver = new FirefoxDriver();

    @Before
    public void openPage() {
        driver.get("https://www.google.com.ua/");
//        driver.manage().window().maximize();
    }

    @After
    public void closePage() {
        driver.close();
    }

    @Test
     public void mainTest() throws InterruptedException, IOException {
        SearchPage googleHome = PageFactory.initElements(driver, SearchPage.class);
        ResultsPage searchResults = googleHome.search("осцилограф");
        System.out.println(searchResults.getPagesReturned());
    }
}