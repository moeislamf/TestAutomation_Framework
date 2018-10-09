package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class homePage extends BasePageObject{

	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void navigationToMenu(String menu) throws IOException {
		
     click(By.xpath("//div[@id='cssmenu']//li//a[text()='"+menu+"']"));
	}

}




