package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException {
	//step1: load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx"); 
		
		//step2 :create a workbook for file loaded
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: create sheet
		 Sheet sh = wb.getSheet("Sheet1");
		 
		 //step4: create row
		 Row rw = sh.getRow(1);
		 
		 //step5: create cell
		Cell cl = rw.getCell(1);
		
		
		//step6: get the value from cell
		String data = cl.getStringCellValue();
		 
		 System.out.println(data);
		 
		//one more way to get data from excel, basically it is short form
		String data1 = rw.getCell(2).getStringCellValue();
		 System.out.println(data1);
		 
		 

	}

}
