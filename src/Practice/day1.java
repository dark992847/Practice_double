package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class day1 {
	static String user="rinku@tcs.com";
	static String pass="rahulshettyacademy";
//	static ChromeDriver driver= new ChromeDriver();
    
	public void resetPass(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("rinku");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys(day1.user);
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234");
		driver.findElement(By.className("reset-pwd-btn")).click();
		String pass1=driver.findElement(By.className("infoMsg")).getText();
		String pass2= pass1.split("'")[1];
		day1.pass=pass2;
		System.out.println(day1.pass);
		driver.findElement(By.className("go-to-login-btn")).click();
		
	}
	public boolean logIn(WebDriver driver,String user,String pass) {
		
		boolean exist=false;
		
        driver.findElement(By.id("inputUsername")).sendKeys(user);
		driver.findElement(By.cssSelector("input[name='inputPassword']")).sendKeys(pass);
		driver.findElement(By.className("signInBtn")).click();
		try {
		if(driver.findElement(By.className("error")).isDisplayed()) {
	    	System.out.println("Password wrong...");
	    	exist=true;
	    }
		}
		catch (Exception e) {
			System.out.print("No Error occured");
		}
		return exist;
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();
		day1 obj1=new day1();
		boolean blu=obj1.logIn(driver,user, pass);
			    if(blu) {
			    	System.out.println(blu);
			    	obj1.resetPass(driver);
			    	obj1.logIn(driver,user, pass);
			    	
			    }
       		}
		

	}


