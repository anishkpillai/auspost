package com.auspost.pages;

import com.auspost.modal.PostageServiceModal;
import com.auspost.utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class PostageDetailsPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, 30);

    public PostageDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.postage-item")));
        return driver.findElement(By.cssSelector("div.postage-item")).findElement(By.tagName("h2")).getText();
    }

    public List<PostageServiceModal> getPostageServices() {
        List<PostageServiceModal> postageServices=new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postage-options")));
        List<WebElement> services  = driver.findElements(By.cssSelector("postage-service"));
        for (WebElement element: services) {
            PostageServiceModal service = new PostageServiceModal(element);
            postageServices.add(service);
        }
        return postageServices;
    }

    public void clickLinkToSetSizeAndWeight() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Enter size & weight")));
        driver.findElement(By.linkText("Enter size & weight")).click();
    }
    public void clickLinkToEnterDeliveryDate() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Enter a date")));
        driver.findElement(By.linkText("Enter a date")).click();
    }
    public void addALaterDateFromTodaysDate(int noOfDays) {
        By dateInputLocator = By.xpath("//input[@name='dateInput']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLocator));
        driver.findElement(dateInputLocator).clear();
        driver.findElement(dateInputLocator).sendKeys(Utilities.getALaterDateByDays(noOfDays));
    }

    public void clickSetSizeAndWeightButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-set-dimensions")));
        driver.findElement(By.id("submit-set-dimensions")).click();
    }

    public void clickSetDateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("set-date")));
        driver.findElement(By.id("set-date")).click();
    }

    public void setSizeAndWeight(String length, String width, String height, String weight) {
        By lengthInputLocator = By.xpath("//input[@name='lengthInput']");
        By widthInputLocator = By.xpath("//input[@name='widthInput']");
        By heightInputLocator = By.xpath("//input[@name='heightInput']");
        By weightInputLocator = By.xpath("//input[@name='weightInput']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lengthInputLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(widthInputLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(heightInputLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(weightInputLocator));

        driver.findElement(lengthInputLocator).sendKeys(length);
        driver.findElement(widthInputLocator).sendKeys(width);
        driver.findElement(heightInputLocator).sendKeys(height);
        driver.findElement(weightInputLocator).sendKeys(weight);
    }
}