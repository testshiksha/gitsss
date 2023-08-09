package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String getExcelValue(String sheet,int row,int cell) throws Throwable {
		
		FileInputStream fes = new FileInputStream(".\\src\\test\\resources\\testdata1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fes);
		Sheet sh = wb.getSheet(sheet);
		Row rw = sh.getRow(row);
		String data = rw.getCell(cell).getStringCellValue();
		return data;
		
	}
	
	public void setExcelValue(String sheet, int row, int cell, String value) throws Throwable {
		
	FileInputStream fes = new FileInputStream(IConstants.Excelfilepath);	
	Workbook wb = WorkbookFactory.create(fes);	
		Sheet sh = wb.createSheet(sheet);
		Row rw = sh.createRow(row);
		    rw.createCell(cell).setCellValue(value);
		    
		 FileOutputStream fis = new  FileOutputStream(IConstants.Excelfilepath);
		wb.write(fis);
		 wb.close();
	}
	
	/**
	 * this method will read all the data inside the sheet of excel file to used in data provider
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String sheet) throws Throwable 
	{
	FileInputStream fis= new FileInputStream(IConstants.Excelfilepath);
			Workbook book = WorkbookFactory.create(fis);
			Sheet sh = book.getSheet(sheet);
			int lastrow = sh.getLastRowNum();
			short lastcell = sh.getRow(0).getLastCellNum();
			
			Object[][] data= new Object[lastrow][lastcell];
			
			for(int i=0;i<lastrow;i++)
			{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			}
			return data;

}
}