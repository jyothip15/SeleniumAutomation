package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RandomPage {
	public RandomPage(WebDriver driver) {
		if( driver != null) {
			PageFactory.initElements(driver,this);
		}
	}
	@FindBy (xpath = "//li[@id='home_Tab']/a" )
	public WebElement homeTab;
	
	@FindBy (xpath = "//h1[@class='currentStatusUserName']/a" )
	public WebElement firstLastName;
	
	@FindBy (xpath = "//li[@id='UserProfile_Tab']/a" )
	public WebElement profileTab;
	
	@FindBy (xpath = "//span[@id='tailBreadcrumbNode']" )
	public WebElement nameFirstLastName;
	
	@FindBy (xpath = "//a[@class='contactInfoLaunch editLink']/img")
	public WebElement rEditContact;
	
	@FindBy ( id = "contactInfoContentId")
	public WebElement rFrame;
	
	@FindBy ( id = "aboutTab")
	public WebElement rAboutTab;
	
	@FindBy ( id = "lastName")
	public WebElement rlastName;
	
	@FindBy ( id = "tailBreadcrumbNode")
	public WebElement lUpdatedNameLeft;
	
	@FindBy ( id = "userNavLabel")
	public WebElement rUpdatedNameRight;
	
	@FindBy (xpath = "//a[contains(text(),'My Settings')]")
	public WebElement rMySettings;
	
	@FindBy ( id = "PersonalInfo_font")
	public WebElement rPersonal;
	
	@FindBy (xpath = "//a[@id='PersonalInformation_font']//span[contains(text(),'Personal Information')]")
	public WebElement rPersonal2;
	
	@FindBy (xpath = "//input[@id='PersonalInformationSetup:editPage:pageBlock:lastName']")
	public WebElement rLastName;

//testCase_35
	
	@FindBy (className = "allTabsArrow")
	public WebElement rAllTab;
	
	@FindBy (xpath = "//input[@title='Customize My Tabs']")
	public WebElement rCustTabs;
	
	@FindBy (xpath = "//*[@id='duel_select_1']")
	public WebElement selectedTabs;
	
	@FindBy (xpath = "//*[@id='duel_select_0_left']")
	public WebElement leftArrowBtn;
	
	@FindBy (xpath = "//*[@id='duel_select_0']")
	public WebElement availableTabs;
	
	@FindBy (xpath = "//*[@class='pbButtonb']//input")
	public WebElement rSaveBtnBottom;
	
	@FindBy (xpath = "//*[@class='zen-inlineList zen-tabMenu']")
	public WebElement rAllTabsDisplayed;
	
//test case 36
	
	@FindBy (xpath = "//td[@class='fixedTable']//div[@id='p:f:j_id25:j_id61:28:j_id64']/a")
	public WebElement r8pmLink;
	
	@FindBy (xpath = "//*[@class='comboboxIcon']")
	public WebElement rComboBoxIcon;
	
	@FindBy (xpath = "//*[@class='listItem4']/a")
	public WebElement rSubject;
	
	@FindBy (xpath = "//span[@class='timeInput']/input[@id='EndDateTime_time']")
	public WebElement r9pmLink;
	
	@FindBy (id = "timePickerItem_42")
	public WebElement r9pmDrop;
		
	@FindBy (xpath = "//*[@id='topButtonRow']/input[@name='save']")
	public WebElement rTopSaveBtn;
	
	@FindBy (xpath = "//a[@class='eventMru']")
	public WebElement newEventOther;
	
	@FindBy (id = "StartDateTime_ileinner")
	public WebElement rStartTime;

	@FindBy (id = "EndDateTime_ileinner")
	public WebElement rEndTime;
	
	@FindBy (id = "evt5_ileinner")
	public WebElement rSubjectLast;
	
	@FindBy (xpath = "//td[@class='fixedTable']//div[@id='p:f:j_id25:j_id61:20:j_id64']/a")
	public WebElement r4pmLink;
	
	@FindBy (id = "timePickerItem_38")
	public WebElement r7pmDrop;
	
	@FindBy (xpath = "//span[@class='pageDescription']/a")
	public WebElement rCurrentDate;
	
	@FindBy (xpath = "//input[@id='IsRecurrence']")
	public WebElement IsRecurrence;
	
	@FindBy (xpath = "//input[@id='rectypeftw']")
	public WebElement weeklyRadioBtn;
	
	@FindBy (xpath = "//input[@id='wi']")
	public WebElement rRecursField;
	
	@FindBy (xpath = "//input[@id='1']")
	public WebElement rSun;
	
	@FindBy (xpath = "//input[@id='2']")
	public WebElement rMon;
	
	@FindBy (xpath = "//input[@id='4']")
	public WebElement rTue;
	
	@FindBy (xpath = "//input[@id='8']")
	public WebElement rWed;
	
	@FindBy (xpath = "//input[@id='16']")
	public WebElement rThu;
	
	@FindBy (xpath = "//input[@id='32']")
	public WebElement rFri;
	
	@FindBy (xpath = "//input[@id='64']")
	public WebElement rSat;
	
	@FindBy (xpath = "//input[@id='RecurrenceEndDateOnly']")
	public WebElement rEndDateRecur;
	
	@FindBy (xpath = "//span[@class='dwmIcons']/a[3]/img")
	public WebElement rMonthView;
	
	@FindBy (xpath = "//a[@title='Today']")
	public WebElement getToday;
	
	@FindBy (xpath = "//a[contains(text(),'11')]")
	public WebElement nextWeekDate;


	
	
	
	

	
	
	
	
}
