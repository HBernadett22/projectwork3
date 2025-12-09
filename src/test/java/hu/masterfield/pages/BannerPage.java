package hu.masterfield.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BannerPage {
    WebElement okBtn;

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        okBtn.click();
    }
}
