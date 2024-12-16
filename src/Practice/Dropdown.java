package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		Thread.sleep(1000);
//		driver.findElements(By.cssSelector("#ctl00_mainContent_DropDownListCurrency options"));
		Select options= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		options.selectByVisibleText("USD");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		for(int i=0;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		
		Thread.sleep(1000);
		driver .findElement(By.id("btnclosepaxoption")).click();
//		driver.findElement(By.id("autosuggest")).sendKeys("india");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTNR a[value='AMD']")).click();
		List<WebElement> list=driver.findElements(By.cssSelector("div[class='dropdownDiv'] ul li"));
		System.out.println(list.size());
		for(WebElement ele:list) {
			if(ele.getText().contains("AMD")) {
				System.out.println(ele.getText());
				ele.click();
				break;
			}
		}
//		ctl00_mainContent_ddl_destinationStation1_CTNR
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTNR a[value='GOI']")).click();
		
		
	}

}
