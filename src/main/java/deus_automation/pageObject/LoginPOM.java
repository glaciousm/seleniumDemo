package deus_automation.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import deus_automation.utils.Property;

public class LoginPOM {
	
	WebDriver driver;
	Property prop = new Property();
	
	By username = By.id("email");
	By pass = By.id("password");
	By loginBtn = By.className("btn-primary");
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername() {
		driver.findElement(username).sendKeys(prop.username());
	}
	
	public void setPassword() {
		driver.findElement(pass).sendKeys(prop.password());
	}
	
	public void clickLoginButton() {
		driver.findElement(loginBtn).click();
	}
	
	public LoginPOM login() {
		setUsername();
		setPassword();
		clickLoginButton();
		return new LoginPOM(driver);
	}

}
