package AbstractComp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
	    this.driver=driver;
	}
	
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
	
	public void elementToAppear(By locator) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	} 
	
    public void elementToDisappear(By locator) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
