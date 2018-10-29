package register_functionality;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.addKeyword;
import pageObjects.keywordPage;
import pageObjects.loginPage;
import pageObjects.userDashboardPage;

public class createNewKeyword extends BaseTestScript{
	
	loginPage login;
	userDashboardPage keyword;
	keywordPage createNewKeyword;
	addKeyword createkeyword;
	
	@Test
	public void createkeyword() throws IOException, InterruptedException {
		
	 test = extent.createTest("Test Case 1", "As coustomer Create new Keyword");	
		 
	login = new loginPage(BaseTestScript.driver);
	login.doLogin("textingpro3@gmail.com", "password");
	
	keyword= new userDashboardPage(BaseTestScript.driver);
	keyword.keywordMenu();
	
	createNewKeyword = new keywordPage(BaseTestScript.driver);
	createNewKeyword.clickCreateNewKeywordButton();
	
	createkeyword = new addKeyword(BaseTestScript.driver);
	createkeyword.addKeywordElements();
	
	if(createNewKeyword.keywordConfirmation()) {
		System.out.println("Keyword successfully created");
		Assert.assertTrue(true);
	} else {
		System.out.println("Keyword wasn't created");
		Assert.assertTrue(false);
	}
		
	}
	
	

}
