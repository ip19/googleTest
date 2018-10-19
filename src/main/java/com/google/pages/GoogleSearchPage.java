package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.FindByXpath;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;

@Slf4j
public class GoogleSearchPage {

    //Main elements
    private SelenideElement googleSearchField = $("input[name=\"q\"]");
    private SelenideElement googleSearchButton = $(".lsbb input[type=\"button\"]");
    private ElementsCollection googleSearchTitles = $$(".LC20lb");
    private ElementsCollection googleDetectedLinks = $$(".TbwUpd .iUh30");
    private ElementsCollection googleSwitchPages = $$("#navcnt a.fl");
    //Secondary elements
    private SelenideElement firstSiteTitle = $("#firstHeading");


    @Step
    public GoogleSearchPage open() {
        log.info("Navigation to main page");
        return Selenide.open(baseUrl, GoogleSearchPage.class);
    }

    @Step
    public GoogleSearchPage searchForSomething(String text) {
        log.info("Searching for entered word");
        googleSearchField.append(text);
        return this;
    }

    @Step
    public GoogleSearchPage clickOnSearchButton() {
        log.info("Clicking on search button");
        googleSearchButton.click();
        return this;
    }

    @Step
    public GoogleSearchPage clickOnFirstDetectedLink() {
        log.info("Click on First link into list");
        googleSearchTitles.first().click();
        return this;
    }

    @Step
    public GoogleSearchPage verifyTitleIsCorrect(String text) {
        log.info("Title verification");
        firstSiteTitle.shouldHave(matchText(text));
        return this;
    }

    @Step
    public GoogleSearchPage verifyExpectedDomain(String domainName, Integer buttonAmount) {
        log.info("Domain verification");
        Integer expectedSize = 1;
        Integer domain = googleDetectedLinks.filter(text(domainName)).size();
        for (int i = 0; i < buttonAmount; i++) {
            googleSwitchPages.get(i).click();
        }
        assertEquals(expectedSize, domain);
        return this;
    }
}
