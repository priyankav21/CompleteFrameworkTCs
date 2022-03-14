package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String excelPath, String sheetName)
	{
		try {
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		getRowCount();
		getCellData(1, 1);
	}
	
	public static void getCellData(int rowNum, int colNum)
	{
		
			
//			String projDir=System.getProperty("user.dir");
//			System.out.println(projDir);
//				
//			String excelPath = "./data/Testdata.xlsx";
//			
//				XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
//				XSSFSheet sheet = workbook.getSheet("Sheet1");
				
				DataFormatter formatter = new DataFormatter();
				Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
				
				
				//double value1 = sheet.getRow(1).getCell(2).getNumericCellValue();
				System.out.println(value);
				
		
	}
	
	
	public static void getRowCount()
	{
	
		
//		String projDir=System.getProperty("user.dir");
//		System.out.println(projDir);
			
//		String excelPath = "./data/Testdata.xlsx";
//		
//			XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
//			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows:"+rowcount);
			
	
		
	}
}
