Feature: Create and view sms template

@createTemplate
Scenario: Create sms template
Given Open browser
When user navigate to textingpro url
Then user vrify textingpro logo
When user click on Login link
And  user enter username and password
And user click on login button
Then user successfully logs into the application
When user clicks on SMS Template tab
Then user redirects to template list page
When user click on Add New Template
And user enters Template name
And user enter message
And user click on Add New Template button
Then user redirect to template list page
And user verify template added into list
When user clicks on user profile
And click on logout button
Then user successfully logged out
And close browser