package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(className = "cart_quantity")
    List<WebElement> cartPageQty;

    public boolean isCartPageDisplayed() {
        return checkOutBtn.isDisplayed();
    }

    public void clickOnCheckoutBtn() {
        checkOutBtn.click();
    }

    public void checkQuantityOnCartPage(){
        int quantity=0;
        for(WebElement qty:cartPageQty){
            quantity+=Integer.parseInt(qty.getText());
        }
        ConfigReader.setConfigValue("cartpage.qty", String.valueOf(quantity));
    }
}
