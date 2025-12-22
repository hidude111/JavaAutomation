package models;

import BaseClasses.UIBaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ParaBankLandingPageModel extends UIBaseTest {

    //Creating some web elements
    private By userNameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    private By adminPageLink = By.linkText("Admin Page");
    private By registerButton = By.linkText("Register");

    public ParaBankLandingPageModel(WebDriver webDriver){
        this.driver = webDriver;
        /*if (!webDriver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/index.htm")){
            throw new IllegalStateException("This is not the landing page, " + "you are here instead, " + webDriver.getCurrentUrl());
        }*/
    }

    public void loginUser(){
        this.driver.findElement(userNameField).sendKeys("username");
        this.driver.findElement(passwordField).sendKeys("password");
        this.driver.findElement(loginButton).click();
    }

    public void clickOnAdminPage(){
        this.driver.findElement(adminPageLink).click();
    }

    public void clickRegisterLinkButton(){
        this.driver.findElement(registerButton).click();
    }




}