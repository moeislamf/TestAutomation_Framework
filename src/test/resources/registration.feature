Feature: Registration 

@registration 
Scenario: Successful Registration 

	Given open browser And navigate to url
	When user click on "Register" menu
	Then user verify navigation to registration page 
	And user enter registration details
	And user enter OTP on verify page and click verify button
	When user updates business information
	Then verify users lands on dashboard page