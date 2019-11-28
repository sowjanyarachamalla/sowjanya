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
import com.training.pom.Tc02Loginpom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Tc02LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private Tc02Loginpom Tc02Login;
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
		Tc02Login = new Tc02Loginpom(driver);
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
		Tc02Login.clickLoginRegisterBtn();
		generic.assertText("Log In", "//*[@id=\"post-133\"]/div/div/div/ul/li[1]/a", "xpath","Login Link is not found");
		screenShot.captureScreenShot("LoginRegister");
		Tc02Login.sendUname("admin");
		Tc02Login.sendPassword("admin@123");
		//Tc02Login.ExecutorScroll();
		screenShot.captureScreenShot("LoginCredentials");
		Tc02Login.SinginBtn();
		screenShot.captureScreenShot("LogininSuccessful");
	}

}
