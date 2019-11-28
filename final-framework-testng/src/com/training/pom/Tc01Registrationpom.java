package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tc01Registrationpom {
	private WebDriver driver;

	public Tc01Registrationpom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "sign-in")
	private WebElement Login_Register;

	@FindBy(xpath = "//*[@id=\"post-133\"]/div/div/div/ul/li[2]/a")
	private WebElement Register;

	@FindBy(id = "email")
	private WebElement Email;

	@FindBy(id = "first-name")
	private WebElement FirstName;

	@FindBy(id = "last-name")
	private WebElement LastName;

	@FindBy(xpath = "//*[@id=\"signupform\"]/p[5]/input")
	private WebElement RegisterBtn;



	private Object js;

	public void clickLoginRegisterBtn() {
		this.Login_Register.click();
	}

	public void clickRegisterTab() {
		this.Register.click();
	}

	public void sendEmail(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);
	}

	public void sendFirstName(String FirstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);
	}

	public void sendLastName(String LastName) {
		this.LastName.clear();
		this.LastName.sendKeys(LastName);
	}

	public void clickRegisterBtn() {
		this.RegisterBtn.click();
	}

	public void ExecutorScroll() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
	}

}
