package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String readingDataFromSheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		String excelPath = "C:\\Users\\Rishabh Singh\\eclipse-workspace\\recognition\\Data\\Book1.xlsx";
		
		String value = WorkbookFactory.create(new FileInputStream(excelPath)).getSheet(sheet).getRow(row-1).getCell(cell-1).getStringCellValue();
		
		return value;
	}

}
