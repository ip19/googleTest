package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Slf4j
public class GoogleSearchPage {

    //Main elements
    private SelenideElement googleSearchField = $("input[name=\"q\"]");
    private SelenideElement googleSearchButton = $(".lsbb input[type=\"button\"]");
    private ElementsCollection googleSearchTitles = $$(".LC20lb");
    private ElementsCollection googleDetectedLinks = $$(".TbwUpd .iUh30");
    private ElementsCollection googleSwitchPages = $$("#xjs a.fl");
    //Secondary elements
    private SelenideElement firstSiteTitle = $("#firstHeading");


    @Step
    public GoogleSearchPage open() {
        log.info("Navigation to main page");
        return Selenide.open(baseUrl, GoogleSearchPage.class);
    }

    @Step
    public GoogleSearchPage searchFor(String text) {
        log.info("Searching for entered word and click on search button");
        googleSearchField.append(text);
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

        String Green = "\u001B[32m";
        String Red = "\u001B[31m";
        String Default = "\u001B[0m";

        for (int i = 0; i < buttonAmount; i++) {
            Integer value = googleDetectedLinks.filterBy(text(domainName)).size();
            if (value == 1) {
                log.info(Green + "Element is found on page - " + (i + 1) + Default);
            } else {
                log.info(Red + "Element isn't found on page - " + (i + 1) + Default);
            }
            googleSwitchPages.get(i).scrollTo().click();
        }
        return this;
    }
}
