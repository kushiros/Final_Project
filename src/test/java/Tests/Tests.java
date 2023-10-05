package Tests;

import org.testng.annotations.Test;

import Pages.GoogleResultPage;
import Pages.GoogleSearchPage;
import Pages.StoreSteamPoweredPage;
import chromedriver.SetWebDriver;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterTest;

public class Tests {
	SetWebDriver webDriver;
	GoogleSearchPage googleSearchPage;
	GoogleResultPage googleResultPage;
	StoreSteamPoweredPage storeSteamPoweredPage;
	By classNameImage= By.xpath("//ul[@role='listbox']/li");
  @Test
  public void f() throws InterruptedException {
	  
	  googleSearchPage.SendKeysOnInput("auto");
	  List<WebElement> _autolist = googleSearchPage.WebElementList(classNameImage);
	  googleSearchPage.clearInput();
	  googleSearchPage.SendKeysOnInput("automation");
	  List<WebElement> _automationlist = googleSearchPage.WebElementList(classNameImage);
	  googleSearchPage.CompareList(_autolist, _automationlist);
	  googleSearchPage.ClickOnElementWithImage();
	  googleResultPage.ClickOnNResult();
	  storeSteamPoweredPage.confirmActualURL();
	  

  }
  @BeforeTest
  public void beforeTest() throws IOException {
	  webDriver = new SetWebDriver();
	  webDriver.getWebDriver().manage().window().maximize();
	  googleSearchPage = new GoogleSearchPage(webDriver);
	  googleResultPage = new GoogleResultPage(webDriver);
	  storeSteamPoweredPage = new StoreSteamPoweredPage(webDriver);
	  
  }

  @AfterTest
  public void afterTest() {
  }

}

