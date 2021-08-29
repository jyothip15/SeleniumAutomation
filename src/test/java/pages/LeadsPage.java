package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		if(driver != null) {
			PageFactory.initElements(driver,this);
		}
	}

	@FindBy (xpath = "//li[@id='Lead_Tab']/a" )
	public WebElement leadsTab;
	
	@FindBy (xpath = "//*[@class='bPageTitle']//div[@class='content']//h1" )
	public WebElement leadsHome;
	
	@FindBy (xpath = "//span[@class='fBody']/*[@id='fcf']" )
	public WebElement leadsSelect;	
	
	@FindBy (xpath = "//*[@id='userNavButton']" )
	public WebElement userMenu;	
	
	@FindBy (xpath = "//*[@title='Logout']" )
	public WebElement logout;	
	
	@FindBy (xpath = "//input[@title='Go!']" )
	public WebElement goBtn;
	
	@FindBy (xpath = "//input[@name='new']" )
	public WebElement newBtn;
	
	@FindBy (xpath = "//input[@name='name_lastlea2']" )
	public WebElement lName;
	
	@FindBy (xpath = "//input[@name='lea3']" )
	public WebElement comName;
	
	@FindBy (xpath = "//*[@id='bottomButtonRow']/input[1]" )
	public WebElement lSaveBtn;
	
	@FindBy (xpath = "//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2" )
	public WebElement leadEdit;
	
	
	
	
	
	
}
