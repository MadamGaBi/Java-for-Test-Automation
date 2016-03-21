package test;

/**
 * Created by BIL on 10.02.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InBox extends Page {

    public InBox(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='z0']/div[@role='button']")
    private WebElement createLetterButton;

    public WritePage openWritePage(){

        // Click on button Create letter
        createLetterButton.click();
        return PageFactory.initElements(_driver, WritePage.class);
    }
}
