package jenkinsTargetTests;

import static org.testng.Assert.fail;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jenkinsTargetTestPages.MainPage;

public class jenkinsTargetTests {
	public WebDriver driver;
	MainPage mainPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikolai\\Desktop\\driverNew\\chromedriver.exe");
		this.driver = new ChromeDriver();
		mainPage = PageFactory.initElements(driver, MainPage.class);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public void testLoginMainPage() {
		driver.manage().deleteAllCookies();
		driver.get(mainPage.PAGE_URL);
		mainPage.setTextUserNameLogin("talai-2005");
		mainPage.setTextPassWordLogin("333gtnz");
		mainPage.ClickLoginMain();
		mainPage.ClickManageJenkinsButton();
	}

	@Test(priority = 2)
	public void testManageJenkinsHeader() {
		String result = mainPage.checkManageJenkingsHeader();
		if (!StringUtils.isBlank(result)) {
			Assert.assertEquals(result, "Настройка Jenkins");
		} else {
			fail("The test has been failed");
		}
	}

	@Test(priority = 3)
	public void testCreateModifyUsers() {
		String result = mainPage.checkCreateModifyUsersHeader();
		if (!StringUtils.isBlank(result)) {
			Assert.assertEquals(result,
					"Создание, удаление и модификция пользователей, имеющих право доступа к Jenkins");
		} else {
			fail("The test has been failed");
		}
	}

	@Test(priority = 4)
	public void manageUsersButton() {
		mainPage.clickManageUsersLink();
	}

	@Test(priority = 5)
	public void testCreateUsers() {
		String result = mainPage.testCreateUsers();
		if (!StringUtils.isBlank(result)) {
			Assert.assertEquals(result, "Создать пользователя");
		} else {
			fail("The test has been failed. The 'Create User' field has not been found");
		}
	}

	@Test(priority = 6)
	public void clickCrUsersButton() {
		mainPage.clickCreateUsersLink();
	}

	@Test(priority = 7)
	public void findUserCreationForm() {
		boolean result = mainPage.findForm();
		if (result == true) {
			Assert.assertTrue(result, "[The form exists]");
		} else {
			fail("The test has been failed. The form has not been found");
		}
	}

	@Test(priority = 8)
	public void findFormUsernameTextElement() {
		boolean result = mainPage.findFormUsernameTextElement();
		Assert.assertEquals(result, true);

	}

	@Test(priority = 9)
	public void findFormFullnameTextElement() {
		boolean result = mainPage.findFormFullnameTextElement();
		Assert.assertEquals(result, true);
	}

	@Test(priority = 10)
	public void findFormEmailTextElement() {
		boolean result = mainPage.findFormFullnameTextElement();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 11)
	public void findFormPasswordElement() {
		boolean result = mainPage.findFormPasswordElement();
		Assert.assertEquals(result, true);
	}
	
	@Test(priority = 12)
	public void findFormPasswordConfirmElement() {
		boolean result = mainPage.findFormPasswordConfirmElement();
		Assert.assertEquals(result, true);
	}
	@Test(priority = 13)
	public void findEmptyUserNameFieldCheck() {
		String result = mainPage.findEmptyUserNameFieldCheck();
		Assert.assertEquals(result, "");
	}
	
	@Test(priority = 14)
	public void findEmptyPasswordFieldCheck() {
		String result = mainPage.FindEmptyPasswordFieldCheck();
		Assert.assertEquals(result, "");
	}
	
	@Test(priority = 15)
	public void findEmptyConfirmPasswordFieldCheck() {
		String result = mainPage.findEmptyUserNameFieldCheck();
		Assert.assertEquals(result, "");
	}
	
	@Test(priority = 16)
	public void findEmptyfullNameFieldCheck() {
		String result = mainPage.findEmptyUserNameFieldCheck();
		Assert.assertEquals(result, "");
	}
	
	@Test(priority = 17)
	public void findEmptyEmailAddressFieldCheck() {
		String result = mainPage.findEmptyUserNameFieldCheck();
		Assert.assertEquals(result, "");
	}
	
		
	@Test(priority = 18)
	public void filloutEmptyUserNameField() {
		String result = mainPage.filloutEmptyUserNameField("someuser");
		Assert.assertEquals(result, "someuser");
	}
	
	@Test(priority = 19)
	public void filloutPasswordField() {
		String result = mainPage.filloutPasswordField("somepassword");
		Assert.assertEquals(result, "somepassword");
	}
	
	@Test(priority = 20)
	public void filloutPasswordConfirmField() {
		String result = mainPage.filloutPasswordConfirmField("somepassword");
		Assert.assertEquals(result, "somepassword");
	}
	
	@Test(priority = 21)
	public void filloutFullaNameField() {
		String result = mainPage.filloutFullaNameField("Some Full Name");
		Assert.assertEquals(result, "Some Full Name");
	}
	
	@Test(priority = 22)
	public void filloutEmailaNameField() {
		String result = mainPage.filloutEmailaNameField("some@addr.dom");
		Assert.assertEquals(result, "some@addr.dom");
	}

	@Test(priority = 23)
	public void clickCreateUserButton() {
		mainPage.clickCreateUserButton();
	}
	
	@Test(priority = 24)
	public void someUserCheck() {
	Assert.assertEquals(mainPage.someUserCheck(), true);
	}
	
	@Test(priority = 25)
	public void clickUserDeleteHref() {
		mainPage.clickUserDeleteHref();
	}
	
	@Test(priority = 26)
	public void clickYesDeleteButton() {
	mainPage.clickYesDeleteButton();
	}
	
	@Test(priority = 27)
	public void deleteUserLinkCheck() {
	Assert.assertEquals(mainPage.deleteUserLinkCheck(), true);
	}
	
	//Making sure the page does not contain the "user/someuser/delete" href just after user removal
	@Test(priority = 28)
	public void removalUserLinkCheck() {
	Assert.assertEquals(mainPage.removalUserLinkCheck(), true);
	}	
	
	// Refreshing the page to make sure the "user/someuser/delete" href is not there
	@Test(priority = 28)
	public void pageRefresh() {
	mainPage.pageRefresh();
	}	
	
	//Making sure the page does not contain "user/someuser/delete" href
	@Test(priority = 28)
	public void removalUserLinkCheckAnew() {
	Assert.assertEquals(mainPage.removalUserLinkCheck(), true);
	}
	
}
