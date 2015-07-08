package com.qait.kplus.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import junit.framework.Assert;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFileHandling {

	// for reading file input stream is used and make the file type as FIS
	// for writing file output stream
	
	public static Map TestDataList;
	
	public static void main(String [] args) throws IOException{	
		getCloumnName("C:\\Users\\vipinverma\\Desktop\\KplusTestData.xlsx","Internal_Medicine");
	}
	
	public static Workbook getWorkbookObject(String FileRef) throws IOException{
		String[] arrpath = FileRef.split("\\.");					// it is a regular expression therefore we use \\(it is used for treating it as normal character not a regular expression)
		String extension = arrpath[1];
		
		Workbook wbook = null;
		
		FileInputStream fis = new FileInputStream(FileRef);
		
		if (extension.equalsIgnoreCase("xlsx")){
			wbook = new XSSFWorkbook(fis);
			
		}else if(extension.equalsIgnoreCase("xls")){
			wbook = new HSSFWorkbook(fis);
		}
		
		return wbook;
	}	
	 
	
	public static void GetTestData(String FilePath, String SheetName, String DataTag) throws IOException{
		Map <String,String> TestDataList = new HashedMap();
		
		Workbook WbookObj = getWorkbookObject(FilePath);
		Sheet SheetObj = WbookObj.getSheet(SheetName);
		
		int rownum = SheetObj.getLastRowNum();		// No of last activated rows in the sheet
		int ReqRowNum = 0;
		
		for (int i=0; i<=rownum;i++){
			Row RowObj = SheetObj.getRow(i);
			Cell CellObj = RowObj.getCell(0);
			String xlDataTag = CellObj.getStringCellValue();
			
			if (xlDataTag.equalsIgnoreCase(DataTag)){
				ReqRowNum = i;
				break;
			}	
		}
			
		Row ReqRowObj = SheetObj.getRow(ReqRowNum);
		int cellnum = ReqRowObj.getLastCellNum();								// Last active cell number
		Map<String, String> rowValues=new HashMap<String, String>();
		for (int i=1;i<=cellnum-1;i++){											// Here it will use the indexing from 1
			Cell CellObj = ReqRowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
			String ReqCellValue = CellObj.getStringCellValue();
			rowValues.put("", ReqCellValue);
		}
		
		//return TestDataList;
	}

	
	public static void getCloumnName(String FilePath, String SheetName) throws IOException{
		
		Workbook WbookObj = getWorkbookObject(FilePath);
		Sheet SheetObj = WbookObj.getSheet(SheetName);
		Row rowObj = SheetObj.getRow(0);
		
		int CellNumber = rowObj.getLastCellNum();
		
		Set <String> colNames = new HashSet<String>(); 
		
		for (int i=0;i<=CellNumber;i++){
			try{
		Cell CellObj = rowObj.getCell(i,Row.CREATE_NULL_AS_BLANK);
				
		String ColValue = CellObj.getStringCellValue();
		System.out.println(ColValue);
		
		if(i!=0){
			colNames.add(ColValue);
		}
			}catch (Exception e){
			
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test  
	public static void Readingxlsx () throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\vipinverma\\Desktop\\KplusTestData.xlsx");
		XSSFWorkbook wbookobj = new XSSFWorkbook(fis); // creating object of Workbook
		XSSFSheet sheetobj = wbookobj.getSheet("Internal_Medicine"); // creating object of Sheet
		XSSFRow rowobj = sheetobj.getRow(1); // creating object of Row
		
		MissingCellPolicy MCPobj = XSSFRow.CREATE_NULL_AS_BLANK;
		
		XSSFCell cellobj = rowobj.getCell(1, MCPobj);
		
		String cellvalue = cellobj.getStringCellValue();
		
		System.out.println(cellvalue);
			
	}

	public static void SimpleReading() throws IOException{
		Workbook Wbookobj = getWorkbookObject("C:\\Users\\vipinverma\\Desktop\\KplusTestData.xlsx");
		Sheet sheetobj = Wbookobj.getSheet("Internal_Medicine");
		Row rowobj = sheetobj.getRow(1);
		
		MissingCellPolicy MCPobj = XSSFRow.CREATE_NULL_AS_BLANK;
		
		Cell cellobj = rowobj.getCell(1, MCPobj);
		
		String cellvalue = cellobj.getStringCellValue();
		System.out.println(cellvalue);
	}

	
	public static void test_method() throws IOException{
		Workbook WbookObj = getWorkbookObject("");
		Sheet SheetObj = WbookObj.getSheet("");
		
		int rowcount = SheetObj.getLastRowNum();
		int Reqrownumber = 0;
		for (int i=0; i<=rowcount;i++){
			Row RowObj = SheetObj.getRow(i);
			Cell CellObj = RowObj.getCell(0, RowObj.CREATE_NULL_AS_BLANK);
			String XlDataTag = CellObj.getStringCellValue();
		
			if (XlDataTag.equalsIgnoreCase("")){
				Reqrownumber = i;
				break;
			}
		}
			Row ReqrowObj = SheetObj.getRow(Reqrownumber);
			int cellnum = ReqrowObj.getLastCellNum();
			
			for (int i =0; i<=cellnum-1;i++){
				Cell CellObj = ReqrowObj.getCell(i, ReqrowObj.CREATE_NULL_AS_BLANK);
				String ReqCellValue = CellObj.getStringCellValue();
				System.out.println(ReqCellValue);
			}			
		}
		
	}


