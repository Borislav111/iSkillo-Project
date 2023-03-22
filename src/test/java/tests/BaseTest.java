package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    public static final String TEST_RESOURCE_DIR = "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public static final String SCREENSHOT_DIR = TEST_RESOURCE_DIR.concat("screenshots" + File.separator);

//    @BeforeSuite
//    public void setUp(){
//
//    }
    @BeforeSuite
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @AfterSuite
    public void tearDown() throws IOException {
      //  takeScreenshot(testResult);
        if(driver != null){
            driver.close();
        }
    }
//    private void takeScreenshot(ITestResult testResult) throws IOException {
//        if(ITestResult.FAILURE == testResult.getStatus()){
//            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//            File screenshotSave = takesScreenshot.getScreenshotAs(OutputType.FILE);
//            String fileName = testResult.getTestName(); // името на файла с който запазваме
//            FileUtils.copyFile(screenshotSave, new File(SCREENSHOT_DIR.concat(fileName).concat("jpg")));
//        }
//    }
}
