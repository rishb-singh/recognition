package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import base.BaseClass;

public class Sheet extends BaseClass {
	

	@Test
	public void readingSheet() throws EncryptedDocumentException, IOException {
		String excelPath = "C:\\Users\\Rishabh Singh\\eclipse-workspace\\recognition\\Data\\Book1.xlsx";
		
		String value = WorkbookFactory.create(new FileInputStream(excelPath)).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		
		System.out.println(value);
	}
}
