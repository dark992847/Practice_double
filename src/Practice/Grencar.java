package Practice;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Grencar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
        List<String> vegList=List.of("Cucumber","Brocolli","Carrot");
        List<WebElement> list=driver.findElements(By.cssSelector("h4[class='product-name']"));
        for(int i=0;i<list.size();i++) {
        	String vegName=list.get(i).getText().split("-")[0].trim();
        	if(vegList.contains(vegName)) {
        		driver.findElements(By.cssSelector("div[class='product-action'] button")).get(i).click();
        	}
        	
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[class='cart-icon'] img")).click();
        driver.findElement(By.cssSelector(".action-block button")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
        driver.findElement(By.cssSelector(".discountAmt ~ button")).click();
       
//        promoInfo
//        wait.until(ExpectedConditions.visibilityOfElementLocated("By.className('promoBtn')"));
//        wait.until(ExpectedConditions.visibilityOf("driver.findElement(By.className('promoBtn'))"));
	
	}

}
