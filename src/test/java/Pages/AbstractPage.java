package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import chromedriver.SetWebDriver;

public abstract class AbstractPage {
	SetWebDriver webDriver;
	Wait<WebDriver> wait;

	public AbstractPage(SetWebDriver driver) {

		webDriver = driver;

	}

	public void SetUpPage(String URL) {

		webDriver.SetUrl(URL);

	}

	public Wait<WebDriver> GetWebDriver() {
		wait = new FluentWait<>(webDriver.getWebDriver()).withTimeout(Duration.ofMillis(10000))
				.pollingEvery(Duration.ofMillis(1000)).ignoring(org.openqa.selenium.NoSuchElementException.class);
		return wait;
	}

	public SetWebDriver GetSetWebDriver() {
		return webDriver;
	}

	public WebElement WaitElementByLocator(final By _byLocator) {

		WebElement _WaitElementyXpathVariable = GetWebDriver().until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement _element = driver.findElement(_byLocator);
				if (_element.isDisplayed() && _element.isEnabled()) {
					return _element;
				} else {
					return null;
				}
			}
		});
		return _WaitElementyXpathVariable;

	}




	public WebDriverWait getExplicitWait() {
		WebDriverWait wait = new WebDriverWait(webDriver.getWebDriver(), Duration.ofMillis(4000));
		return wait;
	}
	
	
}
