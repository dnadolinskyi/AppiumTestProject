package appiumTests;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import tests.AndroidDriverSetup;
import uimaps.Common;
import uimaps.UIMaps;

public class AppiumTests extends AndroidDriverSetup{
    
	@BeforeClass
	public void Setup()
    {
        if (!AndroidDriverInitializeCheck())
        {
            DriverSetup();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
    }
	
	@AfterClass
	public void TearDown(){
		AndroidDriverQuit();
	}
	
	public void ClickTheMenuButton(){
		UIMaps map = new UIMaps();
		Common common = new Common();
		
		try{
			common.CheckNewTabIsOpened(driver);
			
			driver.findElementByXPath(map.main_menuButton).click();
			Thread.sleep(2000);
		}
		catch(Exception e){
			
		}
	}
}
