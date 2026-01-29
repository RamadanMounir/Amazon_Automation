package Tests;

import base.BaseTest;
import org.Mazaly.Pages.CartPage;
import org.Mazaly.Pages.DealsPage;
import org.Mazaly.Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {


    @Test
    public void verifyItemsAddedToCartCorrectly()  {
        int quantity=2;

        DealsPage dealsPage = homePage.openTodayDealsPage();
        String tittle = dealsPage.getPageTittle();
        System.out.println("Page Tittle: "+tittle);

        Assert.assertTrue(tittle.contains("Today's Deals"));

        dealsPage.selectSecondCategory();
        ProductPage productPage = dealsPage.selectFirsProduct();
  // This statement based on if the product has variety item to chose between them
 //      productPage.selectSecondItem();

        String expectedTittle = productPage.getExpectedProductTitle();
        int expectedPrice = productPage.getExpectedProductPrice();
        System.out.println("expected price for 1 piece = "+expectedPrice);

// calculate subtotal = price of the product * quantity
        int subtotal = expectedPrice * quantity;

        productPage.setQuantity(quantity);
        productPage.addProductToCart();

        CartPage cartPage = productPage.goToCart();

// verify that tittle of the product selected is the same on the cart
        Assert.assertTrue(cartPage.getActualProductTitle().contains(expectedTittle)
                ,"product tittle mismatch");

// verify that subtotal is correct as calculated = price * quantity
        Assert.assertEquals(subtotal,cartPage.getSubtotal(),"subtotal is incorrect");
        System.out.println("actual subtotal ="+subtotal);


    }
}
