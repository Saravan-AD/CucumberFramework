package com.automation.steps;

import com.automation.pages.MonkeyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MonkeyTypeSteps {
    MonkeyPage mpage=new MonkeyPage();
    @Given("user get to the website")
    public void userGetToTheWebsite() throws InterruptedException {
        mpage.openMonkeySite();
        Thread.sleep(5000);
    }

    @Then("verify user is on the page")
    public void verifyUserIsOnThePage() {
        Assert.assertTrue(mpage.isMonkeyPageDisplayed());
    }

    @And("start typing")
    public void startTyping() throws InterruptedException {
        mpage.type();
    }
}
