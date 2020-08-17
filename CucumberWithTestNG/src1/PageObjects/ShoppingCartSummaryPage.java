package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {
	public ShoppingCartSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Dresses']/following::a[@title='T-shirts']")
	WebElement catTShirt;
}
