package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
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
import pages.Opportyspage;
import pages.accountspage;

public class VerifyOpportyModule extends BaseTest{


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
	public void Opportunity_15(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));


		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); 
		Opportyspage op = new Opportyspage(driver);

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

		if(oCommonUtilities.waitForElementVisible(op.OpportyTab)) {
			op.OpportyTab.click();
		}

		Thread.sleep(2000);
		test.info("Opportunities home page is displayed.");
		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Opporty.Home"));

		Select selectOpporty = new Select(op.opportyDropDown);

		List<WebElement> selectoptions = selectOpporty.getOptions();

		String[] options = {"All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};

		boolean match = false;

		for(int i=0; i<selectoptions.size(); i++) {
			if(selectoptions.get(i).getText().equals(options[i])){
				match = true; 	
			}
			else {
				match = false;
				break;
			}
		}

		sa.assertTrue(match);

		if(match) {
			test.info("Drop down with \"All Opportunities\", \"Closing Next Month\", \"Closing This Month\", \"My Opportunities\", \"New This Week\", \"Recently Viewed Opportunities\",\"Won\" are available");
		}
		else {
			test.info("Drop down with \"All Opportunities\", \"Closing Next Month\", \"Closing This Month\", \"My Opportunities\", \"New This Week\", \"Recently Viewed Opportunities\",\"Won\" are NOT available");
		}


		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Opportunities.home"))){
			test.pass(mName.getName()+ " passed");    	
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed");
		}  

		sa.assertAll();
	}

	   @Test(priority = 2)
	   @Parameters({"BrowserName"})
	public void createNewOpty_16(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); Opportyspage op = new
				Opportyspage(driver);

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

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.OpportyTab)) {
			op.OpportyTab.click();
		}

		Thread.sleep(2000);
		test.info("Opportunities home page is displayed.");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Opporty.Home"));

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.newOpr)) {
			op.newOpr.click();
		}
		//		WebElement newOpr = driver.findElement(By.xpath("//input[@name='new']"));

		test.info("New Opportunity Edit page is displayed");
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Opportunity.edit"));

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.oprName)) {
			op.oprName.clear();
			op.oprName.sendKeys("Jyothi Poozhikkuth");
		}
		//		WebElement oprName = driver.findElement(By.xpath("//input[@id='opp3']"));
		//		oprName.clear();
		//		oprName.sendKeys("Jyothi Poozhikkuth");

		test.info("Entered Opportunity Name as \"Jyothi Opr\" ");

		sa.assertEquals(op.oprName.getAttribute("value"), "Jyothi Poozhikkuth");
		Thread.sleep(2000);

		//		WebElement lookUp = driver.findElement(By.xpath("//*[@id='opp4_lkwgt']//img"));

		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(op.lookUp).perform();

		op.lookUp.click();

		sa.assertNotNull(driver.getCurrentUrl());
		Thread.sleep(5000);

		String parentWindow = driver.getWindowHandle();
		Set<String> sWindowHandles = driver.getWindowHandles();
		Iterator<String> it = sWindowHandles.iterator();
		while(it.hasNext()) {
			String childWindow = it.next();

			if(!parentWindow.equals(childWindow)) {

				driver.switchTo().window(childWindow);

				if(oCommonUtilities.waitForElementVisible(op.lookUpFrame)) {
					op.lookUpFrame.click();
				}

//	    		WebElement lookUpFrame = driver.findElement(By.xpath("//frame[@title='Search']"));
				driver.switchTo().frame(op.lookUpFrame);

				if(oCommonUtilities.waitForElementVisible(op.searchAccount)) {
					op.searchAccount.clear();                                 
					op.searchAccount.sendKeys("Jyothi");
				}
				//	    		WebElement  = driver.findElement(By.xpath("//*[@class='lookup']//div[2]//input[@id='lksrch']"));

				Thread.sleep(5000);

				sa.assertEquals(op.searchAccount.getAttribute("value").toUpperCase(), "JYOTHI");

				test.info("searching Jyothi in look up");

				//  		        WebElement goButton = driver.findElement(By.xpath("//input[@name='go']"));

				if(oCommonUtilities.waitForElementVisible(op.goButton)) {
					op.goButton.click();
				}

				test.info("clicking go button");

				sa.assertNotNull(driver.getCurrentUrl());

				Thread.sleep(2000);

				driver.switchTo().defaultContent();

				//	    		WebElement resultFrame = driver.findElement(By.xpath("//*[@id='resultsFrame']"));
				driver.switchTo().frame(op.resultFrame);

				Thread.sleep(2000);    
				//	    		WebElement choseJyothi = driver.findElement(By.xpath("//*[@id='new']/div/div[3]/div/div[2]/table/tbody/tr[2]/th/a"));
				if(oCommonUtilities.waitForElementVisible(op.choseJyothi)) {
					op.choseJyothi.click();
				}
				test.info("chosing jyothi as account holder");

				Thread.sleep(5000);   	   		

			}
		}
		driver.switchTo().window(parentWindow);

		Thread.sleep(2000);  
		//	     WebElement choseDate = driver.findElement(By.xpath("//input[@id='opp9']"));
		if(oCommonUtilities.waitForElementVisible(op.choseDate)) {
			op.choseDate.click();
		}
		sa.assertNotNull(driver.getTitle());

		Thread.sleep(2000);  

		//	     WebElement datesToday = driver.findElement(By.xpath("//*[@class='buttonBar']/a"));

		if(oCommonUtilities.waitForElementVisible(op.datesToday)) {
			op.datesToday.click();
		}

		test.info("chosing date as today");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Opportunity.edit"));

		//	     WebElement stageEle = driver.findElement(By.xpath("//*[@id='opp11']"));

		Select selectStage = new Select(op.stageEle);
		selectStage.selectByVisibleText("Proposal/Price Quote");

		test.info("chosing stage as \"Proposal/Price Quote\"");

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Opportunity.edit"));


		//	     WebElement probability = driver.findElement(By.xpath("//*[@id='opp12']"));
		if(oCommonUtilities.waitForElementVisible(op.probability)) {
			op.probability.clear();
			op.probability.sendKeys("50");
		}
		test.info("Probability as 50%");

		sa.assertEquals(op.probability.getAttribute("value"), "50");
		System.out.println();
		//	     WebElement leadSource = driver.findElement(By.xpath("//*[@id='opp6']"));
		Select selectLeadSource = new Select(op.leadSource);
		selectLeadSource.selectByVisibleText("Partner Referral");

		test.info("leadSource \"Partner Referral\"");


		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Opportunity.edit"));

		//	     WebElement PrimCamSource = driver.findElement(By.xpath("//*[@id='opp17']"));
		//	     PrimCamSource.clear();
		//	     PrimCamSource.sendKeys("Campaign Source");
		//	     
		//	     test.info(" PrimCamSource as \"Campaign Source\"");

		//	    WebElement bottomSave = driver.findElement(By.xpath("//*[@id='topButtonRow']//*[@name='save']"));
		js.executeScript("arguments[0].scrollIntoView();", op.bottomSave);
		if(oCommonUtilities.waitForElementVisible(op.bottomSave)) {
			op.bottomSave.click();
		}
		test.info("clicked on save button and New Opportunity page is displayed with Opportunity details.");
		sa.assertNotNull(driver.getTitle());

		if(driver.getTitle().equals(oDataUtilities.ReadWebElementProperties("Opportunity.save"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName() + "failed");
		}

		sa.assertAll();	 		 
	}

	@Test(priority = 3)
	@Parameters({"BrowserName"})
	public void optyPipelineReport_17(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); Opportyspage op = new
				Opportyspage(driver);

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

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.OpportyTab)) {
			op.OpportyTab.click();
		}

		Thread.sleep(2000);
		test.info("Opportunities home page is displayed.");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Opporty.Home"));

		Thread.sleep(2000);
		
//       WebElement pipe = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));


		js.executeScript("arguments[0].scrollIntoView();", op.pipeLineLink);
		if(oCommonUtilities.waitForElementVisible(op.pipeLineLink)) {
			op.pipeLineLink.click(); 
		}

		test.info("Clicked on Opportunity Pipeline link  under Reports.");
		Thread.sleep(6000);

		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Opportunity.pipeline"));


		if(op.pipeLinePage.getText().equals(oDataUtilities.ReadWebElementProperties("Opportunity.pipelinepage"))) {
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
	public void stuckOpportunityLink_18(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); Opportyspage op = new
				Opportyspage(driver);

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

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.OpportyTab)) {
			op.OpportyTab.click();
		}

		Thread.sleep(2000);
		test.info("Opportunities home page is displayed.");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Opporty.Home"));
         
//		WebElement stuckOtpyLink = driver.findElement(By.xpath("//*[contains(text(),'Stuck Opportunities')]"));
		js.executeScript("arguments[0].scrollIntoView();", op.stuckOtpyLink);
		if(oCommonUtilities.waitForElementVisible(op.stuckOtpyLink)) {
		op.stuckOtpyLink.click();
		}
		test.info("Clicked Click on Stuck Opportunities link  under Reports.");
		
		sa.assertEquals(driver.getTitle(), oDataUtilities.ReadWebElementProperties("Opportunity.stuck"));


		if(op.pipeLinePage.getText().equals(oDataUtilities.ReadWebElementProperties("Opportunity.pipelinepage"))) {
			test.pass(mName.getName()+" passed");
		}
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+" failed"); 
		}

		sa.assertAll();
	}
	
	@Test(priority = 6)
	@Parameters({"BrowserName"})
	public void quarterlySummaryLink_19(String sBrowserName,Method mName) throws IOException, InterruptedException {

		driver = getDriver(sBrowserName);

		driver.get(oDataUtilities.ReadWebElementProperties("App.URL"));

		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Login.Title"));

		test.info("App launched");

		accountspage ap = new accountspage(BaseTest.driver); Opportyspage op = new
				Opportyspage(driver);

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

		Thread.sleep(4000);
		sa.assertEquals(driver.getCurrentUrl(), oDataUtilities.ReadPageURLproperties("Salesforce.HomePage"));


		if(oCommonUtilities.waitForElementVisible(ap.disName)) {
			sa.assertEquals(ap.disName.getText(),oDataUtilities.ReadAccountProperties("user.name"));

		}

		test.info("home page is logged in with correct username.");

		Thread.sleep(2000);

		if(oCommonUtilities.waitForElementVisible(op.OpportyTab)) {
			op.OpportyTab.click();
		}

		Thread.sleep(2000);
		test.info("Opportunities home page is displayed.");

		sa.assertEquals(driver.getCurrentUrl(),oDataUtilities.ReadPageURLproperties("Opporty.Home"));
		
//		WebElement selectInterval = driver.findElement(By.xpath("//*[@id='quarter_q']"));
		Select selectIntervalOptions = new Select(op.selectInterval);
		
		selectIntervalOptions.selectByVisibleText("Current and Previous FY");
		test.info("selected \"Current and Previous FY\" as Interval");

		sa.assertEquals(selectIntervalOptions.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Opportunity.interval"));

//		WebElement elements = selectIntervalOptions.getOptions();   //need to check
//		for(WebElement w : elements ) {
//		System.out.println(w.getText());
//	}
		
		Thread.sleep(2000);
//		WebElement selectIncOpty = driver.findElement(By.xpath("//*[@id='open']"));
		Select selectIncOptyOptions = new Select(op.selectIncOpty);
		selectIncOptyOptions.selectByValue("closedwon");
		
		sa.assertEquals(selectIncOptyOptions.getFirstSelectedOption().getText(),oDataUtilities.ReadWebElementProperties("Opportunity.include"));
		
		test.info("included \"closed/won Opportunities\" ");
		Thread.sleep(2000);
		if(oCommonUtilities.waitForElementVisible(op.runReport)) {
			op.runReport.click();
		}
		
//		WebElement runReport = driver.findElement(By.xpath("//*[@title='Run Report']"));
		
	    test.info("cliked on the Run Report and Report Page with the Opportunities that satisfies the search criteria is displayed.");
		sa.assertEquals(driver.getTitle(),oDataUtilities.ReadWebElementProperties("Opportunity.reportTitle"));
		
//		WebElement opportunityReport = driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Report')]"));
	
		if(op.opportunityReport.getText().equals(oDataUtilities.ReadWebElementProperties("Opportunity.report"))){
			test.pass(mName.getName()+ " passed");
		}
		
		else {
			test.addScreenCaptureFromPath(oCommonUtilities.takeScreenshot());
			test.fail(mName.getName()+ " failed");
		}
		
		sa.assertAll();
	}      	
}
