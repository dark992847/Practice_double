package Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windw {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.cssSelector(".gf-t tbody tr"));
		
		WebElement ele1=ele.findElements(By.tagName("td")).get(0);
		List<WebElement> list=ele1.findElements(By.tagName("a"));
		System.out.println(list.size());
		String str=Keys.chord(Keys.CONTROL,Keys.ENTER);
		Actions a= new Actions(driver);
		for(int i=1;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			a.moveToElement(list.get(i)).keyDown(Keys.CONTROL).click().build().perform();
		}
		Set<String> set=driver.getWindowHandles();
		Iterator<String> str1=set.iterator();
		while(str1.hasNext()) {
			driver.switchTo().window(str1.next());
			System.out.println(driver.getTitle());
		}

	}

}
