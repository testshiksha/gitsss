package Practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class will provide implementation for IRetryAnalysar Interface
 * @author Lenovo
 *
 */
public class RetryAnalayeserImplementation implements IRetryAnalyzer{

	int count = 0;
	int recount = 3;
	
	public boolean retry(ITestResult result) {
		while(count<=recount)//0<=3--1<=3--2<=3	---3<=3	
			{
			count++;//1--2--3--4
			return true;//retry1--2---3--4
		}
		
		
		// TODO Auto-generated method stub
		return false;
	}
	

}
