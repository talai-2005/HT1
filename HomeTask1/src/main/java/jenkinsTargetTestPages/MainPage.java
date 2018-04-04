package jenkinsTargetTestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	public String PAGE_URL = "http://192.168.1.2:8080/login?from=%2F";
	public String PAGE_TITLE = "Jenkins";

	@FindBy(id = "j_username")
	WebElement field_userNameLogin;

	@FindBy(xpath = ".//*[@id='main-panel']/div/form/table/tbody/tr[2]/td[2]/input")
	WebElement field_passWordLogin;

	@FindBy(xpath = ".//*[@id='yui-gen1-button']")
	WebElement button_Login;

	@FindBy(xpath = ".//*[@id='tasks']/div[4]/a[2]")
	WebElement manageJenkinsButton;

	@FindBy(xpath = ".//*[@id='main-panel']/h1")
	WebElement manageJenkinsHeader;

	@FindBy(xpath = ".//*[@id='management-links']/tbody/tr[15]/td[2]/div[2]")
	WebElement createModifyJenkinsUsers;

	@FindBy(xpath = ".//*[@id='management-links']/tbody/tr[15]/td[2]/div[1]/a")
	WebElement manageUsersLink;

	@FindBy(xpath = ".//*[@id='tasks']/div[3]/a[2]")
	WebElement createUsersLink;

	@FindBy(xpath = ".//*[@id='main-panel']/form")
	WebElement form_locator;

	@FindBy(xpath = ".//*[@id='username']")
	WebElement userNameField;

	@FindBy(xpath = ".//*[@id='main-panel']/form/div[1]/table/tbody/tr[2]/td[2]/input")
	WebElement passwordField;

	@FindBy(xpath = ".//*[@id='main-panel']/form/div[1]/table/tbody/tr[3]/td[2]/input")
	WebElement confirmPasswordField;

	@FindBy(xpath = ".//*[@id='main-panel']/form/div[1]/table/tbody/tr[4]/td[2]/input")
	WebElement fullNameField;

	@FindBy(xpath = ".//*[@id='main-panel']/form/div[1]/table/tbody/tr[5]/td[2]/input")
	WebElement emailAddressField;
	
	@FindBy(xpath = ".//*[@id='yui-gen4-button']")
	WebElement createUserButton;
	
	@FindBy(xpath = ".//*[@id='people']/tbody/tr[2]/td[2]/a")
	WebElement someUser;
	
	@FindBy(xpath = ".//*[@id='people']/tbody/tr[2]/td[4]/a[2]/img")
	WebElement clickUserDeleteLink;
	
	@FindBy(xpath = ".//*[@id='main-panel']/form")
	WebElement deleteUserLink;
	
	@FindBy(xpath = ".//*[@id='yui-gen4-button']")
	WebElement clickYesDeleteButton;
	
	@FindBy(xpath = ".//*[@id='main-panel']")
	WebElement generalPanel;	
	
	
	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;

	}

	public void setTextUserNameLogin(String text) {
		field_userNameLogin.sendKeys(text);
	}

	public void setTextPassWordLogin(String text) {
		field_passWordLogin.sendKeys(text);
	}

	public void ClickLoginMain() {
		button_Login.click();
	}

	public void ClickManageJenkinsButton() {
		manageJenkinsButton.click();
	}

	public String checkManageJenkingsHeader() {

		return manageJenkinsHeader.getText();
	}

	public String checkCreateModifyUsersHeader() {

		return createModifyJenkinsUsers.getText();
	}

	public void clickManageUsersLink() {
		manageUsersLink.click();
	}

	public String testCreateUsers() {

		return createUsersLink.getText();
	}

	public void clickCreateUsersLink() {
		createUsersLink.click();
	}

	public boolean findForm() {
		return form_locator.isDisplayed();

	}

	public boolean findFormUsernameTextElement() {
		boolean result = form_locator.findElement(By.name("username")).getAttribute("type").equalsIgnoreCase("text");
		return result;

	}

	public boolean findFormFullnameTextElement() {
		boolean result = form_locator.findElement(By.name("fullname")).getAttribute("type").equalsIgnoreCase("text");
		return result;

	}

	public boolean findFormEmailTextElement() {
		boolean result = form_locator.findElement(By.name("email")).getAttribute("type").equalsIgnoreCase("text");
		return result;
	}

	public boolean findFormPasswordElement() {
		boolean result = form_locator.findElement(By.name("password1")).getAttribute("type")
				.equalsIgnoreCase("password");
		return result;
	}

	public boolean findFormPasswordConfirmElement() {
		boolean result = form_locator.findElement(By.name("password2")).getAttribute("type")
				.equalsIgnoreCase("password");
		return result;
	}

	public String findEmptyUserNameFieldCheck() {
		String result = userNameField.getText();

		return result;

	}

	public String FindEmptyPasswordFieldCheck() {
		String result = passwordField.getText();

		return result;

	}
	
	public String findEmptyConfirmPasswordFieldCheck() {
		String result = confirmPasswordField.getText();

		return result;

	}
	
	public String findEmptyfullNameFieldCheck() {
		String result = fullNameField.getText();

		return result;

	}
	
	public String findEmptyEmailAddressFieldCheck() {
		String result = emailAddressField.getText();
		return result;

	}
	
	public String filloutEmptyUserNameField (String value) {
		form_locator.findElement(By.name("username")).sendKeys(value);
		String result = form_locator.findElement(By.name("username")).getAttribute("value");
		return result;
				}
	
	public String filloutPasswordField (String value) {
		form_locator.findElement(By.name("password1")).sendKeys(value);
		String result = form_locator.findElement(By.name("password1")).getAttribute("value");
		return result;
				}

	public String filloutPasswordConfirmField (String value) {
		form_locator.findElement(By.name("password2")).sendKeys(value);
		String result = form_locator.findElement(By.name("password2")).getAttribute("value");
		return result;
				}
	
	public String filloutFullaNameField (String value) {
		form_locator.findElement(By.name("fullname")).sendKeys(value);
		String result = form_locator.findElement(By.name("fullname")).getAttribute("value");
		return result;
				}
	
	public String filloutEmailaNameField(String value) {
		form_locator.findElement(By.name("email")).sendKeys(value);
		String result = form_locator.findElement(By.name("email")).getAttribute("value");
		return result;
	}

	public void refreshPage() {
		driver.navigate().refresh();
		}

	public void clickCreateUserButton() {
		createUserButton.click();
	}

	public boolean someUserCheck() {
		return someUser.isDisplayed();
		
	}
	
	public void clickUserDeleteHref() {
		clickUserDeleteLink.click();
	}
	
	public void clickYesDeleteButton() {
		clickYesDeleteButton.click();
	}
	
	public boolean deleteUserLinkCheck() {
		return someUser.isDisplayed();

	}

	public boolean removalUserLinkCheck() {

		List<WebElement> deleteLinks = generalPanel
				.findElements(By.xpath(".//*[@id='people']/tbody/tr[2]/td[4]/a[2]/img"));
		boolean result = deleteLinks.isEmpty();
		return result;

	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public boolean removalUserLinkCheckAnew() {

		List<WebElement> deleteLinks = generalPanel
				.findElements(By.xpath(".//*[@id='people']/tbody/tr[2]/td[4]/a[2]/img"));
		boolean result = deleteLinks.isEmpty();
		return result;

	}
}
