package com.github.ovenal.demo.translate.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

// we should force Google not to switch language
// to avoid problem with user locale (as soon as we use text for element search)
@DefaultUrl("https://www.google.com/ncr")
public class SearchPage extends PageObject {

    @FindBy(id = "gbqfq")
    private WebElementFacade fieldSearch;

    @FindBy(id = "gbqfb")
    private WebElementFacade buttonSearch;

    public void setSearchCriterion(String keyword) {
        fieldSearch.type(keyword);
    }

    public void clickSearchButton() {
        buttonSearch.click();
    }
}