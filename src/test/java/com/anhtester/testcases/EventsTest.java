/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.testcases;

import com.anhtester.common.BasePage;

import com.anhtester.keywords.WebUI;
import com.anhtester.projects.website.anhtester.pages.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.*;


@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class EventsTest extends BasePage {

    AnhTesterLoginPage anhTesterLoginPage;
    AnhTesterDashboardPage anhTesterDashboardPage;
    AnhTesterEventsPage anhTesterEventsPage;
    AnhTesterClientsPage anhTesterClientsPage;

    @BeforeClass()
    public void beforeClass() {
        anhTesterLoginPage = new AnhTesterLoginPage();
        anhTesterDashboardPage = anhTesterLoginPage.login();
        anhTesterDashboardPage.waitForDashboardPage();
    }

    @AfterClass()
    public void afterClass() {
//        anhTesterEventsPage = new AnhTesterEventsPage();
    }

    @BeforeMethod()
    public void beforeMethod() {
        System.out.println("I am on before method");
        anhTesterDashboardPage.gotoAnhTesterDashboardPage();
        anhTesterDashboardPage.waitForDashboardPage();
        anhTesterDashboardPage.isOnDashboard();
    }

    @AfterMethod()
    public void afterMethod() {
        System.out.println("I am on after method");
    }

    @Test(priority = 1)
    public void SignInAnhTesterWebsite() {
        WebUI.waitForPageLoaded();
        System.out.println("Welcome to Rise Anhtester");
    }

    @Test(priority = 2)
    public void goToEventPage() {
        anhTesterEventsPage = anhTesterDashboardPage.goToAnhTesterEventsPage();
        anhTesterEventsPage.waitForEventsPage();
        System.out.println("I am on Events Page");
    }

    @Test(priority = 3)
    public void goToEventPageTab1() {
        anhTesterEventsPage = anhTesterDashboardPage.goToAnhTesterEventsPage();
        anhTesterEventsPage.waitForEventsPage();
        System.out.println("I am on Events Page");
    }

    @Test(priority = 4)
    public void goToClientsPage() {
        anhTesterClientsPage = anhTesterDashboardPage.goToClientsPage();
        anhTesterClientsPage.waitForClientsPage();
        System.out.println("I am on Events Page");
    }

}
