package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import listeners.TestListeners;
import pages.loginpage;

@Listeners(TestListeners.class)
public class VerifyUserDropDown extends BaseTest{


	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}



	//	@Test
	@Parameters({"BrowserName"})
	public void userDropDown_TC05(String sBrowserName,Method mName ) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");



		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), "Blessings143");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			lp.Login.click();

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}

		String[] ActualmenuItems= lp.UserMenu.getText().split("\\n");

		boolean flag = oCommonUtilities.verifyUser(ActualmenuItems);


		if(flag == true) {
			//		System.out.println(flag);

			test.pass(mName.getName()+" PASSED");
		} 
		else {
			System.out.println(flag);
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}
		sa.assertAll();
	}
	//	@Test
	@Parameters({"BrowserName"})

	public void userDropDown_TC06(String sBrowserName,Method mName ) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");



		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), "Blessings143");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			lp.Login.click();

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			//		sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}

		String[] ActualmenuItems= lp.UserMenu.getText().split("\\n");

		boolean flag = oCommonUtilities.verifyUser(ActualmenuItems);

		if (oCommonUtilities.waitForElementVisible(lp.UserMenuProfile)) {

			//		sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuProfile.click();
		}

		Thread.sleep(4000);


		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.ProfPage"));


		int windowCount = driver.getWindowHandles().size();



		if (oCommonUtilities.waitForElementVisible(lp.UserPrfEdit)) {
			lp.UserPrfEdit.click();
			test.info("My profile is clicked");
		}
		Thread.sleep(3000);

		sa.assertEquals(windowCount, driver.getWindowHandles().size());
		test.info("Edit profile pop up window is displayed");

		driver.switchTo().frame("contactInfoContentId");

		sa.assertEquals(lp.aboutTab.getText(), oDataUtilities.ReadWebElementProperties("editprf.about.tab"));

		sa.assertEquals(lp.contactTab.getText(), oDataUtilities.ReadWebElementProperties("editprf.contact.tab"));
		test.info("Contact and About tab are displayed");

		if (oCommonUtilities.waitForElementVisible(lp.aboutTab)) {
			lp.aboutTab.click();
			test.info("AboutTab is clicked");
		}
		if (oCommonUtilities.waitForElementVisible(lp.lastName)){
			lp.lastName.clear();
			lp.lastName.sendKeys(oDataUtilities.ReadWebElementProperties("last.upd.name"));
			test.info("last name is entered");
		}
		Thread.sleep(2000);
		if(oCommonUtilities.waitForElementVisible(lp.saveBtn)) {
			lp.saveBtn.click();
			test.info("Save button from popup window is clicked");
		}
		Thread.sleep(2000);

		sa.assertEquals(lp.updlastName.getText(), oDataUtilities.ReadWebElementProperties("updated.name"));


		if(oCommonUtilities.waitForElementVisible(lp.postButton)) {
			lp.postButton.click();
			test.info("Post link is clicked");
		}
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.UpdLastNamePage"));

		driver.switchTo().frame(lp.iFramePost);
		if(oCommonUtilities.waitForElementVisible(lp.postbody)) {
			lp.postbody.sendKeys(oDataUtilities.ReadWebElementProperties("shared.post"));
			test.info("details is entered");
		}

		Thread.sleep(3000);

		driver.switchTo().defaultContent();

		if(oCommonUtilities.waitForElementVisible(lp.shareButton)) {
			lp.shareButton.click();
			test.info("share link is clicked");
		}

		Thread.sleep(3000);
		sa.assertEquals(lp.postDetails.getText(), oDataUtilities.ReadWebElementProperties("shared.post"));
		test.info("entered text is displayed on the page");

		if(oCommonUtilities.waitForElementVisible(lp.fileLink)) {
			lp.fileLink.click();
			test.info("file link is clicked");
		}

		if(oCommonUtilities.waitForElementVisible(lp.uploadLink)) {
			lp.uploadLink.click();
			test.info("upload link is clicked");
		}

		if(oCommonUtilities.waitForElementVisible(lp.chooseFile)) {
			lp.chooseFile.sendKeys("C:\\Users\\jyoth\\eclipse-workspace\\FileHandlingMar\\Utilities\\sampleFile.txt");
			Thread.sleep(6000);
			test.info("file is uploaded");
		}

		if(oCommonUtilities.waitForElementVisible(lp.shareFileBtn)) {
			lp.shareFileBtn.click();
			test.info("file is shared");
		}

		sa.assertEquals(lp.fileName.getText(),oDataUtilities.ReadWebElementProperties("file.name"));

		oCommonUtilities.waitForElementVisible(lp.actionMouse);

		Actions action = new Actions(driver);
		action.moveToElement(lp.actionMouse).build().perform();

		test.info("mousehover is done");

		if(oCommonUtilities.waitForElementVisible(lp.uploadphotoLink)) {
			lp.uploadphotoLink.click();
			test.info("uploadphotoLink is clicked");
		}

		oCommonUtilities.waitForElementVisible(lp.photoUpdiFrame);

		driver.switchTo().frame(lp.photoUpdiFrame);

		if(oCommonUtilities.waitForElementVisible(lp.choosePhotoUpload)) {
			lp.choosePhotoUpload.sendKeys("C:\\Users\\jyoth\\OneDrive\\Desktop\\S.jpg");
			test.info("photo chose from system");
		}
		Thread.sleep(6000);


		if(oCommonUtilities.waitForElementVisible(lp.photoSaveBtn)) {
			lp.photoSaveBtn.click();
			test.info("addphoto is saved");
		}

		Thread.sleep(10000);

		if(oCommonUtilities.waitForElementVisible(lp.cropSaveBtn)) {

			lp.cropSaveBtn.click();

			Thread.sleep(50000);


			test.info("cropphoto is saved");
		}
		//		Thread.sleep(6000);


		sa.assertEquals(lp.imagelink.isDisplayed(), lp.imagelink.isEnabled());

		if(lp.imagelink.isDisplayed()) {
			test.pass(mName.getName()+"  PASSED");
		} 
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}

		sa.assertAll();

	}	
//	@Test
//	@Parameters({"BrowserName"})


	public void userDropDown_TC07(String sBrowserName,Method mName ) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");



		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), "Blessings143");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			lp.Login.click();

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}

		String[] ActualmenuItems= lp.UserMenu.getText().split("\\n");

		//		boolean flag = oCommonUtilities.verifyUser(ActualmenuItems);
		oCommonUtilities.verifyUser(ActualmenuItems);

		if (oCommonUtilities.waitForElementVisible(lp.settingLink)) {
			lp.settingLink.click();
		}

		test.info("SettingPage is displayed");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.SettingPage"));


		if (oCommonUtilities.waitForElementVisible(lp.personalLink)) {
			lp.personalLink.click();
		}
		test.info("PersonalLink is Linked");

		sa.assertEquals(lp.personalLink.getText(),oDataUtilities.ReadWebElementProperties("Personal.Link")); 

		Thread.sleep(2000);
		if (oCommonUtilities.waitForElementVisible(lp.historyLink)) {
			lp.historyLink.click();
		}

		sa.assertEquals(lp.historyLink.getText(),oDataUtilities.ReadWebElementProperties("Login.History"));
		test.info("HistoryLink is clicked");

		if (oCommonUtilities.waitForElementVisible(lp.downLoadLink)) {
			lp.downLoadLink.click();
		}
		test.info("Login history is displayed");

		sa.assertEquals(lp.downLoadLink.getText(),oDataUtilities.ReadWebElementProperties("Download.details"));

		boolean downloadFlag = oCommonUtilities.isFileDownloaded_Ext("C:\\Users\\jyoth\\Downloads", ".csv");

		sa.assertEquals(lp.downLoadLink.isDisplayed(),lp.downLoadLink.isEnabled());


		if(downloadFlag == true){
			test.info("the data is downloaded in .csv format.");

		}

		if (oCommonUtilities.waitForElementVisible(lp.disLayLink)) {
			lp.disLayLink.click();
		}
		test.info("Display & Layout link is clicked");

		sa.assertEquals(lp.disLayLink.isDisplayed(),lp.disLayLink.isEnabled());

		Thread.sleep(3000);
		if (oCommonUtilities.waitForElementVisible(lp.customTab)) {

			lp.customTab.click();
		}

		Thread.sleep(10000);

		Select dropfirst = new Select(lp.salesChatter);

		Thread.sleep(3000);
		dropfirst.selectByVisibleText(oDataUtilities.ReadAccountProperties("sales.chatter"));

		Thread.sleep(3000);

		test.info("Customize My tab is selected");


		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.CustomPage"));

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;	

		js.executeScript("arguments[0].scrollIntoView();", lp.reportsTab);

		if (oCommonUtilities.waitForElementVisible(lp.reportsTab)) {
			Thread.sleep(3000);
			lp.reportsTab.click();
		}

		test.info("Reports Tab is selected");

		sa.assertEquals(lp.reportsTab.getText(),oDataUtilities.ReadWebElementProperties("Reports.Tab")); 

		Thread.sleep(3000);
		if (oCommonUtilities.waitForElementVisible(lp.addButton)) {

			lp.addButton.click();
		}

		test.info("Add Button is clicked");

		Thread.sleep(10000);


		sa.assertEquals(lp.selectedReport.getText(),oDataUtilities.ReadWebElementProperties("Reports.Tab"));

		test.info("Reports field present in Selected Tabs");

		if (oCommonUtilities.waitForElementVisible(lp.saveButton)) {

			lp.saveButton.click();
		}
		test.info("Save Button is clicked");


		sa.assertEquals(lp.tabReports.isEnabled(), lp.tabReports.isDisplayed());

		test.info("Reports field added in the links available in top of salesforce page");

		//        dropfirst.selectByVisibleText(oDataUtilities.ReadAccountProperties("sales.chatter"));
		/*     
		// not working  as in excel --> Reports field is added in sales force chatter page and sales and marketing pages.		
		dropfirst.selectByVisibleText("Sales");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        test.info("Sales tab is selected");

       WebElement salesReport = driver.findElement(By.xpath("//*[@id='duel_select_1']/option[14]"));
       js.executeScript("arguments[0].scrollIntoView();",salesReport);
        System.out.println(salesReport.getText()+"hi");

        dropfirst.selectByVisibleText("Marketing");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        test.info("Marketing tab is selected");

        WebElement marketingReport = driver.findElement(By.xpath("//option[@value='report']"));
        js.executeScript("arguments[0].scrollIntoView();",marketingReport);
        System.out.println(marketingReport.getText()+"hi");
		 */ 
		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(lp.emailField)) {
			lp.emailField.click();
		}
		test.info("emailField is clicked");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(lp.emailSettings)) {
			lp.emailSettings.click();
		}
		test.info("emailSettings is clicked");

		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(lp.senderName)) {
			lp.senderName.clear();
			lp.senderName.sendKeys(oDataUtilities.ReadAccountProperties("user.name"));
		}

		Thread.sleep(3000);
		sa.assertEquals(lp.senderName.getAttribute("value"), oDataUtilities.ReadAccountProperties("user.name"));

		test.info("senderName is updated");
		Thread.sleep(3000);


		if (oCommonUtilities.waitForElementVisible(lp.senderEmail)) {
			lp.senderEmail.clear();
			lp.senderEmail.sendKeys(oDataUtilities.ReadAccountProperties("user.email") );
		}

		Thread.sleep(3000);

		sa.assertEquals(lp.senderEmail.getAttribute("value"), oDataUtilities.ReadAccountProperties("user.email"));
		test.info("senderEmail is updated");
		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(lp.radiobtn)) {
			lp.radiobtn.click();
		}

		test.info("radiobtn is clicked");
		Thread.sleep(3000);

		if (oCommonUtilities.waitForElementVisible(lp.savebtn)) {
			lp.savebtn.click();
		}
		test.info("savebtn is clicked");

		Thread.sleep(3000);

		//		driver.switchTo().alert().accept();

		Thread.sleep(3000);

		sa.assertEquals(lp.textmsge.getText(),oDataUtilities.ReadWebElementProperties("Settings.msg"));

		Thread.sleep(5000);

		js.executeScript("window.scrollBy(0,250)");
		
		if (oCommonUtilities.waitForElementVisible(lp.calender)) {
			lp.calender.click();
		}
		
		test.info("calender is clicked");

		sa.assertEquals(lp.calender.isEnabled(),lp.calender.isDisplayed());   
	
		
		Thread.sleep(5000);

		if (oCommonUtilities.waitForElementVisible(lp.reminder)) {
			lp.reminder.click();
		}
		test.info("reminder is clicked");
		
		sa.assertEquals(lp.reminder.isEnabled(),lp.reminder.isDisplayed());   
		
		Thread.sleep(5000);


		if (oCommonUtilities.waitForElementVisible(lp.reminder)) {
			lp.openReminder.click();
		}
		test.info("openReminder is clicked");
		
		sa.assertEquals(lp.openReminder.isEnabled(),lp.openReminder.isDisplayed());
		
		Thread.sleep(5000);

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		Iterator<String> it = s.iterator();

		while(it.hasNext()) {

			String childWindow = it.next();	 
            if(!parent.equals(childWindow)) {
            	
            	driver.switchTo().window(childWindow);
//            	sa.assertEquals(driver.switchTo().window(childWindow).getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.openReminder"));
            	driver.close();
              }
		}
 
		
       driver.switchTo().window(parent);
       System.out.println(s.size()+"no of window handles");
       test.info("event pop window is dispayed");

		if(s.size()>1) {
			test.pass(mName.getName()+"  PASSED");
		} 
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}
		

		sa.assertAll();
	}

//	@Test
//	@Parameters({"BrowserName"})


	public void userDropDown_TC08(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");

		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), "Blessings143");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			lp.Login.click();

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}
        test.info("usermenu is clicked");
		
		String[] ActualmenuItems= lp.UserMenu.getText().split("\\n");

		//		boolean flag = oCommonUtilities.verifyUser(ActualmenuItems);
		oCommonUtilities.verifyUser(ActualmenuItems);
		
		Thread.sleep(3000);
		if (oCommonUtilities.waitForElementVisible(lp.devConsole)) {
			sa.assertEquals(lp.devConsole.getText(),oDataUtilities.ReadWebElementProperties("Dev.Console")); 
			lp.devConsole.click();
		}
        test.info("devConsole is clicked");
		
		String parent = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			
			String childwindow = it.next();
			
			if(!parent.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(2000);
//				System.out.println(driver.switchTo().window(childwindow).getTitle());
				sa.assertEquals(driver.switchTo().window(childwindow).getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Salesforce.devConsole"));
			    driver.close();
			}

		}
		test.info("devConsole is closed");
		driver.switchTo().window(parent);
		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));
		
		if(handles.size()>1) {
			test.pass(mName.getName()+" is passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" is failed");
			
		}
		
		sa.assertAll();
}	

	@Test
	@Parameters({"BrowserName"})
	
	
	public void userDropDown_TC09(String sBrowserName,Method mName ) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(), "Login | Salesforce");

		loginpage lp = new loginpage(BaseTest.driver);

		test.info("Application is launched");

		if (oCommonUtilities.waitForElementVisible(lp.Username))

			lp.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		sa.assertNotNull(lp.Username.getText(), "jyothi15@gmail.com");

		test.info("Username is Entered");



		if (oCommonUtilities.waitForElementVisible(lp.Password)) {
			lp.Password.clear();
			lp.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
			test.info("Password is entered");
		}

		sa.assertNotNull(lp.Password.getText(), "Blessings143");


		if (oCommonUtilities.waitForElementVisible(lp.Login))
			lp.Login.click();

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}
        test.info("usermenu is clicked");
		
		String[] ActualmenuItems= lp.UserMenu.getText().split("\\n");

		//		boolean flag = oCommonUtilities.verifyUser(ActualmenuItems);
		oCommonUtilities.verifyUser(ActualmenuItems);
		Thread.sleep(3000);
		
		if (oCommonUtilities.waitForElementVisible(lp.logout)) {

	//		sa.assertEquals(lp.logout.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			System.out.println(lp.logout.getText());
			lp.logout.click();
		}
		
     
      test.info("current sales force application is Logged out and login page is displayed");
      Thread.sleep(3000);
      
      sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Salesforce.LoginPage"));
      
      if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Login.Title"))) {
    	  test.pass(mName.getName()+" is passed");
      }
      else {
    	  test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
    	  test.fail(mName.getName()+" is failed");
      }
	
		sa.assertAll();
}
	
}



