package com.anhtester.projects.website.anhtester.pages;

import com.anhtester.common.CommonPageAnhTester;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;

public class AnhTesterDashboardPage extends CommonPageAnhTester {


    public By dashBoardTitle = By.xpath("//h4[text()='Dashboard']");
    public By eventsPageTab = By.xpath("//div/ul/li/a/span[text()='Events']");
    public By dashboardLogo = By.xpath("//img[@class='dashboard-image' and contains(@src,'site-logo')]");
    public By clientsPageTab = By.xpath("//div/ul/li/a/span[text()='Clients']");

    public boolean isOnDashboard() {
//        System.out.println("I'm on dashboard");
        return WebUI.verifyElementVisible(dashBoardTitle);
    }

    public void waitForDashboardPage() {
        WebUI.waitForPageLoaded();
        isOnDashboard();
    }

    public AnhTesterEventsPage goToAnhTesterEventsPage() {
        WebUI.clickElement(eventsPageTab);
        WebUI.waitForPageLoaded();
        return new AnhTesterEventsPage();
    }

    public void gotoAnhTesterDashboardPage() {
        WebUI.clickElement(dashboardLogo);
    }

    public AnhTesterClientsPage goToClientsPage() {
        WebUI.clickElement(clientsPageTab);
        WebUI.waitForPageLoaded();
        return new AnhTesterClientsPage();
    }

}
