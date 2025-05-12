package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Login_DataDriven_Test extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "datadriven") // we using dataProviderClass if the
	public void verify_LoginDDT(String email, String password, String exp) {

		logger.info("*****Started the Login Testcases*****");

		logger.info("*****Executed the Login Page*****");

		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// LoginPage
		logger.info("*****Providing login details*****");
		LoginPage lp = new LoginPage(driver);
		lp.setTxtusername(email);
		lp.setTxtpassword(password);
		lp.setBtnLogin();

		// MyAccountPage
		logger.info("*****Login Successfully and Verify the Message*****");
		MyAccountPage myaccount = new MyAccountPage(driver);
		boolean targetPage = myaccount.isVisibleMyAccount();

		if (exp.equalsIgnoreCase("Valid")) {

			if (targetPage == true) {
				myaccount.clickLogOut();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		} else {
			if (targetPage == true) {
				myaccount.clickLogOut();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

		logger.info("*****Started the Login Testcases*****");
	}

}
