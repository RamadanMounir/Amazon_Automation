package org.Mazaly.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select select;


    public ProductPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    private By secondItemOnProduct = By.xpath("//input[@name='1']");
    private By productTittle = By.id("productTitle");
    private By productPrice  =By.className("a-price-whole");
    private By quantityDropdown = By.id("quantity");
    private By addToCart = By.xpath("//input[@id='add-to-cart-button']");
    private By cartBtn = By.xpath("//a[@id='nav-cart']");

    public void selectSecondItem(){
        wait.until(ExpectedConditions.elementToBeClickable(secondItemOnProduct)).click();
    }

    public String getExpectedProductTitle() {
       String expectedProductTittle =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productTittle)).getText().trim();
        return expectedProductTittle;
    }

    public int getExpectedProductPrice() {
        String expectedProductPriceText=driver.findElement(productPrice).getText();
               // wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();

        String editedPriceText = expectedProductPriceText
                .replace(",", "").trim();

        int expectedProductPrice = Integer.parseInt(editedPriceText);
        return expectedProductPrice;
    }


    public void setQuantity(int index){
        WebElement qtyElement = wait.until(
                ExpectedConditions.elementToBeClickable(quantityDropdown)
        );
        select = new Select(qtyElement);
        wait.until(ExpectedConditions.elementToBeClickable(qtyElement));
        select.selectByIndex(index-1);

        driver.findElement(By.cssSelector("#availability")).click();


    }

    public void addProductToCart(){

        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

    public CartPage goToCart(){

        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
        return new CartPage(driver);
    }



}
