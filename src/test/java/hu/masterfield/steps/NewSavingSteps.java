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

    @When("iOpenTheMenü")
    public void i_click_on_menu_and_submenu(String menu, String submenu) {
        // Kattintás a fő menü elemre (Megtakarítás)
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"savings-menu\"]"));
        mainMenu.click();

        // Kattintás a második menü elemre (Új megtakarítás)
        WebElement subMenu = driver.findElement(By.xpath("///*[@id=\"new-savings-menu-item\"]"));
        subMenu.click();
    }
    @And("iCreateANewSavingAccountWith")
    public void i_create_new_saving_account_with(io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> data = dataTable.asMaps().get(0);
        newSavingPage.selectMainSavingType(data.get("TakarékszámlaTípusa"));
        newSavingPage.selectSubSavingType(data.get("TakarékszámlaTulajdonjoga"));
        newSavingPage.enterSavingName(data.get("SzámlaNeve"));
        newSavingPage.enterInitialDeposit(data.get("KezdetiBefizetés"));

        @FindBy(id = "newSavingsSubmit")
        private WebElement newSavingsSubmitButton;
        newSavingsSubmitButton.click();

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
