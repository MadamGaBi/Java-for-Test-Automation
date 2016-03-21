package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends Page{

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id='center_col']/div[2]")                    //www.google.com.ua
    private WebElement resultStats;

    @FindBy(xpath = "//*[@id='pnnext']")
    private WebElement buttonNext;

    public String getPagesReturned() throws InterruptedException, IOException {
        String necessaryPageIsFound = null;

        do{
            try {
                // Check if the link vit.ua is present on the page
                if (resultStats.getText().matches("^[\\s\\S]*vit\\.ua[\\s\\S]*$")) {
                    necessaryPageIsFound = _driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
                    ScreenShot.getScreenShot(_driver);
                    break;
                } else {
                    try {
                        buttonNext.click();
                    } catch (NoSuchElementException exp) {
                        necessaryPageIsFound = "Sorry, the page \"vit.ua\" was not found";
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            } while (_driver.findElement(By.xpath("//*[@class='flyr-c']")) != null);
        return necessaryPageIsFound;
    }
}