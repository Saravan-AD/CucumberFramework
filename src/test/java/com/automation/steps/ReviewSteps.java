package com.automation.steps;

import com.automation.pages.ReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReviewSteps {

    ReviewPage reviewPage=new ReviewPage();
    @Then("verify user is on review page")
    public void verify_user_is_on_review_page() {
        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
    }
    @When("user click on Finish button")
    public void user_click_on_finish_button() {
        reviewPage.clickOnFinishBtn();
    }

    @And("verify price displayed is equal to the actual price")
    public void verifyPriceDisplayedIsEqualToTheActualPrice() {
        double totalPrice= reviewPage.priceCalc();
        Assert.assertEquals(reviewPage.getTotalPrice(),totalPrice,0);
    }
}
