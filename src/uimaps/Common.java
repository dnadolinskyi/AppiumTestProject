package uimaps;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.hamcrest.Matcher.*;

/// <summary>
/// This Class contains all common functions that can be used for validation
/// </summary>
public class Common {
   
    public void CheckNewTabIsOpened(AndroidDriver<AndroidElement> driver)
    {
        UIMaps map = new UIMaps();
        
        System.out.println("Checking if the search icon is displayed");
        if (IsElementVisible(driver, By.xpath(map.main_searchIcon)) == true) //(driver, By.xpath(map.main_searchIcon)) == false)
        {
        	System.out.println("1. Assert is TRUE");
        	CheckSearchIcon(driver);
        }

    }

    //Check Main view
    public void CheckSearchIcon(AndroidDriver<AndroidElement> driver)
    {
        UIMaps map = new UIMaps();
        //Assert.IsTrue(IsElementVisible(driver, By.xpath(map.main_searchIcon)), "Search icon is displayed");
        Assert.assertTrue(IsElementVisible(driver, By.xpath(map.main_searchIcon)) == true);
        System.out.println("2. Assert is TRUE");
        
        /*
        do
        {
            driver.FindElementByXPath(map.update_okbutton).Click();
        }
        while (IsElementVisible(driver, By.XPath(map.update_alert)) == true);
        */
    }
    
    

    //returns if element is visible or not
    public Boolean IsElementVisible(AndroidDriver<AndroidElement> driver, By element)
    {
        return driver.findElement(element).isDisplayed();
    }

}
