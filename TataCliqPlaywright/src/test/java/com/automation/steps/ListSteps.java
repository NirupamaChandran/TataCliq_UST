package com.automation.steps;

import com.automation.pages.ListPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ListSteps {

    ListPage listPage = new ListPage();


    @Then("verify {string} listing page is displayed")
    public void verifyListingPageIsDisplayed(String item) {
        assertThat(listPage.isListPageHeadingDisplayed()).toString().toLowerCase().equals(ConfigReader.getConfigValue(item).toLowerCase());
    }

    @When("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        listPage.clickFirstProduct();
    }


    @Then("verify whether product list page is displayed")
    public void verifyWhetherProductListPageIsDisplayed() {
        assertThat(listPage.isProductListPageDisplayed());
    }


    @And("user sort price high to low")
    public void userSortPriceHighToLow() throws InterruptedException {
        listPage.sortPriceHighToLow();
    }

    @Then("verify whether product list is sorted high to low")
    public void verifyWhetherProductListIsSortedHighToLow() {
        listPage.isPriceHighToLowSorted();
    }


    @And("user sort price low to high")
    public void userSortPriceLowToHigh() throws InterruptedException {
        listPage.sortPriceLowToHigh();
    }

    @Then("verify whether product list is sorted low to high")
    public void verifyWhetherProductListIsSortedLowToHigh() {
        listPage.isPriceLowToHighSorted();
    }

}
