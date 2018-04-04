package testLoginPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MainPageLoginVerification {
	
	public String PAGE_URL= "http://192.168.1.2:8080/";
	public String PAGE_TITLE= "ИнфоПанель [Jenkins]";

	@FindBy (xpath = ".//*[@id='main-panel']/div[2]/h1") WebElement wellcomeHeader;
	public String checkWelcomeHeader () {
		
	return wellcomeHeader.getText();
	}
}
