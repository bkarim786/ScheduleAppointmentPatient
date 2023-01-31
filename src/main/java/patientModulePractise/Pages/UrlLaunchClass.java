package patientModulePractise.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UrlLaunchClass {
	
	 WebDriver driver;

	public UrlLaunchClass(WebDriver driver) {
	this.driver = driver;
	}
	
	@Test
	 public void launchBrowser(String url) {
		 driver.manage().window().maximize();
		 driver.get(url);
	 }
}
