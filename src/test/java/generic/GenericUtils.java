package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class GenericUtils extends BaseTest {
	public static void gSelectByIndex(WebElement element,int n) {
		Select select=new Select(element);
		select.selectByIndex(n);
	}
	public static void gSelectByValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void gSelectByVisibleText(WebElement element,String v) {
		Select select=new Select(element);
		select.selectByVisibleText(v);
	}
	public static void hover(WebDriver driver,WebElement toElement) {
		Actions action=new Actions(driver);
		action.moveToElement(toElement).perform();
	}
	public static void sortListbox(WebElement element) {
		Select select=new Select(element);
		List<WebElement> li = select.getOptions();
		ArrayList<String> ar=new ArrayList<String>();
		ArrayList<String> ar1=new ArrayList<String>();
		//to sort elements
		for(int i=1;i<li.size();i++) {
			String st = li.get(i).getText();
			ar.add(st);
			ar1.add(st);
		}
		Collections.sort(ar);
		//to comapre the elemnts
		for(int i=0;i<ar.size();i++) {
			if(!(ar1.get(i).equals(ar.get(i)))) {
				Reporter.log("List is not sorted:fail",true);
			}
		}
		Reporter.log("List is sorted:Pass",true);
	}
}
