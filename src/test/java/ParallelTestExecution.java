import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static Utils.extentreports.ExtentTestManager.startTest;

//To run this in parallel we need to use testng.xml, I will fix that later cause the tests in
public class ParallelTestExecution {
    @Test
    public void testLoginInChrome() {
        startTest("testLoginInChrome", "Parallel test to be ran with testLoginInEdge");
        WebDriver driver = new ChromeDriver();  // ChromeDriver setup
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.quit();
    }

    @Test
    public void testLoginInEdge() {
        startTest("testLoginInEdge", "Parallel test to be ran with testLoginInChrome");
        WebDriver driver = new EdgeDriver();  // FirefoxDriver setup
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.quit();
    }
}