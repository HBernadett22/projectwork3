package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BannerPage extends BasePage {
    @FindBy(css = ".cc-nb-okagree")
    WebElement okBtn;

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
    }

//    public void acceptCookies() {
//        okBtn.click();
//    }
}
