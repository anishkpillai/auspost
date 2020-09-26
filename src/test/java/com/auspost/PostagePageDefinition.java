package com.auspost;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.auspost.pages.PostagePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class PostagePageDefinition {
	WebDriver driver;
	PostagePage postagePage;
	

	@Given("^the Australia Post Calculate Page$")
	public void the_Australia_Post_Calculate_Page() throws Throwable {
		postagePage = new PostagePage(driver);
		postagePage.navigateTo();
	}

	@Then("^verify heading has text \"([^\"]*)\"$")
	public void verify_heading_has_text (String expectedHeading) throws Throwable {
		postagePage = new PostagePage(driver);
		String actualHeading = postagePage.getHeading();
		Assert.assertTrue("Verify Post Page Heading", actualHeading.contains(expectedHeading));
	}

	@Then("^submit the form to calculate postage fee$")
	public void submit_the_form_to_calculate_postage_fee() throws Throwable {
		postagePage = new PostagePage(driver);
		postagePage.clickGoButton();
	}

	@Then("^enter the from postcode as \"([^\"]*)\" and select \"([^\"]*)\" from dropdown$")
	public void enter_the_from_postcode_as_and_select_from_dropdown(String postCode, String suburb) throws Throwable {
		postagePage = new PostagePage(driver);
		postagePage.enterFromPostCodeAndSelectSuburb(postCode,suburb);
	}

	@Then("^enter the to postcode as \"([^\"]*)\" and select \"([^\"]*)\" from dropdown$")
	public void enter_the_to_postcode_as_and_select_from_dropdown(String postCode, String suburb) throws Throwable {
		postagePage = new PostagePage(driver);
		postagePage.enterToPostCodeAndSelectSuburb(postCode,suburb);
	}
}
