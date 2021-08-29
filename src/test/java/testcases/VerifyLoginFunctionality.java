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

	@Test
	@Parameters({"BrowserName"})

	public void VerifyLoginErrorMessage01(String sBrowserName,Method mName) throws IOException, InterruptedException {

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

		//	WebElement sPassword = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.password.xpath")));

		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			System.out.println("password");
			test.info("Password is Empty");
		}
		//			sPassword.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.Wrong.password"));

		sa.assertEquals(lp.Password.getText(), "");

		Thread.sleep(3000);

		//		WebElement sLoginButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.login.xpath")));

		if (oCommonUtilities.waitForElementVisible(lp.Login))

			lp.Login.click();


		//		WebElement sErrorMsg = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.errormsg.xpath")));

		sa.assertEquals(lp.Errormsg.getText(), oDataUtilities.ReadWebElementProperties("login.errormsg"));

		sa.assertAll();
//		try {
			if (lp.Errormsg.getText().equals(oDataUtilities.ReadWebElementProperties("login.errormsg"))) {

				test.pass(mName.getName()+" PASSED");
			} else {
				test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
				test.fail(mName.getName()+" FAILED");
			}

//		}

//		catch(Exception e) {}
//		finally {
			sa.assertAll();

		}
	
	@Test
	@Parameters({"BrowserName"})

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

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));
		
		System.out.println(driver.getCurrentUrl()+"(driver.getCurrentUrl()");
//		try {
			if (driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"))) {

				test.pass(mName.getName()+" PASSED");
			} else {
				
				test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
				test.fail(mName.getName()+" FAILED");
			}
//		}
//		catch(Exception e) {}
//		finally {
			sa.assertAll();

//		}

	}
	//################################
	@Test
	@Parameters({"BrowserName"})

	public void VerifyLoginErrorMessage03(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver("Chrome");
		driver.manage().window().maximize();
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		test.info("Application is launched");

		WebElement sUserName = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.username.xpath")));

		if(oCommonUtilities.waitForElementVisible(sUserName)) {
			oCommonUtilities.enterText(sUserName, oDataUtilities.ReadAccountProperties("prodaccount.name"), "USERNAME");
			//				sUserName.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.name"));
		}
		sa.assertNotNull(sUserName.getText(),"jyothi15@gmail.com");
		test.info("UserName is entered");

		WebElement sPassword = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.password.xpath")));

		if(oCommonUtilities.waitForElementVisible(sPassword)) {
			sPassword.clear();
			sPassword.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));   
			Thread.sleep(2000);
			test.info("password is entered");
		}

		Thread.sleep(2000);
		sa.assertNotNull(sPassword.getText(),"Blessings143");

		WebElement rememberMe = driver.findElement(By.name(oDataUtilities.ReadWebElementProperties("we.remember.me")));

		if(oCommonUtilities.waitForElementVisible(rememberMe)) {
			rememberMe.click();
			test.info("RememberMe is clicked");
		}

		sa.assertEquals(rememberMe.isSelected(),rememberMe.isEnabled());
		Thread.sleep(2000);
		WebElement sLoginButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.login.xpath")));
		Thread.sleep(2000);
		if(oCommonUtilities.waitForElementVisible(sLoginButton)) {
			sLoginButton.click();
			test.info("loginbtn is clicked");
		}

		Thread.sleep(2000);

		//		    System.out.println(driver.getCurrentUrl()+" driver.getCurrentUrl()");
		//		    System.out.println(oDataUtilities.ReadPageURLproperties("Salesforce.HomePage") + " homepage");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		WebElement userMenu = driver.findElement(By.id(oDataUtilities.ReadWebElementProperties("userMenu")));
		Thread.sleep(2000);
		if(oCommonUtilities.waitForElementVisible(userMenu)) {
			userMenu.click();
			test.info("usermenu is clicked");
			System.out.println("usermenu is clicked");
		}
		Thread.sleep(2000);
		//			System.out.println(userMenu.isDisplayed()+" userMenu.isDisplayed()");
		//			System.out.println(userMenu.isEnabled()+" userMenu.isSelected()" );
		sa.assertEquals(userMenu.isDisplayed(),userMenu.isEnabled());


		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("logout")));
		Thread.sleep(2000);
		logout.click();
		test.info("logout is clicked");
		Thread.sleep(4000);

		WebElement userDIS = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("userDIS")));

		sa.assertEquals(userDIS.getText(),oDataUtilities.ReadAccountProperties("prodaccount.name"));

		
		Thread.sleep(2000);

		System.out.println(mName.getName()+ " mName.getName()");

//		try {
			if( userDIS.getText().equals(oDataUtilities.ReadAccountProperties("prodaccount.name"))){
				test.pass(mName.getName()+" passed");
			}
			else {
				test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
				test.fail(mName.getName()+"  failed");

			}	
//		}
//		catch(Exception e) {System.out.println( e);}
//		finally {
			sa.assertAll();
//		}

	}


	@Test
	@Parameters({"BrowserName"})
	public void VerifyLoginErrorMessage4A(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		//	loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		WebElement forgotpwd = driver.findElement(By.id(oDataUtilities.ReadWebElementProperties("forgotpwd")));
		forgotpwd.click();

		test.info("forgotpwd is clicked");

		Thread.sleep(2000);


		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.ForgotPage"));


		WebElement userforgot = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("userforgot")));
		userforgot.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));
		test.info("username is clicked");

		WebElement continueButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("continue.Button")));
		continueButton.click();
		test.info("continuebtn is clicked");

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.PwdPage"));

//		try {
			if (driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Salesforce.PwdPage"))) {

				test.pass(mName.getName()+" PASSED");
			} else {
				System.out.println("Hii");
				test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
				test.fail(mName.getName()+" FAILED");
			}
	//	}
//		catch(Exception e) {}
//		finally {
			sa.assertAll();
		}
//	}

	@Test
	@Parameters({"BrowserName"})
	

	//########################
	public void VerifyLoginErrorMessage4B(String sBrowserName,Method mName) throws IOException, InterruptedException {

		Thread.sleep(3000);

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		loginpage lp = new loginpage(BaseTest.driver);
		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		test.info("Application is launched");

	//	WebElement sUserName = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.username.xpath")));

		if (oCommonUtilities.waitForElementVisible(lp.Username)) {
			oCommonUtilities.enterText(lp.Username, oDataUtilities.ReadAccountProperties("prodaccount.wrong.name"), "USERNAME");
			//			sUserName.sendKeys(oDataUtils.ReadAccountProperties("prodaccount.name"));
		}
		sa.assertNotNull(lp.Username.getText(), oDataUtilities.ReadAccountProperties("prodaccount.wrong.name"));
		test.info("Username is Entered");

	//	WebElement sPassword = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.password.xpath")));

		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.wrong.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), oDataUtilities.ReadAccountProperties("prodaccount.wrong.password"));

		Thread.sleep(2000);
	//	WebElement sLoginButton = driver.findElement(By.xpath(oDataUtilities.ReadWebElementProperties("we.login.xpath")));
		Thread.sleep(2000);
		if(oCommonUtilities.waitForElementVisible(lp.Login)) {
			lp.Login.click();
			test.info("loginbtn is clicked");
		}
		Thread.sleep(3000);
		
        sa.assertEquals(lp.ErrormsgLogin.getText(), oDataUtilities.ReadWebElementProperties("popup.msg"));
        Thread.sleep(3000);
        
        if (lp.ErrormsgLogin.getText().equals(oDataUtilities.ReadWebElementProperties("popup.msg"))) {
			test.pass(mName.getName()+" PASSED");
		} else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}


		sa.assertAll();
	}		
	
}





