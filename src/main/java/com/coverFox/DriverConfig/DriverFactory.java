package com.coverFox.DriverConfig;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.coverFox.Utils.Utility;

public class DriverFactory {
	static WebDriver driver;
	
	public static WebDriver initBrowser(String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			Reporter.log("Setting browser as "+browserName, true);
		}
		else if(browserName.equalsIgnoreCase("fireFox"))
		{
			driver=new FirefoxDriver();
			Reporter.log("Setting browser as "+browserName, true);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("Setting browser as "+browserName, true);
		}
		
		driver.manage().window().maximize();
		driver.get(Utility.readDataFromPropertiesFile("url"));
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
