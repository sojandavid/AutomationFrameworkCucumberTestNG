package com.anhtester.projects.website.anhtester.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class AnhTesterClientsPage {

    public By overViewTab = By.xpath("//a[text()='Overview']");

    public boolean isOnClientsPage() {
        return WebUI.verifyElementVisible(overViewTab);
    }

    public void waitForClientsPage() {
        WebUI.waitForPageLoaded();
        isOnClientsPage();
    }

}
