package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Collections;
import java.util.List;

public class HomeSteps {

    HomePage homePage=new HomePage();
    List<Double> highToLow;
    List<Double> lowToHigh;
    List<String> aToz;
    List<String> zToa;
    static int qty;
    String qtyInBadge;
    @Then("verify user is on home page")
    public void verify_user_is_on_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user click on add to cart button of the first item")
    public void user_click_on_add_to_cart_button_of_the_first_item() {
        homePage.clickOnAddToCartOfFirstItem();
    }

    @Then("verify cart icon displays quantity one")
    public void verify_cart_icon_displays_quantity_one() {
        Assert.assertEquals(homePage.checkQuantityOnShoppingCart(), "1");
    }

    @When("user click on cart icon")
    public void user_click_on_cart_icon() {
        homePage.clickOnShoppingCartLink();
    }

    @Then("verify the page has been sorted Z to A")
    public void verifyThePageHasBeenSortedZToA() {
        Collections.sort(aToz,Collections.reverseOrder());

        Assert.assertEquals(aToz,zToa);
    }

    @When("product name is sorted from Z to A")
    public void productNameIsSortedFromZToA() {
        aToz=homePage.asscendingProdNames();
        zToa=homePage.sortProdByName();
    }

    @When("product name is sorted high to low price")
    public void productNameIsSortedHighToLowPrice() {
        lowToHigh=homePage.asscendingProdNamesByPrice();
        highToLow =homePage.sortProdByPrice();
    }

    @Then("verify the page has been sorted from high to low price")
    public void verifyThePageHasBeenSortedFromHighToLowPrice() {
        Collections.sort(lowToHigh,Collections.reverseOrder());

        Assert.assertEquals(lowToHigh, highToLow);
    }

    @When("all the items are added to the cart")
    public void allTheItemsAreAddedToTheCart() {
        qty=homePage.clickOnAddToCartOfAllItem();
    }

    @Then("verify the quantity of items added is equal to the number displayed in the cart icon")
    public void verifyTheQuantityOfItemsAddedIsEqualToTheNumberDisplayedInTheCartIcon() {
        qtyInBadge=homePage.checkQuantityOnShoppingCart();
//        System.out.println(Integer.parseInt(qtyInBadge));
        Assert.assertEquals(qty,Integer.parseInt(qtyInBadge));
    }

    @And("verify remove buttons are not present")
    public void verifyRemoveButtonsAreNotPresent() {
        Assert.assertEquals(0,homePage.removeCount());
    }
}
