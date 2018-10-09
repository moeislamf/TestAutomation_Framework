Feature: Registration 

@registration 
Scenario: Successful Registration 

	Given open browser And navigate to url
	When user click on "Register" menu
	Then user verify navigation to registration page 
	When user enter "mislam@atmsolutionsllc.com" and "123456" and "123456" registration details 
	And user click on Sign up button 
	Then user navigates to payment page