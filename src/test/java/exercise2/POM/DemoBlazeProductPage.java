package exercise2.POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import chromedriver.SetWebDriver;

public class DemoBlazeProductPage extends DemoBlazeGeneralPage {
	By addToCart = By.cssSelector("[class=\"btn btn-success btn-lg\"]");
	By nameProduct = By.cssSelector("[class=\"name\"]");
	List<String> optionList = new ArrayList<>();

	public DemoBlazeProductPage(SetWebDriver driver) {
		super(driver);
	}

	

	public By GetAddToCart() {
		return addToCart;
	}
	
	public String getNameOfProduct() {
		
		return WaitElementByLocator(nameProduct).getText();
	}
	
	public void addList(String addToString) {
		optionList.add(addToString);
	}
	public List<String> getStringList(){
		return optionList;
	}

}
