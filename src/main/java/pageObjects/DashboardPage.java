package pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import coreClasses.BasePageObject;

public class DashboardPage extends BasePageObject {
	private static Logger Log = Logger.getLogger(DashboardPage.class.getName());

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyUsersSeeDashboard() throws IOException {
		if (isDisplayed(By.xpath("//*[@id=\"main-content\"]/section/div[1]/div/h3"))) {
			return true;
		} else {

			Log.info("User didn't see Dashboard");
			return false;
		}

	}

}
