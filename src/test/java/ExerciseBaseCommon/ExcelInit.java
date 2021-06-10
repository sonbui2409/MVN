package ExerciseBaseCommon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInit {

	// read data

	public String RDataAtCell(String filename, String sheetname, int iCol, int iRow) {
		String data = "";
		Workbook wb = null;
		try {
			File file = new File(filename); // locate to file excel
			FileInputStream inputStream;
			inputStream = new FileInputStream(file); // changing file excel to read it

			String fileExtensionName = filename.substring(filename.indexOf("."));
			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
				wb = new HSSFWorkbook(inputStream);
			}

			Sheet sh = wb.getSheet(sheetname); // get sheetname that need to read
			Row rw = sh.getRow(iRow); // get row that need to read
			Cell cellData = rw.getCell(iCol); // get column that need to read

			try {
				data = cellData.getStringCellValue(); // return all data as String
			} catch (Exception e) {
				// TODO: handle exception
				data = "";
			}
			inputStream.close();
			wb.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static Workbook newWorkbook(String filename) {
		Workbook wb = null;
		try {
			File file = new File(filename);
			FileInputStream inputStream;
			inputStream = new FileInputStream(file);

			String fileExtensionName = filename.substring(filename.indexOf("."));
			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
				wb = new HSSFWorkbook(inputStream);
			}
			inputStream.close();
			wb.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public  void writeDataAtCell(String filePath, String fileName, String sheetName, int iRow, int iColumn,String data) {
		Workbook wb = null;

		try {
			File file = new File(filePath + "//" + fileName);
			FileInputStream inputStream;
			inputStream = new FileInputStream(file);
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
				wb = new HSSFWorkbook(inputStream);
			}

			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(iRow);

			Cell cell = row.createCell(iColumn, CellType.STRING);
			cell.setCellValue(data);

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(file);
			wb.write(outputStream);
			wb.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public  ArrayList<String> readExcelFileAtColumn(String filename, String sheetName,int column) {
		ArrayList<String> columnData = new ArrayList<String>();
		try {
			Workbook wb = newWorkbook(filename);
			Sheet sheet = wb.getSheet(sheetName);

			// lay khoang row co data
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum(); //
			for (int i = 0; i < rowCount + 1; i++) {
				try {
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(column);
					cell.setCellType(CellType.STRING);// st default la string
					columnData.add(cell.getStringCellValue());
				} catch (Exception e) {
					// if row(i) = null / empty
					columnData.add("");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cannot read data at column:" + column);
		}

		return columnData;
	}

	public  ArrayList<String> readExcelFileAtRow(String filename, String sheetName, int row,int startColumn, int endColumn) {
		ArrayList<String> rowData = new ArrayList<String>();
		try {
			Workbook wb = newWorkbook(filename);
			Sheet sheet = wb.getSheet(sheetName);
			Row rowExcel = null;
			rowExcel = sheet.getRow(row);
			for (int i = startColumn; i <= endColumn; i++) {
				try {
					Cell cell = rowExcel.getCell(i);
					cell.setCellType(CellType.STRING);
					rowData.add(cell.getStringCellValue());
				} catch (Exception e) {
					// if row(i) = null / empty
					rowData.add("");
				}
			}
		} catch (Exception e) {
			System.out.println("Cannot read data at row:" + row);
		}
		return rowData;
	}

	public  String getDataAtCell(String filename, String sheetName, int row, int column) {
		String CellData = "";
		try {
			Workbook wb = newWorkbook(filename);
			Sheet sheet = wb.getSheet(sheetName);
			Row rowExcel = sheet.getRow(row);
			Cell cell = rowExcel.getCell(column);
			cell.setCellType(CellType.STRING);
			CellData = cell.getStringCellValue();
		} catch (Exception e) {
			CellData = "";
		}
		return CellData;
	}
}
