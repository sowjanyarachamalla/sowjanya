package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc02Loginpom {
	
private WebDriver driver; 
	
	public Tc02Loginpom(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	private WebElement Login_Register; 
	

	@FindBy(id="user_login")
	private WebElement Username; 
	
	@FindBy(id="user_pass")
	private WebElement Password;
	
	@FindBy(name="login")
	private WebElement Signingin;
	
	
	
	public void clickLoginRegisterBtn() {
		this.Login_Register.click();
	}
	
	
	public void sendUname(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);
	}
	
	public void sendPassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password); 
	}
	
	public void SinginBtn() {
		this.Signingin.click(); 
	}
    public void ExecutorScroll() throws InterruptedException {
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)","");
		 Thread.sleep(1000);
		}


}
