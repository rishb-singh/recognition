
package base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	
	@BeforeTest
	public void loadConfig() {
		 prop = new Properties();
		 try {
			prop.load(new FileInputStream("C:\\Users\\Rishabh Singh\\eclipse-workspace\\recognition\\Config\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void setup() {
	launchApp();	
	// Duration duration = Duration.ofSeconds(10); // Example: Wait for 10 seconds
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void launchApp() {
		loadConfig();
		
		
		System.out.println(prop.getProperty("Browser"));
		if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		else if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            
        } else if (prop.getProperty("Browser").equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            
        } else {
            System.out.println("Browser not supported or specified in config.");
        }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
}
