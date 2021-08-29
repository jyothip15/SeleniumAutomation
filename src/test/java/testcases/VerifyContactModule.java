package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactPage;
import pages.LeadsPage;
import pages.Opportyspage;
import pages.accountspage;

public class VerifyContactModule extends BaseTest{

	@BeforeMethod
	public void CreateReport(Method sTestMethod) {
		test = extent.createTest(sTestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	//		@Test(priority = 1)
	//		@Parameters({"BrowserName"})
	public void createNewContact_25(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);

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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab =  driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}

		test.info("Clicked on Contact Tab");

		Thread.sleep(2000);

		//		WebElement newBtn =  driver.findElement(By.xpath("//input[@name='new']"));
		if(oCommonUtilities.waitForElementVisible(cp.newBtn)) {
			cp.newBtn.click();
		}
		Thread.sleep(2000);
		test.info("Clicked on New Button");

		//		WebElement cLname =  driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
		if(oCommonUtilities.waitForElementVisible(cp.cLname)) {
			cp.cLname.clear();
			cp.cLname.sendKeys("poozhi");
		}
		test.info("Entered Last Name <poozhi> in Last name field");

		Thread.sleep(5000);

		//		WebElement cLookUp = driver.findElement(By.xpath("//*[@id='con4_lkwgt']//img"));

		Actions action = new Actions(driver);

		action.moveToElement(cp.cLookUp).build();
		if(oCommonUtilities.waitForElementVisible(cp.cLookUp)) {
			cp.cLookUp.click();
		}
		test.info("clicked on the look up in Account name");

		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		Thread.sleep(5000);
		while(it.hasNext()) {

			String childWindow = it.next();

			if(!parentWindow.equals(childWindow)) {

				driver.switchTo().window(childWindow);


				Thread.sleep(5000);

				//				WebElement cLookFrame = driver.findElement(By.xpath("/html/frameset/frame"));

				driver.switchTo().frame(cp.cLookFrame);
				Thread.sleep(5000);

				//				WebElement cSearch = driver.findElement(By.xpath("//div[@class='lookup']//div[2]//input[@id='lksrch']"));
				if(oCommonUtilities.waitForElementVisible(cp.cSearch)) {
					cp.cSearch.clear();

					cp.cSearch.sendKeys("J*");
				}

				test.info("Sent \"J*\" in the search ");

				sa.assertEquals(cp.cSearch.getAttribute("value").toUpperCase(), "J*");


				//				WebElement cGo = driver.findElement(By.xpath("//input[@name='go']"));
				if(oCommonUtilities.waitForElementVisible(cp.cGo)) {
					cp.cGo.click();
				}
				test.info("clicked \"Go!\" button");
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				//				WebElement resultFrame = driver.findElement(By.xpath("//frame[@title='Results']"));
				driver.switchTo().frame(cp.resultFrame);
				Thread.sleep(5000);

				//				WebElement resultsLook = driver.findElement(By.xpath("//div[@class='pbBody']/table/tbody/tr[2]/th/a"));
				if(oCommonUtilities.waitForElementVisible(cp.resultsLook)) {
					cp.resultsLook.click();
				}

				test.info("Selected \"jyothi\" in search results");
				Thread.sleep(5000);
			}			
		}

		driver.switchTo().window(parentWindow);
		//		WebElement cSaveBtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		if(oCommonUtilities.waitForElementVisible(cp.cSaveBtn)) {
			cp.cSaveBtn.click();
		}
		test.info("clicked the save button");
		sa.assertNotNull(driver.getCurrentUrl());
		Thread.sleep(5000);

		System.out.println(driver.getTitle());
		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Contact.lastname"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		sa.assertAll();

	}


	//	@Test(priority = 2)
	//	@Parameters({"BrowserName"})
	public void createNewView_26(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		System.out.println(driver.getCurrentUrl());

		Thread.sleep(2000);
		//		WebElement cNewView = driver.findElement(By.xpath("//*[@class='fFooter']/a[2]"));
		if(oCommonUtilities.waitForElementVisible(cp.cNewView)) {
			cp.cNewView.click();
		}
		test.info("Clicked on Create New View link");
		Thread.sleep(2000);
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.newview"));

		//		WebElement cViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		if(oCommonUtilities.waitForElementVisible(cp.cViewName)) {
			cp.cViewName.clear();
			cp.cViewName.sendKeys(oDataUtilities.ReadWebElementProperties("Contact.viewname"));	
		}

		Thread.sleep(2000);
		test.info("Entered View Name as\"Appukuttan\""); 
		sa.assertEquals(cp.cViewName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("Contact.viewname"));

		//		WebElement cUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));

		if(oCommonUtilities.waitForElementVisible(cp.cUniqueName)) {
			cp.cUniqueName.click();
			cp.cUniqueName.clear();
			cp.cUniqueName.sendKeys(oDataUtilities.ReadWebElementProperties("Contact.uniquename"));
		}

		Thread.sleep(2000);

		test.info("Entered View UniqueName as\"Appukuttan*\""); 
		sa.assertEquals(cp.cUniqueName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("Contact.uniquename"));

		//		WebElement cSave = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[1]"));
		if(oCommonUtilities.waitForElementVisible(cp.cSave)) {
			cp.cSave.click();
		}
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Contact.contacts"));
		test.info("clicked save button");
		Thread.sleep(6000);
		//		WebElement selectCrViewName = driver.findElement(By.xpath("//div[@class='controls']/select"));
		Select selectDropDown = new Select(cp.selectCrViewName);
		sa.assertEquals(selectDropDown.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Contact.viewname"));
		test.info("Created View name \"Appukuttan\"is displayed in drop down in that page by defalut" );

		if(selectDropDown.getFirstSelectedOption().getText().equals(oDataUtilities.ReadWebElementProperties("Contact.viewname"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		Thread.sleep(2000);
		sa.assertAll();
	}

	//	@Test(priority = 3)
	//	@Parameters({"BrowserName"})
	public void checkRecentlyCreatedView_27(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		Thread.sleep(2000);

		//		WebElement selectRecently = driver.findElement(By.xpath("//td[@class='pbHelp']/select"));
		Select recentDropDown = new Select(cp.selectRecently);
		recentDropDown.selectByValue("3");
		test.info("Select 'Recently created' from the drop down list");

		sa.assertEquals(recentDropDown.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Contact.recentview"));

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.recentview"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		Thread.sleep(2000);
		sa.assertAll();

	}


	//	@Test(priority = 4)
	//	@Parameters({"BrowserName"})
	public void myContactsView_28(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

		Thread.sleep(3000);
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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		Thread.sleep(5000);

		//		WebElement selectContact = driver.findElement(By.xpath("//span[@class='fBody']/select"));
		//		js.executeScript("arguments[0].ScrollintoView();",cp.selectContact);

		Select contactDropDown = new Select(cp.selectContact);
		Thread.sleep(5000);
		contactDropDown.selectByVisibleText("My Contacts");
		test.info("Selected 'My Contacts'  View from the drop down list in contacts page");

		sa.assertEquals(contactDropDown.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Contact.mycontacts"));
		System.out.println(contactDropDown.getFirstSelectedOption().getText());
		System.out.println(oDataUtilities.ReadWebElementProperties("Contact.mycontacts"));
		Thread.sleep(5000);
		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.recentview"))) {
			test.pass(mName.getName()+"passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.pass(mName.getName()+"failed");
		}

		sa.assertAll();


	}


	//	@Test(priority = 5)
	//	@Parameters({"BrowserName"})
	public void viewContactInPage_29(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

		Thread.sleep(3000);
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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		Thread.sleep(5000);

		//		WebElement contactName = driver.findElement(By.xpath("//*[@class='pbBody']/table/tbody/tr[2]/th/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactName)) {
			cp.contactName.click();
		}
		test.info("Clicked on a \"contact name\" under the Name field in the Recent Contact Frame ");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.recentview"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		sa.assertAll();
	}


	//	@Test(priority = 6)
	//	@Parameters({"BrowserName"})
	public void errorNewViewName_30(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

		Thread.sleep(3000);
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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(cp.cNewView)) {
			cp.cNewView.click();
		}
		test.info("Clicked on Create New View link");
		Thread.sleep(2000);
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.newview"));

		if(oCommonUtilities.waitForElementVisible(cp.cUniqueName)) {
			cp.cUniqueName.click();
			cp.cUniqueName.clear();
			cp.cUniqueName.sendKeys(oDataUtilities.ReadWebElementProperties("Contact.uniquenamerr"));
		}

		Thread.sleep(2000);

		test.info("Entered View UniqueName as\"EFGH\""); 
		sa.assertEquals(cp.cUniqueName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("Contact.uniquenamerr"));


		//		WebElement cSave = driver.findElement(By.xpath("//div[@class='pbBottomButtons']//input[1]"));
		if(oCommonUtilities.waitForElementVisible(cp.cSave)) {
			cp.cSave.click();
		}
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Contact.contactsnewview"));

		test.info("clicked save button");

		Thread.sleep(2000);
		//		WebElement cErrMsge = driver.findElement(By.xpath("//*[@class='errorMsg']"));

		sa.assertEquals(cp.cErrMsge.getText(),oDataUtilities.ReadWebElementProperties("Contact.errmsge"));
		test.info("Error message is appeared under the View Name field. \"Error: You must enter a value\"");

		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Contacts.errpage"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}

		sa.assertAll();
	}


//	@Test(priority = 7)
//	@Parameters({"BrowserName"})
	public void createNewViewCancel_31(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		//		LeadsPage LP = new LeadsPage(driver);
		ContactPage cp = new ContactPage(driver);

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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

//		WebElement contactsTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}
		test.info("Clicked on Contact Tab");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.home"));

		System.out.println(driver.getCurrentUrl());

		Thread.sleep(2000);
//		WebElement cNewView = driver.findElement(By.xpath("//*[@class='fFooter']/a[2]"));
		if(oCommonUtilities.waitForElementVisible(cp.cNewView)) {
			cp.cNewView.click();
		}
		test.info("Clicked on Create New View link");
		Thread.sleep(2000);
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Contact.newview"));

//		WebElement cViewName = driver.findElement(By.xpath("//input[@id='fname']"));
		if(oCommonUtilities.waitForElementVisible(cp.cViewName)) {
			cp.cViewName.clear();
			cp.cViewName.sendKeys(oDataUtilities.ReadWebElementProperties("Contact.ABCD"));
		}

		Thread.sleep(2000);
		test.info("Entered View Name as\"ABCD\""); 
		sa.assertEquals(cp.cViewName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("Contact.ABCD"));

//		WebElement cUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));

		if(oCommonUtilities.waitForElementVisible(cp.cUniqueName)) {
			cp.cUniqueName.click();
			cp.cUniqueName.clear();
			cp.cUniqueName.sendKeys(oDataUtilities.ReadWebElementProperties("Contact.uniquenamerr"));
		}

		Thread.sleep(2000);

		test.info("Entered View UniqueName as\"EFGH\""); 
		sa.assertEquals(cp.cUniqueName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("Contact.uniquenamerr"));

		Thread.sleep(6000);

		WebElement cCancel = driver.findElement(By.xpath("//*[@class='pbButtonb']/input[2]"));
		cCancel.click();
		test.info("clicked cancel button");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Contact.home"));
		
		if(driver.getCurrentUrl().equals(oDataUtilities.ReadPageURLproperties("Leads.recentview"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}

   	sa.assertAll();
	}
	
	@Test(priority = 8)
	@Parameters({"BrowserName"})
	
	public void createNewViewCancel_32(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);

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

		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		//		WebElement contactsTab =  driver.findElement(By.xpath("//li[@id='Contact_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(cp.contactsTab)) {
			cp.contactsTab.click();
		}

		test.info("Clicked on Contact Tab");

		Thread.sleep(2000);

		//		WebElement newBtn =  driver.findElement(By.xpath("//input[@name='new']"));
		if(oCommonUtilities.waitForElementVisible(cp.newBtn)) {
			cp.newBtn.click();
		}
		Thread.sleep(2000);
		test.info("Clicked on New Button");

		//		WebElement cLname =  driver.findElement(By.xpath("//input[@name='name_lastcon2']"));
		if(oCommonUtilities.waitForElementVisible(cp.cLname)) {
			cp.cLname.clear();
			cp.cLname.sendKeys("India");
		}
		test.info("Entered Last Name <poozhi> in Last name field");

		Thread.sleep(5000);

		//		WebElement cLookUp = driver.findElement(By.xpath("//*[@id='con4_lkwgt']//img"));

		Actions action = new Actions(driver);

		action.moveToElement(cp.cLookUp).build();
		if(oCommonUtilities.waitForElementVisible(cp.cLookUp)) {
			cp.cLookUp.click();
		}
		test.info("clicked on the look up in Account name");

		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		Thread.sleep(5000);
		while(it.hasNext()) {

			String childWindow = it.next();

			if(!parentWindow.equals(childWindow)) {

				driver.switchTo().window(childWindow);


				Thread.sleep(5000);

				//				WebElement cLookFrame = driver.findElement(By.xpath("/html/frameset/frame"));

				driver.switchTo().frame(cp.cLookFrame);
				Thread.sleep(5000);

				//				WebElement cSearch = driver.findElement(By.xpath("//div[@class='lookup']//div[2]//input[@id='lksrch']"));
				if(oCommonUtilities.waitForElementVisible(cp.cSearch)) {
					cp.cSearch.clear();

					cp.cSearch.sendKeys("J*");
				}

				test.info("Sent \"J*\" in the search ");

				sa.assertEquals(cp.cSearch.getAttribute("value").toUpperCase(), "J*");


				//				WebElement cGo = driver.findElement(By.xpath("//input[@name='go']"));
				if(oCommonUtilities.waitForElementVisible(cp.cGo)) {
					cp.cGo.click();
				}
				test.info("clicked \"Go!\" button");
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				//				WebElement resultFrame = driver.findElement(By.xpath("//frame[@title='Results']"));
				driver.switchTo().frame(cp.resultFrame);
				Thread.sleep(5000);

				//				WebElement resultsLook = driver.findElement(By.xpath("//div[@class='pbBody']/table/tbody/tr[2]/th/a"));
				if(oCommonUtilities.waitForElementVisible(cp.resultsLook)) {
					cp.resultsLook.click();
				}

				test.info("Selected \"jyothi\" in search results");
				Thread.sleep(5000);
			}			
		}

		driver.switchTo().window(parentWindow);
		//		WebElement cSaveNewBtn = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[2]"));
		
		if(oCommonUtilities.waitForElementVisible(cp.cSaveNewBtn)) {
			cp.cSaveNewBtn.click();
		}
		test.info("clicked the save and new button");
		sa.assertNotNull(driver.getCurrentUrl());
		
		Thread.sleep(5000);

		System.out.println(driver.getTitle());
		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Contact.edit"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		

		sa.assertAll();

	
	}
}