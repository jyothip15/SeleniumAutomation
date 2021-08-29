package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountspage {
	
	public accountspage(WebDriver driver) {
		
		 if(driver != null) {
			 PageFactory.initElements(driver,this);
		 }
	}
	
	@FindBy(name = "username")
	public WebElement Username;
	
	@FindBy(id = "password")
	public WebElement Password;
		
	@FindBy(xpath = "//*[@id='Login']")
	public WebElement Login;
	
	@FindBy(xpath = "//*[@id='userNavLabel']")
	public WebElement disName;
	
	@FindBy(xpath = "//*[@title='New']")
	public WebElement newAcct;
	
	@FindBy(xpath = "//input[@id='acc2']")
	public WebElement acctName;
	
	@FindBy(xpath = "//*[@id='topButtonRow']//input[@value=' Save ']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//*[@class='topName']")
	public WebElement acctSavName;

	@FindBy(xpath = "//*[@class='fFooter']//a")
	public WebElement newLink;
	
	@FindBy(xpath = "//input[@name='fname']")
	public WebElement viewName;
	
	@FindBy(xpath = "//input[@name='devname']")
	public WebElement viewUniqueName;
	
	@FindBy(xpath = "//*[@class='pbHeader']//input[@name='save']")
	public WebElement saveTopBtn;
	
	@FindBy(xpath = "//*[@name='fcf']")
    public WebElement selectDrop;
	
	@FindBy(xpath = "//span[@class='fFooter']//a[contains(text(), 'Edit')]")
    public WebElement editBtn;
	
	@FindBy(xpath = "//*[@id='fcol1']")
    public WebElement selectAcctEle;
	
	@FindBy(xpath = "//*[@id='fop1']")
    public WebElement selectOper;
	
	@FindBy(xpath = "//input[@name='fval1']")
    public WebElement value;
	
	@FindBy(xpath = "//*[@name='colselector_select_0']//option[@value='ACCOUNT.LAST_ACTIVITY']")
    public WebElement lastActivity;
    
	@FindBy(xpath = "//a[@id='colselector_select_0_right']//*[@class='rightArrowIcon']")
    public WebElement addBtn;
	
	@FindBy(xpath = "//div[@class='pbBottomButtons']//table//tbody//td[2]//input[@value=' Save ']")
    public WebElement saveButton;
	
	@FindBy(xpath = "//*[@title='Last Activity']")
    public WebElement lastActivityDis;
		
	@FindBy (xpath = "//a[contains(text(),'Merge Accounts')]")
	public WebElement mergeAcct;
	
	@FindBy( xpath = "//*[@class='bPageTitle']/div/div/h1")
	public WebElement merge;
		
	@FindBy( xpath = "//input[@name='srch']")
	public WebElement searchAcct;
	
	@FindBy( xpath = "//input[@name='srchbutton']")
	public WebElement searchbtn;
	
	@FindBy( xpath = "//input[@type='checkbox' and @title='Select row 0']")
	public WebElement checkBoxOne;
	
	@FindBy( xpath = "//input[@type='checkbox' and @title='Select row 1']")
	public WebElement checkBoxTwo;
	
	@FindBy( xpath = "//*[@class='pbTopButtons']//input[@class='btn']")
	public WebElement nextBtn;
		
	@FindBy( xpath = "//*[@class='pbTopButtons']//input[@title='Merge']")
	public WebElement mrgeBtn;
	
	@FindBy( xpath = "//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement firstRowData;
	
// tc14	
	@FindBy( xpath = "//*[@class='lbBody']/ul/li[2]/a")
	public WebElement lastActivityReport;
	
	@FindBy( xpath = "//*[@id='ext-gen152']")
	public WebElement calen;
	
	@FindBy( xpath = "//button[contains(text(),'Today')]")
	public WebElement fromDate;
	
	@FindBy( xpath = "//*[@id='ext-gen154']")
	public WebElement toDate1;
	
	@FindBy( xpath = "//*[@id='ext-comp-1046']//ul//li//div//table//tbody//tr//td[3]//a[@title='Next Month (Control+Right)']")
	public WebElement toDate2;
	
	@FindBy( xpath = "//*[@id='ext-comp-1046']//ul//li//div//table//tbody//tr[3]//td//table//tbody//tr[2]//td[2]//em//button")
	public WebElement toDate3;
	
	@FindBy( xpath = "//button[@id='ext-gen49']")
	public WebElement saveReport;
	
	@FindBy( xpath = "//input[@id='saveReportDlg_reportNameField']")
	public WebElement rName;
	
	@FindBy( xpath = "//input[@id='saveReportDlg_DeveloperName']")
	public WebElement rUName;
	
	@FindBy( xpath = "//table[@id='dlgSaveAndRun']")
	public WebElement svArunReport;
	
	
	
	
	
	
}