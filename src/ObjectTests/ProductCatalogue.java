package ObjectTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComp.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	@FindBy(css=".card-body h5 b")
	List<WebElement> products;
	@FindBy(xpath="//div[@class='card-body']/button[2]")
	List<WebElement> addCart;
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	By loc1=By.cssSelector(".ng-animating");
	By loc2=By.cssSelector("#toast-container");
	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	public void getProducts() {
		System.out.println("Total Products: "+products.size());
		for(WebElement p:products) {
			System.out.println(p.getText());
		}
	}

	public void addProduct(String name) throws InterruptedException {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getText().equals(name)) {
				addCart.get(i).click();
				System.out.println("Product added: "+name);
//				Thread.sleep(2500);
				elementToAppear(loc2);
				elementToDisappear(loc1);
				
//				elementToAppear(loc2);
			}
		}
	}

	public void viewCart() throws InterruptedException {
		Thread.sleep(2000);
		cart.click();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
