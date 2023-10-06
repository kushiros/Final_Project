package exercise2.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import exercise2.POM.DemoBlazeCartPage;
import exercise2.POM.DemoBlazeHomePage;
import exercise2.POM.DemoBlazeProductPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import chromedriver.SetWebDriver;

public class StepDefinition {

	SetWebDriver webDriver;
	DemoBlazeHomePage DemoblazeHomePage;
	DemoBlazeProductPage DemoblazeProductPage;
	DemoBlazeCartPage DemoblazeCartPage;

	@Given("As a user I am on {string}")
	public void as_a_user_i_am_on(String string) throws IOException {
		webDriver = new SetWebDriver();
		webDriver.getWebDriver().manage().window().maximize();
		DemoblazeHomePage = new DemoBlazeHomePage(webDriver);
		DemoblazeProductPage = new DemoBlazeProductPage(webDriver);
		DemoblazeCartPage = new DemoBlazeCartPage(webDriver);
	}



	@Then("I go to the Cart Page")
	public void i_go_to_the_cart_page() {
		DemoblazeProductPage.generalClick(DemoblazeProductPage.GetCartBy());
	}

	@When("I click on {string} and fill in the data {string} {string}:")
	public void i_click_on_and_fill_in_the_data(String string, String name, String creditCard) {
		DemoblazeCartPage.generalClick(DemoblazeCartPage.GetPlaceOrderBy());
		DemoblazeCartPage.SetName(name);
		DemoblazeCartPage.SetCreditCard(creditCard);
	}

	@When("I click on {string}")
	public void i_click_on(String string) {
		DemoblazeCartPage.generalClick(DemoblazeCartPage.GetPurchaseBy());
	}

	@Then("I should see the purchase information")
	public void i_compare_the_data() {
		DemoblazeCartPage.checkData();
	}

	@After
	public void closeBrowser() {
		webDriver.getWebDriver().quit();
	}

	@When("I want to buy the following products:")
	public void i_add_the_selected_products_to_the_cart(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : data) {
			String productId = row.get("ProductId");
			String[] productIdArray = productId.split(",");
			for (String _productId : productIdArray) {
				
				int id = Integer.parseInt(_productId.trim());
				if(id<=15) {
					if(id>9) {
						DemoblazeHomePage.GetNextProductPage();;
					}
					
					DemoblazeHomePage.ClickOnElementID(id);

					DemoblazeProductPage.generalClick(DemoblazeProductPage.GetAddToCart());
					DemoblazeProductPage.checkAlert();
					DemoblazeProductPage.generalClick(DemoblazeProductPage.GetHomeLogoBy());
				}
			}

		}

	}

}
