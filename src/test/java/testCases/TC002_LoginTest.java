package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	
	@Test(groups = {"Sanity","Master"})
	void verify_Login() throws IOException {
		
		try {
		logger.info("*****Started the Login Testcases*****");
		
		logger.info("*****Executed the Login Page*****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*****Providing login details*****");
		LoginPage lp = new LoginPage(driver);
		lp.setTxtusername(p.getProperty("email"));
		lp.setTxtpassword(p.getProperty("password"));
		lp.setBtnLogin();
		
		logger.info("*****Login Successfully and Verify the Message*****");
		MyAccountPage myaccount = new MyAccountPage(driver);
		boolean b = myaccount.isVisibleMyAccount();
		
		Assert.assertEquals(b, true, "Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
			
		}
		
		logger.info("*****Finished the Login Testcases*****");
	}
	
	
}
