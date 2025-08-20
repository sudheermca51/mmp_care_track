package org.iitwf.healthcare.mmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//ctrl+shift+o

public class ExcelUtils {
	
	public static void main(String[] args) throws IOException {
		
		HashMap<String,Double> output = getDataFromXLSX("stockgainers.xlsx");
		System.out.println(output);
	}
	public static String[][] getDataFromXLSXfromDP(String fileName)  throws IOException  
	{
		String[][] inputArr = null;
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		inputArr= new String[rowCount][colCount];
		
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++)
			{
					XSSFRow row = sheet.getRow(rowIndex);//fixing the row index
					for(int colIndex=0;colIndex<colCount;colIndex++)
					{
						Cell cell = row.getCell(colIndex);
						inputArr[rowIndex][colIndex]=cell.getStringCellValue();
					}
			}
		
		return inputArr;
		
	}
	{
		
		
		
		
	}
	//Right click on the column->format cell->Select Number (2 decimal points)
	//Post that, add the data in the second column
	public static HashMap<String,Double> getDataFromXLSX(String fileName) throws IOException  
	{
		HashMap<String,Double> hmap= new HashMap<String,Double>();
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		
			for(int rowIndex=0;rowIndex<rowCount;rowIndex++)
			{
					 
					XSSFRow row = sheet.getRow(rowIndex);//fixing the row index
					Cell keyCell=	  row.getCell(0);//fetch the first column - stockName
					Cell KeyValue =  row.getCell(1);//fetch the second column - stockprice
				    String key=      keyCell.getStringCellValue();
					Double value=    KeyValue.getNumericCellValue();
					hmap.put(key,value);
			}
		
		return hmap;
		
	}
}
