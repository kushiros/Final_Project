package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class GoogleResultPage extends AbstractPage{
	public GoogleResultPage(SetWebDriver driver) {
		super(driver);
	}

	By allResults = By.className("yuRUbf");
	
	public void ClickOnNResult() {
		WebElement _clickNElement = WaitElementByLocator(allResults);
	
		if(_clickNElement != null) {
			_clickNElement.click();
		}
	}
}
