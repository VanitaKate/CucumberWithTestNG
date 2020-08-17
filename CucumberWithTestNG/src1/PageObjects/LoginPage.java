package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.BaseClass;

public class LoginPage extends BaseClass {
	
 public LoginPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
 }
 
 @FindBy(xpath="//input[@id='email']")	
	WebElement txtEmailAddress;

 @FindBy(xpath="//input[@name='passwd']")	
	WebElement txtPassword;
 
 @FindBy(xpath="//p[@class='submit']//span[1]")	
	WebElement btnSignIn;
 
 public boolean isLoginPage() throws InterruptedException {
	 Thread.sleep(5);
	 boolean flag=txtEmailAddress.isDisplayed();
	 return flag;
	 
 }
 
 public void enterLoginEmailAddress(String email) {
	 txtEmailAddress.clear();
	 txtEmailAddress.click();
	 txtEmailAddress.sendKeys(email);
 }
 
 
 public void enterLoginPassword(String pwd) {
	 txtPassword.clear();
	 txtPassword.click();
	 txtPassword.sendKeys(pwd);
	 
 }
 
 public void clickSubmitButton() throws InterruptedException {
		Actions action = new Actions(driver);
		action.click(btnSignIn).build().perform();
		Thread.sleep(10);
//	 btnSignIn.click();
 }
 
 public boolean iseMailBlank() {
	 boolean flag=txtEmailAddress.getText().contains("@");
	return flag;
 }
}
