package hu.masterfield.steps;

import hu.masterfield.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginpage;

    @Given("I open the DigitalBank page")
    public void opneDigitalBankPage() {
        driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
        LoginPage loginPage = new LoginPage(driver);
    }
//    @Given ("accept cookies")
//    public void acceptCookies() {
//        // cookies elfogadása
//    }

    @When("I sign in using {string} and {string}")
    public void signIn(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    @Then("the Üdvözöljük, Boglárka is displayed")
    public void chechWelcomeMessage() {
        String message = loginPage.getWellcomeMessage();
        assert message.equals("Üdvözöljük, Boglárka");
    }
    @Then ("an error message is visible {string}")
    public void checkErrorMessage(String expectedError) {
        String error = loginPage.getErrorMessage();
        assert error.equals(expectedError);
    }
}
