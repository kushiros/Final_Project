package Tests;

import org.testng.annotations.Test;

import Pages.GoogleResultPage;
import Pages.GoogleSearchPage;
import Pages.StoreSteamPoweredPage;
import chromedriver.SetWebDriver;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Tests {
	SetWebDriver webDriver;
	GoogleSearchPage googleSearchPage;
	GoogleResultPage googleResultPage;
	StoreSteamPoweredPage storeSteamPoweredPage;

	By autoLocator= By.cssSelector("[jsaction=\"click:.CLIENT;mouseover:.CLIENT\"]");
	
  @Test
  public void f() throws InterruptedException {
	  
	  googleSearchPage.SendKeysOnInput("auto");
	  googleSearchPage.GetWebDriver().until(ExpectedConditions.visibilityOfElementLocated(autoLocator));
	  
	  List<String> _autolist = new ArrayList<>();
	  _autolist = googleSearchPage.WebElementList(autoLocator);
	  googleSearchPage.clearInput();
	  
	  googleSearchPage.GetWebDriver().until(ExpectedConditions.visibilityOfElementLocated(autoLocator));
	  
	  googleSearchPage.SendKeysOnInput("automation");
	  
	  List<String> _automationlist = new ArrayList<>();


	  _automationlist = googleSearchPage.WebElementList(autoLocator);
	  googleSearchPage.GetWebDriver().until(ExpectedConditions.visibilityOfElementLocated(autoLocator));
	  
	 
	  
	 for(String _Auto : _autolist) {
		  Reporter.log("_auto tiene un elemento: "+_Auto);
	  }
	  for(String _automation : _automationlist) {
		  Reporter.log("_automation tiene un elemento: "+_automation);
	  }
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
	  webDriver.getWebDriver().quit();
  }

}

