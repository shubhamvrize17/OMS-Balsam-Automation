package utils;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import com.google.common.base.CharMatcher;

public class JavaUtils extends BaseUtils{

	public JavaUtils(){}

	@SuppressWarnings("deprecation")
	FileUtils fileUtil= new FileUtils();

	public String regexForDigit="^[0-9]";

	public 	String regexForAlphanumeric="^[a-zA-Z0-9_].*$";
	public String regexForImageUrls="(https:\\/\\/www.)[a-z]+\\.+[a-z]+\\/\\w+\\/[a-z | 0-9{2}]+\\/[0-9 | $a-z0-9]+\\/[0-9|0-9_A-Z_A-Za-z_0-9]+[\\/ |\\.]+[$a-z0-9 |(jpg|mp4) |\\/0-9_A-Z_A-Za-z_0-9\\.(jpg|mp4)]+";
	public String regexForFileType="[a-zA-Z]*/(jpeg|jpg)$";	
	public String regexForImage="[^.*$]||(.*?).(jpg).*$";
	public String regexForAlphanumercWithExtension="^[a-zA-Z0-9_\\s]*|^[a-zA-Z0-9_\\s]*.(jpg|jpeg)";


	//DateFormat
	DateFormat datetime = new SimpleDateFormat("MMM d, yy hh:mm:ss a");//MMM d, yy hh:mm:ss a
	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

	public String regexForDateAndTimeFormat="\\[[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}\\+[0-9]{4}]";

	public String regexForStrings="[\\a-zA-Z0-9_].*$";
	public String regexForDecimalValue="[^0-9.0-9].*$";

	//To select date from calendar
	private final By chooseMonthYearButton = By.xpath("//button[contains(@aria-label,'Choose month and year')]");
	private final String chooseYearMonthAndDay = ("//table[contains(@class,'calendar')]//td//div[contains(text(),'%s')]");


	public static  String getLastWord(String text){
		String lastWord = text.substring(text.lastIndexOf(" ")+1);
		return lastWord;
	}


	/**
	 * Name of the method: getRandomString
	 * Description: Method to generate a random string with Alphanumeric characters
	 * Parameters:Length of the string
	 */
	public static String getRandomString(int stringLength) {
		String randomString="ABCDabcd1234567890";
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i <stringLength; i++) {
			int randIndex=rand.nextInt(randomString.length()); 
			res.append(randomString.charAt(randIndex));
		}
		return res.toString();
	}
	

	/**
	 * Name of the method:getRandomNameWithPrefix
	 * Description: Method to generate a random string with desired prefix string
	 * Parameters: Desired prefix string and string length
	 */
	public static String getRandomNameWithPrefix(String prefix,int stringLength) {
		String stringPrefix=prefix+getRandomString(stringLength);
		return stringPrefix;
	}

	/**
	 * Name of the method:getRandomNameWithSuffix
	 * Description: Method to generate a random string with desired suffix string
	 * Parameters: Desired suffix string and string length
	 */
	public static String getRandomNameWithSuffix(String suffix,int stringLength) {
		String stringSuffix=getRandomString(stringLength)+suffix;
		return stringSuffix;
	}



	/**
	 * Name of the method: convertStringToFloat
	 * Description: Method to convert String value to float
	 * Parameters: String value to be converted
	 */
	public float convertStringToFloat(String value) {
		float floatValue=Float.parseFloat(value);
		return floatValue;
	}


	/**
	 * Name of the method: convertStringToInt
	 * Description: Method to convert String value to integer
	 * Parameters: String value to be converted
	 */
	public int convertStringToInt(String value) {
		int intValue=Integer.parseInt(value);
		return intValue;
	}

	/**
	 * Name of the method: convertIntToString
	 * Description: Method to convert Integer Value to String
	 * Parameters: Integer value to be converted
	 */
	public String convertIntToString(int value) {
		String stringValue=String.valueOf(value);  
		return stringValue;
	}

	/**
	 * Name of the method: convertFloatToString
	 * Description: Method to convert float Value to String
	 * Parameters: float value to be converted
	 */
	public String convertFloatToString(float value) {
		String stringValue=String.valueOf(value);  
		return stringValue;
	}

	/**
	 * Name of the method: extractIntegerFromString
	 * Description: Method to extract int from string
	 * Author: Darshan
	 * Parameters: string value
	 */
	public static String extractIntegerFromString(String value) {
		String number = CharMatcher.digit().retainFrom(value);
		return number;
	}

	/**
	 * Name of the method: getSubstring
	 * Description: Method to get the substring of a String from desired start Index
	 * Parameters: Main string, starting index
	 */
	public String getSubstring(String stringValue,int indexValue) {
		String substring = stringValue.substring(indexValue);
		return substring;
	}

	/**
	 * Name of the method: getSubstring
	 * Description: Method to get the substring of a String from desired start Index
	 * Parameters: Main string, starting index, ending index
	 */
	public String getSubstring(String stringValue,int startIndex, int endIndex) {
		String substring = stringValue.substring(startIndex,endIndex);
		return substring;
	}

	

	/**
	 * Name of the method: validateUniqueValuesBetweenMaps
	 * Description: Method to compare every item from one map to another map
	 * Parameters: firstMap, secondMap
	 */
	public boolean validateUniqueValuesBetweenMaps(Map<String, String> firstMap, Map<String, String> secondMap) {
		for (Map.Entry<String, String> item : secondMap.entrySet()) {
			String secondMapKey = item.getKey();
			if (firstMap.containsKey(secondMapKey)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @MethodName: sortMapByValueDescending
	 * @Description: Sorting a map by values Descending
	 * @Parameters: NA
	 * @ToDo: NA
	 */ 	

	public  LinkedHashMap sortMapByValueDescending(Map<String, Double> productPrice){
		Map<String, Double>sortedMapInDescendingOrder = productPrice
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
		return (LinkedHashMap) sortedMapInDescendingOrder;
	}

	/**
	 * @MethodName: sortMapByValueAscending
	 * @Description: Sorting a map by values Ascending
	 * @Parameters: NA
	 * @ToDo: NA
	 */ 	

	public  LinkedHashMap sortMapByValueAscending(Map<String, Double> productPrice){

		Map<String, Double>sortedMapAscending = productPrice
				.entrySet().stream().sorted(comparingByValue())
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
		return (LinkedHashMap) sortedMapAscending;
	}

	/**
	 * @MethodName: sortMapByStringValueAscending
	 * @Description: Sorting a map by string values Ascending
	 * @Parameters: NA
	 * @ToDo: NA
	 */ 	

	public HashMap<String, String> sortMapByStringValueAscending(HashMap<String, String> productTitles){
		HashMap<String, String> temp = productTitles.entrySet().stream().sorted((i1, i2)-> i1.getValue().compareTo(i2.getValue()))
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));
		return temp;
	}

	/**
	 * Name of the method: convertListsToMapKeyValue
	 * Description: converting two list into 1 Map Key and Value 
	 * Parameters: NA
	 * To do: NA
	 */
	public static LinkedHashMap<String,Double> convertListsToMapKeyValue (List<String> keys, List<Double> values) {     
		if (keys.size() != values.size())         
			throw new IllegalArgumentException ("Cannot combine lists with dissimilar sizes");    
		LinkedHashMap<String,Double> map = new LinkedHashMap<String,Double>();    
		for (int i=0; i<keys.size(); i++) {         
			map.put(keys.get(i), values.get(i));     
		}     
		return map; 
	}	

	/**
	 * Name of the method: convertDateformat
	 * Description: To convert the date format dd/mm/yyyy
	 * Parameters: NA
	 * To do: NA
	 */
	public String convertDateformat(String dateString) {
		Date date = null;
		try {
			date = (Date) datetime.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String convertedDate = dateformat.format(date);
		return convertedDate;
	}


	/**
	 * Name of the method: validateLastCharacterOfStringIsNumber
	 * Description: To validate last character of string is Number
	 * Parameters: NA
	 * To do: NA
	 */
	public  boolean validateLastCharacterOfStringIsNumber(String s){
		char c = s.charAt(s.length() - 1); 
		return Character.isDigit(c);
	}

	/**
	 * Name of the method: convertStringToBoolean
	 * Description: Method to convert String value to boolean
	 * Parameters: String value to be converted
	 */
	public boolean convertStringToBoolean(String value) {
		boolean booleanValue=Boolean.parseBoolean(value);
		return booleanValue;
	}
	
	
	/**
	 * Name of the method: getRandomNumber
	 * Description: Method to generate a random string with Numeric characters
	 * Parameters:Length of the string
	 */
	public static String getRandomNumber(int stringLength) {
		String randomString="1234567890";
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i <stringLength; i++) {
			int randIndex=rand.nextInt(randomString.length()); 
			res.append(randomString.charAt(randIndex));
		}
		return res.toString();
	}
	
	/**
	 * Name of the method: getRandomAlphabeticalString
	 * Description: Method to generate a random Alphabetical string 
	 * Parameters:Length of the string
	 */
	public static String getRandomAlphabeticalString(int stringLength) {
		String randomString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rand=new Random();
		StringBuilder res=new StringBuilder();
		for (int i = 0; i <stringLength; i++) {
			int randIndex=rand.nextInt(randomString.length()); 
			res.append(randomString.charAt(randIndex));
		}
		return res.toString();
	}
	
	/**
	 * Name of the method: roundingOfFloatDecimalValue
	 * Description: Method to round off the decimal values in float
	 * Parameters: Passing the float value as parameter
	 * To do: NA
	 */
	public float roundingOfFloatDecimalValue(float value) {
		String formattedValue = String.format("%.2f", value);
		float convertedFloatValue =convertStringToFloat(formattedValue);
		return convertedFloatValue;
	}
	
	/**
	 * Name of the method: removeCurrencySymbolFromPrice
	 * Description: Method to remove currency symbol from price
	 * Parameters: Passing the float value as parameter
	 * To do: NA
	 */
	public float removeCurrencySymbolFromPrice(String value) {
	float	 priceFloat = Float.parseFloat(value.replaceAll("[^0-9.]", ""));

		return priceFloat;
	}
	
	

	/**
	 * Name of the method: getSubStringFromTwoStrings
	 * Description: To get a string value in between 2 Strings
	 * Parameters: Passing text,intialString, lastString
	 * To do: NA
	 */
	public String getSubStringFromTwoStrings(String text, String intialString, String lastString) {
		String expectedText = StringUtils.substringBetween(text, intialString, lastString);
        return expectedText;
	}
}
