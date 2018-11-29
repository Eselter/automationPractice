package pl.b2b.net.automationPractice.pages.womenPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectWomenPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public ObjectWomenPage(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = DataWomenPage.TOPS_IMG)
    private WebElement topsImg;

    public void clickTops() {
        wait.until(ExpectedConditions.elementToBeClickable(topsImg));
        topsImg.click();
    }
}
