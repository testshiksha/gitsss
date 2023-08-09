package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertIntoExcel {

	public static void main(String[] args) throws Throwable {
		//step1: load the file in java readable format
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx"); 
				
				//step2 :create a workbook for file loaded
				Workbook wb = WorkbookFactory.create(fis);
				
				//step 3: create sheet
				 Sheet sh = wb.createSheet("sheet3");
				 
				 //step4: create row
				 Row rw = sh.createRow(7);
				 
				 //step5: create cell
				Cell cl = rw.createCell(7);
				
				
				//step6: get the value from cell
				 cl.setCellValue("hello");
				 
				 
				 //step7:open the file in java format
				FileOutputStream fes = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
				
				//step 8: call the write method
				wb.write(fes);
				System.out.println("data added");
				
				
				 //step9: close the workbook
				wb.close();
				System.out.println("workbook closed");
				

			}

		}


	


