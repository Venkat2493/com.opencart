package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {

		logger.info("*****Starting TC01_AccountRegistrationTest*****");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*****Clicked on MyAccount Link*****");

			hp.clickRegister();
			logger.info("*****Clicked on Register Link*****");

			AccountRegistrationPage accPage = new AccountRegistrationPage(driver);
			logger.info("*****Providing Customer Details*****");

			accPage.setTxtFirstName(randomString().toUpperCase());
			accPage.setTxtLastName(randomString().toUpperCase());
			accPage.setTxtEmail(randomString() + "@gmail.com");
			accPage.setTxtPhone(randomNumber());

			// Password & Confirmed Password

			String same = randomAlphaNumeric();

			accPage.setTxtPassword(same);
			accPage.setTxtConfirmPassword(same);

			accPage.clickRadioSubscribe();
			accPage.clickCheckboxAgree();
			accPage.clickBtnContinue();

			// Validation
			logger.info("*****Validating expected message*****");
			String confmsg = accPage.setMsgConfirmation();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");

			hp.clickMyAccount();
			
			MyAccountPage acc = new MyAccountPage(driver);
			acc.clickLogOut();
			logger.debug("Debug logs..");

		}

		catch (Exception e) {
			logger.error("*****Test is FAILED*****");
			Assert.fail();
		}
		
		
		
		logger.info("*****Finished TC01_AccountRegistrationTest*****");
	}

}
