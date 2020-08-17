package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Configurations.BaseClass;

public class HomePage extends BaseClass{
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
@FindBy(xpath="//a[@title='Dresses']/following::a[@title='T-shirts']")
WebElement catTShirt;

@FindBy(xpath="//a[@class='product_img_link']//img[@class='replace-2x img-responsive']")
WebElement shortsleeveTShirt;

@FindBy(xpath="//span[contains(text(),'Add to cart')]")
WebElement btnAddtoCart;

@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
WebElement msgProcToCart;

@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
WebElement btnProceedToChkOut;

@FindBy(xpath="//span[@id='layer_cart_product_title' and contains(text(),'Faded Short Sleeve T-shirts')]")
WebElement labelProduct;

@FindBy(xpath="//span[@id='layer_cart_product_attributes']")
WebElement labelColorSize;

@FindBy(xpath="//span[@id='layer_cart_product_quantity']")
WebElement labelQuantity;

@FindBy(xpath="//span[@id='layer_cart_product_price']")
WebElement labelTotal;

public String getTitle() {
	String HomePageTitle=driver.getTitle();
	return HomePageTitle;

}

public void selectTShirtCat() throws Throwable {
	Actions action = new Actions(driver);
	action.click(catTShirt).build().perform();
	Thread.sleep(5);
}

public void selectShortSeelve() throws Throwable {
	Actions action = new Actions(driver);
	action.click(shortsleeveTShirt).build().perform();
	Thread.sleep(5);
}
public void addToCart() throws Throwable {
	Actions action = new Actions(driver);
	action.click(btnAddtoCart).build().perform();
	Thread.sleep(5);
}

public boolean isProceedToChkout() throws Throwable {
	boolean flag=btnProceedToChkOut.isDisplayed();
	return flag;

}

public void clickProceedToChkOut() throws Throwable {
	Actions action = new Actions(driver);
	action.click(btnProceedToChkOut).build().perform();
	Thread.sleep(5);	
}
public boolean chkMsgDisplayed() {
	
	boolean flag=msgProcToCart.isDisplayed();
	return flag;
	
}
public String vrfyMessage() {
	
	String msg=msgProcToCart.getText();
	return msg;
	
}

public String labelProduct() {
	String S ="No Product Label found";
	if (labelProduct.isDisplayed()) {
String productName=labelProduct.getText();
return productName;}else 
	return S;
			
}

public String labelColorSize() {
String colorSizeName=labelColorSize.getText();
return colorSizeName;
	
}

public String labelQuantity() {
String productQuantity=labelQuantity.getText();
return productQuantity;
			
}
public String labelTotal() {
String totalPrice=labelTotal.getText();
return totalPrice;
			
}
}
