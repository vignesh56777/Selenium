package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class FirstTest extends BaseClass
{
	//first test
  @Test
  public void firstTest()
  {
	  SoftAssert soft = new SoftAssert();
	  
	  home.clickGears();
	  home.clickSkillrarydemoApp();
	  web.handleChildBrowser();
	  
	  soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
	  skillraryDemo.mouseHoverTocourse(web);
	  skillraryDemo.clickSeleniumTraining();
	  
	  soft.assertEquals(selenium.getPageHeader(), "selenium Training");
	  selenium.doubleClickPlusButton(web);
	  selenium.clickAddToCart();
	  web.handleAlert();
	  web.explicitWait(time, selenium.getItemAddedMessage());
      soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
      
      soft.assertAll();
  }
}
