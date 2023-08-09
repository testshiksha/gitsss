package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractic {
	@Test //(retryAnalyzer = vtiger.Practice.RetryAnalayeserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("hi");
	}

}
