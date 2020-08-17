package Configurations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
public static WebDriver driver;
public HomePage HP;	
// SetUp method is to launch Chrome driver and browse the "AutomationPractice" URL

public WebDriver setUp() {
String projectPath=System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src1/Drivers/chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();

	return driver;
}



}
