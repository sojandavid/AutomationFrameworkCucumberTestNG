/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.testcases;


import com.anhtester.common.BaseTest;
import com.anhtester.projects.website.crm.pages.Dashboard.DashboardPageCRM;
import com.anhtester.projects.website.crm.pages.SignIn.SignInPageCRM;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.anhtester.keywords.WebUI;

@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class SignInTest extends BaseTest {

    SignInPageCRM signInPage;

    public SignInTest() {
        signInPage = new SignInPageCRM();
    }

    //Using library DataProvider with read Hashtable
//    @Test(priority = 1, dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    @Test(priority = 1)
    @Step("SignInTestDataProviderHashtable")
//    public void SignInTestDataProviderHashtable(Hashtable<String, String> data) {
    public void SignInTestDataProviderHashtable() {
        signInPage.signIn();
    }

//    @Test(priority = 2, dataProvider = "getSignInDataHashTable2", dataProviderClass = DataProviderManager.class)
    @Test(priority = 2)
    @Step("SignInTestDataProviderHashtable")
    //    public void SignInTestDataProviderHashtable2(Hashtable<String, String> data) {
    public void SignInTestDataProviderHashtable2() {
        signInPage.signIn();
    }

    @Test(priority = 3)
    @Step("SignInTestDataAdmin")
    public void SignInTestDataAdmin() {
        signInPage.signInWithAdminRole();
        By alert = By.xpath("//div[@role='alert']");
//        WebUI.verifyElementPresent(alert, 5, "The error message does not exist.");
    }

    @Test(priority = 4)
    @Step("SignInTestDataTeamLeader")
    public void SignInTestDataTeamLeader() {
        signInPage.signInWithTeamLeaderRole();
    }

}
