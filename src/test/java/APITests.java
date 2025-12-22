import BaseClasses.APIBaseTest;
import io.restassured.response.Response;
import models.Synonyms;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static Utils.extentreports.ExtentTestManager.startTest;


public class APITests extends APIBaseTest {

    @Test(description = "Testing words synonyms endpoint")
    public void wordExampleShouldGIve200ResponseCode(){
        startTest("wordExampleShouldGIve200ResponseCode", "Testing words synonyms endpoint");
        Response res = given().header(requestHeaders()).get("example/synonyms");
        Assertions.assertEquals(200, res.statusCode());

        Synonyms synonyms = res.body().as(Synonyms.class);
        assertThat(synonyms.word, Is.is("example"));
        assertThat(synonyms.synonyms, is(not(empty())));
        assertThat(synonyms.synonyms, hasItem("model"));
        assertThat(synonyms.synonyms, hasItem("illustration"));
    }

}
