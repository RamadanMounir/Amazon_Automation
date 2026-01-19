package org.Mazaly.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomPage {
private WebDriver driver;
private WebDriverWait wait;
private Actions actions;

    public HomPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    private By navBar = By.id("navbar-main");
    private By signinNav = By.xpath("//div[@id='nav-link-accountList']");
    private By navLists  = By.xpath("//div[@class='nav-div']/a");
    private By yourOrdersNav = By.id("nav_prefetch_yourorders");
    private By  yourAddressesNav= By.id("nav_prefetch_youraddresses");
    private By  yourListsNav= By.xpath("//span[text()='Your Lists']");

    public void waitNavBarToLoad(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(navBar));
    }

    public LoginPage openLoginPage(){
    waitNavBarToLoad();
        wait.until(ExpectedConditions.elementToBeClickable(signinNav)).click();
        return new LoginPage(driver);
    }

    public DealsPage openTodayDealsPage()  {
        waitNavBarToLoad();
        List<WebElement> NavLinks = driver.findElements(navLists);
       List<WebElement> targetLink = NavLinks.stream().
               filter(link->link.getText().contains("Today's Deals")).collect(Collectors.toList());

       if(targetLink.size()>0) {
           wait.until(ExpectedConditions.elementToBeClickable(targetLink.getFirst())).click();
       }

       return new DealsPage(driver);
    }

    public LoginPage hoverOnYourOredersThenGoToIt(){
        WebElement yourOrdersIcon=wait.until(ExpectedConditions.visibilityOfElementLocated(yourOrdersNav));
        actions.moveToElement(yourOrdersIcon).click().build().perform();
        return new LoginPage(driver);
    }
    public LoginPage hoverOnYourAddressesThenGoToIt() {
        WebElement yourAddressesIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(yourAddressesNav));
        actions.moveToElement(yourAddressesIcon).click().build().perform();
        return new LoginPage(driver);
    }
    public ListsPage hoverOnYourListsThenGoToIt() {
        WebElement yourListsIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(yourListsNav));
        actions.moveToElement(yourListsIcon).click().build().perform();
        return new ListsPage(driver);
    }





    public void hoverOnHelloSignInAccountLists(){
       WebElement signInIcon = wait.until(ExpectedConditions.elementToBeClickable(signinNav));
       actions.moveToElement(signInIcon).build().perform();;

    }
}
