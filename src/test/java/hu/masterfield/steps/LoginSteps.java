package hu.masterfield.steps;

import hu.masterfield.pages.BannerPage;
import hu.masterfield.pages.LoginPage;
import hu.masterfield.pages.NewSavingPage;
import hu.masterfield.pages.SavingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class LoginSteps {
    private static LoginPage loginPage;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static BannerPage bannerPage;
    private static NewSavingPage newSavingPage;
    private static SavingPage savingPage;

    @Before
    public static void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        // angol nyelvű böngésző indítása
        //options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        bannerPage = new BannerPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().setSize(new Dimension(900, 900));
    }

    @After
    public static void cleanup() {
        driver.quit();
    }

    @Given("I open the DigitalBank page")
    public void iOpenTheDigitalBankPage() {
        driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
        loginPage = new LoginPage(driver);
        loginPage.isLoaded();
    }

    @And("accept cookies")
    public void acceptCookies() {
        bannerPage.acceptCookies();
    }

    @When("I sign in using {string} and {string}")
    public void iSignInUsingAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("a message is shown on the home page with {string}")
    public void aMessageIsShownWithLogin(String msg) {
        loginPage.checkMessage(msg);
    }

    @Then("a login error message is visible")
    public void anErrorMessageIsVisible() {
        loginPage.checkErrorMessage();
    }

    // New saving:
    @Given("I am signed in on the DigitalBank page")
    public void iAmSignedInOnTheDigitalBankPage() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.iOpenTheDigitalBankPage();
        loginSteps.acceptCookies();
        loginSteps.iSignInUsingAnd("KBoglarka", "KeBo123456");
        loginSteps.aMessageIsShownWithLogin("Üdvözöljük, Boglárka");
    }
// VAGY
//    @Given("I am signed in on the DigitalBank page")
//    public void iAmSignedInOnTheDigitalBankPage() {
//        iOpenTheDigitalBankPage();
//        acceptCookies();
//        iSignInUsingAnd("KBoglarka", "KeBo123456");
//    }
// VAGY
//    @Given("I am signed in on the DigitalBank page")
//    public void iAmSignedInOnTheDigitalBankPage() {
//        driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
//        loginPage = new LoginPage(driver);
//        loginPage.isLoaded();
//    }
//    @And("accept cookies")
//    public void acceptCookies() {
//        bannerPage.acceptCookies();
//    }
//    @And("I sign in using {string} and {string}")
//    public void iSignInUsingAnd(String username, String password) {
//        loginPage.login(username, password);
// VAGY
//    @Given("I am signed in on the DigitalBank page")
//    public void iAmSignedInOnTheDigitalBankPage() {
//        // Write code here that turns the phrase above into concrete actions
//        iOpenTheDigitalBankPage();
//        acceptCookies();
//        iSignInUsingAnd("KBoglarka", "KeBo123456");
//        throw new PendingException();
//    }

    @When("iOpenTheMenü")
    public void i_click_on_menu_and_submenu(String menu, String submenu) {
        // Kattintás a fő menü elemre (Megtakarítás)
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"savings-menu\"]"));
        mainMenu.click();

        // Kattintás a második menü elemre (Új megtakarítás)
        WebElement subMenu = driver.findElement(By.xpath("///*[@id=\"new-savings-menu-item\"]"));
        subMenu.click();
    }

    @FindBy(id = "newSavingsSubmit")
    private WebElement newSavingsSubmitButton;

    @When("I navigate to New Savings page")
    public void iNavigateToNewSavingsPage() {
        // TODO: navigalas
        // Kattintás a főmenü elemre (Megtakarítás)
        WebElement mainMenu = driver.findElement(By.id("savings-menu"));
        mainMenu.click();
        // Kattintás az almenü elemre (Új megtakarítás)
        WebElement subMenu = driver.findElement(By.id("new-savings-menu-item"));
        subMenu.click();
    }

    @And("I create a new saving account with")
    public void iCreateANewSavingAccountWith(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        newSavingPage.createNewSaving(data.get("TakarékszámlaTípusa"),
                data.get("TakarékszámlaTulajdonjoga"),
                data.get("SzámlaNeve"),
                Integer.parseInt(data.get("KezdetiBefizetés")));
    }

    @And("the success message is visible {string}")
    public void theSuccessMessageIsVisible(String arg0) {
        savingPage.checkMsg(arg0);
    }

    @Then("a message is shown on the savings page with {string}")
    public void aMessageIsShownOnTheSavingsPageWith(String arg0) {
        savingPage.checkTitle(arg0);
    }
}

