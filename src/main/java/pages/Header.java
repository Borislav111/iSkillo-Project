package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BasePage{

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;
    @FindBy(id = "nav-link-profile")
    WebElement profileBtn;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void goToLogin(){
        clickElement(loginBtn);
    }
    public void goToProfile(){
        clickElement(profileBtn);
    }

}
