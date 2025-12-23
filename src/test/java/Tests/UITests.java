package Tests;

import BaseClasses.UIBaseTest;
import models.AdminPageModel;
import models.ParaBankLandingPageModel;
import models.RegisterPageModel;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import static Utils.extentreports.ExtentTestManager.startTest;

public class UITests extends UIBaseTest {

    @Test(description = "Verify dropdown returns JMS Web Service and Local.")
    public void verifyLoanProviderDropdownOptions(){
        startTest("verifyLoanProviderDropdownOptions", "Verify dropdown returns JMS Web Service and Local.");
        ParaBankLandingPageModel landingPage = new ParaBankLandingPageModel(driver);
        landingPage.clickOnAdminPage();
        AdminPageModel adminPage = new AdminPageModel(driver);
        wait.until(ExpectedConditions.urlContains("admin"));

        adminPage.GetAllLoanProviderOptions();
        List<String> loanProviderOptions = new ArrayList<>(Arrays.asList("JMS", "Web Service", "Local"));
        Assertions.assertEquals(adminPage.displayAllLoanProviderOptions(), loanProviderOptions);
    }

    @Test(description = "Create accounts", groups = {"Regression"}, testName = "Create User")
    public void CreateUser(){
        startTest("CreateUser", "Create accounts");
        ParaBankLandingPageModel landingPage = new ParaBankLandingPageModel(driver);
        landingPage.clickRegisterLinkButton();
        RegisterPageModel registerPage = new RegisterPageModel(driver);
        wait.until(ExpectedConditions.urlContains("register"));

        registerPage.generateUser();
        registerPage.clickRegister();
        assertThat(registerPage.getSuccessText(), containsString("Welcome"));

    }

}
