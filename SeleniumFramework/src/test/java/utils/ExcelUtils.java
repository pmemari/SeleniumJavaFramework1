package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName) {
		try {
			this.workbook = new XSSFWorkbook(excelPath);
			this.sheet = workbook.getSheet(sheetName);
		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	
	public int getColCount() {
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		return colCount;
	}
	
	
	public String getCellDataString(int rownum, int colnum) {
		String cellData = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		return cellData;
	}
	
	public double getCellDataNumber(int rownum, int colnum) {
		double cellData = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
		return cellData;
	}

}
