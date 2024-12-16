package Practice;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Riceprac {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		List<WebElement> veggies=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		String veg="Almond";
		String foundveg = null;
//		System.out.println(veggies.size());
//		veggies.stream().forEach(s->System.out.println(s.getText()));

		while(driver.findElement(By.cssSelector("a[aria-label='Next']")).isEnabled()) {
			List<WebElement> veggies=driver.findElements(By.xpath("//tbody/tr/td[1]"));
			List<WebElement> prices=driver.findElements(By.xpath("//tbody/tr/td[2]"));
			veggies.stream().forEach(s->System.out.println(s.getText()));
			for(int i=0;i<veggies.size();i++) {
				if(veggies.get(i).getText().equalsIgnoreCase(veg)) {
					System.out.println("veggie found "+veggies.get(i).getText());
					System.out.println("veggie found "+prices.get(i).getText());
//					System.out.println(veggies.get(i).findElement(By.xpath("//following-sibling::td[2]")).getText());
					foundveg=veggies.get(i).getText();
				}
			}
			if(foundveg!=null) {
				break;
			}
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}


	}

	public static String getPrice(WebElement e) {
		String price=e.findElement(By.xpath("//td[2]")).getText();
		return price;

	}

}
