package vtiger.Practice;

public class JavaUtilityDriver {

	public static void main(String[] args) throws Throwable {
	JavaUtility java = new JavaUtility();
	int number = java.getRandomNumber();
	System.out.println(number);
	
	
	 String date = java.getSystemDate();
	System.out.println(date);
	//one more way
	System.out.println(java.getSystemDate());
	
	
	//String date1 = java.getSystemDateInFormat();
	//System.out.println(date1);
	
	//one more way
	System.out.println(java.getSystemDateInFormat());
	
	
	//creating property object
	PropertyFileUtility pro = new PropertyFileUtility();
	String data = pro.getPropertValues("username");
	System.out.println(data);
	
	
	//creating excel object
	ExcelFileUtility exc = new ExcelFileUtility();
	String data1 = exc.getExcelValue("organization", 1,2);
	System.out.println(data1);
	//one more way
	System.out.println(exc.getExcelValue("organization", 3,2));
	
	
	  exc.setExcelValue("sheet3", 3,5,"yess");
	
	
	
	}

}
