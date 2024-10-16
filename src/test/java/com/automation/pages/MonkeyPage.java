package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class MonkeyPage extends BasePage {

    @FindBy(id = "words")
    WebElement words;

    @FindBy(id = "wpmChart")
    WebElement canvas;

    public void openMonkeySite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public boolean isMonkeyPageDisplayed() {
        return words.isDisplayed();
    }

    public void type() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Actions actions = new Actions(driver);
        while (true) {
            WebElement activeWord = words.findElement(By.xpath("//div[@class='word active']"));
            String textToType = activeWord.getText();
            System.out.println(textToType);
            actions.sendKeys(textToType).perform();
            //        for (char c : textToType.toCharArray()) {
            //            actions.sendKeys(String.valueOf(c)).perform(); // Sends each character one by one
            //        }
            actions.sendKeys(" ").perform();
            if (canvas.isDisplayed())
                break;
        }
    }
}


//    public void type() throws InterruptedException {
//        int length=0;
//        Actions actions=new Actions(driver);
//        words.click();
//        WebElement activeWords=words.findElement(By.xpath("//div[@class='word active']"));
//        String para=activeWords.getText().replace("\n", " ");
//        System.out.println(para);
////        while(true) {
////            int i;
////            List<WebElement> letter=words.findElements(By.xpath("//div[@class='word active']/letter"));
////            for ( i=0;i<letter.size();i++) {
////                letter=words.findElements(By.xpath("//div[@class='word active']/letter"));
////                System.out.println(letter.get(i).getText());
////                if (!letter.get(i).getText().equals(""))
////                    actions.keyDown(letter.get(i).getText()).perform();
////                else
////                    Thread.sleep(2000);
////            }
////            i--;
////            length+=i;
////            if(length==letters.size())
////                break;
////        }
//        for(int i=0;;i++) {
//            actions.keyDown(Character.toString(para.charAt(i))).perform();
//            if(i==para.length()-1) {
//                activeWords=words.findElement(By.xpath("//div[@class='word active']"));
//                para = activeWords.getText().replace("\n", " ");
//                i=0;
//            }
////            if(!(para.equals(words.getText().replace("\n", " "))) && i==para.length()-1){
////                i=0;
////                actions.keyDown(Keys.SPACE).perform();
////                 para=words.getText().replace("\n", " ");
////                System.out.println(para);
////            }
//        }
//    }
