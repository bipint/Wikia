package wikia;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.TestCase;

public class Tests extends TestCase{
	
	WebDriver driver;
	private static String login = "Bipin Kumar Tiwari";
	private static String pass = "07011983";
	private static String uploadUrl = "http://www.youtube.com/watch?v=h9tRIZyTXTI";
	
	@Before
	public void setUp() throws Exception {
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	/*@Test
	public void testLogin() throws Exception {
		driver.get("http://testhomework.wikia.com/");
		driver.manage().window().maximize();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = loginPage.login(login, pass);
		//LoginPage loginPageAfterLogout = homePage.logout();
	}*/
	
	@Test
	public void testAddVideo() throws Exception {
		driver.get("http://testhomework.wikia.com/");
		driver.manage().window().maximize();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = loginPage.login(login, pass);
		AddVideoPage addVideoPage = homePage.OpenAddvideopage();
		AddVideoPage addVideoPage1 = addVideoPage.UploadVideo(uploadUrl);
		AddVideoPage addVideoPage2 = addVideoPage1.ClickLink();
		//LoginPage loginPageAfterLogout = homePage.logout();
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
