package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import base.BaseClass;
import utility.Utility;

public class Sheet extends BaseClass {
	


	@Test
	public void checkSheet() throws EncryptedDocumentException, IOException {
		

		String value = Utility.readingDataFromSheet("Sheet1", 1 , 1);
		
		System.out.println(value);
	}
	

}
