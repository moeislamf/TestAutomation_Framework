package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import coreClasses.BasePageObject;

public class VerifyPage extends BasePageObject {
	
	public VerifyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void enterOTP() throws IOException, InterruptedException {
		
    openNewTab("http://www.yopmail.com/en/");
	switchToWindow(1);
    sendkeys(By.id("login"), random);
    click(By.xpath("//*[@id=\"f\"]/table/tbody/tr[1]/td[3]/input"));
	
    swichToIFrame("ifmail");
       
    String OTP = getText(By.xpath("(//*[@id=\"mailmillieu\"]//div[text()])[2]"));
    System.out.println(OTP);
    String[] arrOfStr = OTP.split(":");
    for (String a : arrOfStr) 
           System.out.println(a);

    switchToWindow(0);

    sendkeys(By.xpath("//input[@name='token']"), arrOfStr[1]);
    click(By.xpath("//button[@type='submit']"));
	}

	public void updateBusinessInformation() throws IOException {
	sendkeys(By.id("Business_Phone"), "Automation Business Company");
	sendkeys(By.id("Fax_Number"), "899-788-6787");
	sendkeys(By.id("Street_Address"), "73 W 11 Street");
	sendkeys(By.id("Suite_Floor"), "77th Floor");
	sendkeys(By.id("City"), "New York");
	sendkeys(By.id("state"), "NY");	
	sendkeys(By.id("zipCode"), "10013");	
	selectOptionFromDropDown(By.name("businesstype"), "Marketing");
	click(By.xpath("//*[@id=\"frmupload\"]/div[13]/button"));
	}

	

	
}
