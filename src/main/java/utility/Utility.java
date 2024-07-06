package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class Utility extends BaseClass {

	public static String readingDataFromSheet(int row, int cell) throws EncryptedDocumentException, IOException {
		String excelPath = "C:\\Users\\Rishabh Singh\\eclipse-workspace\\recognition\\Data\\Book1.xlsx";

		String value = WorkbookFactory.create(new FileInputStream(excelPath)).getSheet("Sheet1").getRow(row - 1)
				.getCell(cell - 1).getStringCellValue();
		return value;
	}

	public static void selectDropdown(String frequency, By loctator) {

		List<WebElement> list = driver.findElements(loctator);
		for (WebElement ele : list) {
			if (ele.getText().equalsIgnoreCase(frequency))
				ele.click();
		}
	}

	public static WebElement  waitForElementToBeClickable(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
