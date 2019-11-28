package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.Tc03RecoverPwdpom;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Tc03RecoverPasswordTest {
	
	
	private WebDriver driver;
	private String baseUrl;
	private Tc03RecoverPwdpom Tc03RecoverPwd;
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
		Tc03RecoverPwd = new Tc03RecoverPwdpom(driver);
		baseUrl = properties.getProperty("baseURL");
		generic=new GenericMethods(driver);
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
	public void RecoverPwdTest() throws InterruptedException {
		Tc03RecoverPwd.clickLoginRegisterBtn();
		generic.assertText("Log In", "//*[@id=\"post-133\"]/div/div/div/ul/li[1]/a", "xpath","Login Link is not found");
		Tc03RecoverPwd.ExecutorScroll();
		screenShot.captureScreenShot("LoginRegister");
        Tc03RecoverPwd.LostPasswordBtn();
        generic.assertText("Lost Password", "//*[@id=\"titlebar\"]/div/div/div/h2", "xpath","Lost Password page is not found");
		screenShot.captureScreenShot("LostPasswordPage");
        Tc03RecoverPwd.sendEmail("revasharma@gmail.com");
        screenShot.captureScreenShot("EmailCredentials");
		Tc03RecoverPwd.ResetPasswordBtn();
		generic.assertText("A confirmation link has been sent to your email address", "//*[@id=\"error-page\"]", "xpath","Message is not as expected");
        screenShot.captureScreenShot("PostResetButtonClick");
		
		
	}

}
