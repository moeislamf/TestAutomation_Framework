package register_functionality;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.addSMSTemplatePage;
import pageObjects.loginPage;
import pageObjects.smsTemplatePage;
import pageObjects.userDashboardPage;

public class createNewSMSTemplate extends BaseTestScript{
	
	//smsTemplatePage newsmsTemplate;
	loginPage login;
	userDashboardPage selectTemplate;
	smsTemplatePage createNewSMStemplate;
	addSMSTemplatePage saveNewSMStemplate;
	
	@Test
	public void creatAndverifyAddNewSMSTemplate() throws IOException, InterruptedException {
		
		login = new loginPage(BaseTestScript.driver);
		login.doLogin("textingpro3@gmail.com", "password");
		
		selectTemplate = new userDashboardPage(BaseTestScript.driver);
		selectTemplate.clickTemplateMenu();
		selectTemplate.selectTemplateType();
		
		createNewSMStemplate = new smsTemplatePage(BaseTestScript.driver);
		createNewSMStemplate.clickAddNewTemplate();
		
				
		saveNewSMStemplate = new addSMSTemplatePage(BaseTestScript.driver);
		saveNewSMStemplate.createNewTemplate("Selenium test SMS Template 5", "Macys: Halloween blowout deal at http://atmsolutionsllc.com");
		saveNewSMStemplate.clickAddNewTemplate();
			
		
		if (createNewSMStemplate.verifyTemplateCreatedSuccessfully()) {
			System.out.println("SMS template created successfully");
		} else {
			System.out.println("SMS template was not created");
			Assert.assertTrue(false);
			
		}
		
		
	}	

}
