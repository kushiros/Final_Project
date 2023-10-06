package exercise2.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeCartPage extends DemoBlazeGeneralPage{
	public DemoBlazeCartPage(SetWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String expectedTotal = "";
	By productListID = By.cssSelector("tbody#tbodyid tr.success td:nth-child(3)");
    By purchase = By.cssSelector("[onclick=\'purchaseOrder()\']");
    By ok = By.cssSelector("[class=\'confirm btn btn-lg btn-primary\']");

    public void UpdateExpectedTotal() {
    	List<WebElement> _productsList = webDriver.getWebDriver().findElements(productListID);
    	int _expectedTotal = 0;
    	for(WebElement product : _productsList) {
    		 String value = product.getText();

    		 _expectedTotal += Integer.parseInt(value);
    	}
    	expectedTotal =String.valueOf(_expectedTotal);
    	
    }
    
    public By GetOkBy() {
    	return ok;
    }
    
    public By GetPurchaseBy() {
    	return purchase;
    }
    
    

}
