package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice

{
	
	@Test
	public void sampleTest()
	{
		int a = 1;
		int b = 2;
		System.out.println("step 1");
		System.out.println("step 2");
		Assert.assertEquals(b, a);
		System.out.println("step 3");
		System.out.println("step 4");
		System.out.println("step 5");
	}
		@Test
		public void sampleTest1() {
			int a = 1;
			int b = 2;
			System.out.println("step 1");
			System.out.println("step 2");
		SoftAssert sa = new SoftAssert();	
			sa.assertEquals(false, true);//fail
			System.out.println("step 3");
			Assert.assertEquals(b, a);
			
			System.out.println("step 4");
			sa.assertTrue(false);
			System.out.println("step 1");
			System.out.println("Execution and validation completed");
			sa.assertAll();
			
		}
		
	}


