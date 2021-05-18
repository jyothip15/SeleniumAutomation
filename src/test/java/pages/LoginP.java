package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginP {
	public LoginP(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id = "username")
	public WebElement UserName;
	
	@FindBy(id = "password")
	public WebElement Password;
	
	@FindBy(id = "login")
	public WebElement sLogin;
	
	@FindBy(id = "rem")
	public WebElement RememberMe;
	
	@FindBy(xpath = "//*[@id='error']")
	public WebElement Errormsg;

}
