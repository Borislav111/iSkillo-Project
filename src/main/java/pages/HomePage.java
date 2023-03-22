package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final String homeUrl = "http://training.skillo-bg.com/posts/all";

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void navigateUrl(){
        driver.get(homeUrl);
    }
    public void verifyUrl(){
        verifyUrl(homeUrl);
    }

}
