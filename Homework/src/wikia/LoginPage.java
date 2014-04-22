package wikia;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	final WebDriver driver;
	
	@FindBy(how = How.CSS, using = "div.page-width-container ul#AccountNavigation.AccountNavigation li a.ajaxLogin")
	//@FindBy(   how = "ul#AccountNavigation.AccountNavigation li a.ajaxLogin")
	private WebElement loginLink;
	@FindBy(how = How.NAME, using = "username")
		private WebElement UserName;
	@FindBy(how = How.NAME, using = "password")
		private WebElement Password;
	@FindBy(how = How.CLASS_NAME, using = "login-button")
		private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterLogin(String login) {
	(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return  loginLink.isEnabled();
            }
        });

	
		new WebDriverWait(driver, 40).until(ExpectedConditions
		        .elementToBeClickable(loginLink));
		
		Actions action = new Actions(driver);
		//loginLink.getAttribute("rel");
		WebElement we = driver.findElement(By.cssSelector("ul#AccountNavigation.AccountNavigation li a.ajaxLogin"));
		action.moveToElement(we).build().perform();
		
		
		loginLink.click();
		UserName.clear();
		UserName.sendKeys(login);
	}
	public void enterPassword(String password) {
		Password.clear();
		Password.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	public HomePage login(String login, String password) {
		enterLogin(login);
		enterPassword(password);
		clickLoginButton();
		return PageFactory.initElements(driver, HomePage.class);
	}
}
