package wikia;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	final WebDriver driver;
	

	//@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Add a Video")
	//@FindBy(how = How.CSS, using = "div.buttons nav.wikia-menu-button ul.WikiaMenuElement li:nth-of-type(2)")
	@FindBy(how = How.CSS, using = "div.buttons nav.wikia-menu-button ul.WikiaMenuElement li:nth-of-type(2)")
		private WebElement LinkAddVideo;
	@FindBy(how = How.CSS, using = "div.buttons nav.wikia-menu-button")
		private WebElement ContributeButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickContributeButton() {
		
		/*WebElement frame = driver.findElement(By.id("google_ads_frame1"));
		driver.switchTo().frame(frame);
		driver.switchTo().defaultContent();*/
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return  d.findElement(By.cssSelector("div.buttons nav.wikia-menu-button")).isEnabled();
            }
        });

	
		new WebDriverWait(driver, 40).until(ExpectedConditions
		        .elementToBeClickable(ContributeButton));
		Actions action = new Actions(driver);
		//loginLink.getAttribute("rel");
		WebElement we = driver.findElement(By.cssSelector("div.buttons nav.wikia-menu-button"));
		action.moveToElement(we).keyDown(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		
		
		
//		ContributeButton.click();
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(ContributeButton).perform();
	}
	public void clickAddVideoButton() {
		//LinkAddVideo.click();
	
	}


	public AddVideoPage OpenAddvideopage() {
		clickContributeButton();
		clickAddVideoButton();
		return PageFactory.initElements(driver, AddVideoPage.class);
	}
	


}
