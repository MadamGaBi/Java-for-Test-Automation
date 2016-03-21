package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WritePage extends Page{
 
    public WritePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement enterEmailBox;

    @FindBy(xpath = "//b[@class='Jd-JU']")
    private WebElement hintEmail;

    @FindBy(name = "subjectbox")
    private WebElement subjectBox;

    @FindBy(xpath = "//div[@class='a1 aaA aMZ']")
    private WebElement addAttachmentButton;

    @FindBy(xpath = "//div[@class='J-J5-Ji']/div[2][@role='button']")
    private WebElement sendButton;

    public SentPage writeEmailAndSend() throws IOException, InterruptedException {
        Data userData = new Data();

        WebDriverWait wait = new WebDriverWait(_driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(enterEmailBox));

        // Enter email of receiver
        enterEmailBox.click();
        enterEmailBox.clear();
        enterEmailBox.sendKeys(userData.receiverEmail);

        try{
        if (hintEmail.isEnabled()){
            hintEmail.click();
        }
        }catch (ElementNotFoundException e){}

        // Enter subject of letter
        subjectBox.click();
        subjectBox.clear();
        subjectBox.sendKeys(userData.subjectOfLetter);

        // Add attachment using AutoIT
        addAttachmentButton.click();
        Runtime.getRuntime().exec("D:\\Galyna\\Testing Epam\\Java\\GmailTestUsingAutoIT\\FileForUpload.exe");

        WebDriverWait waitForAttachment = new WebDriverWait(_driver, 15);
        waitForAttachment.until(ExpectedConditions.elementToBeClickable(By.className("dO")));

        // Click on button Send letter
        sendButton.click();

        return PageFactory.initElements(_driver, SentPage.class);
    }
}