package com.auspost.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostagePage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	public PostagePage(WebDriver driver) {
		super(driver);
	}

	public String getHeading() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("title-div")));
		return driver.findElement(By.tagName("title-div")).findElement(By.tagName("h1")).getText();
	}

	public void enterFromPostCodeAndSelectSuburb(String postCode,String suburb) {
		By domFrom = By.id("domFrom_value");
		wait.until(ExpectedConditions.visibilityOfElementLocated(domFrom));
		driver.findElement(domFrom).clear();
		driver.findElement(domFrom).sendKeys(postCode);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("angucomplete-dropdown-wrapper")));
		List <WebElement> suburbs = driver.findElements(By.className("angucomplete-row-wrapper"));
		for (WebElement element: suburbs) {
			if (element.getText().equalsIgnoreCase(suburb)) {
				element.click();
				break;
			}
		}
	}

	public void enterToPostCodeAndSelectSuburb(String postCode,String suburb) {
		By domTo = By.id("domTo_value");
		wait.until(ExpectedConditions.visibilityOfElementLocated(domTo));
		driver.findElement(domTo).clear();
		driver.findElement(domTo).sendKeys(postCode);

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("angucomplete-dropdown-wrapper")));
		List <WebElement> suburbs = driver.findElements(By.className("angucomplete-row-wrapper"));
		for (WebElement element: suburbs) {
			if (element.getText().equalsIgnoreCase(suburb)) {
				element.click();
				break;
			}
		}
	}

	public PostageDetailsPage clickGoButton() {
		driver.findElement(By.id("submit-domestic")).click();
		return new PostageDetailsPage(driver);
	}


}
