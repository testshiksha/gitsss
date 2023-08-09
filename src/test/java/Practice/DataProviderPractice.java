package Practice;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test (dataProvider="getData")
	public void  addToCartTest(String name, int price,String model )
	{
		System.out.println("phone name is "+ name+", price is "+price+"and model no is "+model);
	}
	@DataProvider 
	public Object[][] getData()
	{
		Object[][] data= new Object[3][3];
		 data[0][0]="iphone";
		 data[0][1]=20000;
		 data[0][2]="5034";
		 
		 
		 data[1][0]="samsung";
		 data[1][1]=23000;
		 data[1][2]="53454";
		 
		 
		 data[2][0]="vivo";
		 data[2][1]=10000;
		 data[2][2]="503434";
		 
		 return data;
	}

}
