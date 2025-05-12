package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//1. Find Element
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtPhone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy (xpath = "//label[normalize-space()='Yes']")
	WebElement radioSubscribe;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkboxAgree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//2. Action Methods
	
	public void setTxtFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void setTxtLastName(String  lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void setTxtEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTxtPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void setTxtPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setTxtConfirmPassword(String cPassword) {
		txtConfirmPassword.sendKeys(cPassword);
	}

	public void clickRadioSubscribe() {
		radioSubscribe.click();
	}

	public void clickCheckboxAgree() {
		checkboxAgree.click();
	}

	public void clickBtnContinue() {
		btnContinue.click();
	}

	//3. Validation
	
	public String setMsgConfirmation() {
		
		try{
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
}
