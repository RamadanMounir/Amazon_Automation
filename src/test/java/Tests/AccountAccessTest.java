package Tests;

import base.BaseTest;
import org.Mazaly.Pages.ListsPage;
import org.Mazaly.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountAccessTest extends BaseTest {

    /*Verify that you cannot see “Your Orders” and “Your Addresses” pages if you are not
    logged in. But you can see “Your Lists” intro screen)*/
    @Test
    public void verifyAccountPagesAccessWithoutLogin(){
     // Verify that you cannot see “Your Orders” without login
        homePage.hoverOnHelloSignInAccountLists();
       LoginPage loginPage= homePage.hoverOnYourOredersThenGoToIt();
        Assert.assertTrue(loginPage.getPageTittle().contains("Sign in"));

        homePage = loginPage.openHomePage();

    // Verify that you cannot see “Your Addresses” without login
        homePage.hoverOnHelloSignInAccountLists();
        homePage.hoverOnYourAddressesThenGoToIt();
        System.out.println(loginPage.getPageTittle());
        Assert.assertTrue(loginPage.getPageTittle().contains("Sign in"));

        homePage = loginPage.openHomePage();

    // verify you can see the screen 1 when you go to Your Lists
        homePage.hoverOnHelloSignInAccountLists();
        ListsPage listsPage = homePage.hoverOnYourListsThenGoToIt();
        System.out.println(listsPage.getPageTittle());
        Assert.assertTrue(listsPage.getPageTittle().contains("List"));


    }

    @Test
    public void failedTestToCHeckScreenshotFunction(){
        homePage.hoverOnHelloSignInAccountLists();
        LoginPage loginPage= homePage.hoverOnYourOredersThenGoToIt();
        Assert.assertTrue(loginPage.getPageTittle().contains("********"));

    }
}
