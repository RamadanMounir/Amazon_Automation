package org.Mazaly.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    private By productTittle = By.xpath("//li[@class='sc-item-product-title-cont']");
    private By productPrice  =By.cssSelector("span.a-price span.a-offscreen");
    private By subtotalPrice = By.cssSelector("#sc-subtotal-amount-buybox .sc-price");





    public String getActualProductTitle() {
       String expectedProductTittle =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productTittle)).getText().trim();
        return expectedProductTittle;
    }

    public int getSubtotal(){
       String priceAsText = wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalPrice)).getText()
                .replace("EGP", "")
                .replace(",", "").trim();
        System.out.println("subtotal = "+priceAsText);
       double expectedSubtotalPrice =  Double.parseDouble(priceAsText);
        return (int)expectedSubtotalPrice;
    }

}
