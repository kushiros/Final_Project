package exercise2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeHomePage extends DemoBlazeGeneralPage {
	String BlazeURL = "https://www.demoblaze.com/index.html";
    By ClickOnNotebook = By.cssSelector("a#itemc[onclick=\"byCat('notebook')\"]");
    By clickOnIdProduct = By.cssSelector("[href=\"prod.html?idp_=15\"]");
    int idProduct = 1;
	
	public DemoBlazeHomePage(SetWebDriver driver) {
		super(driver);
        SetUpPage(BlazeURL);
	}
    public void OnClickNoteBookTest() {
    	
        WebElement _onClickElement = WaitElementByLocator(ClickOnNotebook);
        if (_onClickElement != null) {
            _onClickElement.click();
        }
        
        
    }
    
    public void ClickOnElementID(int _id) {
    	idProduct=_id;
    	String _newByID = "[href=\'prod.html?idp_="+_id+"\']";
    	By _newID = By.cssSelector(_newByID);
    	WebElement _onClickElement = WaitElementByLocator(_newID);
    	_onClickElement.click();
    }
    
    public int getIdProduct() {
    	return idProduct;
    }
	
}
