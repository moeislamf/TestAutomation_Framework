Feature: Send inquiry via contact us form

@send_inquiry
Scenario: Send Inquiry
Given open browser And navigate to url
When  user click on "Contact Us" menu
Then verify users see Contact US text
And enter Name and email id and subject and comments
When user click on Send button
Then verify that user get popup confirmation