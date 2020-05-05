package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx","Sheet1");
		System.out.println("Total number of rows : " + excel.getRowCount());
		System.out.println("Total number of columns : " + excel.getColCount());
		System.out.println(excel.getCellDataString(0, 0));
		System.out.println(excel.getCellDataNumber(1, 1));
	}

}
