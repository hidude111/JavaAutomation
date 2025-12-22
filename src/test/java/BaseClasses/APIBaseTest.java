package BaseClasses;

import io.restassured.http.Header;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.restassured.*;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import config.ConfigManager;


//similarly to the BaseClasses.UIBaseTest class, the BaseClasses.APIBaseTest will handle commonly done actions.
public abstract class APIBaseTest {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = ConfigManager.wordsURI();
    }


    /*@AfterTest
    public void tearDown(){
        RestAssured.
    }*/

    public Header requestHeaders(){
        return new Header("x-rapidapi-key", ConfigManager.apiKey());
    }
}
