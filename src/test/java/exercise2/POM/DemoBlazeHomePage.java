package exercise2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import chromedriver.SetWebDriver;

public class DemoBlazeHomePage extends DemoBlazeGeneralPage {
	String BlazeURL = "https://www.demoblaze.com/index.html";
    By clickOnIdProduct = By.cssSelector("[href=\"prod.html?idp_=15\"]");
    By nextProductPage = By.cssSelector("[id='next2']");
    int idProduct = 1;
    By visible = By.cssSelector("[src='imgs/HTC_M9.jpg']");
	
	public DemoBlazeHomePage(SetWebDriver driver) {
		super(driver);
        SetUpPage(BlazeURL);
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
    public void GetNextProductPage() {
    	WebElement _onClickElement = WaitElementByLocator(nextProductPage);
    	GetWebDriver().until(ExpectedConditions.visibilityOfElementLocated(visible));
    	_onClickElement.click();
    }
	
}
