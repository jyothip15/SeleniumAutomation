package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportyspage {
	
	public Opportyspage(WebDriver driver) {
		
		if(driver != null) {
			PageFactory.initElements(driver, this);
		}
	}
	
	@FindBy( xpath = "//input[@name='Login']")
	public WebElement Login;
	
	@FindBy( xpath = "//*[@title='Opportunities Tab']")
	public WebElement OpportyTab;
	
	@FindBy (id ="fcf")
	public WebElement opportyDropDown;
	
	@FindBy( xpath = "//input[@name='new']")
	public WebElement newOpr;
	
	@FindBy( xpath = "//input[@id='opp3']")
	public WebElement oprName;
	
	@FindBy( xpath = "//*[@id='opp4_lkwgt']//img")
	public WebElement lookUp;
	
	@FindBy( xpath = "//frame[@title='Search']")
	public WebElement lookUpFrame;
	
	@FindBy( xpath = "//*[@class='lookup']//div[2]//input[@id='lksrch']")
	public WebElement searchAccount;
	
	@FindBy( xpath = "//input[@name='go']")
	public WebElement goButton;
	
	@FindBy( xpath = "//*[@id='resultsFrame']")
	public WebElement resultFrame;
	
	@FindBy( xpath = "//*[@id='new']/div/div[3]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement choseJyothi;
   
	@FindBy( xpath = "//input[@id='opp9']")
	public WebElement choseDate;
	
	@FindBy( xpath = "//*[@class='buttonBar']/a")
	public WebElement datesToday;
	
	@FindBy( xpath = "//*[@id='opp11']")
	public WebElement stageEle;
	
	@FindBy( xpath = "//*[@id='opp12']")
	public WebElement probability;
	
	@FindBy( xpath = "//*[@id='opp6']")
	public WebElement leadSource;
	
	@FindBy( xpath = "//*[@id='topButtonRow']//*[@name='save']")
	public WebElement bottomSave;
	 
	@FindBy( xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	public WebElement pipeLineLink;
	
	@FindBy( xpath = "//*[@id='report_Tab']/a")
	public WebElement pipeLinePage;
	
	@FindBy( xpath = "//*[contains(text(),'Stuck Opportunities')]")
	public WebElement stuckOtpyLink;
	
	@FindBy( xpath = "//*[@id='quarter_q']")
	public WebElement selectInterval;
	
	@FindBy( xpath = "//*[@id='open']")
	public WebElement selectIncOpty;
	
	@FindBy( xpath = "//*[@title='Run Report']")
	public WebElement runReport;
	
	@FindBy( xpath = "//h1[contains(text(),'Opportunity Report')]")
	public WebElement opportunityReport;
	
	
	
	
	
	
}
