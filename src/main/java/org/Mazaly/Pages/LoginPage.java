package org.Mazaly.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;


    public LoginPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    private By emailField  = By.id("ap_email_login");
    private By continueBtn = By.id("continue");
    private By signInResult   = By.cssSelector("#intent-confirmation-container h1");
    private By amazonLogo = By.cssSelector(".a-link-nav-icon");

    public String getPageTittle(){
      return  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))))
              .getText();

    }
    public HomPage openHomePage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(amazonLogo)).click();
        return new HomPage(driver);
    }


    public void signIn(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
                .sendKeys(email);
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public String getSignInErrorMessage(){
       String result = wait.until(ExpectedConditions.visibilityOfElementLocated(signInResult))
                .getText();
       return result;
    }



}
