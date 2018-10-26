package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class smsTemplatePage extends BasePageObject {

	
	public smsTemplatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 public void clickAddNewTemplate() throws IOException {
	 
	 	 
	 click(By.xpath("//a[@class='btn btn-info pull-right']"));
 }
		
 public boolean verifyTemplateCreatedSuccessfully() throws IOException {
	 return isDisplayed(By.xpath("//span[contains(text(),'Template Created Succesfully')]"));
 }
		
}