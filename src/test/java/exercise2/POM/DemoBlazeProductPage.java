package exercise2.POM;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeProductPage extends DemoBlazeGeneralPage {
	By addToCart = By.cssSelector("[class=\"btn btn-success btn-lg\"]");

	public DemoBlazeProductPage(SetWebDriver driver) {
		super(driver);
	}

	

	public By GetAddToCart() {
		return addToCart;
	}

}
