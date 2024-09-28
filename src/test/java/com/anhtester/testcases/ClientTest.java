/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.testcases;

import com.anhtester.annotations.FrameworkAnnotation;
import com.anhtester.common.BaseTest;
import com.anhtester.dataprovider.DataProviderManager;
import com.anhtester.enums.AuthorType;
import com.anhtester.enums.CategoryType;
import com.anhtester.projects.website.crm.pages.Clients.ClientPageCRM;
import com.anhtester.projects.website.crm.pages.Dashboard.DashboardPageCRM;
import com.anhtester.projects.website.crm.pages.SignIn.SignInPageCRM;
import com.anhtester.keywords.WebUI;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test CRM")
@Feature("Clients Test")
public class ClientTest extends BaseTest {

    public SignInPageCRM signInPage;
    public DashboardPageCRM dashboardPage;
    public ClientPageCRM clientPage;

    public ClientTest() {
        signInPage = new SignInPageCRM();
    }

    @FrameworkAnnotation(author = {AuthorType.AnhTester},
            category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 1, dataProvider = "getClientDataHashTable", dataProviderClass = DataProviderManager.class)
    @Step("Add new Client")
    public void testAddClient(Hashtable<String, String> data) {
        dashboardPage = signInPage.signInWithAdminRole();
        clientPage = dashboardPage.openClientPage();
        clientPage.openClientTabPage();
        clientPage.addClient(data);
    }

    @FrameworkAnnotation(author = {AuthorType.AnhTester},
            category = {CategoryType.SANITY, CategoryType.REGRESSION})
    @Test(priority = 2)
    @Step("Search Client")
    public void testSearchClient() {
        dashboardPage = signInPage.signInWithAdminRole();
        clientPage = dashboardPage.openClientPage();
        clientPage.openClientTabPage();
        // Search the first
        clientPage.enterDataSearchClient("Anh Tester");
//        WebUI.checkContainsSearchTableByColumn(2, "Anh Tester");
        // Search the second
        clientPage.enterDataSearchClient("Anh Tester Client 0407A1");
//        WebUI.checkContainsSearchTableByColumn(2, "Anh Tester Client 0407A1");

    }

}