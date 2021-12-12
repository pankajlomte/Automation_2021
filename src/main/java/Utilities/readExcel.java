package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import Base.BaseClass;

public class readExcel extends BaseClass{
	
	public static FileInputStream fis;
	public static Workbook workbook;
	public static Sheet sheet; 
	public static Row row;
	public static Cell cell;
	public static CellStyle cellstyle;
	
	
	public static String filePath;
	public static String userName;
	public static String passWord;
	public static String firstName;
	public static String lastName;
	public static String userRole;
	
	public static String [] [] data ;
	
	public static void getTestData() throws FileNotFoundException{
		
		filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\Automation_Sample.xlsx";
		
		File file = new File(filePath);
		
		fis = new FileInputStream(file);
		
		System.out.println("fis------ "+fis);
		
		try {
			
			workbook = WorkbookFactory.create(fis);
			
	//Factory for creating the appropriate kind of Workbook(be it HSSFWorkbook or XSSFWorkbook),by auto-detecting from the supplied input.
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator <Sheet> sh = workbook.sheetIterator();
		//Returns an iterator of the sheets in the workbook in sheet order. Includes hidden and very hidden sheets.
		
		while(sh.hasNext()) {
			
			sheet = sh.next();
			
			System.out.println("Sheet name is -------"+sheet.getSheetName());
			
			Iterator <Row> r = sheet.rowIterator();//Returns an iterator of the physical rows
			
			while (r.hasNext()) {
				
				row = r.next();
				
				Iterator<Cell> c = row.cellIterator();//Cell iterator of the physically defined cells.
				
				while (c.hasNext()) {
					
					cell = c.next();
					
					System.out.println();
					
					if (cell.getColumnIndex()==0) {
						userName  = cell.getStringCellValue();
						
						System.out.println("Username is --------> "+userName);
						
					}
					else if(cell.getColumnIndex()==1) {
						passWord = cell.getStringCellValue();
						
						System.out.println("Password is --------> "+passWord);
					}
					
					else if (cell.getColumnIndex()==2) {
						firstName = cell.getStringCellValue();
						
						System.out.println("First name is --------> "+firstName);
					}
					else if (cell.getColumnIndex()==3) {
						lastName=cell.getStringCellValue();
						
						System.out.println("Last name is --------> "+lastName);
					}
					else if (cell.getColumnIndex()==4) {
						userRole = cell.getStringCellValue();
						
						System.out.println("User Role is --------> "+userRole);
					}
		
				}
					
				}
			

		}
		
		
					
		}
}


			
	
			
			
			
