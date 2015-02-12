package com.github.ovenal.demo.translate.steps;

import com.github.ovenal.demo.translate.pages.SearchPage;
import com.github.ovenal.demo.translate.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertTrue;

public class SearchSteps extends ScenarioSteps {
    // these fields will be initiated by Thucydides itself
    private SearchPage searchPage;
    private SearchResultPage resultPage;

    @Step
    public void open() {
        searchPage.open();
    }

    @Step
    public void search(String criterion) {
        searchPage.setSearchCriterion(criterion);
        searchPage.clickSearchButton();
    }

    @Step
    public void should_see_link_to_google_translate() {
        assertTrue("There is no link to Google Translate service that matches our criteria",
                resultPage.isGoogleTranslateLinkVisible());
    }

    @Step
    public void open_google_translate_in_another_session() {
        String url = resultPage.getGoogleTranslateLink();
        openNewWindowAndSwitchTo();
        getDriver().get(url);
    }

    private void openNewWindowAndSwitchTo() {
        ((JavascriptExecutor)getDriver()).executeScript("window.open()");
        getDriver().switchTo().window(getNewWindowHandle());
    }

    private String getNewWindowHandle() {
        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(getDriver().getWindowHandle())) {
                return handle;
            }
        }
        throw new AssertionError("There is no window handle different from " + getDriver().getWindowHandle());
    }
}
