package com.uiAutomation.Flipkart.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {
	
	String path;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow rows;
	XSSFCell cell;
	
	
	public Excel_reader(String path) throws IOException{
		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook =  new XSSFWorkbook(fis);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public String[][] getExceldata(String Sheetname, String excelName){
		String dataSet[][] = null;
		try{
		sheet = workbook.getSheet(Sheetname);
		int total_row = sheet.getLastRowNum()+1;
		int total_col = sheet.getRow(0).getLastCellNum();
		dataSet = new String[total_row-1][total_col];
		
		for(int i=1;i<total_row;i++){
			rows=sheet.getRow(i);
			for(int j=0;j<total_col;j++){
				cell=rows.getCell(j);
				if(cell.getCellType() == Cell.CELL_TYPE_STRING){
					dataSet[i-1][j]=cell.getStringCellValue();
				}
				else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					String cellText =String.valueOf(cell.getNumericCellValue());
					dataSet[i - 1][j] = cellText;
				}
				else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN){
					dataSet[i - 1][j]=String.valueOf(cell.getBooleanCellValue());
				}
				
			}
		}
		return dataSet;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dataSet;
	}
		
}
	


