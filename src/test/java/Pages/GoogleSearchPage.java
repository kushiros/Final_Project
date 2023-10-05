package Pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import chromedriver.SetWebDriver;

public class GoogleSearchPage extends AbstractPage {

	String googleURL = "https://www.google.com/";
	By inputField = By.className("gLFyf");
	By firstImage = By.className("sbre");

	public GoogleSearchPage(SetWebDriver driver) {
		super(driver);
		SetUpPage(googleURL);
	}

	public void SendKeysOnInput(String _string) {

		WebElement _inputFieldElement = WaitElementByLocator(inputField);
		if (_inputFieldElement != null) {
			_inputFieldElement.clear();
			_inputFieldElement.sendKeys(_string);

		}
	}
	
	public void clearInput() {

		WebElement _inputFieldElement = WaitElementByLocator(inputField);
		if (_inputFieldElement != null) {
			_inputFieldElement.clear();
		}

	}

	public void ClickOnElementWithImage() {
		WebElement _inputFieldElement = WaitElementByLocator(firstImage);
		if (_inputFieldElement != null) {
			_inputFieldElement.click();
		}
	}

	public List<String> WebElementList(By _by) {
		List<WebElement> listElements = webDriver.getWebDriver().findElements(_by);
		List<String> _filteredElements = new ArrayList<>();
		for (WebElement element : listElements) {
			_filteredElements.add(element.getText());
			
		}
		
		
		return _filteredElements;
	}
	
	public void CompareList(List<String> _list1,List<String> _list2) {
		for (String elemento1 : _list1) {

		    for (String elemento2 : _list2) {

		        Assert.assertNotEquals(elemento1, elemento2, "Se encontró un elemento equivalente"+elemento1+elemento2);
		    }
		}

	}
}
