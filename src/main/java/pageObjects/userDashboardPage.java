package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class userDashboardPage extends BasePageObject {

	public userDashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickTemplateMenu() throws IOException {
		click(By.xpath("//span[contains(text(),'Template')]"));
	}

	public void selectTemplateType() throws IOException {
		click(By.xpath("//a[contains(text(),'SMS Template')]"));
	}

    public void keywordMenu() throws IOException {
    	
    	click(By.xpath("//span[contains(text(),'Keyword')]"));
    	click(By.xpath("//a[contains(text(),'Keyword List')]"));
    }
	
}
