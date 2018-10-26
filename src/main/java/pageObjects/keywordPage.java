package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class keywordPage extends BasePageObject {

	public keywordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickCreateNewKeywordButton() throws IOException {
	 click(By.xpath("//a[@class='btn btn-info pull-right']"));
		
	}
  
public boolean keywordConfirmation() throws IOException {
	return isDisplayed(By.xpath("//span[contains(text(),'Keyword Created Succesfully')]"));
}
//span[contains(text(),'Keyword Created Succesfully')]
		
		
	
}
