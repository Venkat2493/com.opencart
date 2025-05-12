package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtusername;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;

	public void setTxtusername(String user) {
		txtusername.sendKeys(user);
	}

	public void setTxtpassword(String pass) {
		txtpassword.sendKeys(pass);
	}

	public void setBtnLogin() {
		btnLogin.click();
	}
	
	
	

}
