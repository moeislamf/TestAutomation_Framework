package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class addKeyword extends BasePageObject {

	public addKeyword(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public void addKeywordElements() throws IOException {
	
	sendkeys(By.id("Name"),"deal");
	sendkeys(By.id("UrlBox"), "http://wwww.gmail/mymail/yourmail/hismail/hermail/ourmail/index/aspx");
	click(By.xpath("//a[@class='btn btn-success btn-sm mt-sm-4']"));
	sendkeys(By.id("autoReply"), "Staples: Sunday doorbuster up to 99% at all our retail stores. Visit us at http://www.google.com");
	click(By.xpath("//button[@type='submit']"));
	
	
}
	
}
