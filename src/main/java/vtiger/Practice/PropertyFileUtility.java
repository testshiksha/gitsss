package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * this method will provide all the information about property file
	 * @param key
	 * @return key value
	 * @throws Throwable
	 */
	
	public String getPropertValues(String key) throws Throwable
	{
		FileInputStream fes = new FileInputStream(".\\src\\test\\resources\\data.properties");
		Properties pro = new Properties();
		pro.load(fes);
		String value = pro.getProperty(key);
		return value;
		
	}

}
