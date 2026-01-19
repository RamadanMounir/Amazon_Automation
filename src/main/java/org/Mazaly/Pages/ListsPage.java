package org.Mazaly.Pages;

import org.openqa.selenium.WebDriver;

public class ListsPage {
    private WebDriver driver;

    public ListsPage(WebDriver driver){
        this.driver=driver;
    }

    public String getPageTittle(){
        return driver.getTitle();
    }
}
