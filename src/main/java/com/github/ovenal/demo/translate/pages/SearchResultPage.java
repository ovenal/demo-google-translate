package com.github.ovenal.demo.translate.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class SearchResultPage extends PageObject {
    // this xpath-expression was written exactly to the requirements:
    // '3.	Open result page that is linked to "translate.google.com" ...'
    // I would choose more simple way to find the required link
    @FindBy(xpath = "//h3[following-sibling::div[@class='s']//div[starts-with(., 'translate.google.com/')]]//a")
    private WebElementFacade linkToGoogleTranslate;

    public boolean isGoogleTranslateLinkVisible() {
        return linkToGoogleTranslate.isVisible();
    }

    public String getGoogleTranslateLink() {
        return linkToGoogleTranslate.getAttribute("href");
    }

}
