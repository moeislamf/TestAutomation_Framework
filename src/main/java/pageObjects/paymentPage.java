package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class paymentPage extends BasePageObject {

	public paymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void paymentFields() throws IOException {

		selectOptionFromDropDown(By.id("countrySelector"), "United States");

	}

}
