package Drivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileIO {

	/******* variables declaration *******/
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	Properties prop;
	public static String userDir = System.getProperty("user.dir");

	/******* Setting properties file for input *******/
	public Properties inputSetup() {
		File file = new File(userDir + "\\drivers\\config.properties");

		try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static void output(String[] prodname) throws Exception {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output");

		/******* iterating rows and printing the headphones with price *******/
		for (int i = 0; i < 15; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(prodname[i]);

		}

		sheet.autoSizeColumn(0);
		/******* Writing the output to Excel file using FileOutputStream *******/
		try {
			fos = new FileOutputStream("SubmenuDisplay.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void output1(String[] name, String[] price) {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("output1");
		for (int i = 0; i < 3; i++) {
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(name[i]);
			row.createCell(1).setCellValue(price[i]);
		}

		sheet.autoSizeColumn(0);
		
		/******* Writing the output to Excel file using FileOutputStream *******/
		try {
			fos = new FileOutputStream("BookshelvesDisplay.xlsx");
			workbook.write(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

