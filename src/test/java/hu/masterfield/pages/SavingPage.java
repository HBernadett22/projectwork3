package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SavingPage extends BasePage {
    public SavingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"page-title\"]")
    private WebElement savingAccountsHeader;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/span[1]")
    private WebElement savingMessage;

    public void checkTitle(String expectedTitle) {
        // TODO: assert
        org.testng.Assert.assertEquals(
                savingAccountsHeader.getText().trim(),
                expectedTitle,
                "The saving accounts header text does not match!"
        );
    }

    public void checkMsg(String expectedMsg) {
        // TODO: assert
        org.testng.Assert.assertEquals(
                savingMessage.getText().trim(),
                expectedMsg,
                "The success message on the savings page does not match!"
        );
    }
}

