package tests;
import java.net.MalformedURLException;
import java.net.URL;
 

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidDriverSetup {
   
	//Initialize driver
    public AndroidDriverSetup androidDriverSetup;
    public AndroidDriver<AndroidElement> driver;

    //capabilities for setup
    public String device = "Moto G";
    public String udid = "TA933075TR";
    public String platform = "Android";
    public String version = "5.1";
    public String baseurl = "http://127.0.0.1:4723/wd/hub";

    //for screenshot logging
    public static String screendir;

    /*
    //Create Directory for screenshot of the current test run
    public static void CreateScreenshotDirectory()
    {
        var logdir = Path.Combine(Environment.CurrentDirectory, "Screenshots", DateTime.Now.ToString("yyyy-MM-dd"));
        if (!Directory.Exists(logdir))
        {
            Directory.CreateDirectory(logdir);
        }

        screendir = Path.Combine(logdir, "AppiumTest_" + DateTime.Now.ToString("HHmmss"));
        Directory.CreateDirectory(screendir);
    }
     */
    //Set driver and device capabilities
    public AndroidDriver<AndroidElement> DriverSetup()
    {
    	System.out.println("Starting android driver....");
        try
        {
            //Set Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", device);
            caps.setCapability("udid", udid);
            caps.setCapability("platformName", platform);
            caps.setCapability("platformVersion", version);
            caps.setCapability("appPackage", "org.mozilla.firefox");
            caps.setCapability("appActivity", "org.mozilla.gecko.BrowserApp");
            caps.setCapability("noReset", "true");
            caps.setCapability("fullReset", "false");
            System.out.println("Android Driver Started...");

            return driver = new AndroidDriver<AndroidElement>(new URL(baseurl), caps);    
        }
        catch (Exception e)
        {
        	System.out.println("Error starting android driver");
            e.printStackTrace();
            return driver;
        }
    }
   
    //Check if AndroidDriver is already setup to be executed before each test
    public Boolean AndroidDriverInitializeCheck()
    {
        if (androidDriverSetup != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //for Tear down function to be executed after each test
    public void AndroidDriverQuit()
    {
        System.out.println("Closing Android Driver...");
        try
        {
            if (driver != null)
            {
                driver.quit();
            }
            System.out.println("Closed Android Driver...........");
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
    }
/*
    //Get screenshot of current screen and save it in MobileAgent/bin/debug
    public void GetScreenshot(String testname, String view)
    {
        var fileName = String.Format("{0}{1}", view, ".png");
        var ssdir = Path.Combine(screendir, testname);

        if (!Directory.Exists(ssdir))
        {
            Directory.CreateDirectory(ssdir);
        }
        var ss = ((ITakesScreenshot)driver).GetScreenshot();
        ss.SaveAsFile(Path.Combine(ssdir, fileName), ScreenshotImageFormat.Png);
    }
    */
}
