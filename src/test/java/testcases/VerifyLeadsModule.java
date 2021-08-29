package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LeadsPage;
import pages.Opportyspage;
import pages.accountspage;

public class VerifyLeadsModule extends BaseTest{

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

		@Test(priority = 1)
		@Parameters({"BrowserName"})
	public void leadsTabLink_20(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		LeadsPage LP = new LeadsPage(driver);

		Thread.sleep(300);
		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			//		Thread.sleep(2000);
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//	WebElement leadsTab = driver.findElement(By.xpath("//li[@id='Lead_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");
		Thread.sleep(2000);

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Leads.title"));

		//		WebElement leadsHome = driver.findElement(By.xpath("//*[@class='bPageTitle']//div[@class='content']//h1"));

		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.Home"))) {
			test.pass(mName.getName() + " passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName() + " failed");

		}


		sa.assertAll();

	}
		@Test(priority = 2)
		@Parameters({"BrowserName"})
	public void leadsSelectView_21(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		LeadsPage LP = new LeadsPage(driver);

		Thread.sleep(300);
		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(2000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));
		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");
		Thread.sleep(2000);

		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		//		WebElement leadsSelect = driver.findElement(By.xpath("//span[@class='fBody']/*[@id='fcf']"));

		Select leadsDropDown = new Select(LP.leadsSelect);

		String [] mOptions = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};

		List<WebElement> leadsOptions = leadsDropDown.getOptions();

		boolean match = false;

		for(int i=0; i<leadsOptions.size(); i++) {

			if(leadsOptions.get(i).getText().equals(mOptions[i])) {
				match = true; 
			}
			else {
				match = false;
				break;
			}

		}

		sa.assertTrue(match);

		if(match) 
			test.info("Drop down with \"All Open Leads\",\"My Unread Leads\",\"Recently Viewed Leads\",\"Today's Leads\",\"View - Custom 1\",\"View - Custom 1\" are available");
		else
			test.info("Drop down with \"All Open Leads\",\"My Unread Leads\",\"Recently Viewed Leads\",\"Today's Leads\",\"View - Custom 1\",\"View - Custom 1\" are NOT available");


		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Leads.title"))) {
			test.pass(mName.getName() + " passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName() + " failed");

		}

		sa.assertAll();
	}

		@Test(priority = 3)
		@Parameters({"BrowserName"})
	public void leadsSelectView_22(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		LeadsPage LP = new LeadsPage(driver);

		Thread.sleep(300);
		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(2000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));
		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");
		Thread.sleep(2000);

		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		Select leadsDropDown = new Select(LP.leadsSelect);

		leadsDropDown.selectByVisibleText("Today's Leads");

		test.info("Select \"Today's Leads\" from the drop down menu ");

		sa.assertEquals(leadsDropDown.getFirstSelectedOption().getText(), "Today's Leads");

		//		WebElement userMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));

		if (oCommonUtilities.waitForElementVisible(LP.userMenu)) {

			LP.userMenu.click();
		}

		sa.assertEquals(LP.userMenu.getText(), "jyothi Sanoj");

		test.info("clicked the usermenu");

		//		WebElement logout = driver.findElement(By.xpath("//*[@title='Logout']"));
		if (oCommonUtilities.waitForElementVisible(LP.logout)) {
			LP.logout.click();
		}

		test.info("clicked the logout");

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Leads.logout"));

		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(2000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");

		Thread.sleep(2000);

		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		sa.assertEquals(leadsDropDown.getFirstSelectedOption().getText(), "Today's Leads");
		test.info("'Todays leads' view is the default view");

		//		WebElement goBtn = driver.findElement(By.xpath("//input[@title='Go!']"));
		if(oCommonUtilities.waitForElementVisible(LP.goBtn)) {
			LP.goBtn.click();
		}
		test.info("clicked the GO button");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Leads.stitle"));
		Thread.sleep(3000);

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.TodayLead"))) {
			test.pass(mName.getName() + " passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName() + " failed");

		}

		sa.assertAll();
	}

		@Test(priority = 4)
		@Parameters({"BrowserName"})
	public void leadsTodaysLead_23(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		LeadsPage LP = new LeadsPage(driver);

		Thread.sleep(300);
		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(2000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));
		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");
		Thread.sleep(2000);

		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		Select leadsDropDown = new Select(LP.leadsSelect);

		leadsDropDown.selectByVisibleText("Today's Leads");

		test.info("Select \"Today's Leads\" from the drop down menu ");

		sa.assertEquals(leadsDropDown.getFirstSelectedOption().getText(), "Today's Leads");

		System.out.println();
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Leads.title"));
		test.info("Todays's Lead page is displayed.");

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.Home"))){
			test.pass(mName.getName()+" is passed");	
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" is failed");			
		}

	}

	@Test(priority = 5)
	@Parameters({"BrowserName"})
	public void leadsNewView_24(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		LeadsPage LP = new LeadsPage(driver);

		Thread.sleep(300);
		if (oCommonUtilities.waitForElementVisible(ap.Username))

			ap.Username.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.name"));

		Thread.sleep(3000);
		test.info("username entered");

		sa.assertEquals(ap.Username.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.name"));

		if(oCommonUtilities.waitForElementVisible(ap.Password)) {
			ap.Password.clear();
			ap.Password.sendKeys(oDataUtilities.ReadAccountProperties("prodaccount.password"));
		}
		test.info("password entered");
		sa.assertEquals(ap.Password.getAttribute("value"), oDataUtilities.ReadAccountProperties("prodaccount.password"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(op.Login)) {
			op.Login.click();
		}

		test.info("login btn clicked");

		Thread.sleep(2000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));
		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(LP.leadsTab)) {
			LP.leadsTab.click();
		}
		test.info("Clicked leads tab link from Home Page");

		Thread.sleep(2000);
		sa.assertEquals(LP.leadsHome.getText(),"Leads");

		//		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		if(oCommonUtilities.waitForElementVisible(LP.newBtn)) {
			LP.newBtn.click();
		}
		test.info("New Button is clicked");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Leads.newtitle"));

		Thread.sleep(2000);

		//		WebElement lName = driver.findElement(By.xpath("//input[@name='name_lastlea2']"));
		if(oCommonUtilities.waitForElementVisible(LP.lName)) {
			LP.lName.clear();
			LP.lName.sendKeys("ABCD");
		}
		Thread.sleep(5000);
		sa.assertEquals(LP.lName.getAttribute("value"),"ABCD");
		test.info("Last name is entered as \"ABCD\"");

//		WebElement comName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/form[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/input[1]"));
//		 comName.clear();
//		 comName.sendKeys("ABCD");
		
		if(oCommonUtilities.waitForElementVisible(LP.comName)) {
			LP.comName.clear();
			LP.comName.sendKeys("ABCD");
		}
		Thread.sleep(3000);

		sa.assertEquals(LP.comName.getAttribute("value"),"ABCD");
		test.info("company name is entered as \"ABCD\"");

//		WebElement lSaveBtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		if(oCommonUtilities.waitForElementVisible(LP.lSaveBtn)) {
			LP.lSaveBtn.click();
		}
		test.info("clicked save button");
		Thread.sleep(3000);
//		WebElement leadedit = driver.findElement(By.xpath("//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2"));
		
		sa.assertEquals(LP.leadEdit.getText(), oDataUtilities.ReadWebElementProperties("Leads.edit"));

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Leads.ABCDtitle"))){
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" passed");
		}
		sa.assertAll();
	}

}
