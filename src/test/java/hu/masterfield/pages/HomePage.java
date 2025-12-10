package hu.masterfield.pages;

import io.cucumber.java.PendingException;

public class HomePage {
    public HomePage() {
        Then("^a message is show with \"([^\"]*)\"$", (String arg0) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
