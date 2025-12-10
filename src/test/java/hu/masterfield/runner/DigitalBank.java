package hu.masterfield.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

//JUnit plattformnak jelezzük, hogy ez egy teszt suite és nem kell metódusokat írni,
//majd az annotáció határozza meg, mi fusson:
@Suite
//ezzel mondjuk meg, hogy a cucumber engines-t kell futtatni
// a .feature file-okat a cucumber fogja feldolgozni és nem a JUnit Jupiter próbálja meg
@IncludeEngines("cucumber")
//hibára futott scenariókat berakja a megadott txt-be:
@ConfigurationParameter(key = "cucumber.plugin", value = "rerun:target/cucumber_rerun.txt")
// beállítjuk a futtatandó feature file-t:
@SelectClasspathResource("features/digital_bank_login.feature")
//beállítjuk, hol találja a step-ek megvalósításait:
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hu.masterfield.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value =
        "pretty, " +
                "html:target/cucumber_report.html, " +
                "rerun:target/cucumber_rerun.txt, " +
                "json:target/cucumber_report.json")

public class DigitalBank {

}