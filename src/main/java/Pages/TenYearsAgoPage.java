package Pages;

import Base.DriverBase;
import Base.Methods;
import com.relevantcodes.extentreports.ExtentTest;
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
public class TenYearsAgoPage extends DriverBase {

    ExtentTest extentTest;

    public TenYearsAgoPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
        this.extentTest = super.logger;
    }
    @FindBy(xpath = "//figure[@data-e2e-name='image-figure-image']")
    @CacheLookup public static List<WebElement> slideImage;

    //method to display slideshow images count
    public TenYearsAgoPage displaySlideImageCount() throws IOException {
        Methods.getArticleImagesCount(extentTest,driver,slideImage);
        return new TenYearsAgoPage(driver);
    }
}
