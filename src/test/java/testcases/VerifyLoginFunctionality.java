package testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.TestListener;

import base.BaseTest;
import listeners.TestListeners;
import pages.loginpage;

/*Description:
 * 
 * 
 * 
 * @Autor 
 * 
 * */

@Listeners(TestListeners.class)
public class VerifyLoginFunctionality extends BaseTest {

	
	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
	
	
	/* Method will vwrify login functionaly */
	

	@Parameters({"BrowserName"})
	@Test
	public void VerifyLoginErrorMessage01(String sBrowserName) throws IOException, InterruptedException {
		
		driver = getDriver(sBrowserName);
		
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));
		
		sa.assertEquals(driver.getTitle(), "Login | Salesforce");
		
	    loginpage lp = new loginpage(BaseTest.driver);
	    
		test.info("Application is launched");

//		WebElement sUserName = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.username.xpath")));
		Thread.sleep(4000);
      
		if (oCommonUtilities.waitForElementVisible(lp.Username))
			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));
		
		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");
		
		test.info("Username is Entered");

		WebElement sPassword = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.password.xpath")));

		if (oCommonUtilities.waitForElementVisible(sPassword)) {
			sPassword.clear();
			test.info("Password is Empty");
		}
//			sPassword.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.Wrong.password"));

		sa.assertEquals(sPassword.getText(), "");

		WebElement sLoginButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.login.xpath")));

		if (oCommonUtilities.waitForElementVisible(sLoginButton))
			sLoginButton.click();

		WebElement sErrorMsg = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.errormsg.xpath")));

		sa.assertEquals(sErrorMsg.getText(), oDataUtilities.ReadWebElementProperties("login.errormsg"));

		sa.assertAll();
		if (sErrorMsg.getText().equals(oDataUtilities.ReadWebElementProperties("login.errormsg"))) {

			test.pass("TC01 Passed");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail("TC01 FAILED");
		}

	}
	
	@Parameters({"BrowserName"})
	@Test
	public void VerifyLoginErrorMessage02(String sBrowserName,Method mName) throws IOException, InterruptedException {

		Thread.sleep(3000);
		
		driver = getDriver(sBrowserName);
		
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		test.info("Application is launched");

		WebElement sUserName = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.username.xpath")));

		if (oCommonUtilities.waitForElementVisible(sUserName)) {
			oCommonUtilities.enterText(sUserName, oDataUtilities.ReadAccountProperties("prodaccount.name"), "USERNAME");
//			sUserName.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.name"));
		}
		sa.assertNotNull(sUserName.getText(), "jyothi15@gmail.com");
		test.info("Username is Entered");

		WebElement sPassword = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.password.xpath")));

		if (oCommonUtilities.waitForElementVisible(sPassword)) {
			sPassword.clear();
			sPassword.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}
//			sPassword.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.Wrong.password"));

		sa.assertNotNull(sPassword.getText(), "Blessings143");

		WebElement sLoginButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.login.xpath")));

		if (oCommonUtilities.waitForElementVisible(sLoginButton))
			sLoginButton.click();
		
	
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));
	
		if (driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"))) {

			test.pass(mName.getName()+" PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+"TC02 FAILED");
		}
		sa.assertAll();

	}

}