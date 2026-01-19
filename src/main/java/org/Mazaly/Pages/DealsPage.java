package org.Mazaly.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DealsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DealsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By navBar = By.id("navbar-main");
    private By categories = By.cssSelector("div[data-a-input-name='departments']");
    private By productCard = By.cssSelector("div[data-testid='product-card']");
    private By productLink = By.cssSelector("a[data-testid='product-card-link']");

    private void waitNavBarToLoad(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navBar));
    }

    public String getPageTittle(){
        waitNavBarToLoad();
        return driver.getTitle();
    }

    public void selectSecondCategory(){
        List<WebElement> departments = driver.findElements(categories);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", departments.get(1));

       departments.get(1).click();
    }
    public ProductPage selectFirsProduct(){
        waitNavBarToLoad();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));
        List<WebElement>allProducts = driver.findElements(productCard);

       WebElement firstProduct = allProducts.get(0).findElement(productLink);
       wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
       return new ProductPage(driver);
    }
}
