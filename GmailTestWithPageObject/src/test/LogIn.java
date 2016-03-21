package test;

/**
 * Created by GaBi on 10.02.2016.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn extends Page{

    public LogIn (WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    private WebElement login;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement password;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    public InBox logIn(){
        Data userData = new Data();

        // Enter email
        login.clear();
        login.sendKeys(userData.login);
        nextButton.click();

        // Enter password
        password.clear();
        password.sendKeys(userData.password);

        // Click on button Send letter
        signInButton.click();

        return PageFactory.initElements(_driver, InBox.class);
    }
}
