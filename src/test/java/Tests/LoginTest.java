package Tests;

import base.BaseTest;
import org.Mazaly.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "credentials")
    public Object[] getData() {
        return new Object[] { "unregisteredUser@test.com" };

    }

    @Test(dataProvider = "credentials")
    public void VerifyUserCannotLoginWithUnregisteredEmail(String email){
        LoginPage loginPage =homePage.openLoginPage();
        loginPage.signIn(email);
        loginPage.clickContinue();

        Assert.assertTrue(loginPage.getSignInErrorMessage().contains("Looks like you're new to Amazon"),
                "this user already registered before");
    }


}
