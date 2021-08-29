package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.loginpage;


public class Testsample extends BaseTest{
	
	
	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}


	@Test
	@Parameters({"BrowserName"})

	public void VerifyLoginErrorMessage01(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

			Thread.sleep(4000);

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");

	
		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys("Blessings143");
		}
	

		Thread.sleep(3000);

	
		if (oCommonUtilities.waitForElementVisible(lp.Login))

			lp.Login.click();
		
		Thread.sleep(5000);

		WebElement usermenu = driver.findElement(By.id("userNav"));
		Thread.sleep(3000);

		Thread.sleep(3000);
		

		WebElement userlist = driver.findElement(By.xpath("//*[@id='userNavLabel']")); 
		userlist.click();
		
		String[] actualitems = usermenu.getText().split("\\n");
		for(int i= 1;i<actualitems.length;i++) {
			System.out.println(actualitems[i]);
		}
		
		System.out.println(actualitems.length);
		
		
		
		
		
		}
		
		
	}
	

