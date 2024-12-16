package Practice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rescode {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		List<WebElement> links=driver.findElements(By.cssSelector(".gf-t a"));
		System.out.println(links.size());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\SS\\Scrn.png"));
		for(WebElement i:links) {
			String url=i.getAttribute("href");
//			System.out.println(url);
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			System.out.println(url+" "+conn.getResponseCode());
		}

	}

}
