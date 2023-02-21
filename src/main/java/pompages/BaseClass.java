package pompages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import genericlibraries.ExcelUtility;
import genericlibraries.IConstantPath;
import genericlibraries.PropertiesFileUtility;
import genericlibraries.WebDriverUtility;

public class BaseClass
{

	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSelenium coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;
	protected long time;
	
	
  //@BeforeSuite
 // @BeforeTest
  @BeforeClass
  public void classConfiguration()
  {
	  property = new PropertiesFileUtility();
	  excel = new ExcelUtility();
	  web = new WebDriverUtility();
	  
	  property.propertyFileInitialization(IConstantPath.PROPERTIES_FILE_PATH);
	  excel.excelInitialization(IConstantPath.PROPERTIES_FILE_PATH);
  }
  @BeforeMethod
  public void methodConfiguration()
  {
	  time = Long.parseLong(property.fetchProperty("timeouts"));
	  driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), 0);
	  
	  home = new HomePage(driver);
	  Assert.assertTrue(home.getLogo().isDisplayed());
	  skillraryDemo = new SkillraryDemoAppPage(driver);
	  selenium = new SeleniumTrainingPage(driver);
	  coreJava= new CoreJavaForSelenium(driver);
	  javaVideo = new CoreJavaVideoPage(driver);
	  testing = new TestingPage(driver);
	  contact = new ContactUsPage(driver);
	  
  }
  @AfterMethod
  public void methodTearDown()
  {
	  web.quitBrowser();
  }
  @AfterClass
  public void classTearDown()
  {
	  excel.closeExcel();
  }
 // @AfterTest
  //@AfterSuite
}
