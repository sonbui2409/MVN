package ExerciseBaseCommon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelInit {
	
	//read data
	
	public String RDataAtCell(String filepath, String sheetname, int iCol, int iRow) {
		String data = "";
		Workbook wb = null;				
		try {				
			File file = new File(filepath);		//locate to file excel	
			FileInputStream inputStream;			
			inputStream = new FileInputStream(file);			//changing file excel to read it
						
			String fileExtensionName = filepath.substring(filepath.indexOf("."));			
			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {			
				wb = new XSSFWorkbook(inputStream);		
			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {			
				wb = new HSSFWorkbook(inputStream);		
			}	
			
			Sheet sh = wb.getSheet(sheetname); //get sheetname that need to read
			Row rw = sh.getRow(iRow); //get row that need to read
			Cell cellData = rw.getCell(iCol); // get column that need to read
			
			try {
				data = cellData.getStringCellValue(); //return all data as String
			} catch (Exception e) {
				// TODO: handle exception
				data = "";
			}
			
			
		} catch (FileNotFoundException e) {				
			e.printStackTrace();			
		} catch (IOException e) {				
			e.printStackTrace();			
		}				
		return data;				
						
		
		
	}
	
	
	
	
	
	
	
	
	//write data
	
	

}
