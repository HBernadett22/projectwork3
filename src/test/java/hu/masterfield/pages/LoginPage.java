package hu.masterfield.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPage extends BasePage {
    //private WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"right-panel\"]/div[1]/div[2]/div/div/ol/li")
    private WebElement welcomeMessage;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div")
    private WebElement errorMessage;

    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
        } catch (TimeoutException e) {
            fail(e);
            return false;
        }
    }


//    public void checkMessage(String msg) {
//        assertEquals(msg, welcomeMessage);
//    }
//    public void checkErrorMessage(String expectedError) {
//        // assert ...
//        assertEquals(expectedError, errorMessage);
//    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkMessage(String msg) {
        assertEquals(msg, welcomeMessage.getText());
    }

    public void checkErrorMessage() {
        //assertEquals(expectedError, errorMessage.getText());
        assertTrue(wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed());
    }
}
