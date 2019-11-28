package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.Tc01Registrationpom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Tc01RegistrationTest {

	private WebDriver driver;
	private String baseUrl;
	private Tc01Registrationpom TC01Registration;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods generic;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TC01Registration = new Tc01Registrationpom(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void RegistrationTest() throws InterruptedException {
		TC01Registration.clickLoginRegisterBtn();
		generic.assertText("Log In", "//*[@id=\"post-133\"]/div/div/div/ul/li[1]/a", "xpath","Login Link is not found");
		TC01Registration.ExecutorScroll();
		screenShot.captureScreenShot("LoginRegister");
		TC01Registration.clickRegisterTab();
		generic.assertText("Register", "//*[@id=\"post-133\"]/div/div/div/ul/li[2]/a", "xpath","Register page is not found");
		screenShot.captureScreenShot("Register");
		TC01Registration.sendEmail("revasharma@gmail.com");
	
		TC01Registration.sendFirstName("reva");

		TC01Registration.sendLastName("sharma");
		
		//TC01Registration.ExecutorScroll();
		screenShot.captureScreenShot("Credentials");
		TC01Registration.clickRegisterBtn(); 
		generic.assertText("You have successfully registered to Real Estate. We have emailed your password to the email address you entered", "//*[@id=\"post-133\"]/div/div/div/div[1]/p", "xpath","Register page is not found");
		screenShot.captureScreenShot("RegistrationSuccessful");
	}
}
