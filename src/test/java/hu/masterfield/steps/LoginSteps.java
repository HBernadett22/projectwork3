package hu.masterfield.steps;

import hu.masterfield.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps {
    private static LoginPage loginPage;
    private static WebDriver driver;
    private static WebDriverWait wait;
    LoginSteps bannerPage = null;

    @Before
    public static void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();

        // angol nyelvű böngésző indítása
        //options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(900, 900));
    }

    @After
    public static void cleanup() {
        driver.quit();
    }

    @Given("I open the DigitalBank page")
    public void iOpenTheDigitalBankPage() {
        //driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
        loginPage = new LoginPage(driver);
        loginPage.isLoaded();
    }

    @And("accept cookies")
    public void acceptCookies() {
        // TODO
        bannerPage.acceptCookies();
    }

    @When("I sign in using {string} and {string}")
    public void iSignInUsingAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("a message is shown with {string}")
    public void aMessageIsShownWith(String msg) {
        loginPage.checkMessage(msg);
    }

    @Then("an error message is visible {string}")
    public void anErrorMessageIsVisible(String expectedError) {
        loginPage.checkErrorMessage(expectedError);
    }

}
