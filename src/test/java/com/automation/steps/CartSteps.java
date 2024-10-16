package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartSteps {

    CartPage cartPage=new CartPage();

    @Then("verify user is on cart page")
    public void verify_user_is_on_cart_page() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @When("user click on checkout button")
    public void user_click_on_checkout_button() {
        cartPage.clickOnCheckoutBtn();
    }


    @And("verify total items equals to items added in the cart")
    public void verifyTotalItemsEqualsToItemsAddedInTheCart() {
        cartPage.checkQuantityOnCartPage();
        Assert.assertEquals(Integer.parseInt(ConfigReader.getConfigValue("addedItems.qty")),Integer.parseInt(ConfigReader.getConfigValue("cartpage.qty")));
    }
}
