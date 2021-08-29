package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
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
import pages.Opportyspage;
import pages.RandomPage;
import pages.accountspage;
import pages.loginpage;

public class VerifyRandomScenarios extends BaseTest{

	@BeforeMethod
	public void CreateReport(Method stestMethod) {
		test = extent.createTest(stestMethod.getName());
	}

	@AfterMethod
	public void CloseReport() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	//	@Test(priority = 1)
	//	@Parameters({"BrowserName"})
	public void verifyFirstLastName_33(String sBrowserName,Method mName) throws IOException, InterruptedException {
		driver = getDriver(sBrowserName);
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);
		RandomPage rp = new RandomPage(driver);

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

		//		WebElement homeTab = driver.findElement(By.xpath("//li[@id='home_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.homeTab)) {
			rp.homeTab.click();
		}

		test.info("Home Tab from main menu is clicked");
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.home"));

		Thread.sleep(2000);
		//		WebElement firstLastName = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.firstLastName)) {
			rp.firstLastName.click();
		}
		Thread.sleep(2000);
		test.info("Click on the FirstName LastName link in the home page");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Random.firstLastName"));

		Thread.sleep(2000);


		//		WebElement profileTab = driver.findElement(By.xpath("//li[@id='UserProfile_Tab']/a"));


		sa.assertEquals(rp.profileTab.getText(),oDataUtilities.ReadWebElementProperties("Random.profile"));

		test.info(" 'User:FirstName LastName' page should be displayed.");

		Thread.sleep(2000);

		//		WebElement nameFirstLastName = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));

		test.info("Current page should be same as the 'My Profile' page.");

		sa.assertEquals(rp.nameFirstLastName.getText(), oDataUtilities.ReadWebElementProperties("Random.name"));

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Random.firstLastName"))) {
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
	public void verifyFirstLastName_34(String sBrowserName,Method mName) throws IOException, InterruptedException {
		driver = getDriver(sBrowserName);
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);
		loginpage lp = new loginpage(driver);
		RandomPage rp = new RandomPage(driver);

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

		//		WebElement homeTab = driver.findElement(By.xpath("//li[@id='home_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.homeTab)) {
			rp.homeTab.click();
		}
		test.info("Home Tab from main menu is clicked");
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.home"));

		Thread.sleep(2000);
		//		WebElement firstLastName = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.firstLastName)) {
			rp.firstLastName.click();
		}
		Thread.sleep(2000);
		test.info("Click on the FirstName LastName link in the home page");
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Random.firstLastName"));

		Thread.sleep(2000);
		//		WebElement profileTab = driver.findElement(By.xpath("//li[@id='UserProfile_Tab']/a"));

		sa.assertEquals(rp.profileTab.getText(),oDataUtilities.ReadWebElementProperties("Random.profile"));

		test.info(" 'User:FirstName LastName' page should be displayed.");

		Thread.sleep(2000);


		//		WebElement rEditContact = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']/img"));
		if(oCommonUtilities.waitForElementVisible(rp.rEditContact)) {
			rp.rEditContact.click();
		}

		test.info("Clicked on the 'Edit Profile' icon near Contact");
		Thread.sleep(3000);

		//		WebElement rFrame = driver.findElement(By.id("contactInfoContentId"));

		driver.switchTo().frame(rp.rFrame);

		Thread.sleep(4000);

		//		WebElement rAboutTab = driver.findElement(By.id("aboutTab"));
		if(oCommonUtilities.waitForElementVisible(rp.rAboutTab)) {
			rp.rAboutTab.click();
		}
		test.info("Clicked on the 'About' tab in the popup.");

		Thread.sleep(2000);

		//		WebElement rlastName = driver.findElement(By.id("lastName"));
		if(oCommonUtilities.waitForElementVisible(rp.rlastName)) {
			rp.rlastName.clear();
			rp.rlastName.sendKeys("Abcd");
		}
		test.info("sent last name as \"Abcd\" ");

		if(oCommonUtilities.waitForElementVisible(lp.saveBtn)) {
			lp.saveBtn.click();			
		}
		test.info("Save button from popup window is clicked");

		driver.switchTo().defaultContent();

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.ProfPage"));

		test.info("The 'Edit Profile' popup is closed");

		//		WebElement lUpdatedNameLeft = driver.findElement(By.id("tailBreadcrumbNode"));

		sa.assertEquals(rp.lUpdatedNameLeft.getText(),oDataUtilities.ReadAccountProperties("user.updatednamel"));

		test.info("The updated LastName of the account holder is displayed at the top left hand side of the page.");

		//		WebElement rUpdatedNameRight = driver.findElement(By.id("userNavLabel"));

		sa.assertEquals(rp.rUpdatedNameRight.getText(),oDataUtilities.ReadAccountProperties("user.updatednamer"));

		test.info("The 'User menu for FirstName LastName' menu button showed the updated Last Name, at the top right hand side of the page");

		Thread.sleep(2000);

		rp.rUpdatedNameRight.click();

		Thread.sleep(2000);

		//		WebElement rMySettings = driver.findElement(By.xpath("//a[contains(text(),'My Settings')]"));
		if(oCommonUtilities.waitForElementVisible(rp.rMySettings)) {
			rp.rMySettings.click();
		}

		Thread.sleep(2000);

		//		WebElement rPersonal = driver.findElement(By.id("PersonalInfo_font"));

		if(oCommonUtilities.waitForElementVisible(rp.rPersonal)) {
			rp.rPersonal.click();
		}

		Thread.sleep(2000);

		//		WebElement rPersonal2 = driver.findElement(By.xpath("//a[@id='PersonalInformation_font']//span[contains(text(),'Personal Information')]"));
		if(oCommonUtilities.waitForElementVisible(rp.rPersonal2)) {
			rp.rPersonal2.click();
		}

		Thread.sleep(9000);

		//		WebElement rLastName = driver.findElement(By.xpath("//input[@id='PersonalInformationSetup:editPage:pageBlock:lastName']"));

		sa.assertEquals(rp.rLastName.getAttribute("value"),oDataUtilities.ReadWebElementProperties("Random.lastname"));

		test.info("The 'User:FirstName LastName' page has the updated LastName");

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Random.lnametitle"))) {
			test.pass(mName.getName()+" is passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" is failed");
		}

		sa.assertAll();
	}

	//	@Test(priority = 3)
	//	@Parameters({"BrowserName"})
	public void verifyTabCustomization_35(String sBrowserName,Method mName) throws IOException, InterruptedException {
		driver = getDriver(sBrowserName);
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);
		loginpage lp = new loginpage(driver);
		RandomPage rp = new RandomPage(driver);

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


		//		WebElement rAllTab = driver.findElement(By.className("allTabsArrow"));
		if(oCommonUtilities.waitForElementVisible(rp.rAllTab)) {
			rp.rAllTab.click();
		}
		test.info("Clicked on the all tab '+' ");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.alltab"));
		Thread.sleep(2000);

		//		WebElement rCustTabs = driver.findElement(By.xpath("//input[@title='Customize My Tabs']")); 
		if(oCommonUtilities.waitForElementVisible(rp.rCustTabs)) {
			rp.rCustTabs.click();
		}
		test.info("Clicked on the 'Customize My Tabs' button on the right hand side of the page.");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.custmytab"));

		Thread.sleep(2000);

		//		WebElement selectedTabs = driver.findElement(By.xpath("//*[@id='duel_select_1']"));

		Select selectedItem = new Select(rp.selectedTabs);
		selectedItem.selectByValue("WorkOrder");

		test.info("Selected \"Work Orders\" from selected tabs");

		sa.assertEquals(selectedItem.getFirstSelectedOption().getText(), "Work Orders");

		Thread.sleep(2000);

		//		WebElement leftArrowBtn = driver.findElement(By.xpath("//*[@id='duel_select_0_left']"));
		if(oCommonUtilities.waitForElementVisible(rp.leftArrowBtn)) {
			rp.leftArrowBtn.click();
		}
		test.info("The selected tab \"Work Orders\"is removed from the 'Selected Tabs' section after clicking left arrow");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Random.leftArrowBtn"));


		//		WebElement availableTabs = driver.findElement(By.xpath("//*[@id='duel_select_0']"));
		Select availableItem = new Select(rp.availableTabs);

		availableItem.selectByValue("WorkOrder");

		test.info("The tab \"Work Orders\" is moved to the 'Available Tabs' section.");

		sa.assertEquals(availableItem.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Random.workorders"));
		Thread.sleep(2000);

		//		WebElement rSaveBtnBottom = driver.findElement(By.xpath("//*[@class='pbButtonb']//input"));
		if(oCommonUtilities.waitForElementVisible(rp.rSaveBtnBottom)) {
			rp.rSaveBtnBottom.click();
		}
		test.info("clicked on the save button");

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Random.customizeTabs"));

		test.info("The 'All Tabs' is displayed.");
		boolean noTabPresent = false;	

		//		WebElement rAllTabsDisplayed = driver.findElement(By.xpath("//*[@class='zen-inlineList zen-tabMenu']"));
		oCommonUtilities.isTabPresent(rp.rAllTabsDisplayed,noTabPresent); 

		/*		
		String[] rActualTabs = rAllTabsDisplayed.getText().toString().split("(?=[A-Z])");
		boolean flag = false;
		for(String s: rActualTabs) {
				System.out.println( s );
				if(s.equals(oDataUtilities.ReadWebElementProperties("Random.workorders"))) {
					flag = true;
					System.out.println("in if");
				}
				else
					flag = false;
				System.out.println("in else");
			}
		 */

		if(noTabPresent == false) {
			test.info("The tab \"Work Orders\" is not be displayed in the tab bar.");
		}
		if (oCommonUtilities.waitForElementVisible(lp.UserMenu)) {

			sa.assertEquals(lp.UserMenuDrop.getText(),oDataUtilities.ReadAccountProperties("user.name")); 
			lp.UserMenuDrop.click();
		}
		test.info("usermenu is clicked");

		if (oCommonUtilities.waitForElementVisible(lp.logout)) {
			lp.logout.click();
		}		

		test.info("current sales force application is Logged out and login page is displayed");
		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Salesforce.LoginPage"));

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

		test.info("SalesForce application is Launced.");
		WebElement rAllTabsDisplayAfter = driver.findElement(By.xpath("//*[@class='zen-inlineList zen-tabMenu']"));

		oCommonUtilities.isTabPresent(rAllTabsDisplayAfter,noTabPresent); 

		if(noTabPresent == false) {
			test.info("The tab \"Work Orders\" is not be displayed in the tab bar.");
		}

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Random.homePage"))) {
			test.pass(mName.getName()+" is passed");	
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" is failed");
		}

		sa.assertAll();

	}

	//	@Test(priority = 4)
	//	@Parameters({"BrowserName"})
	public void blockingAnEventInCalender_36(String sBrowserName,Method mName) throws IOException, InterruptedException {
		driver = getDriver(sBrowserName);
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);
		loginpage lp = new loginpage(driver);
		RandomPage rp = new RandomPage(driver);

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

		//		WebElement homeTab = driver.findElement(By.xpath("//li[@id='home_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.homeTab)) {
			rp.homeTab.click();
		}
		test.info("Home Tab from main menu is clicked");
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.home"));

		Thread.sleep(3000);

		WebElement rCurrentDate = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));

		//				LocalDate today = LocalDate.now( ZoneId.of( "Asia/Kolkata" ) ) ;
		LocalDate today = LocalDate.now( ZoneId.of( "America/Montreal" ) ) ;

		String outputDay = today.getDayOfWeek().toString() ; 

		String outputMonth = today.getMonth().toString() ; 

		int outputYear = today.atStartOfDay().getYear() ; 

		String Datetoday = outputDay+" "+outputMonth+" "+today.getDayOfMonth()+", "+outputYear;

		System.out.println(outputDay+" "+outputMonth+" "+today.getDayOfMonth()+", "+outputYear);


		sa.assertEquals(rCurrentDate.getText().toLowerCase(), Datetoday.toLowerCase());
		rCurrentDate.click();
		test.info("Current date is displayed as Day Month Date,Year format");

		Thread.sleep(3000);
		js.executeScript("javascript:window.scrollBy(250,350)");
		//		WebElement r8pmLink = driver.findElement(By.xpath("//td[@class='fixedTable']//div[@id='p:f:j_id25:j_id61:28:j_id64']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.r8pmLink)) {
			rp.r8pmLink.click();
		}
		test.info("Clicked on the current date link and calender page is displayed");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.calenderPage"));
		Thread.sleep(5000);
		WebElement rComboBoxIcon = driver.findElement(By.xpath("//*[@class='comboboxIcon']"));
		//		if(oCommonUtilities.waitForElementVisible(rp.rComboBoxIcon)) {
		//		     rp.rComboBoxIcon.click();
		//		}
		rComboBoxIcon.click();

		test.info("Clicked on 'Subject Combo' icon next to Subject field.");
		sa.assertEquals(rComboBoxIcon.isEnabled(), rComboBoxIcon.isDisplayed());

		String parentWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> it = windowHandles.iterator();

		while(it.hasNext()) {

			String childWindow = it.next();

			if(!parentWindow.equals(childWindow)) {
				test.info("The 'Combobox' popup is opened.");
				Thread.sleep(2000);
				driver.switchTo().window(childWindow);
				Thread.sleep(2000);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				//				WebElement rSubject = driver.findElement(By.xpath("//*[@class='listItem4']/a"));

				rp.rSubject.click();

				test.info("\"Other\" is entered in the Subject field");

			}

		}
		test.info("The 'Combobox' popup is closed. ");
		driver.switchTo().window(parentWindow);

		Thread.sleep(5000);

		//		WebElement r9pmLink  = driver.findElement(By.xpath("//span[@class='timeInput']/input[@id='EndDateTime_time']"));
		if(oCommonUtilities.waitForElementVisible(rp.r9pmLink)) {
			rp.r9pmLink.click();
		}
		sa.assertTrue(rp.r9pmLink.isEnabled());

		test.info("Clicked on the 'End' time field and Drop down should be displayed differet set of time ");

		Thread.sleep(5000);

		Actions actionDate = new Actions(driver);
		WebElement r9pmDrop  = driver.findElement(By.id("timePickerItem_42"));
		js.executeScript("arguments[0].scrollIntoView();", rp.r9pmDrop);
		actionDate.moveToElement(rp.r9pmDrop).perform();
		if(oCommonUtilities.waitForElementVisible(rp.r9pmDrop)) {
			rp.r9pmDrop.click();
		}
		Thread.sleep(9000);


		test.info("Selected '9:00 PM' from the dropdown");
		sa.assertTrue(r9pmDrop.isEnabled());

		Thread.sleep(5000);

		//		WebElement rTopSaveBtn  = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[@name='save']"));
		if(oCommonUtilities.waitForElementVisible(rp.rTopSaveBtn)) {
			rp.rTopSaveBtn.click();
		}
		test.info("Clicked the Save button");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Random.CalPageSave"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Random.savedCalPage"));
		Thread.sleep(2000);
		//		WebElement newEventOther = driver.findElement(By.xpath("//a[@class='eventMru']"));
		sa.assertEquals(rp.newEventOther.getText(),"Other");
		if(oCommonUtilities.waitForElementVisible(rp.newEventOther)) {
			rp.newEventOther.click();
		}
		test.info("\"Other\" event is created under \"Recent Items\"");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Random.CalEventPage"));

		//		WebElement rStartTime  = driver.findElement(By.id("StartDateTime_ileinner"));

		String startText1 =  rp.rStartTime.getText();
		String startResult = oCommonUtilities.getTextFromWebLement(startText1);
		sa.assertEquals(startResult, "8:00 PM");

		//		WebElement rEndTime = driver.findElement(By.id("EndDateTime_ileinner"));
		String endText1 = rp.rEndTime.getText();
		String endResult = oCommonUtilities.getTextFromWebLement(endText1);

		sa.assertEquals(endResult, "9:00 PM");
		test.info("The 'Calendar for FirstName LastName' page is displayed with 'Other' event in the time slot 8:00PM to 9:00PM.");

		//		WebElement rSubjectLast = driver.findElement(By.id("evt5_ileinner"));

		Thread.sleep(5000);
		if(rp.rSubjectLast.getText().equals("Other")) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}

		sa.assertAll();
	}




	@Test(priority = 5)
	@Parameters({"BrowserName"})
	public void blockingEventCalenderRecurrance(String sBrowserName,Method mName) throws IOException, InterruptedException {
		driver = getDriver(sBrowserName);
		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);
		ContactPage cp = new ContactPage(driver);
		loginpage lp = new loginpage(driver);
		RandomPage rp = new RandomPage(driver);

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

		//		WebElement homeTab = driver.findElement(By.xpath("//li[@id='home_Tab']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.homeTab)) {
			rp.homeTab.click();
		}
		test.info("Home Tab from main menu is clicked");
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.home"));

		Thread.sleep(3000);

//		WebElement rCurrentDate = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));

		//				LocalDate today = LocalDate.now( ZoneId.of( "Asia/Kolkata" ) ) ;
		LocalDate today = LocalDate.now( ZoneId.of( "America/Montreal" ) ) ;

		String outputDay = today.getDayOfWeek().toString() ; 

		String outputMonth = today.getMonth().toString() ; 

		int outputYear = today.atStartOfDay().getYear() ; 

		String Datetoday = outputDay+" "+outputMonth+" "+today.getDayOfMonth()+", "+outputYear;

		System.out.println(outputDay+" "+outputMonth+" "+today.getDayOfMonth()+", "+outputYear);


		//		sa.assertEquals(rCurrentDate.getText().toLowerCase(), Datetoday.toLowerCase());
		rp.rCurrentDate.click();
		test.info("Current date is displayed as Day Month Date,Year format");

		Thread.sleep(3000);
		js.executeScript("javascript:window.scrollBy(250,350)");
		//		WebElement r8pmLink = driver.findElement(By.xpath("//td[@class='fixedTable']//div[@id='p:f:j_id25:j_id61:28:j_id64']/a"));
		if(oCommonUtilities.waitForElementVisible(rp.r4pmLink)) {
			rp.r4pmLink.click();
		}
		test.info("Clicked on 4pm link and calender page is displayed");

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Random.calenderPage"));
		Thread.sleep(5000);
		WebElement rComboBoxIcon = driver.findElement(By.xpath("//*[@class='comboboxIcon']"));
		//		if(oCommonUtilities.waitForElementVisible(rp.rComboBoxIcon)) {
		//		     rp.rComboBoxIcon.click();
		//		}
		rComboBoxIcon.click();
		Thread.sleep(4000);
		

		test.info("Clicked on 'Subject Combo' icon next to Subject field.");
		sa.assertEquals(rComboBoxIcon.isEnabled(), rComboBoxIcon.isDisplayed());

		String parentWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		Iterator<String> it = windowHandles.iterator();

		while(it.hasNext()) {

			String childWindow = it.next();

			if(!parentWindow.equals(childWindow)) {
				test.info("The 'Combobox' popup is opened.");
				Thread.sleep(2000);
				driver.switchTo().window(childWindow);
				Thread.sleep(2000);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				//				WebElement rSubject = driver.findElement(By.xpath("//*[@class='listItem4']/a"));

				rp.rSubject.click();

				test.info("\"Other\" is entered in the Subject field");

			}

		}
		test.info("The 'Combobox' popup is closed. ");
		driver.switchTo().window(parentWindow);

		Thread.sleep(5000);

		//		WebElement r9pmLink  = driver.findElement(By.xpath("//span[@class='timeInput']/input[@id='EndDateTime_time']"));
		if(oCommonUtilities.waitForElementVisible(rp.r9pmLink)) {
			rp.r9pmLink.click();
		}
		sa.assertTrue(rp.r9pmLink.isEnabled());

		test.info("Clicked on the 'End' time field and Drop down should be displayed differet set of time ");

		Thread.sleep(5000);

		Actions actionDate = new Actions(driver);
		//			WebElement r9pmDrop  = driver.findElement(By.id("timePickerItem_42"));
		js.executeScript("arguments[0].scrollIntoView();", rp.r7pmDrop);
		actionDate.moveToElement(rp.r7pmDrop).perform();
		if(oCommonUtilities.waitForElementVisible(rp.r7pmDrop)) {
			rp.r7pmDrop.click();
		}
		Thread.sleep(9000);

		test.info("Selected '7:00 PM' from the dropdown");
		sa.assertTrue(rp.r7pmDrop.isEnabled());

		Thread.sleep(5000);

//		WebElement IsRecurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		if(oCommonUtilities.waitForElementVisible(rp.IsRecurrence)) {
		  rp.IsRecurrence.click();
		}

		sa.assertTrue(rp.IsRecurrence.isSelected());


//		WebElement weeklyRadioBtn = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		if(oCommonUtilities.waitForElementVisible(rp.weeklyRadioBtn)) {
			rp.weeklyRadioBtn.click();
		}
		
		
		sa.assertTrue(rp.weeklyRadioBtn.isSelected());

//		WebElement rRecursField = driver.findElement(By.xpath("//input[@id='wi']"));
		if(oCommonUtilities.waitForElementVisible(rp.rRecursField)) {
			rp.rRecursField.clear();
			rp.rRecursField.sendKeys("1");
		}
		sa.assertEquals(rp.rRecursField.getAttribute("value"), "1");

		Thread.sleep(5000);

		boolean rDayFlag = false;

//		WebElement  rSun = driver.findElement(By.xpath("//input[@id='1']"));
		boolean rSunFlag = rp.rSun.isSelected();
		if(rSunFlag == true) {
			rp.rSun.click();
		}

//		WebElement  rMon = driver.findElement(By.xpath("//input[@id='2']"));	
		boolean rMonFlag = rp.rMon.isSelected();
		if(rMonFlag == true) {
			rp.rMon.click(); 
		}

//		WebElement  rTue = driver.findElement(By.xpath("//input[@id='4']"));	
		boolean rTueFlag = rp.rTue.isSelected();
		if(rTueFlag == true) {
			rp.rTue.click(); 
		}

//		WebElement  rWed = driver.findElement(By.xpath("//input[@id='8']"));	
		boolean rWedFlag = rp.rWed.isSelected();
		if(rWedFlag == true) {
			rp.rWed.click(); 
		}

//		WebElement  rThu = driver.findElement(By.xpath("//input[@id='16']"));	
		boolean rThuFlag = rp.rThu.isSelected();
		if(rThuFlag == true) {
			rp.rThu.click(); 
		}

//		WebElement  rFri = driver.findElement(By.xpath("//input[@id='32']"));	
		boolean rFriFlag = rp.rFri.isSelected();
		if(rFriFlag == true) {
			rp.rFri.click(); 
		}

//		WebElement  rSat = driver.findElement(By.xpath("//input[@id='64']"));	
		boolean rSatFlag = rp.rSat.isSelected();
		if(rSatFlag == true) {
			rp.rSat.click(); 
		}

		switch(outputDay) {
		//		switch("MONDAY") {
		case "SUNDAY":
			//			WebElement  rSun = driver.findElement(By.xpath("//input[@id='1']"));	
			rp.rSun.click();
			rDayFlag = true;
			sa.assertTrue(rp.rSun.isSelected());
			break; 

		case "MONDAY":
			//			WebElement  rMon = driver.findElement(By.xpath("//input[@id='2']"));	
			rp.rMon.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rMon.isSelected());
			break; 

		case "TUESDAY":
			//			WebElement  rTue = driver.findElement(By.xpath("//input[@id='4']"));	
			rp.rTue.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rTue.isSelected());
			break; 

		case "WEDNESDAY":
			//			WebElement  rWed = driver.findElement(By.xpath("//input[@id='8']"));	
			rp.rWed.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rWed.isSelected());
			break; 

		case "THURSDAY":
			//			WebElement  rThu = driver.findElement(By.xpath("//input[@id='16']"));	
			rp.rThu.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rThu.isSelected());
			break; 
		case "FRIDAY":
			//			WebElement  rFri = driver.findElement(By.xpath("//input[@id='32']"));	
			rp.rFri.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rFri.isSelected());
			break; 

		case "SATURDAY":
			//			WebElement  rSat = driver.findElement(By.xpath("//input[@id='64']"));	
			rp.rSat.click(); 
			rDayFlag = true;
			sa.assertTrue(rp.rSat.isSelected());
			break; 

		default:
			rDayFlag = false;
		}
		if(rDayFlag) {
			test.info("Current day of the week is checked");
		}

		Thread.sleep(2000);
	
//		WebElement rEndDateRecur = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']")); 
		if(oCommonUtilities.waitForElementVisible(rp.rEndDateRecur)) {
			rp.rEndDateRecur.click();
			rp.rEndDateRecur.clear();
		}
		
	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.add(Calendar.DATE, 14);
	    String newDate = dateFormat.format(cal.getTime());

	    rp.rEndDateRecur.sendKeys(newDate);
	        
		if(oCommonUtilities.waitForElementVisible(rp.rTopSaveBtn)) {
			rp.rTopSaveBtn.click();
		}
		test.info("Clicked the Save button");
		Thread.sleep(5000);
		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Random.CalRecurSave"));
        
//		WebElement rMonthView = driver.findElement(By.xpath("//span[@class='dwmIcons']/a[3]/img"));
		if(oCommonUtilities.waitForElementVisible(rp.rMonthView)) {
			rp.rMonthView.click();
		}
		Thread.sleep(5000);
		
//		WebElement getToday = driver.findElement(By.xpath("//a[@title='Today']"));
		
		DateFormat newFormat = new SimpleDateFormat("d");
		Calendar todayDate = Calendar.getInstance();
		todayDate.setTime(new Date());
		String todaydate = newFormat.format(todayDate.getTime());
		test.info(todaydate +" is todays date");
		sa.assertEquals(rp.getToday.getText(), todaydate);
	
		todayDate.add(Calendar.DATE, 7);
		
		String futureDate = newFormat.format(todayDate.getTime());
		
		test.info(futureDate +" is a week from now.");
		
		WebElement others = driver.findElement(By.xpath("//td[@class='calActive']/div[2]/a[1]"));
		System.out.println(others.getText());     
		
//		WebElement nextWeekDate = driver.findElement(By.xpath("//a[contains(text(),'10')]"));
//		WebElement nextWeekDate = driver.findElement(By.xpath("//a[contains(text(),'11')]"));
		
		sa.assertEquals(rp.nextWeekDate.getText(), futureDate);
				
		WebElement otherElement1 = driver.findElement(By.xpath("//td[@class='calToday']//a[contains(text(),'Other')]"));
		
		sa.assertEquals(rp.nextWeekDate.getText(), futureDate);
		test.info("Current date and a week from current date have the 'Other' event blocked as a link.");
	
		if(rp.getToday.getText().equals(todaydate) && rp.nextWeekDate.getText().equals(futureDate) 
						&& otherElement1.getText().equals(others.getText())	) {
			test.pass(mName.getName()+ " is passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			
			
			test.fail(mName.getName()+ " is failed");
			
		}
			
		sa.assertAll();		
	}

}


