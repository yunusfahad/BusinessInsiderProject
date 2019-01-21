package Pages;

import Base.DriverBase;
import Base.Methods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static Base.DriverBase.driver;

/**
 * Created by Fahad on 1/20/19.
 */
public class LifePage extends DriverBase {

    ExtentTest extentTest;
    public LifePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.extentTest = super.logger;
    }
    @FindBy(xpath = "//*[@data-dropdown-id='dropdown-Life']")
    @CacheLookup public static WebElement lifeTab;
    @FindBy(css = "a.title")
    @CacheLookup public static List<WebElement> articleTitle;
    @FindBy(xpath = "//div[@class='list-pipes no-pipe']")
    @CacheLookup public static List<WebElement> articleAuthor;
    @FindBy(xpath = "//img[@class='river-thumb']")
    @CacheLookup public static List<WebElement> articleThumbUrl;

    //page object method for clicking on Travel Tab
    public LifePage clickOnLife() throws IOException {
        Methods.performClick(extentTest,driver,lifeTab,"Life Tab");
        return new LifePage(driver);
    }

    //page object method for getting article content with author
    public LifePage articleTitleAndAuthor(int indexNumber) throws IOException, InterruptedException {
        String prviousUrl = driver.getCurrentUrl();
        Thread.sleep(2500);
        extentTest.log(LogStatus.INFO,"Current url is " + driver.getCurrentUrl());
        Methods.browseTo(extentTest,driver,prviousUrl);
        Methods.getElementText(extentTest,driver,articleTitle,indexNumber,"Title");
        Methods.getElementText(extentTest,driver,articleAuthor,indexNumber,"Author");
        return new LifePage(driver);
    }

}
