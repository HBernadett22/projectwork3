package hu.masterfield.steps;

import hu.masterfield.driver.DriverInitializer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before( order = 0)
    public void globalSetup() {
        System.out.println("Global setup fut.");
        driver = DriverInitializer.initChrome();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("Login okay.");
    }

    @After(order =0)
    public void globalTeardown() {
        System.out.println("Login failed.");
    }
}
