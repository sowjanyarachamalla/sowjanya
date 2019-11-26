package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Tc03RecoverPwd;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Tc03RecoverPassword {
	
	
	private WebDriver driver;
	private String baseUrl;
	private Tc03RecoverPwd Tc03RecoverPwd;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		Tc03RecoverPwd = new Tc03RecoverPwd(driver);
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
	public void RecoverPwdTest() throws InterruptedException {
		Tc03RecoverPwd.clickLoginRegisterBtn();
		Tc03RecoverPwd.ExecutorScroll();
		screenShot.captureScreenShot("LoginRegister");
        Tc03RecoverPwd.LostPasswordBtn();
		screenShot.captureScreenShot("LostPasswordPage");
        Tc03RecoverPwd.sendEmail("revasharma@gmail.com");
		screenShot.captureScreenShot("EmailCredentials");
		Tc03RecoverPwd.ResetPasswordBtn();
        screenShot.captureScreenShot("PostResetButtonClick");
		
	}

}
