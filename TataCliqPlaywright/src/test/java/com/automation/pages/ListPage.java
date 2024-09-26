package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPage extends BasePage{

    List<Locator> titleList;
    Locator headingText;

    Locator sortButton;
    List<Locator> priceList;

    public ListPage(){
        titleList = page.locator("//div[@class='ProductModule__content']/div/div/h2").all();
        headingText = page.locator("span.Plp__camelCase");

        sortButton = page.locator(".SelectBoxDesktop__hideSelect");
        priceList = page.locator("//div[@class='ProductDescription__discount ProductDescription__priceHolder']/h3").all();
    }


    public Locator isListPageHeadingDisplayed() {
        return headingText;
    }

    public void clickFirstProduct() {

        titleList = page.locator("//div[@class='ProductModule__content']/div/div/h2").all();
        Locator title = page.locator("//div[@class='ProductModule__content']/div/div/h2").first();

        System.out.println(title.textContent());

        System.out.println(titleList.size() + "1111111111111111111");
        ConfigReader.setConfigValue("product.name", title.textContent());

        Page newPage = page.waitForPopup(title::click);

    }



    public Locator isProductListPageDisplayed() {
        return sortButton;
    }

    public void sortPriceHighToLow() {
        sortButton.click();
        sortButton.selectOption("Price Low to High");    }



    public boolean isPriceHighToLowSorted() {
        List<Double> newPriceList = new ArrayList<>();

        for (Locator price : priceList) {
            String str = price.textContent();
            newPriceList.add(Double.valueOf(str.substring(1)));

        }
        List<Double> copyPriceList = new ArrayList<>(newPriceList);
        Collections.sort(copyPriceList);
        Collections.reverse(copyPriceList);

        return newPriceList.equals(copyPriceList);
    }

    public void sortPriceLowToHigh() {
        sortButton.click();
        sortButton.selectOption("Price High to Low");
    }

    public boolean isPriceLowToHighSorted() {
        List<Double> newPriceList = new ArrayList<>();

        for (Locator price : priceList) {
            String str = price.textContent();
            newPriceList.add(Double.valueOf(str.substring(1)));

        }
        List<Double> copyPriceList = new ArrayList<>(newPriceList);
        Collections.sort(copyPriceList);

        return newPriceList.equals(copyPriceList);
    }



}
