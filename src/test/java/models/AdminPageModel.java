package models;

import BaseClasses.UIBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import config.ConfigManager;
import java.util.ArrayList;
import java.util.List;

public class AdminPageModel extends UIBaseTest {

    //Web Elements
    private By initialBalance = By.id("initialBalance");
    private By minimumBalance = By.id("minimumBalance");

    public AdminPageModel(WebDriver driver){
        this.driver = driver;
        if (!driver.getCurrentUrl().contains(ConfigManager.getAdminPageURL())){
            throw new IllegalStateException("This is not the admin page, " + "you are here instead, " + driver.getCurrentUrl());
        }
    }

    public String getUrlText() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> GetAllLoanProviderOptions() {
        WebElement selectLoanProvider = driver.findElement(By.name("loanProvider"));
        Select select = new Select(selectLoanProvider);
        return select.getOptions();
    }


    public List<String> displayAllLoanProviderOptions(){
        List<String> options = new ArrayList<>();
        for(WebElement option : GetAllLoanProviderOptions()){
            options.add(option.getAccessibleName());
        }
        return options;
    }


}
