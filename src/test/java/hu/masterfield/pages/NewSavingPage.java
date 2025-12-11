package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class NewSavingPage extends SavingBasePage {
    public NewSavingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private List<WebElement> savingTypeMainList;
    private List<WebElement> savingTypeSubList;
    private List<WebElement> savingNameList;
    private List<WebElement> initialDepositList;
    private List<WebElement> submitButtonList;

    public void setSavingTypeMainList(List<WebElement> list) {
        this.savingTypeMainList = list;
    }

    public void setSavingTypeSubList(List<WebElement> list) {
        this.savingTypeSubList = list;
    }

    public void setSavingNameList(List<WebElement> list) {
        this.savingNameList = list;
    }

    public void setInitialDepositList(List<WebElement> list) {
        this.initialDepositList = list;
    }

    public void setSubmitButtonList(List<WebElement> list) {
        this.submitButtonList = list;
    }

    // metódusok:
    public void selectMainSavingType(String text) {
        for (WebElement element : savingTypeMainList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    public void selectSubSavingType(String text) {
        for (WebElement element : savingTypeSubList) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    public void enterSavingName(String name) {
        for (WebElement element : savingNameList) {
            if (element.getAttribute("placeholder").contains("Számla neve")) {
                element.sendKeys(name);
                break;
            }
        }
    }

    public void enterInitialDeposit(String value) {
        for (WebElement element : initialDepositList) {
            if (element.getAttribute("placeholder").contains("Kezdeti befizetés")) {
                element.sendKeys(value);
                break;
            }
        }
    }

    public void clickSubmit() {
        for (WebElement element : submitButtonList) {
            if (element.getText().contains("Elküldés")) {
                element.click();
                break;
            }
        }
    }


}
