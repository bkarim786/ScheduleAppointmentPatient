package patientModulePractise.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPractise {
 
		WebDriver driver;
	public LoginPractise(WebDriver driver) {
		this.driver = driver;
		}
	public void login(String uname, String pword) {
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();

	}

}
