package org.liveproject.com.SeleniumTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadNWrite {

	
	public static void main(String args[]) throws IOException {
		
		String filepath = "C:\\Persistent_Share\\ABC.xlsx";
		//ArrayList<String> fileData = readExcel(filepath);
		writeIntoExcel(filepath);

	}
/*
	public static ArrayList<String> readExcel(String filepath) throws IOException{
		
		ArrayList<String> arr = new ArrayList<String>();
		XSSFRow row;
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int noOfRows = sheet.getLastRowNum();
		//System.out.println(No of Rows  = noOfRows);
		
		for (int i=1; i <=noOfRows; i++){
			
			int col = sheet.getRow(0).getLastCellNum();
			
			row = sheet.getRow(i);
			
			for(int j=0 ; j<col ; j++) {
				
				XSSFCell cellVal = row.getCell(j);
				
				switch (cellVal.getCellType()) {
				
	                case Cell.CELL_TYPE_STRING:
	                    System.out.println(cellVal.getStringCellValue());
	                    arr.add(cellVal.toString());
	                    break;
	                case Cell.CELL_TYPE_NUMERIC:
	                	DataFormatter formatter = new DataFormatter();
	                	String val = formatter.formatCellValue(cellVal);
	                    System.out.println(val);
	                    arr.add(val);             
	                    break;
	                case Cell.CELL_TYPE_BOOLEAN:
	                    System.out.println(cellVal.getBooleanCellValue());
	                    arr.add(cellVal.toString());
	                    break;
	                case Cell.CELL_TYPE_FORMULA:
	                    System.out.println(cellVal.getCellFormula());
	                    arr.add(cellVal.toString());
	                    break;
	                default:
				}
				
			}
			workbook.close();					
		}
		return arr;	
}
*/
	
	public static void writeIntoExcel(String filepath) throws IOException{
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		String colName = "Result";
		sheet.getRow(0).createCell(4).setCellValue(colName);
		
		
		FileOutputStream os = new FileOutputStream(filepath);
		workbook.write(os);
		workbook.close();
	}

}
