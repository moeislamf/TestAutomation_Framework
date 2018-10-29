package register_functionality;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import coreClasses.BaseTestScript;
import pageObjects.loginPage;


public class login2 extends BaseTestScript{
	
	loginPage login;
	
	@Test(priority =1)

	public void Tc_Login_Pass() throws IOException, InterruptedException{
		
		test = extent.createTest("Login", "As coustomer i have to login to texting pro");
		
 login = new loginPage(BaseTestScript.driver);
 //Log into application with valid credentials
 login.doLogin("mislam@tcgiit.com", "lookatme"); //calling doLogin which will enter credentials and submit. Look at the decleration athe buttom

 //verify user logged in successfully 
 if (login.verifyLoginSuccess() ) {
	 System.out.println("Login Success");
		Assert.assertTrue(true);
 } else {
	 System.out.println("Login Failed");
	 Assert.assertTrue(false);
 }
 		
}
	@Test(priority =2)
public void Tc_Login_Fail() throws IOException, InterruptedException {
		
	test = extent.createTest("Login", "As coustomer i have to validate invalid login to texting pro attempt");	
	
	login.doLogin("mislam@tcgiit.com", "notagoodPassword");
	
	if(login.verifyErrorMessage4FailedLogin()) {
		System.out.println("Test Case Passed");
		Assert.assertTrue(true);
	
	}else {
		System.out.println("TC failed");
	Assert.assertTrue(false);			
	}
	
	
		//pass incorrect password then get error message. take error message and verify.
	
}

}



//Tc_Login_Pass: user successfully login and sees dashboard
//Tc_Login_Fail: Login fail and users sees a friendly message "Password incorrect"