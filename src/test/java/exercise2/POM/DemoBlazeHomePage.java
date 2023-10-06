package exercise2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeHomePage extends DemoBlazeGeneralPage {
	String BlazeURL = "https://www.demoblaze.com/index.html";
	By _ClickOnMacBookXPath = By.xpath("//*[@id='tbodyid']/div[6]/div/a/img");
    By _ClickOnNotebook = By.cssSelector("a#itemc[onclick=\"byCat('notebook')\"]");
    By _BannerElement = By.cssSelector("img.d-block[src=\"Samsung1.jpg\"]");
	
	public DemoBlazeHomePage(SetWebDriver driver) {
		super(driver);
        SetUpPage(BlazeURL);
	}
    public void OnClickNoteBookTest() {
    	
        WebElement _OnClickElement = WaitElementByLocator(_ClickOnNotebook);
        if (_OnClickElement != null) {
            _OnClickElement.click();
        }
        
        
    }
    public void OnClickElementMacBookPro() {
    	WebElement _OnClickElementMacbookPro =  WaitElementByLocator(_ClickOnMacBookXPath);
        
	    if (_OnClickElementMacbookPro != null) {
	    	_OnClickElementMacbookPro.click();
	    }
	    
    }
	
}
