package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) {
		if(driver != null) {
			PageFactory.initElements(driver,this);
		}
	}
	
	@FindBy (xpath = "//li[@id='Contact_Tab']/a")
    public WebElement contactsTab;
	
	@FindBy (xpath = "//input[@name='new']")
    public WebElement newBtn;
	
	@FindBy (xpath = "//input[@name='name_lastcon2']")
    public WebElement cLname;
	
	@FindBy (xpath = "//*[@id='con4_lkwgt']//img")
    public WebElement cLookUp;
	
	@FindBy (xpath = "/html/frameset/frame")
    public WebElement cLookFrame;
	
	@FindBy (xpath = "//div[@class='lookup']//div[2]//input[@id='lksrch']")
    public WebElement cSearch;
	
	@FindBy (xpath = "//input[@name='go']")
    public WebElement cGo;
	
	@FindBy (xpath = "//frame[@title='Results']")
    public WebElement resultFrame;
	
	@FindBy (xpath = "//div[@class='pbBody']/table/tbody/tr[2]/th/a")
    public WebElement resultsLook;
	
	@FindBy (xpath = "//*[@id='bottomButtonRow']/input[1]")
    public WebElement cSaveBtn;
	
	@FindBy (xpath = "//*[@class='fFooter']/a[2]")
    public WebElement cNewView;
	
	@FindBy (xpath = "//input[@id='fname']")
    public WebElement cViewName;
	
	@FindBy (xpath = "//input[@id='devname']")
    public WebElement cUniqueName;
	
	@FindBy (xpath = "//div[@class='pbBottomButtons']//input[1]")
    public WebElement cSave;
	
//	@FindBy (xpath = "//div[@class='topNav primaryPalette']//select")
//	@FindBy (xpath = "//div[@class='controls']/select")
	
	
	@FindBy (xpath = "//*[@class='individualPalette listViewportWrapper']//div//form//div//div//select")
	public WebElement selectCrViewName;
	
	
	@FindBy (xpath = "//td[@class='pbHelp']/select")
    public WebElement selectRecently;
	
//	@FindBy (xpath = "//span[@class='fBody']/select")
//	@FindBy (xpath = "/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[2]/form/div/span/span[1]/select")
	@FindBy (xpath = "//*[@class='filterOverview']/form/div/span/span/select")
    public WebElement selectContact;
	
	@FindBy (xpath = "//tr[contains(@class,'dataRow even first')]//td[1]")
	public WebElement contactName; 		
	
	@FindBy (xpath = "//*[@class='errorMsg']")
	public WebElement cErrMsge; 
	
	@FindBy (xpath = "//div[@class='pbBottomButtons']//input[2]")
    public WebElement cSaveNewBtn;
	
	
	
	
	
}
