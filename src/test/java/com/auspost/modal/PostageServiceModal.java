package com.auspost.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PostageServiceModal {
	
	protected WebElement element;

	public PostageServiceModal(WebElement element) {
		this.element = element;
	}

	public String getName() {
		return element.findElement(By.className("postage-service__section__name-label")).getText();
	}
	
	public String getCost() {
		return element.findElement(By.className("postage-service__section__price")).getText();
	}
}
