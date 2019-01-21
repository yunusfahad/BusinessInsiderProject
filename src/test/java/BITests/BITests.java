package BITests;

import Base.DriverBase;
import org.testng.annotations.Test;

import Pages.LifePage;
import Pages.TenYearsAgoPage;
import Base.Methods;
import Base.DriverBase;
import org.jsoup.Connection;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.BaseClass.lifePage;
import static Pages.BaseClass.tenYearsAgoPage;

/**
 * Created by Fahad on 1/21/19.
 */
public class BITests extends DriverBase {

    @Test(priority = 1)
    public void testLifePage() throws IOException, InterruptedException {

        //Navigate to https://www.thisisinsider.com/
        Methods.browseTo(logger,driver,"https://www.thisisinsider.com/");

        //Verify loaded page title matches “INSIDER”
        Methods.verifyTitle(logger,driver,"INSIDER");

        //On the navigation bar, click on “Life”
        lifePage().clickOnLife();

        //Verify loaded page title contains "Lifestyle - INSIDER" and URL is https://www.thisisinsider.com/lifestyle
        Methods.verifyTitle(logger,driver,"Lifestyle - INSIDER");
        Methods.verifyUrl(logger,driver,"https://www.thisisinsider.com/lifestyle");

        lifePage().articleTitleAndAuthor(0);

    }//end of testlifepage method

    @Test(priority = 2)
    public void testTenYearsAgoPage() throws IOException, InterruptedException {

        Methods.browseTo(logger,driver,"https://www.thisisinsider.com/popular-things-that-didnt-exist-10-years-ago-2018-12");

        tenYearsAgoPage().displaySlideImageCount();

        Thread.sleep(1500);


    }
}
