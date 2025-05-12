package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='list-inline']//li[@class='dropdown']")
	WebElement dropdownMyAccount;
	
	@FindBy(linkText = "Register")
	WebElement optionRegister;
	
	@FindBy(linkText = "Login")
	WebElement optionLogin;
	
	

	public void clickMyAccount() {
		dropdownMyAccount.click();
	}
	
	
	
	public void clickLogin() {
		optionLogin.click();
	}

	public void clickRegister() {
		//Solution 1
		optionRegister.click();
		
		//Solution 2
		//optionRegister.submit();
		
		//Solution 3
		//Actions act = new Actions(driver);
		//act.moveToElement(optionRegister).click().perform();
		
		//Solution 4
		//optionRegister.sendKeys(Keys.RETURN);
		
		//Solution 5
		//WebDriverWait mywait = new WebDriverWait (driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(optionRegister)).click();;
		
		//Solution 6
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments [0].click();", optionRegister);
	}
	
	
	
}
