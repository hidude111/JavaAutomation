package BaseClasses;

import com.aventstack.extentreports.ExtentReports;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import config.ConfigManager;

//base test class will cover reusable actions across tests. So in this case, that would be WebDriver Start up and CLose down
public abstract class UIBaseTest{

    //Threadlocal is used to run selenium tests in parallel
    protected ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    @Getter
    protected WebDriver driver;
    protected WebDriverWait wait;
    private ExtentReports extent;


    //before each test run, we will start up the driver, no need to manually call new instances of a webdriver when we can do it in the base class.
    @BeforeTest
    public void setup(){
        extent = new ExtentReports();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigManager.getLandingPageURL());
        //We will now store the driver in an instance of the threadDriver variable
        threadDriver.set(driver);
    }


    @AfterTest
    public void tearDown() {
        if (driver != null){
            driver.quit();
        }
        threadDriver.get().quit();
        threadDriver.remove();
        extent.attachReporter();
        extent.flush();
    }

}
