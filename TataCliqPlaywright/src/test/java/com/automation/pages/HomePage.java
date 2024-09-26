package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    FrameLocator popupIframe;
    Locator closeBtn;
    Locator askMeLater;
    Locator bannerBase;
    Locator searchBox;

    public HomePage(){
        popupIframe = page.frameLocator("#wiz-iframe");
        closeBtn = popupIframe.locator("//div[@class='wzrkPPwarp']/a");
        askMeLater = page.locator("button.No.thanks");
        bannerBase = page.locator("div.BannerDesktop__base");
        searchBox = page.locator("#search-text-input");
    }


    public void openWebsite() {
        page.navigate(ConfigReader.getConfigValue("website.url"));
    }

    public void closePopUp() {
        closeBtn.click();
        askMeLater.click();
    }

    public Locator isHomePageDisplayed() {
        return bannerBase;
    }

    public void searchItem(String item) {
        searchBox.fill(item);
        searchBox.press("Enter");
    }

}
