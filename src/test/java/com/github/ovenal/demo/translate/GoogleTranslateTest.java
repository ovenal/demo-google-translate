package com.github.ovenal.demo.translate;

import com.github.ovenal.demo.translate.steps.SearchSteps;
import com.github.ovenal.demo.translate.steps.TranslateSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(ThucydidesRunner.class)
public class GoogleTranslateTest {
    private String textToSearch = "google translate";
    private String textToTranslate = "my test task";
    private String expectedTranslation = "zadaniem testu";

    @Managed
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    private SearchSteps search;

    @Steps
    private TranslateSteps translate;

    @Title("Simple test to demonstrate coding skills using Google services")
    @Test
    public void testGoogleTranslate() {
        search.open();
        search.search(textToSearch);
        search.should_see_link_to_google_translate();
        search.open_google_translate_in_another_session();
        translate.set_text_to_search_via_clipboard(textToTranslate);
        translate.switch_to_polish();
        translate.translate();
        translate.should_see_translated_text(expectedTranslation);
    }
}
