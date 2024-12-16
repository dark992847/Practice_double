package Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		String item="ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		Thread.sleep(2500);
		List<WebElement> products=driver.findElements(By.cssSelector(".card-body h5 b"));
		System.out.println("Total Products: "+products.size());
		for(int i=0;i<products.size();i++) {
			System.out.println(products.get(i).getText());
			if(products.get(i).getText().equals(item)) {
				driver.findElements(By.xpath("//div[@class='card-body']/button[2]")).get(i).click();
			}
		}
		
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
//        driver.findElement(By.cssSelector("#toast-container div div")).getText();
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
        Thread.sleep(2000);
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
