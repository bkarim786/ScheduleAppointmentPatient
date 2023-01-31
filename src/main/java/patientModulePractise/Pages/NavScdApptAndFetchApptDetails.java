package patientModulePractise.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavScdApptAndFetchApptDetails {
	WebDriver driver;
	public NavScdApptAndFetchApptDetails(WebDriver driver) {
		this.driver = driver;
	}
	public void navigateSchAppt() { 
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment'] ")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
		public HashMap<String,String> fetchApptDetails() {
		//date , time , appointment, doctor.. xpath (//table[@class='table']/tbody/tr/td)[1] or below one
		String actualdate=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		String actualtime=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		String actualappt=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		String actualdoctor=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		HashMap<String,String> actualMap = new HashMap<String,String>();
		actualMap.put("apptdate", actualdate);
		actualMap.put("appttime", actualtime);
		actualMap.put("apptreason", actualappt);
		actualMap.put("apptdoctor", actualdoctor);
		return actualMap;

}
	
}
