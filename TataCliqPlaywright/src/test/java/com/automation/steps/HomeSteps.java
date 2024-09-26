package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens website")
    public void userOpensWebsite() {
        homePage.openWebsite();
        homePage.closePopUp();
    }

    @Then("verify user is on homepage")
    public void verifyUserIsOnHomepage() {
        assertThat(homePage.isHomePageDisplayed());
    }

    @When("user search an item {string} in search bar")
    public void userSearchAnItemInSearchBar(String item) {
        homePage.searchItem(ConfigReader.getConfigValue(item));
    }

}
