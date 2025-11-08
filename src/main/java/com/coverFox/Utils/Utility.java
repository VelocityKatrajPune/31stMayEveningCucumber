package com.coverFox.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static void main(String[] args) {
		
		
		}
	
	//screenshot //scrollintoview //wait //excel reading
	public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    String timeStamp=new SimpleDateFormat("dd-mm-yyyy-HH-mm-ss").format(new Date());
	    String path = System.getProperty("user.dir");
	    File dest = new File(path+ "\\screenshot\\" +screenshotName + "_" + timeStamp + ".png" );
	    System.out.println("ScreenShotName"+screenshotName);
	    System.out.println("taking screenshot and saving at location...."+ dest);
	    FileHandler.copy(src, dest);
	 }
	
	//scrollintoview
	public static void scrollIntoView(WebDriver driver, WebElement webElement  )
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
		System.out.println("ScrollingIntoView ...."+ webElement.getText());
	}
	
	//wait implicitly for element
	
	public static void waitForElementExplicitly(WebDriver driver, long waitTime, WebElement webElement)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(waitTime));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println("waiting for element for..."+waitTime);
	}
	
	//waitImplicitly
	public static void waitImplicitly(WebDriver Driver, long waitTime)
	{
	WebDriverWait wait=new WebDriverWait(Driver, Duration.ofMillis(waitTime));
	}

	
	//readDataFromPropertiesFile
	public static String readDataFromPropertiesFile(String Key) throws IOException
	{
		Properties properties=new Properties();
		FileInputStream myFile=new FileInputStream("D:\\new eclipse\\31StMayCoverFoxTest\\src\\main\\resources\\config\\config.properties");
		properties.load(myFile);
		String value = properties.getProperty(Key);
		System.out.println("reading"+Key+"and value is "+ value);
		return value;
		
	}
	 
	//handling Drop down Using Visible text
	public static void handleDropDownUsingVisibleText(WebElement element, String visibleText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
		System.out.println("Handling drop down, alue is "+visibleText);
	}
	
	
	//Read data from excel
	public static String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myFile=new FileInputStream("D:\\new eclipse\\31StMayCoverFoxTest\\src\\main\\resources\\config\\config.properties");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		String testData = mySheet.getRow(row).getCell(cell).getStringCellValue();
		System.out.println("reading data from excel..."+ testData);
		return testData;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


