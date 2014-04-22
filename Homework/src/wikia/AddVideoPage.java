package wikia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddVideoPage {
	final WebDriver driver;
	

	@FindBy(how = How.ID, using = "wpWikiaVideoAddUrl")
		private WebElement TxtVideoUrl;
	
	@FindBy(how = How.CSS, using = "div.submits input")
		private WebElement AddButton;
	
	@FindBy(how = How.CSS, using = "div.global-notification div.msg a")
	private WebElement LinkNotification;
	
	
	
	public AddVideoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterURL(String upUrl) {
		TxtVideoUrl.clear();
		TxtVideoUrl.sendKeys(upUrl);
	}
	public void clickAddVideoButton() {
		AddButton.click();
	
	}
	public void clickNotificationLink() {
		LinkNotification.click();
	
	}

	public AddVideoPage UploadVideo(String upUrl) {
		enterURL(upUrl);
		clickAddVideoButton();
		return PageFactory.initElements(driver, AddVideoPage.class);
	}
	
	public AddVideoPage ClickLink() {
	
		clickNotificationLink();
		return PageFactory.initElements(driver, AddVideoPage.class);
	}
}
