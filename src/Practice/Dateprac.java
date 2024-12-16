package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dateprac {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		String day="6";
		String mon="6";
		String year="2027";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.className("react-date-picker__inputGroup__year")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText"))	.click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText"))	.click();
//		driver.findElement(By.xpath("//button[text()="+year+"]")).click();
//		driver.findElement(By.xpath("button[text()="+year+"]")).click();)
		List<WebElement> years=driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year"));
		System.out.println(driver.findElements(By.cssSelector(".react-calendar__decade-view__years__year")).size());
		for(WebElement i:years) {
			if(i.getText().equalsIgnoreCase(year)) {
				i.click();
			}
			
		}
		Thread.sleep(2000);
//		#root > div > div.date-field-container > div > span > div > div > div.react-calendar__viewContainer > div > div > button:nth-child(1)
//		System.out.println(driver.findElements(By.cssSelector("button[class='react-calendar__tile react-calendar__year-view__months__month']")).size());
		
//		System.out.println(driver.findElements(By.cssSelector(".react-calendar__tile")).size());
//		driver.findElements(By.cssSelector("react-calendar__year-view__months__month")).get(Integer.valueOf(mon)-1).click();
//		driver.findElement(By.cssSelector("button[text()="+day+"]")).click();

	}

}
