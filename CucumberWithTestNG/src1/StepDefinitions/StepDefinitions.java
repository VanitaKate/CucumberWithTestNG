package StepDefinitions;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Configurations.BaseClass;
import PageObjects.DefaultPage;
import PageObjects.LoginPage;
import Utilities.DateTimeStamp;
import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions extends BaseClass {
	DateTimeStamp timeStamp=new DateTimeStamp();
	
	@Before
	public void StartTest(Scenario scenario) {
		System.out.println("The Scenario "+scenario.getName()+ "starts here at: " +timeStamp.getTimeStamp());
		System.out.println("The Scenario URI is: "+scenario.getUri());
		String URI=scenario.getUri().toString();
		String[] Split1=URI.split("/Features/");
		int length=Split1.length;
		System.out.println(length);
		if (length==2) {
			System.out.println("The feature name is: "+Split1[1]); 
		}
		String FeatureName=Split1[1];

	}
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("The Scenario "+scenario.getName()+ "starts ends at: " +timeStamp.getTimeStamp());
		System.out.println("============================================================================================================");
		System.out.println("\n==========================================================================================================");
		driver.close();
	}
	WebDriver driver;
	@Given("user launches browser and opens the application")
	public void user_launches_browser_and_opens_the_application() {
		driver=setUp();
		driver.get("http://Automationpractice.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Then("clicks on SignIn link to open Sign In details")
	public void clicks_on_sign_in_link_to_open_sign_in_details() throws Throwable {
		DefaultPage DP=new DefaultPage(driver);
		DP.clickSignInBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("User enters valid credentials and home page of the application displays")
	public void user_enters_valid_credentials_and_home_page_of_the_application_displays() throws InterruptedException {
		LoginPage LP=new LoginPage(driver);	
		LP.enterLoginEmailAddress("vani_ket@rediffmail.com");
		LP.enterLoginPassword("jetblue");

		if (LP.iseMailBlank()) {
			System.out.println("Entered value disappears on auto page refresh");
		}else
		LP.clickSubmitButton();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println("User logged in succesfully.");

	}
	
	@Then("HomePage title is validated")
	public void home_page_title_is_validated() {
		 HP=new HomePage(driver);
		 
		String HPTitle=HP.getTitle();
      Assert.assertEquals(HPTitle,"My account - My Store");
		
	}

	@Then("Short sleeve T-Shirt is selectd under T-Shirt category added added to Cart")
	public void short_sleeve_t_shirt_is_selectd_under_t_shirt_category_added_added_to_cart() throws Throwable {

		HP.selectTShirtCat();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Catgory 'T-Shirts' is selected");
		HP.selectShortSeelve();
		System.out.println("Short sleeve T-Shirt is selected");
		HP.addToCart();
		System.out.println("Short sleeve T-Shirt is added to cart");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Then("Product details verified")
	public void product_details_verified() throws Throwable {
		boolean isProceedBtn=HP.isProceedToChkout();
		System.out.println("Is Proceed to CheckOut displayed: "+isProceedBtn);
		boolean flag=HP.chkMsgDisplayed();
		System.out.println("Is message displayed: "+flag);
		System.out.println("Short sleeve T-Shirt is added to cart");
		String msg=HP.vrfyMessage();
		System.out.println("Message Displayed on screen: "+msg);
		String productName=HP.labelProduct();
		String colorSize=HP.labelColorSize();
		String quantity=HP.labelQuantity();
		String totalPrice=HP.labelTotal();
		System.out.println("Product Name:" +productName +"\ncolorSize:" +colorSize+ "\nQuantity"+quantity+"\nTotalPrice" +totalPrice);
		Thread.sleep(5);
	}

	@Then("ProceedToCheckout button is clicked")
	public void proceed_to_checkout_button_is_clicked() throws Throwable {
		HP.clickProceedToChkOut();

	}
}
