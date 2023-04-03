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

    @FindBy(css = ".toast-warning .toast-message")
    WebElement warningToastMsg;

    @FindBy(css = ".toast-message")
    WebElement toastMsg;

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

    public String getErrorToastMsg() {
        smallWait.until(ExpectedConditions.visibilityOf(errorToastMsg));
        String errorMsg = errorToastMsg.getText();
        try {
            switch (errorMsg) {
                case "User not found":
                case "Ivalid password":
                case "UsernameOrEmail cannot be empty":
                case "Password cannot be empty":
                    return errorMsg;
                default:
                    throw new RuntimeException("Unexpected error: " + errorMsg);
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return errorMsg;
    }

    public String getSuccessToastMsg() {
        smallWait.until(ExpectedConditions.visibilityOf(successToastMsg));
        String successMsg = successToastMsg.getText().trim();
        String expectedMsg = "Successful login!";
        if (!successMsg.equals(expectedMsg)) {
            throw new IllegalArgumentException("Successful toast message is different - actual: " + successMsg + " expected: " + expectedMsg);
        }
        return successMsg;
    }

    public String getWarningToastMsg() {
        smallWait.until(ExpectedConditions.visibilityOf(warningToastMsg));
        return warningToastMsg.getText().trim();
    }

    public String getToastMgs() {
        smallWait.until(ExpectedConditions.visibilityOf(toastMsg));
        return toastMsg.getText();
    }
}

