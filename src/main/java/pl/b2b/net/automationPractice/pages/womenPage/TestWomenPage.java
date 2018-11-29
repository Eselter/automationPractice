package pl.b2b.net.automationPractice.pages.womenPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pl.b2b.net.automationPractice.SingletonWebDriver;
import pl.b2b.net.automationPractice.pages.topsPage.ObjectTopsPage;

public class TestWomenPage {
    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private ObjectWomenPage objectWomenPage;
    private ObjectTopsPage objectTopsPage;

    @BeforeClass
    private void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWebDriverWait();
        objectWomenPage = new ObjectWomenPage(webDriver, wait);
        objectTopsPage = new ObjectTopsPage(webDriver, wait);
    }

    @Test
    public void goToTops() {
        objectWomenPage.clickTops();
        Assert.assertEquals(objectTopsPage.getTopAssert().getAttribute("innerHTML").trim(), "Tops");
    }
}
