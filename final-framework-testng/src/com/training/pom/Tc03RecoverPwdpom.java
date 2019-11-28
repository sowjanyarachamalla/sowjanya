package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc03RecoverPwdpom {
	
private WebDriver driver; 
	
	public Tc03RecoverPwdpom(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	private WebElement Login_Register; 
	

	@FindBy(css="#tab1 > form > p.lost_password > a")
	private WebElement LostPasswordLink; 
	
	@FindBy(xpath="//*[@id=\"user_login\"]")
	private WebElement Email;
	
	@FindBy(className="lostpassword-button")
	private WebElement ResetPassword;
	


	
	public void clickLoginRegisterBtn(){
		this.Login_Register.click();
	}
	
	
	
	public void LostPasswordBtn() {
		this.LostPasswordLink.click();
	}
	
	
	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}
	
	public void ResetPasswordBtn() {
		this.ResetPassword.click();
	}
	
	public void ExecutorScroll() throws InterruptedException {
		
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)","");
		 Thread.sleep(1000);
		}



	

	

	
	


}
