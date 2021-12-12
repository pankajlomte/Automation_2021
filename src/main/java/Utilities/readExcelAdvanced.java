package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readExcelAdvanced {
	
	//Declare required variables for File at class level - Workbook,Sheet,Cell
	
	public static File file;
	public static FileInputStream fis;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	
	public static Map<String,Integer> columns = new HashMap<String,Integer>();
	

	
	public static void setExcelfile(String ExcelPath,String SheetName) {
		
		//Create new file instance
		
		file = new File(ExcelPath);
		
		try {
			//Take input bytes from file in file system 			
			fis = new FileInputStream(file);
			
			//Creates the appropriate HSSFWorkbook / XSSFWorkbook from the given InputStream. 
			workbook = WorkbookFactory.create(fis);
			//Get the sheet
			sheet = workbook.getSheet(SheetName);
			
			//Now Add all the Column Headers in Map "columns"
			sheet.getRow(0).forEach(cell ->{
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});	
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Now create a method which takes rownumber and columnnumber to take data
	
	public static String getData(String columnName,int rownum) {
		
		int columnIndex = columns.get(columnName);
		
		cell = sheet.getRow(rownum).getCell(columnIndex);
		
		String cellData=null;
		
		switch (cell.getCellType()) {
			
			case STRING:
				cellData = cell.getStringCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					cellData= String.valueOf(cell.getDateCellValue());
				}
				else
					cellData=String.valueOf((long)cell.getNumericCellValue());
					break;	
			case BOOLEAN:
					cellData=Boolean.toString(cell.getBooleanCellValue());
					break;
			case BLANK:
					cellData="";
					break;
		}
		return cellData;
	}
	//Now create a method which takes column name and rownumber
/*	public static String getCellData(String columnName,int rownum) {
		return getData(rownum, columns.get(columnName));
	}*/
}