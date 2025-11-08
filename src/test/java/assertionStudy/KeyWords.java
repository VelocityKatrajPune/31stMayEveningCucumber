package assertionStudy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Keywords {
  @Test(invocationCount = 2)
  public void f() {
	 WebDriver driver= new ChromeDriver();
	 driver.get("https://www.coverfox.com/");
  }
	
	@Test(priority = -1)
	public void loginn()
	{
		Reporter.log("loginn test", true);
	}
	@Test(priority = 1)
	public void signIn()
	{
		Reporter.log("c test", true);
	}
	@Test(priority = 9)
	public void payment()
	{
		Reporter.log("payment test", true);
	}
	
	@Test(timeOut = 2000)
	public void login1() throws InterruptedException
	{
		Thread.sleep(1000);
		Reporter.log("login1 test", true);
	}
	
	@Test
	public void login()
	{
		Reporter.log("login test", true);
	}
	@Test(enabled = true)
	public void logout()
	{
		Reporter.log("logout test", true);
	}
	
	@Test(dependsOnMethods = { "b" })
	public void a() {

		Reporter.log("a test", true);
	}

	@Test
	public void b() {
		Assert.fail();
		Reporter.log("b test", true);
	}

	@Test
	public void c() {

		Reporter.log("c test", true);
	}
	
//	@Test(priority = -9,dependsOnMethods = {"b"} )
//	public void a()
//	{
//		Reporter.log("payment test", true);
//	}
}
