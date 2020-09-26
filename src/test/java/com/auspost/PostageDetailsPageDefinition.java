package com.auspost;

import com.auspost.datatable.PostService;
import com.auspost.modal.PostageServiceModal;
import com.auspost.pages.PostageDetailsPage;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostageDetailsPageDefinition {

    WebDriver driver;
    PostageDetailsPage detailsPage;

    @When("^the postage details page is loaded with heading \"([^\"]*)\"$")
    public void the_postage_details_page_is_loaded_with(String expectedHeading) throws Throwable {
        detailsPage = new PostageDetailsPage(driver);
        String actualHeading = detailsPage.getHeading();
        Assert.assertTrue("Verify Details Page Heading", actualHeading.contains(expectedHeading));
    }

    @When("^I click the link to enter size \"([^\"]*)\" and weight as (\\d+)$")
    public void i_click_the_link_to_enter_size_and_weight_as(String size, String weight) throws Throwable {
        detailsPage = new PostageDetailsPage(driver);
        detailsPage.clickLinkToSetSizeAndWeight();
        String[] dimensions = size.split(":");
        detailsPage.setSizeAndWeight(dimensions[0], dimensions[1], dimensions[2], weight);
        detailsPage.clickSetSizeAndWeightButton();
    }

    @When("^I click the link to enter a (\\d+) days later delivery$")
    public void i_click_the_link_to_enter_a_days_later_delivery(int days) throws Throwable {
        detailsPage = new PostageDetailsPage(driver);
        detailsPage.clickLinkToEnterDeliveryDate();
        detailsPage.addALaterDateFromTodaysDate(days);
        detailsPage.clickSetDateButton();
    }


    @When("^verify details page contains the below services with cost$")
    public void verify_details_page_contains_the_below_services_with_cost(List<PostService> expectedPostServices) throws Throwable {
        detailsPage = new PostageDetailsPage(driver);
        List <PostageServiceModal> availableServices= detailsPage.getPostageServices();
        Map<String,String> availableServicesMap = new HashMap<String, String>();
        for (int i=0 ; i<availableServices.size();i++) {
            availableServicesMap.put(availableServices.get(i).getName(),availableServices.get(i).getCost());
        }
        Assert.assertTrue("The number of services does NOT match",expectedPostServices.size()==availableServices.size());
        for (PostService service: expectedPostServices) {
            Assert.assertTrue("Service "+service.getService() + "does not exist in",availableServicesMap.containsKey(service.getService()));
            Assert.assertTrue("Cost is not matching for the Service: "+service.getService(),availableServicesMap.get(service.getService()).equalsIgnoreCase(service.getCost()));
        }


    }

}