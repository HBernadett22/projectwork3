package hu.masterfield.steps;

import hu.masterfield.pages.BannerPage;
import hu.masterfield.pages.NewSavingPage;
import hu.masterfield.pages.WelcomePage;
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
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewSavingSteps {
    private static WelcomePage welcomePage;
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static BannerPage bannerPage;
    private static NewSavingPage newSavingPage;

    @Before
    public static void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();

        // angol nyelvű böngésző indítása
        //options.addArguments("--lang=en-US");
        driver = new ChromeDriver(options);
        bannerPage = new BannerPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(900, 900));
    }

    @After
    public static void cleanup() {
        driver.quit();
    }

    @Given("I am singed in on the DigitalBank page")
    public void iAmSingedInOnTheDigitalBankPage() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.iOpenTheDigitalBankPage();
        loginSteps.acceptCookies();
        loginSteps.iSignInUsingAnd("KBoglarka", "KeBo123456");
        loginSteps.aMessageIsShownWith("Üdvözöljük, Boglárka");
    }


    //@When("I ckick on {string} and {string}")
    //public void iCkickOnAnd(String Megtakarítás, String ÚjMegtakarítás) {
    // Write code here that turns the phrase above into concrete actions
    // throw new PendingException();
    //xpath típus megtakarítás: /html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[2]/div[2]/label[1]
    //xpath tulajdonjog egyéni: /html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[3]/div[2]/label[1]
    //xpath számla neve: //*[@id="name"]
    //xpath kezdeti befizetés: //*[@id="openingBalance"]
    //xpath elküldés: //*[@id="newSavingsSubmit"]

    @When("iCkickOn<Megtakarítás>And<ÚjMegtakarítás>")

    @And("iCreateANewSavingAccountWith")
    public void i_create_new_saving_account_with(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);
        newSavingPage.selectMainSavingType(data.get("TakarékszámlaTípusa"));
        newSavingPage.selectSubSavingType(data.get("TakarékszámlaTípusa"));
        newSavingPage.enterSavingName(data.get("SzámlaNeve"));
        newSavingPage.enterInitialDeposit(data.get("KezdetiBefizetés"));

    @Then("a message is shown with {string}")
    public void aMessageIsShownWith(String savingAccounts) {
        savingPage.checkMessage(savingmsg);
    }
    @And("theSuccessMessageIsVisible {string}")
    public void theSuccessMessageIsVisible(String successmessage){
        savingPage.checkMessage(successmsg);
    }


    }
}
