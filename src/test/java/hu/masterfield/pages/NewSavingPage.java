package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewSavingPage extends BasePage {
    public NewSavingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Megtakarítások")
    private WebElement savingTypeMain;

    @FindBy(id = "Egyéni")
    private WebElement savingOwnership;

    @FindBy(id = "name")
    private WebElement savingName;

    @FindBy(id = "openingBalance")
    private WebElement initialDeposit;

    @FindBy(id = "newSavingsSubmit")
    private WebElement submitButton;

    public void createNewSaving(String type, String ownership, String accName, int amount) {
        savingTypeMain.sendKeys(type);
        savingOwnership.sendKeys(ownership);
        // TODO
        savingName.sendKeys(accName);
        initialDeposit.sendKeys("" + amount);

        submitButton.click();
    }

}
