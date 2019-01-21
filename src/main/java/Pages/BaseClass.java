package Pages;

import Base.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Base.DriverBase.driver;

/**
 * Created by Fahad on 1/20/19.
 */
public class BaseClass extends DriverBase {

    public BaseClass(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    // Object for Life Page
    public static LifePage lifePage() {
        LifePage lifePage = new LifePage(driver);
        return lifePage;
    }

    // Object for ten years ago article page
    public static TenYearsAgoPage tenYearsAgoPage() {
        TenYearsAgoPage tenYearsAgo = new TenYearsAgoPage(driver);
        return tenYearsAgo;
    }
}
