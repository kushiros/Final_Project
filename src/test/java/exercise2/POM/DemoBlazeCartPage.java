package exercise2.POM;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeCartPage extends DemoBlazeGeneralPage{
	public DemoBlazeCartPage(SetWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String expectedTotal = "";
	String name ="";
	String creditCard ="";
	String ListOfProducts = "//td[contains(text(),'Nokia lumia 1520')]";
	By productListID = By.cssSelector("tbody#tbodyid tr.success td:nth-child(3)");
	By placeOrder = By.cssSelector("[data-target=\"#orderModal\"]");
    By purchase = By.cssSelector("[onclick=\'purchaseOrder()\']");
    By ok = By.cssSelector("[class=\'confirm btn btn-lg btn-primary\']");
    By checkData = By.cssSelector("[class=\'lead text-muted \']");

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
    public By GetPlaceOrderBy() {
    	return placeOrder;
    }
    
    public void SetName(String _name) {
    	WaitElementByLocator(By.cssSelector("[id='name']")).sendKeys(_name);
    	name=_name;
    }
    
    public void SetCreditCard(String _creditCard) {
    	WaitElementByLocator(By.cssSelector("[id=\"card\"]")).sendKeys(_creditCard);
    	creditCard = _creditCard;
    }
    
    public void checkData() {
    	String _checkData = WaitElementByLocator(checkData).getText();
    	Assert.assertTrue(_checkData.contains(expectedTotal));
    	Assert.assertTrue(_checkData.contains(name));
    	Assert.assertTrue(_checkData.contains(creditCard));
    }
    
    public void CheckProducts(List<String> string) {
    	String checkString="//td[contains(text(),'Sony vaio i7')]";
    	for(String element : string) {
    		checkString = "//td[contains(text(),'"+element+"')]";
    		By xpathProduct = By.xpath(checkString);
    		WebElement ElementProduct = WaitElementByLocator(xpathProduct);
    		Assert.assertTrue(ElementProduct.getText().contains(element));
    	}
    }
    
    

}
