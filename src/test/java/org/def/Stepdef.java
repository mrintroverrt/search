package org.def;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdef extends BaseClass {
	@Given("I launch the browser")
	public void i_launch_the_browser() {

		LaunchBrowser();
		System.out.println("Browser Lauched ..");

	}

	@Given("I navigate to the webpage URL")
	public void i_navigate_to_the_webpage_url() {
		LaunchURl("https://www.google.com/");

	}

	@When("I click the search icon")
	public void i_click_the_search_icon() {
		WebElement Search = driver.findElement(By.id("APjFqb"));
		clickBtn(Search);

	}

	@When("I enter {string} in the search field")
	public void i_enter_in_the_search_field(String string) {

		WebElement searchbox = driver.findElement(By.id("APjFqb"));
		String searchtext = "Selfmade Ninja";
		passText(searchtext, searchbox);

	}

	@When("I click the search button")
	public void i_click_the_search_button() {
		WebElement clicksearchbtn = driver.findElement(By.xpath("(//input[@value='Google Search'])[2]"));
		clickBtn(clicksearchbtn);

	}

	@Then("I print the text of the first search result link")
	public void i_print_the_text_of_the_first_search_result_link() {

		WebElement text = driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]"));
		String text1 = text.getText();
		System.out.println(text1);

	}

	@And("I close the browser")
	public void I_close_the_browser() {
		closeEntireBrowser();
	}
}
