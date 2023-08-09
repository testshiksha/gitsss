package vtiger.Practice;

import java.util.Date;
import java.util.Random;
/**
 * this class consist all generic method related to java
 * @return
 */
public class JavaUtility {
	/**
	 * this method is for getting random number related to all java program
	 * @return random number
	 */
	
	
	public int getRandomNumber()
	{
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;
	}
	/**
	 * this method will generate the system date in specific format
	 * @return date
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
		
		
	}
	
	public String getSystemDateInFormat() {
	
	Date d1 = new Date();	
		 String[] date = d1.toString().split(" ");
		String currentdate = date[2];
		String month = date[1];
		String year = date[5];
		String time = date[3].replace(":", "-");
		String dateInFormat = currentdate+" "+month+" "+year+" "+time;
		return dateInFormat;
		
	}
}
