package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BannerPage extends BasePage {
    @FindBy(css = ".cc-nb-okagree")
    WebElement okBtn;

    //private WebDriverWait wait;

    public BannerPage(WebDriver driver) {
        super(driver);
        //    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://hun.digitalbank.masterfield.hu/bank/login");
    }

    public void acceptCookies() {
        okBtn.click();
    }
}


