package com.test1.work;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
@Test
public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	//constructor
	public ExcelDataProvider() {
		//represent file and directory pathname and manipulate file 
		File src=new File("./test-data/Data.xlsx");
		
		try {
			//convert file in raw data(extract input byte)
			FileInputStream fis= new FileInputStream(src);
			
			//to read data from excel(from sheet/row/column)
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file" +e.getMessage());
		}
	}
	//method Overloading
	public String getStringData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	public String getStringData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
}
	public double getNumericData(int sheetName, int row, int column) {
		return wb.getSheetAt(sheetName).getRow(row).getCell(column).getNumericCellValue();
}
}