package Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fahad on 1/20/19.
 */
public class DriverBase {
    public static WebDriver driver = null;
    public static ExtentReports report = null;
    public static ExtentTest logger = null;
    public static JavascriptExecutor jse = null;
    String driverPath = "/Users/Fahad/Documents/MavenProject/src/main/resources/chromedriver";
    String reportPath = "/Users/Fahad/Documents/BIProject/src/main/java/Report/ExtentReport.html";

    @BeforeSuite
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver",driverPath);

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        report = new ExtentReports(reportPath, true);

        //define the javascript
        jse = (JavascriptExecutor)driver;

    }


    @BeforeMethod
    public void loggerSession(Method methodName){
        logger = report.startTest(methodName.getName());
        logger.log(LogStatus.INFO,"Test Started");
    }

    @AfterMethod
    public void endLogger(){
        report.endTest(logger);
        logger.log(LogStatus.INFO,"Test Ended");
    }
    @AfterSuite()
    public void closeBrowser(){
        report.flush();
        report.close();
    }

}
