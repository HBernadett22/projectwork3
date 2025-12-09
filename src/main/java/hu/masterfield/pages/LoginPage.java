package hu.masterfield.pages;

import hu.masterfield.steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Hooks {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");
    private By welcomeMessage = By.xpath("//*[@id=\"right-panel\"]/div[1]/div[2]/div/div/ol/li");  //xpath
    private By errorMessage = By.xpath("/html/body/div[1]/div/div/div[2]/div");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername (String username) {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}

