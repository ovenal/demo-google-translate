package com.github.ovenal.demo.translate.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class TranslatePage extends PageObject {
    @FindBy(id = "source")
    private WebElementFacade fieldSource;

    @FindBy(id = "result_box")
    private WebElementFacade fieldResult;

    @FindBy(xpath = "//div[contains(@class, 'goog-menuitem-content') and .='Polish']")
    private WebElementFacade labelLanguagePolish;

    @FindBy(css = "div.goog-flat-menu-button-dropdown")
    private WebElementFacade dropdownLanguage;

    @FindBy(id = "gt-submit")
    private WebElementFacade buttonTranslate;

    public void setFocusToSourceField() {
        fieldSource.setWindowFocus();
    }

    public String getTranslatedText() {
        return fieldResult.getText();
    }

    public void switchTranslateLanguageToPolish() {
        dropdownLanguage.click();
        labelLanguagePolish.waitUntilVisible();
        labelLanguagePolish.click();
    }

    public void clickTranslateButton() {
        buttonTranslate.click();
    }

}