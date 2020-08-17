package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.BaseClass;

public class DefaultPage extends BaseClass{
	//	WebDriver driver=getDriver();
	JavascriptExecutor js= (JavascriptExecutor) driver;

	/*
	 * public DefaultPage() { PageFactory.initElements(driver,this); }
	 */

	public DefaultPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//	WebElement SignInBtn=driver.findElement(By.xpath("//a[@class='login']"));
	@FindBy(xpath="//a[@class='login']")	
	WebElement SignInBtn;

	public void clickSignInBtn() throws InterruptedException {
		boolean flag=SignInBtn.isDisplayed();
		System.out.println("The button is displayed:  "+flag);
		Actions action = new Actions(driver);
		action.click(SignInBtn).build().perform();
		// js.executeScript("arguments[0].click", SignInBtn);
		System.out.println("Sign In Button is clicked");
		Thread.sleep(5);
	}
}
