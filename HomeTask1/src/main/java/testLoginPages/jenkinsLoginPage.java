package testLoginPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class jenkinsLoginPage {
	
	public String PAGE_URL= "http://192.168.1.2:8080/loginError";
	public String PAGE_TITLE= "Login Error [Jenkins]";
	
	@FindBy (xpath = ".//*[@id='main-panel']/div[2]/div") WebElement errorHeader;
	public String checkErroHeader () {
				
		return errorHeader.getText();
	}

}
