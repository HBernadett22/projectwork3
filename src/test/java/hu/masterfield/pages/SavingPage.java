package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingPage {

    WebDriver driver;

    public SavingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"page-title\"]")
    private WebElement savingAccountsHeader;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/span[1]")
    private WebElement savingMessage;

    public boolean isSavingAccountsVisible() {
        return savingAccountsHeader.isDisplayed();
    }

    public boolean isSavingMessageVisible() {
        return savingMessage.isDisplayed();
    }

}
