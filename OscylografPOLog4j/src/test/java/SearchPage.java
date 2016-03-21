//package test;

/**
 * Created by GaBi on 04.02.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class SearchPage extends Page{

    private static final Logger logger=LogManager.getLogger("SearchPage");

    public SearchPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "lst-ib")                           //www.google.com.ua
    private WebElement searchBox;                     //Search box

    @FindBy(id = "sblsbb")                            //www.google.com.ua
    private WebElement searchSubmit;                  //Search button
 
    public ResultsPage search(String searchStatement){
        logger.info(searchBox);
        logger.info(searchSubmit);
        searchBox.clear();
        searchBox.sendKeys(searchStatement);
        searchSubmit.click();
        _driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return PageFactory.initElements(_driver, ResultsPage.class);
    }
}