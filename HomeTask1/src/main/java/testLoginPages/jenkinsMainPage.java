package testLoginPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class jenkinsMainPage {
	
	
	public String PAGE_URL= "http://192.168.1.2:8080/login?from=%2F";
	public String PAGE_TITLE= "Jenkins";
	
	@FindBy (id = "j_username") WebElement field_userNameLogin;
	@FindBy (xpath = ".//*[@id='main-panel']/div/form/table/tbody/tr[2]/td[2]/input") WebElement field_passWordLogin;
	@FindBy (xpath = ".//*[@id='yui-gen1-button']") WebElement button_Login;
	
	WebDriver driver;
	
	public jenkinsMainPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void setTextUserNameLogin (String text) {
		field_userNameLogin.sendKeys(text);
		
		Assert.assertEquals(field_userNameLogin.getAttribute("value"), text);
	}
	
		public void setTextPassWordLogin(String text) {
			field_passWordLogin.sendKeys(text);
			Assert.assertEquals(field_passWordLogin.getAttribute("value"), text);
		}
	
				
	public void ClickLoginMain () {
		button_Login.click();
	}
		
	}
	
	
	
