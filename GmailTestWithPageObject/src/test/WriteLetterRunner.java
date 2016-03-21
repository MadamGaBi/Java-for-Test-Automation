package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WriteLetterRunner {
    WebDriver driver = new FirefoxDriver();

    @Before
    public void openPage() {
        String baseUrl = "https://accounts.google.com/";
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl + "/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=ru&service=mail#identifier");
        driver.manage().window().maximize();
    }

    @After
    public void closePage() {
        driver.close();
    }

    @Test
    public void mainTest() throws InterruptedException, IOException {
        LogIn gmailHome = PageFactory.initElements(driver, LogIn.class);
        InBox inBoxHome = gmailHome.logIn();
        WritePage writeLetter = inBoxHome.openWritePage();
        SentPage sendLetter = writeLetter.writeEmailAndSend();
        sendLetter.checkIfLetterIsSent();
    }
}