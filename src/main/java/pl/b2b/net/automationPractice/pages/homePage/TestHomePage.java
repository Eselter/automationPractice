package pl.b2b.net.automationPractice.pages.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.b2b.net.automationPractice.SingletonWebDriver;

public class TestHomePage {
    private SingletonWebDriver singletonWebDriver;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private ObjectHomePage objectHomePage;

    @BeforeClass
    private void setUp() {
        singletonWebDriver = SingletonWebDriver.getInstance();
        webDriver = singletonWebDriver.getWebDriver();
        wait = singletonWebDriver.getWebDriverWait();
        objectHomePage = new ObjectHomePage(webDriver, wait);
    }

    @Test(priority = 1)
    public void openStore() {
        webDriver.get(DataHomePage.URL);
        Assert.assertEquals(webDriver.getTitle(), "My Store");
    }

    @Test(priority = 2)
    public void goToWomenPage() {
        objectHomePage.clickWomenPage();
        Assert.assertEquals(webDriver.getTitle(), "Women - My Store");
}

    @Test(priority = 3)
    public void goToCategoryDresses(){
        objectHomePage.clickCategory("Dresses");
        Assert.assertTrue(webDriver.getTitle().contains("Dresses"));
    }

    @Test(priority = 4)
    public void goToCategoryTshirts(){
        objectHomePage.clickCategory("T-shirts");
        Assert.assertTrue(webDriver.getTitle().contains("T-shirts"));
    }

    @Test(priority = 5)
    @Parameters({"title"})
    public void goToCategory(@Optional("Women") String title){
        objectHomePage.clickCategory(title);
        Assert.assertTrue(webDriver.getTitle().contains(title));
    }

//    @AfterClass
//    private void tearUp() throws InterruptedException {
//        Thread.sleep(10000);
//        webDriver.quit();
//    }
}
