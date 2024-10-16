package com.automation.pages;

import com.automation.pages.BasePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ReviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "inventory_item_price")
    List<WebElement> itemPrice;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement total;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void priceCalc(){
        List<Double> prodPrice=new ArrayList<>();
        for(WebElement price:itemPrice){
            String priceText = price.getText().replace("$", "").replace(",", "").trim();
            prodPrice.add(Double.parseDouble(priceText));
        }
        double sumPrice = prodPrice.stream().mapToDouble(Double::doubleValue).sum();
        String priceText = tax.getText().replace("Tax:", "").replace("$","").trim();
        sumPrice=sumPrice+Double.parseDouble(priceText);
        ConfigReader.setConfigValue("actual.price", String.valueOf(sumPrice));
    }

    public void getTotalPrice(){
        String priceText = total.getText().replace("Total:", "").replace("$","").trim();
        ConfigReader.setConfigValue("displayed.price", priceText);
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }
}
