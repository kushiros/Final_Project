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

	SetWebDriver _webDriver;
	DemoBlazeHomePage _DemoblazeHomePage;
	DemoBlazeProductPage _DemoblazeProductPage;
	DemoBlazeCartPage _DemoblazeCartPage;

	@Given("As a user I am on {string}")
	public void as_a_user_i_am_on(String string) throws IOException {
		_webDriver = new SetWebDriver();
		_DemoblazeHomePage = new DemoBlazeHomePage(_webDriver);
		_DemoblazeProductPage = new DemoBlazeProductPage(_webDriver);
		_DemoblazeCartPage = new DemoBlazeCartPage(_webDriver);
	}

	@When("I click on the product with ID {string}")
	public void i_click_on_the_product_with_id(String idString) {
		int id = Integer.parseInt(idString);
		_DemoblazeHomePage.ClickOnElementID(id);
	}

	@Then("I go to the product details page")
	public void i_go_to_the_product_details_page() {

	}

	@When("I click on the Add to Cart button")
	public void i_click_on_the_button() {
		_DemoblazeProductPage.generalClick(_DemoblazeProductPage.GetAddToCart());
		_DemoblazeProductPage.checkAlert();
	}

	@Then("I go to the Cart Page")
	public void i_go_to_the_cart_page() {
		_DemoblazeProductPage.generalClick(_DemoblazeProductPage.GetCartBy());
	}

	@When("I click on {string} and fill in the data {string} {string}:")
	public void i_click_on_and_fill_in_the_data(String string, String name, String creditCard) {
		_DemoblazeCartPage.generalClick(_DemoblazeCartPage.GetPlaceOrderBy());
		_DemoblazeCartPage.SetName(name);
		_DemoblazeCartPage.SetCreditCard(creditCard);
	}

	@When("I click on {string}")
	public void i_click_on(String string) {
		_DemoblazeCartPage.generalClick(_DemoblazeCartPage.GetPurchaseBy());
	}

	@Then("I compare the data")
	public void i_compare_the_data() {
		_DemoblazeCartPage.checkData();
	}

	@After
	public void closeBrowser() {
		_webDriver.getWebDriver().quit();
	}

	@When("I want to buy the following products:")
	public void i_add_the_selected_products_to_the_cart(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : data) {
			String productId = row.get("ProductId");
			String[] productIdArray = productId.split(",\\s*");
			for (String _productId : productIdArray) {
				int id = Integer.parseInt(_productId.trim());
				_DemoblazeHomePage.ClickOnElementID(id);

				_DemoblazeProductPage.generalClick(_DemoblazeProductPage.GetAddToCart());
				_DemoblazeProductPage.checkAlert();
				_DemoblazeProductPage.generalClick(_DemoblazeProductPage.GetHomeLogoBy());
			}
		}

	}

}
