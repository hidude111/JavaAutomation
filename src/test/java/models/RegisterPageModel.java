package models;

import BaseClasses.UIBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import config.ConfigManager;

import java.util.Random;

public class RegisterPageModel extends UIBaseTest {

    //WebElements
    private By firstNameTextbox = By.name("customer.firstName");
    private By lastNameTextbox = By.name("customer.lastName");
    private By addressTextbox = By.name("customer.address.street");
    private By cityTextbox = By.name("customer.address.city");
    private By stateTextbox = By.name("customer.address.state");
    private By zipCodeTextbox = By.name("customer.address.zipCode");
    private By phoneNumberTextbox = By.name("customer.phoneNumber");
    private By ssnTextbox = By.name("customer.ssn");
    private By userNameTextbox = By.name("customer.username");
    private By passwordTextbox = By.name("customer.password");
    private By confirmTextbox = By.name("repeatedPassword");

    private By registerButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    private By stringRegistrationSuccess = By.className("title");

    public RegisterPageModel(WebDriver driver){
        this.driver = driver;
        if (!driver.getCurrentUrl().contains(ConfigManager.getRegisterPageURL())){
            throw new IllegalStateException("This is not the admin page, " + "you are here instead, " + driver.getCurrentUrl());
        }
    }

    public String getUrlText() {
        return driver.getCurrentUrl();
    }

    public void generateUser(){
        driver.findElement(firstNameTextbox).sendKeys(generateRandomString(5));
        driver.findElement(lastNameTextbox).sendKeys(generateRandomString(5));
        driver.findElement(addressTextbox).sendKeys(generateRandomString(5));
        driver.findElement(cityTextbox).sendKeys(generateRandomString(5));
        driver.findElement(stateTextbox).sendKeys(generateRandomString(5));
        driver.findElement(zipCodeTextbox).sendKeys(generateRandomString(5));
        driver.findElement(phoneNumberTextbox).sendKeys(generateRandomString(5));
        driver.findElement(ssnTextbox).sendKeys(generateRandomString(5));

        driver.findElement(userNameTextbox).sendKeys(generateRandomString(5));
        driver.findElement(passwordTextbox).sendKeys("test123");
        driver.findElement(confirmTextbox).sendKeys("test123");



    }

    public void clickRegister(){
        driver.findElement(registerButton).click();
    }


    public String getSuccessText(){
        return driver.findElement(stringRegistrationSuccess).getText();
    }


    //create a helper method to generate random strings for the text fields
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Get a random index from the character pool
            int randomIndex = random.nextInt(CHARACTERS.length());
            // Append the character at that index to the StringBuilder
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }
}
