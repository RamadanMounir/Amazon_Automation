package base;

import io.qameta.allure.Allure;
import org.Mazaly.Pages.HomPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseTest {
protected WebDriver driver;
protected HomPage homePage;

String URL = "https://www.amazon.eg/";

@BeforeMethod
public void setUp(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--Incognito");
    driver = new ChromeDriver(options);

    driver.get(URL);
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    System.out.println("Website Name is "+driver.getTitle());
    homePage = new HomPage(driver);

}

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot: " + result.getName(),
                    new ByteArrayInputStream(screenshotBytes));
        }
    }

@AfterClass
    public void teardown(){
    driver.quit();
}

}
