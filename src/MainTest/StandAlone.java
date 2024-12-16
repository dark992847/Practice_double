package MainTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import AbstractComp.AbstractComponents;
import AbstractComp.Basicdetails;
import ObjectTests.LandingPage;
import ObjectTests.ProductCatalogue;

public class StandAlone extends Basicdetails{
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
//		DesiredCapabilities caps=new DesiredCapabilities();
//		caps.setBrowserName("Chrome");
		
		ChromeOptions options=new ChromeOptions();
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\PropFiles\\Base.properties");
		prop.load(fis);
		String browser= System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
				prop.getProperty("browser");
		if(browser.equals("chrome")) {
			options.addArguments("headless");
			driver=new ChromeDriver(options);
		}
//		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.127:4444"),caps);
//		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		initDriver();
		String item="ZARA COAT 3";
		String item2="IPHONE 13 PRO";
		String URL="https://rahulshettyacademy.com/client";
		LandingPage landPage=new LandingPage(driver);
		landPage.goTo(URL);
		ProductCatalogue prodCat=landPage.logIn("anshika@gmail.com", "Iamking@000");
		prodCat=new ProductCatalogue(driver);
		prodCat.getProducts();
		prodCat.addProduct(item);
		prodCat.addProduct(item2);
		prodCat.viewCart();
		Thread.sleep(2000);
		
		List<WebElement> cartprods=driver.findElements(By.cssSelector(".itemNumber"));
		for(WebElement c:cartprods) {
			System.out.println("Reference id:- "+c.getText());
		}
		
        driver.findElement(By.cssSelector(".cartSection h3")).getText();
        Thread.sleep(2000);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder*='Country']")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".ta-item span")).get(1).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());

	}

}
