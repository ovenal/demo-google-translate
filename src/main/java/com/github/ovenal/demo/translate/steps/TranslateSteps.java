package com.github.ovenal.demo.translate.steps;

import com.github.ovenal.demo.translate.pages.TranslatePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class TranslateSteps extends ScenarioSteps {
    // this field will be initiated by Thucydides itself
    private TranslatePage translatePage;

    @Step
    public void set_text_to_search_via_clipboard(String text) {
        translatePage.setFocusToSourceField();
        setTextToClipboard(text);
        pasteTextFromClipboard();
    }

    @Step
    public void switch_to_polish() {
        translatePage.switchTranslateLanguageToPolish();
    }

    @Step
    public void translate() {
        translatePage.clickTranslateButton();
    }

    @Step
    public void should_see_translated_text(String expectedTranslation) {
        assertEquals("Wrong translated text", expectedTranslation, translatePage.getTranslatedText());
    }

    private void setTextToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void pasteTextFromClipboard() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
        } catch (AWTException e) {
            throw new AssertionError("An exception occurred during pasting text from clipboard", e);
        }
    }
}
