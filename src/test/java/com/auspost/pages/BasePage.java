package com.auspost.pages;

import com.auspost.GlobalHooks;
import org.openqa.selenium.WebDriver;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = GlobalHooks.globalDriver;
	}

	public PostagePage navigateTo() {
		driver.get("https://auspost.com.au/parcels-mail/calculate-postage-delivery-times/#/");
		return new PostagePage(driver);
	}
}
