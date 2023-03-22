package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private String loginUrl = "http://training.skillo-bg.com/users/login";
    @FindBy(css = "form .h4")
    WebElement headerText;

    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordField;

    @FindBy(css = "*[formcontrolname='rememberMe']")
    WebElement rememberMeBtn;

    @FindBy(id = "sign-in-button")
    WebElement signInBtn;

    @FindBy(css = ".toast-error .toast-message")
    WebElement errorToastMsg;

    @FindBy(css = ".toast-success .toast-message")
    WebElement successToastMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyUrl() {
        verifyUrl(loginUrl);
    }

    public String getHeader() {
        wait.until(ExpectedConditions.visibilityOf(headerText));
        return headerText.getText();
    }

    public void logIn(String username, String password) {
        enterText(usernameField, username);
        enterText(passwordField, password);
        markCheckbox(rememberMeBtn);
        clickElement(signInBtn);
    }

    public String getErorrToastMsg() throws Exception {
        smallWait.until(ExpectedConditions.visibilityOf(errorToastMsg));
        String errorMsg = errorToastMsg.getText();
        try {
            if (errorMsg.equals("User not found") || errorMsg.equals("Ivalid password") || errorMsg.equals("UsernameOrEmail cannot be empty") || errorMsg.equals("Password cannot be empty")) {
                // System.out.println("msg= " + errorMsg);
                return errorMsg;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return errorToastMsg.getText();
    }

    public String getSuccessToastMsg(){
        wait.until(ExpectedConditions.visibilityOf(successToastMsg));
        String successMsg = successToastMsg.getText().trim();
        String expectedMsg = "Successful login!";
        if (!successMsg.equals(expectedMsg)) {
            throw new IllegalArgumentException("Successful toast message is different - actual: " + successMsg + " expected: " + expectedMsg);
        }
        return successMsg;
    }
}

//        } else {
//            System.out.println(errorMsg);
//            throw new Exception("User has logged in successfully!");
//        }

