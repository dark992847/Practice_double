package AbstractComp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectTests.LandingPage;

public class Basicdetails {

	
	public static void initDriver() throws IOException {
//		Properties prop= new Properties();
//		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\PropFiles\\Base.properties");
//		prop.load(fis);
//		String browser=prop.getProperty("browser");
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\PropFiles\\Base.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
		System.out.println("Phalana");
		}
		
	}
	
	
	
}
