package exercise2.POM;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeProductPage extends DemoBlazeGeneralPage{
	By _AddToCartXPath = By.xpath("//*[@id=\'tbodyid\']/div[2]/div/a");

	
	public DemoBlazeProductPage(SetWebDriver driver) {
        super(driver);
    }
    public void OnClickElementAddToCart() {
    	WebElement _OnClickElementAddToCart = WaitElementByLocator(_AddToCartXPath);
	    
	    if (_OnClickElementAddToCart != null) {
	    	_OnClickElementAddToCart.click();
	    }
    }

}
