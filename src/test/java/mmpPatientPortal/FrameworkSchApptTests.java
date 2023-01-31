package mmpPatientPortal;

import java.util.HashMap;

import org.mmpPractise.util.BaseClassPractise;
import org.testng.Assert;
import org.testng.annotations.Test;


import patientModulePractise.Pages.BookAppointment;
import patientModulePractise.Pages.LoginPractise;
import patientModulePractise.Pages.NavScdApptAndFetchApptDetails;

public class FrameworkSchApptTests extends BaseClassPractise {
//	WebDriver driver;
	@Test
	public void schApptTests() {
		
        LoginPractise loginP = new LoginPractise(driver);
		loginP.login(pro.getProperty("patientUserName"),pro.getProperty("patientPassword"));
		
		NavScdApptAndFetchApptDetails nsch = new NavScdApptAndFetchApptDetails(driver);
		nsch.navigateSchAppt();
		
		BookAppointment ba = new BookAppointment(driver);
		HashMap<String,String> expectedHMap = ba.scheduleAppt("Dr.Alexander", Integer.parseInt(pro.getProperty("futureDate")));
		
		HashMap<String,String> actualHMap = nsch.fetchApptDetails();
		Assert.assertEquals(actualHMap,expectedHMap);
		
		
		
	}
	
}
