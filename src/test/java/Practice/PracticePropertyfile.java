package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PracticePropertyfile {

	public static void main(String[] args) throws Throwable {
		//step1---load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.properties");
		
	//step2---create object of properties class from java.util
		Properties pro = new Properties();
		
		//step3--load the file into properties class
		pro.load(fis);
		
		//step4--provide the key and get value
		String URL = pro.getProperty("url");
		System.out.println(URL);

	}

}
