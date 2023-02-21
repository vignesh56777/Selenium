package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage 
{
//declaration
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement  pageHeader;
	@FindBy(name = "name")
	private WebElement fullNameTF;
	@FindBy(name="sender")
	private WebElement emailTF;
	@FindBy(name="sender")
	private WebElement subjectTF;
	@FindBy(name="message")
	private WebElement messageTextArea;
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//initialization
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public void submitDetails(String name, String email, String subject, String message)
	{
		fullNameTF.sendKeys(name);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
		sendUsMailButton.click();
	}
	public WebElement getPageHeader() {
		
		return pageHeader;
	}
	
	
}
