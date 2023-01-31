package javaExamples;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePractise {

	public static void main(String[] args) {
		
		String ApptDate=futureDateAppt(15,"MMMM/dd/YYYY");
		System.out.println(ApptDate+":: is main apptdate");
	}
	public static String futureDateAppt(int noofdays, String pattern)  {
		Calendar cal =  Calendar.getInstance(); //Calendar is abstract class and getInstance is static method.hence cannot create object(no new keyword)
		cal.add(Calendar.DAY_OF_MONTH,15); // cal is variable here, not object
		Date d = cal.getTime();
		System.out.println("date 15 days from now is ::"+d);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String fDate = sdf.format(d);
		System.out.println("date is ::"+fDate);
		return fDate;
	}

}
