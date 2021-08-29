package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	public loginpage(WebDriver driver) {
		
		if(driver != null) {
//		PageFactory.initElements(driver,loginpage.class);
		PageFactory.initElements(driver, this);
	}
	}
	
	@FindBy(name = "username")
	public WebElement Username;
	
	@FindBy(id = "password")
	public WebElement Password;
	
//	@FindBy(id = "login")
//	public WebElement Login;
	
	@FindBy(css = "#Login")
	public WebElement Login;
	
//	@FindBy(id = "rem")
//	public WebElement RememberMe;
	
	@FindBy(xpath = "//input[@id='rememberUn']")
	WebElement rememberMe; 
	
	@FindBy(xpath = "//*[@id='error']")   
	public WebElement Errormsg;
	
	@FindBy(xpath = "//div[@id='error']")
	public WebElement ErrormsgLogin;
	
//useraccount
	
	@FindBy( id ="userNav")
	public WebElement UserMenu;
	
	@FindBy(xpath = "//*[@id='userNavLabel']")
	public WebElement UserMenuDrop;
	
	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement UserMenuProfile;
	
	@FindBy(xpath = "(//img[@title='Edit Profile'])[1]")
	public WebElement UserPrfEdit;
	
	@FindBy(id = "aboutTab")
	public WebElement aboutTab;
	
	@FindBy(xpath = "//li[@id='contactTab']")
	public WebElement contactTab;
	
	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath = "//input[@value='Save All']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//span[@id='tailBreadcrumbNode']")
	public WebElement updlastName;
	
	@FindBy(xpath ="//a[@id='publisherAttachTextPost']")
	public WebElement postButton;
	
	@FindBy(xpath = "//div[@id='cke_39_contents']/iframe")
	public WebElement iFramePost;
	
	@FindBy(tagName = "body")
	public WebElement postbody;
	
	@FindBy(xpath ="//input[@id ='publishersharebutton']")
	public WebElement shareButton;
	
	@FindBy(tagName = "p")
	public WebElement postDetails;
	
	@FindBy(xpath = "//a[@title='File']")
	public WebElement fileLink;
	
	@FindBy(xpath = "//a[@id='chatterUploadFileAction']")
	public WebElement uploadLink;
	
	@FindBy (xpath = "//input[@id='chatterFile']")
	public WebElement chooseFile;
	
	@FindBy (xpath = "//input[@id='publishersharebutton']")
	public WebElement shareFileBtn;
	
	@FindBy (xpath = "//span[@class='contentTitleLink']")
	public WebElement fileName;
	
	@FindBy (xpath = "//div[@id='photoSection']")
	public WebElement actionMouse;
	
	@FindBy (xpath = "//a[@id='uploadLink']")
	public WebElement uploadphotoLink;
	
	@FindBy (xpath = "//iframe[@id='uploadPhotoContentId']")
	 public WebElement photoUpdiFrame;
	
	@FindBy (xpath = "//input[@id='j_id0:uploadFileForm:uploadInputFile']")
	public WebElement choosePhotoUpload;
	
	@FindBy (xpath = "//*[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveBtn;
	
	@FindBy (xpath = "//input[@value='Save']")
//	@FindBy (xpath = "/html[1]/body[1]/span[1]/form[1]/div[2]/input[1]")
	public WebElement cropSaveBtn;
	
	@FindBy (xpath = "//*[@id='photoSection']/span[2]/img[1]")
	public WebElement imagelink;
	
	@FindBy (xpath = "//a[@title='My Settings' and @class='menuButtonMenuLink' ]")
	public WebElement settingLink;
	
	@FindBy (xpath = "//span[@id='PersonalInfo_font']")
	public WebElement personalLink;
	
	@FindBy (xpath = "//*[@id='LoginHistory_font']")
	public WebElement historyLink;
	
	@FindBy (xpath = "//div[@class='pShowMore']/a")
	public WebElement downLoadLink;
	
	@FindBy (xpath = "//div[@id='DisplayAndLayout']/a")
	public WebElement disLayLink;
	
	@FindBy (xpath = "//span[@id='CustomizeTabs_font']")
	public WebElement customTab;
	
	@FindBy (id = "p4")
	public WebElement salesChatter;
	
	@FindBy (xpath = "//option[@value='report']")
	public WebElement reportsTab;
	
	@FindBy (id = "duel_select_0_right")
	public WebElement addButton;
	
	@FindBy (xpath = "//*[@id='bottomButtonRow']/input[1]")
	public WebElement saveButton;
	
	@FindBy (xpath = "//a[@title='Reports Tab']")
	public WebElement tabReports;
	
	@FindBy (xpath = "//option[@value='report']")
	public WebElement selectedReport;
	
	@FindBy (id = "EmailSetup_font")
	public WebElement emailField;
	
	@FindBy (xpath = "//span[@id='EmailSettings_font']")
	public WebElement emailSettings;
	
	@FindBy (xpath = "//input[@id='sender_name']")
	public WebElement senderName;
	
	@FindBy (xpath = "//input[@id='sender_email']")
	public WebElement senderEmail;
	
	@FindBy (xpath = "//input[@id='auto_bcc1']")
	public WebElement radiobtn;
	
	@FindBy (xpath = "//input[@name='save']")
	public WebElement savebtn;
	
	@FindBy (xpath = "//div[@class='messageText']")
	public WebElement textmsge;
	
	@FindBy (xpath = "/html/body/div/div[2]/table/tbody/tr/td[1]/div/div[4]/div[6]/a/span[2]")
	public WebElement calender;
	
	@FindBy (xpath = "//*[@id='Reminders_font']")
	public WebElement reminder;
	
	@FindBy (xpath = "//input[@value='Open a Test Reminder']")
	public WebElement openReminder;
	
	@FindBy (xpath = "//*[@title='Developer Console (New Window)']")
	public WebElement devConsole;
	
	@FindBy (xpath = "//*[@title='Logout']")
	public WebElement logout;
	
	 
	
}


