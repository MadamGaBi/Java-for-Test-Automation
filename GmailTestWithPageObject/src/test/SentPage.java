package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import java.io.IOException;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.*;


public class SentPage extends Page{
 
    public SentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, 'https://mail.google.com/mail/u/0/#sent')]")
    private WebElement sentLettersList;

    @FindBy(xpath = "//*[@class = 'BltHke nH oy8Mbf'][@role='main']")
    private WebElement getSentLettersList;

    public void checkIfLetterIsSent() throws InterruptedException, IOException {
        Data userData = new Data();

        // Go to folder with sent letters
        sentLettersList.click();

        // Check if there is letter just has been sent
        try {
            assertEquals("", true, getSentLettersList.getText().contains(userData.subjectOfLetter));
        } catch (ElementNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }
}