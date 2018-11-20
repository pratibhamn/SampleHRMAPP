package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BasePage;
import generic.BaseTest;
import generic.Excel;
import generic.GenericUtils;
import pom.HomePage;

public class TestScripts extends BaseTest {
	@Test(enabled=true)
	public void testCreateEmployee() throws EncryptedDocumentException, InvalidFormatException, IOException {
		HomePage pi=new HomePage(driver);
		pi.setUserName(Excel.readData("Sheet1", 0, 1));
		pi.setPwd(Excel.readData("Sheet1", 1, 1));
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickAddEmp_Menu();
		pi.setFirstName("Leela");
		pi.setLastName("jdfh");
		pi.clickSaveBtn();
		pi.verifyFirstname("Leela");
		Reporter.log("hello",true);
	}
	@Test(enabled=false)
	public void testdeleteEmployee() throws InterruptedException {
		HomePage pi=new HomePage(driver);
		pi.setUserName("Admin");
		pi.setPwd("admin123");
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickEmpList();
		Thread.sleep(2000);
		pi.clickEmpCheckBox("Linda");
		pi.clickDelete();
		Thread.sleep(2000);
		pi.clickOK();
		Thread.sleep(2000);
		pi.verifyEmpIsNotPresent("Linda");
	}
	@Test(enabled=false)
	public void testSortList() {
		HomePage pi=new HomePage(driver);
		pi.setUserName("Admin");
		pi.setPwd("admin123");
		pi.clickLogin();
		BasePage.verifyTitle("OrangeHRM");
		pi.clickPim_Menu();
		pi.clickEmpList();
		GenericUtils.sortListbox(driver.findElement(By.xpath("//select[@id='empsearch_job_title']")));
	}

}
