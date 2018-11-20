package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConst {
	public static WebDriver driver;
	//@Parameters("browser")
	@BeforeMethod
	public void preCondition() {
		/*if(browser.equals("firefox")) {*/
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		//}
		/*else if(browser.equals("chrome")) {
			System.setProperty(CHROME_KEY,CHROME_VALUE);
			driver=new ChromeDriver();
		}	*/	
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	@AfterMethod
	public void postmethod() {
		driver.close();
	}

}
