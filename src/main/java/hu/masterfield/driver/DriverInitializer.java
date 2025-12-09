package hu.masterfield.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static hu.masterfield.driver.BrowserType.*;

public class DriverInitializer {
    public static WebDriver initChrome(){
        return initDriver(CHROME_SELMGR);
    }
    public static WebDriver initFirefox() {
        return initDriver(FIREFOX_SELMGR);
    }

    public static WebDriver initEdge() {
        return initDriver(EDGE_SELMGR);
    }
    private static WebDriver initDriver (BrowserType type) {
        switch (type) {
            case CHROME_SELMGR:
                ChromeOptions options = new ChromeOptions();

                //inkognitó módban indítjuk:
                options.addArguments("--incognito");
                // Server ne nézze automata botnak:
                options.addArguments("--disable-blink-features=AutomationControlled");
                // letiltja a "chorme is being contorlled by automated test sw" infobar-t:
                options.addArguments("--disable-infobars");
                //max méretben nyíljon meg:
                options.addArguments("--start-maximized");

                return new ChromeDriver(options);
            case FIREFOX_SELMGR:
                return new FirefoxDriver();
            case EDGE_SELMGR:
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Incorrect browser type!");
        }
    }
}
