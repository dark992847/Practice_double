package TestPrac.copy;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {
	
	@Test
	@Parameters({"URL"})
	public void carLoanzzz(String url) {
		System.out.println("carLoanApi");
		System.out.println(url);
	}
	
	@Test
	public void carLoanWeb() {
		System.out.println("day1.smoke");
	}
	
	@BeforeSuite
	public void bfsuite() {
		System.out.println("I'm before suite");
	}
	
	@BeforeTest
	public void bfclass() {
		System.out.println("Before Test------------------------------");
	}
	
	@AfterTest
	public void afclass() {
		System.out.println("After Test------------------------------");
	}
	
	@AfterSuite
	public void afsuite() {
		System.out.println("I'm After suite");
	}
	
	
	
}
