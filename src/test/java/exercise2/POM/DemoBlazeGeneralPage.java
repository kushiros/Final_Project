package exercise2.POM;

import org.openqa.selenium.By;

import chromedriver.SetWebDriver;

public class DemoBlazeGeneralPage extends AbstractPage{
	By homeLogo = By.cssSelector("[href=\"index.html\"]");
	By cart = By.cssSelector("[id=\"cartur\"]");
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
