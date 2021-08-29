package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.TestListeners;
import pages.accountspage;

@Listeners(TestListeners.class)
public class VerifyAccountsModule extends BaseTest {


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
	public void createAccount_10(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 

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

		WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));

		Thread.sleep(2000);
		Login.click();

		test.info("login btn clicked");

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));
		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);
		WebElement AccountTab = driver.findElement(By.xpath("//*[@title='Accounts Tab']"));
		AccountTab.click();

		Thread.sleep(2000);


		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AccountPage")); 

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}
		test.info("Accounts page is displayed with correct username");

		if(oCommonUtilities.waitForElementVisible(ap.newAcct)) {
			ap.newAcct.click();
		}
		test.info(" Accounts link on the home page is clicked");


		if(oCommonUtilities.waitForElementVisible(ap.acctName)) {
			ap.acctName.clear();
			ap.acctName.sendKeys(oDataUtilities.ReadWebElementProperties("account.Name"));
		}
		test.info("Entered Account name - Appu");

		if(oCommonUtilities.waitForElementVisible(ap.saveBtn)) {
			ap.saveBtn.click();;
		}
		test.info("clicked on save button");
		Thread.sleep(3000);

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.title1"));

		if(oCommonUtilities.waitForElementVisible(ap.acctSavName)) {

			test.info("New account page is displayed with account-details");	
			sa.assertEquals(ap.acctSavName.getText(), oDataUtilities.ReadWebElementProperties("account.Name"));
		}


		if(ap.acctSavName.getText().equals(oDataUtilities.ReadWebElementProperties("account.Name"))) {

			test.pass(mName.getName()+" PASSED");
		} 
		else {

			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}
		sa.assertAll();
	}

		@Test(priority = 2)
		@Parameters({"BrowserName"})
	public void createNewView_11(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 

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
		//		
		//		if(oCommonUtilities.waitForElementVisible(ap.Login)) {
		//			
		//				ap.Login.click();
		//		}
		//	not working page factory code	


		WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));

		Thread.sleep(2000);
		Login.click();

		test.info("login btn clicked");


		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);
		WebElement AccountTab = driver.findElement(By.xpath("//*[@title='Accounts Tab']"));
		AccountTab.click();

		test.info("Clicked on Accounts link on the home page");

		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AccountPage"));

		
		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}
		test.info("Accounts page is displayed with correct username");

		Thread.sleep(3000);
		//		WebElement newLink = driver.findElement(By.xpath("//*[@class='fFooter']//a"));
		//		newLink.click();
		//		System.out.println(newLink.getText());
		if(oCommonUtilities.waitForElementVisible(ap.newLink)) {
			ap.newLink.click();
		}
		Thread.sleep(5000);

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.editTitle"));
 
		
		test.info("Clicked on create new view link ");
		Thread.sleep(3000);

		if(oCommonUtilities.waitForElementVisible(ap.viewName)) {
			ap.viewName.clear();
			ap.viewName.sendKeys(oDataUtilities.ReadWebElementProperties("account.viewName"));
		}
		test.info("entered testingName as viewName");
		sa.assertEquals(ap.viewName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("account.viewName"));

		Thread.sleep(3000);

		if(oCommonUtilities.waitForElementVisible(ap.viewUniqueName)) {
			ap.viewUniqueName.clear();
			ap.viewUniqueName.sendKeys(oDataUtilities.ReadWebElementProperties("account.uniqueName"));
		}
		sa.assertEquals(ap.viewUniqueName.getAttribute("value"), oDataUtilities.ReadWebElementProperties("account.uniqueName"));
		
		
		test.info("entered testingUniqueName as UniqueName");

		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.saveTopBtn)) {

			ap.saveTopBtn.click();
		}
		test.info("clicked save button");
		Thread.sleep(7000);
		Select selectObj = new Select(ap.selectDrop);

		sa.assertEquals(selectObj.getFirstSelectedOption().getText(), oDataUtilities.ReadWebElementProperties("account.viewName"));
        
		
		test.info("Newely added View is displayed in the account view list");

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("account.accounts"))) {
			test.pass(mName.getName() + " passed");
		}
		else {
			test.fail(mName.getName() + " failed");
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());

		}

		sa.assertAll();
	}

		@Test(priority = 3)
		@Parameters({"BrowserName"})
	public void editAccount_12(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 

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
		//		
		//		if(oCommonUtilities.waitForElementVisible(ap.Login)) {
		//			
		//				ap.Login.click();
		//		}
		//	not working page factory code	


		WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));

		Thread.sleep(2000);
		Login.click();

		test.info("login btn clicked");


		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");
		Thread.sleep(2000);
		WebElement AccountTab = driver.findElement(By.xpath("//*[@title='Accounts Tab']"));
		AccountTab.click();

		test.info("Clicked on Accounts link on the home page");

		Thread.sleep(3000);


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.home"));

		System.out.println(driver.getTitle());
		System.out.println(oDataUtilities.ReadWebElementProperties("account.home")+" account.home");

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}
		test.info("Accounts page is displayed with correct username");

		Thread.sleep(3000);

		Select selectObj = new Select(ap.selectDrop);

		selectObj.selectByVisibleText(oDataUtilities.ReadWebElementProperties("account.viewName"));


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.home"));

		System.out.println(driver.getTitle());
		System.out.println(oDataUtilities.ReadWebElementProperties("account.accounts")+" account.accounts");

		if(oCommonUtilities.waitForElementVisible(ap.editBtn)) {
			ap.editBtn.click();
		}
		test.info("clicked on the edit button");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.editTitle"));

		System.out.println(driver.getTitle());
		System.out.println(oDataUtilities.ReadWebElementProperties("account.editTitle")+" account.editTitle");


		Thread.sleep(3000);

		if(oCommonUtilities.waitForElementVisible(ap.viewName)) {
			ap.viewName.clear();
			ap.viewName.sendKeys(oDataUtilities.ReadWebElementProperties("account.changeview"));
		}

		Thread.sleep(4000);
		System.out.println(ap.viewName.getAttribute("value")+" viewName");
		test.info("Changed view Name as KannanAdvaith");

		Select selectAcct = new Select(ap.selectAcctEle);

		selectAcct.selectByVisibleText(oDataUtilities.ReadWebElementProperties("account.nm"));
		
		sa.assertEquals(selectAcct.getFirstSelectedOption().getText(), oDataUtilities.ReadWebElementProperties("account.nm"));

		test.info("selected Account name");
		Thread.sleep(4000);

		Select selectOper = new Select(ap.selectOper);
		selectOper.selectByVisibleText("contains");
		test.info("selected operator as contains");

		sa.assertEquals(selectOper.getFirstSelectedOption().getText(), oDataUtilities.ReadWebElementProperties("account.operator"));
		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.value)) {
			ap.value.clear();
			ap.value.sendKeys("a");
		}
		test.info("send the value as a ");

		sa.assertEquals(ap.value.getAttribute("value"), oDataUtilities.ReadWebElementProperties("account.value"));
		Thread.sleep(2000);
		//////  not required  
		//	    WebElement selectbtn = driver.findElement(By.xpath("//*[@id='colselector_select_0']"));

		if(oCommonUtilities.waitForElementVisible(ap.lastActivity)) {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ap.lastActivity);
			ap.lastActivity.click(); 	
		}
		//	    sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AcctActivity"));
		System.out.println(driver.getTitle()+"Salesforce.AcctActivity");
		System.out.println(oDataUtilities.ReadWebElementProperties("account.editTitle")+" account.editTitle");
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.editTitle"));
		test.info("LastActivity is clicked");
		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(ap.addBtn)) {
			ap.addBtn.click();
		}
		test.info("addBtn is clicked");

		//	    sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AcctAddBtn"));
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.editTitle"));

		System.out.println(oDataUtilities.ReadWebElementProperties("account.editTitle")+" Salesforce.AcctAddBtn");

		System.out.println(driver.getTitle()+"Salesforce.AcctAddBtn");

		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(ap.saveButton)) {
			ap.saveButton.click(); 
		}
		test.info("saveBtn is clicked");


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.accounts"));
		System.out.println(driver.getTitle());
		System.out.println(oDataUtilities.ReadWebElementProperties("account.accounts")+ "account.accounts");

		Thread.sleep(2000);

		if(ap.lastActivityDis.getText().equals(oDataUtilities.ReadWebElementProperties("account.activity"))){
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}
		sa.assertAll();
	}


	@Test(priority = 4)
	@Parameters({"BrowserName"})
	public void mergeAccount_13(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 

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
		//		
		//		if(oCommonUtilities.waitForElementVisible(ap.Login)) {
		//			
		//				ap.Login.click();
		//		}
		//	not working page factory code	


		WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));

		Thread.sleep(2000);
		Login.click();

		test.info("login btn clicked");


		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");
		Thread.sleep(2000);
		WebElement AccountTab = driver.findElement(By.xpath("//*[@title='Accounts Tab']"));
		AccountTab.click();

		test.info("Clicked on Accounts link on the home page");

		Thread.sleep(3000);


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.home"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}
		test.info("Accounts page is displayed with correct username");

		Thread.sleep(3000);


		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(5000);

		if(oCommonUtilities.waitForElementVisible(ap.mergeAcct)){

			ap.mergeAcct.click();
		}
		test.info("clicked on Merge Accounts link in the tools area");

		Thread.sleep(3000);

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("account.merge"));

		if(oCommonUtilities.waitForElementVisible(ap.searchAcct)){
			ap.searchAcct.clear();
			ap.searchAcct.sendKeys(oDataUtilities.ReadWebElementProperties("account.Name"));
		}
		sa.assertEquals(ap.searchAcct.getAttribute("value").toLowerCase(), oDataUtilities.ReadWebElementProperties("account.Name").toLowerCase());

		test.info("send keys as Jyothi for searching accounts");
		if(oCommonUtilities.waitForElementVisible(ap.searchbtn)){
			ap.searchbtn.click();
		}

		test.info("clicked on the find accounts");
		Thread.sleep(3000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AcctMerge"));

		if(oCommonUtilities.waitForElementVisible(ap.checkBoxOne)){
			ap.checkBoxOne.click();
		}
		test.info("clicked on the first checkbox");
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.checkBoxTwo)){
			ap.checkBoxTwo.click();
		}
		test.info("clicked on the second checkbox");
		Thread.sleep(3000);

		if(oCommonUtilities.waitForElementVisible(ap.nextBtn)){
			ap.nextBtn.click();
		}

		test.info("cliked on the next button");
		Thread.sleep(3000);

		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.AcctMerge"));

		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.mrgeBtn)){
			ap.mrgeBtn.click();		
		}

		test.info("cliked on the merge button");

		Thread.sleep(5000);

		test.info("New pop up for account merge confirmation is displayed");

		driver.switchTo().alert().accept();

		Thread.sleep(3000);

		sa.assertEquals(ap.firstRowData.getText().toLowerCase(),oDataUtilities.ReadWebElementProperties("account.Name").toLowerCase());
		test.info("merged account displayed in the recently viewed view");

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("account.home"))){
			test.info(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.info(mName.getName()+ "failed");
		}
		sa.assertAll();
	}

	@Test(priority = 5)
	@Parameters({"BrowserName"})
	public void createAccountReport_14(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 

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
		//		
		//		if(oCommonUtilities.waitForElementVisible(ap.Login)) {
		//			
		//				ap.Login.click();
		//		}
		//	not working page factory code	


		WebElement Login = driver.findElement(By.xpath("//input[@name='Login']"));

		Thread.sleep(2000);
		Login.click();

		test.info("login btn clicked");


		Thread.sleep(4000);

		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");
		Thread.sleep(2000);
		WebElement AccountTab = driver.findElement(By.xpath("//*[@title='Accounts Tab']"));
		AccountTab.click();

		test.info("Clicked on Accounts link on the home page");

		Thread.sleep(3000);


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("account.home"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}
		test.info("Accounts page is displayed with correct username");
		
		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		
		if(oCommonUtilities.waitForElementVisible(ap.lastActivityReport)){
//		WebElement lastActivity = driver.findElement(By.xpath("//*[@class='lbBody']/ul/li[2]/a"));
		ap.lastActivityReport.click();
		}
		
		test.info("Clicked on Accounts with last activity > 30 days link in reports");
		
	    sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("account.unsavedReport"));
	    
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.calen)) {
//		WebElement calen = driver.findElement(By.xpath("//*[@id='ext-gen152']"));
		ap.calen.click();	
		}
				
		test.info("clicked on from Calender"); 
		sa.assertEquals(ap.calen.isDisplayed(),ap.calen.isEnabled() );
		
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.fromDate)) {
//		WebElement fromDate = driver.findElement(By.xpath("//button[contains(text(),'Today')]"));
		ap.fromDate.click();    
		}
		test.info("clicked on from date in Calender"); 
		
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.toDate1)) {
//		WebElement toDate1 = driver.findElement(By.xpath("//*[@id='ext-gen154']"));
		ap.toDate1.click();
		}
				
		sa.assertEquals(ap.toDate1.isEnabled(),ap.toDate1.isDisplayed());
		
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.toDate2)) {
//		WebElement toDate2 = driver.findElement(By.xpath("//*[@id='ext-comp-1046']//ul//li//div//table//tbody//tr//td[3]//a[@title='Next Month (Control+Right)']"));
		ap.toDate2.click();
		}
		
		sa.assertEquals(ap.toDate2.isEnabled(),ap.toDate2.isDisplayed());
				
		Thread.sleep(3000);
		
		if(oCommonUtilities.waitForElementVisible(ap.toDate3)) {
//		WebElement toDate3 = driver.findElement(By.xpath("//*[@id='ext-comp-1046']//ul//li//div//table//tbody//tr[3]//td//table//tbody//tr[2]//td[2]//em//button"));
		ap.toDate3.click();
		}
		test.info("clicked on to date in Calender");      	
		
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.saveReport)) {
//		WebElement saveReport = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		ap.saveReport.click();
		}
		test.info("clicked on save button");
		
		sa.assertEquals(ap.saveReport.getText(),"Save");
		
		Thread.sleep(3000);
		if(oCommonUtilities.waitForElementVisible(ap.rName)) {
//		WebElement rName = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		ap.rName.clear();
		ap.rName.sendKeys("Appu17");
		}
		test.info("sent Report name "); 
		
		Thread.sleep(3000);
			
     	sa.assertEquals(ap.rName.getAttribute("value"),"Appu17");
		
     	if(oCommonUtilities.waitForElementVisible(ap.rUName)) {
//		WebElement rUName = driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
        Thread.sleep(3000);
		ap.rUName.clear();
		ap.rUName.sendKeys("Ku17");
	}
		test.info("sent Unique Report name ");
			
		sa.assertEquals(ap.rUName.getAttribute("value"),"Appu17Ku17");
		Thread.sleep(3000);
		
		if(oCommonUtilities.waitForElementVisible(ap.svArunReport)) {
//		WebElement svArunReport = driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']"));
		ap.svArunReport.click();
		}
				
		test.info("Save and Run the report");
		
		sa.assertEquals(ap.svArunReport.getText(), "Save and Run Report");
		
		Thread.sleep(3000);
	
		
		if(driver.getTitle().equals("Appu17 ~ Salesforce - Developer Edition")) {

			test.pass(mName.getName()+" PASSED");
		} 
		else {

			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" FAILED");
		}
		
		sa.assertAll();
}
	

}
