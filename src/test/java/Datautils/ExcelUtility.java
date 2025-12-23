package Datautils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Object[][] sendDatafromExcel(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Workbook wb = new XSSFWorkbook(file);
		Sheet sheet = wb.getSheet(sheetName);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rowCount-1][columnCount];
		
		for(int i=1; i<rowCount; i++) {
			Row row = sheet.getRow(i);
			for(int j=0; j<columnCount; j++) {
				data[i-1][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		file.close();
		return data;
	}
}
