package exercise2.POM;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import chromedriver.SetWebDriver;

public class DemoBlazeGeneralPage extends AbstractPage{
	By homeLogo = By.cssSelector("[href=\"index.html\"]");
	By cart = By.cssSelector("[id=\"cartur\"]");
	List<String> optionList = new ArrayList<>();
	public DemoBlazeGeneralPage(SetWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
    public By GetCartBy() {
    	return cart;
    }
    
    public By GetHomeLogoBy() {
    	return homeLogo;
    }

}
