package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUser {

    @Test
    void test_getUser(ITestContext context){

//        int id = (int) context.getAttribute("user_id");
        int id = (int) context.getSuite().getAttribute("user_id");

        String bearerToken = "e12a163b8d5864b0bd8a8ef7616ecf4bef4fac547c518de17c872733518c8af4";

       given()
                .header("Authorization","Bearer " + bearerToken)
               .pathParam("id",id)
       .when()
                .get("https://gorest.co.in/public/v2/users/{id}")

       .then()
               .statusCode(200)
               .log().all();
    }
}
