package Pages;


import org.junit.Assert;

import chromedriver.SetWebDriver;

public class StoreSteamPoweredPage extends AbstractPage{

	String expectedURL = "store.steampowered.com";
	public StoreSteamPoweredPage(SetWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void confirmActualURL() {
		String _actualURL = webDriver.getWebDriver().getCurrentUrl();
		Assert.assertTrue(_actualURL.contains(expectedURL));
	}
}
