package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDropDown {
	
	public UserDropDown(WebDriver driver) {
		if(driver != null) {
			PageFactory.initElements(driver, this);
		}
	}

	@FindBy( id ="userNav")
	public WebElement UserMenu;
	
}
