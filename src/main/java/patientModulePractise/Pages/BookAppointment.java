package patientModulePractise.Pages;

import java.util.HashMap;

import org.mmpPractise.util.FutureDateClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookAppointment {
	WebDriver driver;
	public BookAppointment(WebDriver driver) {
		this.driver = driver;
	}

	public HashMap<String,String> scheduleAppt(String doctorname, int apptdate) {
		//Dr.Alexander ,HashMap-->date , time , appointment, doctor
		HashMap<String,String> expectedMap = new HashMap<String,String>(); //====>>>expectedHashMap(Declaration)
		
String doctor="//h4[text()='"+doctorname+"']/following-sibling::div/p[text()='Description:Dermitologost']/ancestor::td/button[text()='Book Appointment']";
driver.findElement(By.xpath(doctor)).click();
driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='myframe']")));
driver.findElement(By.xpath("//input[@id='datepicker']")).click();

	String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
    System.out.println("actualYear is:"+actualYear);
    
	String expectedDate = FutureDateClass.futureDateAppt(15,"MMMM/dd/YYYY");// o/p->february/14/2023
	expectedMap.put("apptdate",FutureDateClass.futureDateAppt(15,"MM/dd/YYYY"));// o/p->02/14/2023=>1).expectedHashMap(date)
	System.out.println(expectedDate);
	String [] DateArray = expectedDate.split("/");
	String expectedMonth = DateArray[0];
	String expectedDay = DateArray[1];
	String expectedYear = DateArray[2];
  System.out.println("ExpectedYear is :"+expectedYear);
  while(!(actualYear.equals(expectedYear))) {
	  driver.findElement(By.xpath("//span[text()='Next']")).click(); //span[@class='ui-icon ui-icon-circle-triangle-e']
	  actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
  }
String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

  while(!(actualMonth.equals(expectedMonth))) {
	  driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	  actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
  }
  driver.findElement(By.linkText(expectedDay)).click();
 Select timeselect = new Select(driver.findElement(By.xpath("//select[@id='time']")));
 timeselect.selectByVisibleText("10Am");
 expectedMap.put("appttime","10Am"); // =========================================================>>>(2).expectedHashMap(Time)
 driver.findElement(By.xpath("//button[@id='ChangeHeatName' and text()='Continue']")).click();
 
// driver.findElement(By.xpath("//textarea[@name='sym']")).click();
 driver.findElement(By.id("sym")).sendKeys("Skin rash,red & itchy scalp");
 expectedMap.put("apptreason","Skin rash,red & itchy scalp"); // =========================>>>(3).expectedHashMap(Appointment)
 driver.findElement(By.xpath("//input[@value='Submit']")).click();
 expectedMap.put("apptdoctor",doctorname.substring(3)); // ====================================>>>(4).expectedHashMap(Doctor)
 //doctorname coming from fameworkScdApptTest class as Dr.Alexandar
 // substring used to start from 3rd index 'Alexander' as dataBase has-> 02/14/2023,10Am,Skinrashred&itchyscalp,Alexander 
 return expectedMap;
	}	

}
