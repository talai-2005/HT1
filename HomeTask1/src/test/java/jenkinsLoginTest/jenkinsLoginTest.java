package jenkinsLoginTest;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testLoginPages.MainPageLoginVerification;
import testLoginPages.jenkinsLoginPage;
import testLoginPages.jenkinsMainPage;

public class jenkinsLoginTest {
	public WebDriver driver;
	jenkinsMainPage jenMainPage;
	jenkinsLoginPage jenLoginPage;
	MainPageLoginVerification mPageLoginVerification;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikolai\\Desktop\\driverNew\\chromedriver.exe");
		this.driver = new ChromeDriver();
		jenMainPage = PageFactory.initElements(driver, jenkinsMainPage.class);
		jenLoginPage = PageFactory.initElements(driver, jenkinsLoginPage.class);
		mPageLoginVerification = PageFactory.initElements(driver, MainPageLoginVerification.class);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "login")
	public static Object[][] login() {
		return new Object[][] { 
			{ "talai-2005", "333gtnz", "Пожалуйста, создайте новую задачу для того чтобы начать работу." }, // positive test
			
		{ " ", "333gtnz", "Если вы системный администратор и подозреваете ошибку в конфигурации, " 
								+ "обратитесь к выводу консоли сервера, чтобы "
								+ "получить больше информации." }, //negative test

		
				{ "talai-2005", " ", "Если вы системный администратор и подозреваете ошибку в конфигурации, "
						+ "обратитесь к выводу консоли сервера, чтобы "
						+ "получить больше информации." }, //negative test
				
				};
	}

	@Test(dataProvider = "login")
	public void testLoginMainPage(String userName, String passWord, String message) {
		driver.manage().deleteAllCookies();
		driver.get(jenMainPage.PAGE_URL);
		Assert.assertEquals(driver.getTitle(), jenMainPage.PAGE_TITLE);
		jenMainPage.setTextUserNameLogin(userName);
		jenMainPage.setTextPassWordLogin(passWord);
		jenMainPage.ClickLoginMain();

		
		if (!StringUtils.isBlank(message)) {
	String result = jenLoginPage.checkErroHeader();
		Assert.assertEquals(result, message);
	} else {
		
		String result = mPageLoginVerification.checkWelcomeHeader();
		Assert.assertEquals(result, message);
	}
		
	}
}

