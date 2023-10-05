package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class GoogleResultPage extends AbstractPage{
	public GoogleResultPage(SetWebDriver driver) {
		super(driver);
	}

	By allResults = By.className("yuRUbf");
	
	public void ClickOnNResult(int n) {
		WebElement _clickNElement = WaitElementByLocator(allResults);
		WebElement _click = _clickNElement;
		if(_clickNElement != null) {
			_click.click();
		}
	}
}
