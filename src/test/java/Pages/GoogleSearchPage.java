package Pages;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

			for (int i = 0; i < _string.length(); i++) {
				char c = _string.charAt(i);
				String s = new StringBuilder().append(c).toString();
				_inputFieldElement.sendKeys(s);
			}
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

	public List<WebElement> WebElementList(By _by) {
		List<WebElement> listElements = webDriver.getWebDriver().findElements(By.xpath("//ul[@role='listbox']/li"));

		List<WebElement> _filteredElements = new ArrayList<>();
		System.out.println("aaaaaa");
		for (WebElement element : listElements) {
			String classes = element.getAttribute("class");
			String role = element.getAttribute("role");
			if ((classes.contains("sbct") || classes.contains("sbct sbre")) && "presentation".equals(role)) {
				_filteredElements.add(element);
				
			}
			 _filteredElements.clear();
		}
		return _filteredElements;
	}
	
	public void CompareList(List<WebElement> _list1,List<WebElement> _list2) {
		for (WebElement elemento1 : _list1) {
		    for (WebElement elemento2 : _list2) {
		        Assert.assertNotEquals(elemento1.getText(), elemento2.getText(), "Se encontró un elemento equivalente"+elemento1.getText()+elemento2.getText());
		    }
		}
	}
}
