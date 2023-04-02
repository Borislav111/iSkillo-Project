package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotFoundPage extends  BasePage{
    private final String notFoundURL = "http://training.skillo-bg.com/not-found";
    @FindBy(css = ".container h2")
    WebElement infoMsg;

    public NotFoundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getInfoMsg(){
        smallWait.until(ExpectedConditions.visibilityOf(infoMsg));
        verifyUrl(notFoundURL);
        return infoMsg.getText();
    }
}
