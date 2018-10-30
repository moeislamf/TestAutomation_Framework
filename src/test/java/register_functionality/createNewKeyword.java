package register_functionality;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import coreClasses.BaseTestScript;
import pageObjects.addKeyword;
import pageObjects.keywordPage;
import pageObjects.loginPage;
import pageObjects.userDashboardPage;

public class createNewKeyword extends BaseTestScript {

	loginPage login;
	userDashboardPage keyword;
	keywordPage createNewKeyword;
	addKeyword createkeyword;

	@Test
	public void createkeyword() throws IOException, InterruptedException {

		login = new loginPage(BaseTestScript.driver);
		login.doLogin("textingpro3@gmail.com", "password");

		keyword = new userDashboardPage(BaseTestScript.driver);
		keyword.keywordMenu();

		createNewKeyword = new keywordPage(BaseTestScript.driver);
		createNewKeyword.clickCreateNewKeywordButton();

		createkeyword = new addKeyword(BaseTestScript.driver);
		createkeyword.addKeywordElements();

		if (createNewKeyword.keywordConfirmation()) {
			System.out.println("Keyword successfully created");

			logger = extent.startTest("passTest");
			Assert.assertTrue(true);
			// To generate the log when the test case is passed
			logger.log(LogStatus.PASS, "Test Case Passed is passTest");

		} else {
			System.out.println("Keyword wasn't created");

			logger = extent.startTest("failTest");
			Assert.assertTrue(false);
			logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		}

	}

}
