package ObjectTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
    public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	super(driver);
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
	}
    
    @FindBy(id="userEmail")
    WebElement emailLoc;
    @FindBy(id="userPassword")
    WebElement passLoc;
    @FindBy(id="login")
    WebElement subBut;
	
	public void goTo(String URL) throws InterruptedException {
    	driver.get(URL);
    	driver.manage().window().maximize();
    	Thread.sleep(2000);
    }
	
	public ProductCatalogue logIn(String email,String pass) throws InterruptedException {
		emailLoc.sendKeys(email);
		passLoc.sendKeys(pass);
		subBut.click();
		Thread.sleep(2500);
		ProductCatalogue prodCat=new ProductCatalogue(driver);
		return prodCat;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
