package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateandTimeUtils {

	public DateandTimeUtils() {
		
	}
	
	public String regexForDateAndTimeFormat="\\[[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}\\+[0-9]{4}]";
	
	public static String getTodaysDate(){
    	String pattern = "MM/dd/yyyy";
    	String dateInString =new SimpleDateFormat(pattern).format(new Date());
    	String replaceLeadZeros= "^0+(?!$)";
    	dateInString=dateInString.replaceAll(replaceLeadZeros, "");
    	return dateInString ;
    	}

	public static String addFiveDaysToCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 5);
		String addDays = dateFormat.format(c.getTime());
		String replaceLeadZeros= "^0+(?!$)";
		addDays=addDays.replaceAll(replaceLeadZeros, "");
		return addDays;

	}
	/**
	 * @Name: validateDateFormat
	 * @Description: returns true if the date extracted matches the regex format of the date and time
	 * @param: String date extracted
	 * @return: boolean
	 */
	public boolean validateDateFormat(String date) {
		boolean visible = false;
		if (date.matches(regexForDateAndTimeFormat)) {
			visible = true;
		}
		return visible;
	}
}
