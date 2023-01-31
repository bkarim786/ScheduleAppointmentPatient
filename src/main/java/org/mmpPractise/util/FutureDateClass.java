package org.mmpPractise.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class FutureDateClass {
	//no need to pass driver through constructor becoz its not having any driver method, it has regular java methods 
	//static method below can be called anywhere without creating object, eg:called in Bookappointment class
	public static String futureDateAppt(int noofdays, String pattern)  {
		Calendar cal =  Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofdays);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String fDate = sdf.format(d);
		System.out.println("date is ::"+fDate);
		return fDate;
	}

}
