package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic.BasePage;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername")
	private WebElement userTxtbox;
	@FindBy(id="txtPassword")
	private WebElement pwdTxtBox;
	@FindBy(id="btnLogin")
	private WebElement loginBtn;
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim_menu;
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmp_Menu;
	@FindBy(id="firstName")
	private WebElement fName;
	@FindBy(id="lastName")
	private WebElement lName;
	@FindBy(id="btnSave")
	private WebElement saveBtn;
	@FindBy(id="personal_txtEmpFirstName")
	private WebElement firstname1;
	
	public void setUserName(String un) {
		userTxtbox.sendKeys(un);		
	}
	public void setPwd(String pwd) {
		pwdTxtBox.sendKeys(pwd);		
	}

	public void clickLogin() {
		loginBtn.click();		
	}
	public void clickPim_Menu() {
		pim_menu.click();
	}
	public void clickAddEmp_Menu() {
		addEmp_Menu.click();
	}
	public void setFirstName(String fn) {
		fName.sendKeys(fn);
	}
	public void setLastName(String ln) {
		lName.sendKeys(ln);
	}
	public void clickSaveBtn() {
		saveBtn.click();
	}
	public void verifyFirstname(String eFn) {
		String aFn = firstname1.getAttribute("value");
		Assert.assertEquals(aFn,eFn);
	}
	
	//to delete an employee
	@FindBy(id="menu_pim_viewEmployeeList")
	private WebElement empList_Btn;
	@FindBy(id="btnDelete")
	private WebElement btnDelete;
	@FindBy(id="dialogDeleteBtn")
	private WebElement btnOK;
	public void clickEmpList() {
		empList_Btn.click();
	}
	public void clickEmpCheckBox(String name) {
		String xp = "//a[text()='"+name+"']/../../td[1]//input";
		driver.findElement(By.xpath(xp)).click();
	}
	public void clickDelete() {
		btnDelete.click();
	}
	public void clickOK() {
		btnOK.click();
	}
	public void verifyEmpIsNotPresent(String name) {
		String xp = "//a[text()='\"+name+\"']";
	boolean present = verifyElementisPresentOrNot(xp);
	Assert.assertFalse(present);
	}
}
