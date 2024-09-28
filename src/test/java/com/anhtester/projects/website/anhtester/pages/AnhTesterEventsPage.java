package com.anhtester.projects.website.anhtester.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class AnhTesterEventsPage {

    public By eventsTitle = By.xpath("//h1[text()='Event calendar']");

    public boolean isOnEventsPage() {
//        System.out.println("I'm on dashboard");
        return WebUI.verifyElementVisible(eventsTitle);
    }

    public void waitForEventsPage() {
        WebUI.waitForPageLoaded();
        isOnEventsPage();
    }

}
