package Base;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * Created by Fahad on 1/20/19.
 */
public class Methods {

    //method for browsing to specified url
    public static void browseTo(ExtentTest logger,WebDriver driver, String url) throws IOException {
        try{
            logger.log(LogStatus.INFO,"Browsing to " + url);
            driver.navigate().to(url);
        }catch (Exception err) {
            logger.log(LogStatus.FAIL,"Unable to browse to url " + err);
        }
    }

    //method to click on a specified object
    public static void performClick(ExtentTest logger,WebDriver driver, WebElement element, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            //System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            WebElement button = wait.until(ExpectedConditions.visibilityOf(element));
            button.click();
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to perform click on element " + elementName);
        }
    }

    //method to perform click based on the index of an element
    public static void clickByIndex(ExtentTest logger,WebDriver driver, List<WebElement> element, int indexNumber,String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            List<WebElement> button = wait.until(ExpectedConditions.visibilityOfAllElements(element));
            button.get(indexNumber).click();
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
        }
    }

    //method for entering string into an element
    public static void enterText(ExtentTest logger,WebDriver driver, WebElement element, String userInput, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            logger.log(LogStatus.INFO, "Entering " + userInput + " in element " + elementName);
            WebElement inputElement = wait.until(ExpectedConditions.visibilityOf(element));
            inputElement.sendKeys(userInput);
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to send info on element " + elementName);
        }
    }
    //method to verify page title
    public static void verifyTitle(ExtentTest logger,WebDriver driver,String expectedTitle){
        String actualTitle = driver.getTitle();
        if(expectedTitle.equals(actualTitle)){
            logger.log(LogStatus.PASS,"Expected title = "+ expectedTitle + " matches with " + actualTitle);
        } else {
            logger.log(LogStatus.FAIL,"Expected title = "+ expectedTitle + " does not match with " + actualTitle);
        }
    }

    //method to verify URL
    public static void verifyUrl(ExtentTest logger,WebDriver driver,String expectedUrl){
        String actualUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            logger.log(LogStatus.PASS,"Expected URL = "+ expectedUrl + " matches with " + actualUrl);
        } else {
            logger.log(LogStatus.FAIL,"Expected URL = "+ expectedUrl + " does not match with " + actualUrl);
        }
    }

    //get text of a specific element
    public static String getElementText(ExtentTest logger, WebDriver driver, List<WebElement> element, int indexNumber, String elementName) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        String textValue = null;
        try{
            textValue = wait.until(ExpectedConditions.visibilityOfAllElements(element)).get(indexNumber).getText();
            logger.log(LogStatus.PASS,"Text for element " + elementName + " is " + textValue);
        }catch (Exception err){
            logger.log(LogStatus.FAIL,"Unable to get text for " + elementName);
        }
        return textValue;
    }

    //count for all article images in a specific section
    public static int getArticleImagesCount(ExtentTest logger, WebDriver driver,List<WebElement> element) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,20);
        List<WebElement> imageList = null;
        int imageCount = 0;
        try{
            imageList = wait.until(ExpectedConditions.visibilityOfAllElements(element));
            logger.log(LogStatus.INFO,"Total count of article images = " + imageList.size());
            imageCount = imageList.size();
        }catch (Exception err) {
            logger.log(LogStatus.INFO,"Unable to get total count of article images");
        }
        return imageCount;
    }
}
