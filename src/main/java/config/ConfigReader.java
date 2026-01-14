package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigReader {
	
	public List<HashMap<Object, Object>> JsonToHashMap(String filePath) throws IOException {
		
		//Json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//String to HashMap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<Object, Object>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<Object, Object>>>() {
		});
		
		return data;
	}
	
	public Object[][] sendDatafromExcel(String filePath, String sheetName) throws IOException {
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
	
	public Properties loadProperties() throws IOException {
		Properties pro = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		pro.load(file);
		return pro;
	}
	

}
